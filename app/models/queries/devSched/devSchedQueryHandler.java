package models.queries.devSched;

import models.DevSchedForm;
import java.awt.*;
import java.time.LocalTime;
import java.util.*;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.entities.RealTime;
import models.queries.queries;
import org.postgis.Point;
import play.libs.Json;

public class devSchedQueryHandler {

    DevSchedForm form;

    public devSchedQueryHandler(DevSchedForm form) {
        this.form = form;
    }

    public JsonNode getResult() {
        Date start=form.getStartDate();
        Date end=form.getEndDate();

        String coor1=form.getCoor1();
        String[] coor1_x_y= coor1.split(",");
        String coor2=form.getCoor2();
        String[] coor2_x_y=coor2.split(",");
        Point p1=new Point(Double.parseDouble(coor1_x_y[1]),Double.parseDouble(coor2_x_y[0]));
        Point p2=new Point(Double.parseDouble(coor2_x_y[1]),Double.parseDouble(coor1_x_y[0]));
        Point p3=new Point(Double.parseDouble(coor1_x_y[1]),Double.parseDouble(coor1_x_y[0]));
        Point p4=new Point(Double.parseDouble(coor2_x_y[1]),Double.parseDouble(coor2_x_y[0]));
        double max_x=Math.max(Math.max(p1.getX(),p2.getX()),Math.max(p3.getX(),p4.getX()));
        double min_x=Math.min(Math.min(p1.getX(),p2.getX()),Math.min(p3.getX(),p4.getX()));
        double max_y=Math.max(Math.max(p1.getY(),p2.getY()),Math.max(p3.getY(),p4.getY()));
        double min_y=Math.min(Math.min(p1.getY(),p2.getY()),Math.min(p3.getY(),p4.getY()));

        String start_hour=form.getStartHour();
        String end_hour=form.getEndHour();
        List<RealTime> real_time_ref;
        if(start_hour.equals("00") && end_hour.equals("00")){
             real_time_ref=RealTime.find.query().where().between("recordedAtTime_Date" , start, end )
                    .between("ST_X(loction)",min_x,max_x).between("ST_Y(loction)",min_y,max_y).findList();
        }
        else {
            LocalTime t1 = LocalTime.parse(start_hour + ":00");
            LocalTime t2 = LocalTime.parse(end_hour + ":00");
            real_time_ref = RealTime.find.query().where().between("recordedAtTime_Date", start, end)
                    .between("recordedAtTime_Time", t1, t2).between("ST_X(loction)", min_x, max_x).between("ST_Y(loction)", min_y, max_y).findList();
        }
        String day=form.getDay();
        if(!(day.equals("All"))){
            real_time_ref=filter_day(real_time_ref,day);
        }

        Map<Integer, List<String>> dec_late=get_description_late(real_time_ref);
        Map<Integer, List<String>> dec_early=get_description_early(real_time_ref);
        Map<Integer, Double> avg_late= get_avg_late(real_time_ref);
        Map<Integer, Double> avg_early= get_avg_early(real_time_ref);
        devSchedFeatureCollection totalLoad = new devSchedFeatureCollection();
        for (int i = 0; i < real_time_ref.size(); i++) {
            String[] des1=new String[0];
            String[] des2=new String[0];
            double average1=0;
            double average2=0;
            Point p1_real = real_time_ref.get(i).getLoction();
            double[] coor13933 = {p1_real.getY() , p1_real.getX()};
            if(avg_early.containsKey(real_time_ref.get(i).getStop().getStop_id())){
                average1=avg_early.get(real_time_ref.get(i).getStop().getStop_id());//early
            }
            if(avg_late.containsKey(real_time_ref.get(i).getStop().getStop_id())){
                average2=avg_late.get(real_time_ref.get(i).getStop().getStop_id());//late
            }
            if(dec_early.containsKey(real_time_ref.get(i).getStop().getStop_id())) {
                List<String> des1_list = dec_early.get(real_time_ref.get(i).getStop().getStop_id());//early
                des1 = des1_list.toArray(new String[des1_list.size()]);
            }
            if(dec_late.containsKey(real_time_ref.get(i).getStop().getStop_id())) {

                List<String> des2_list = dec_late.get(real_time_ref.get(i).getStop().getStop_id());//late
                des2 = des2_list.toArray(new String[des2_list.size()]);
            }
            totalLoad.addFeature(coor13933,average1,average2,des1,des2);
        }
        //demo data
        /*
        double[] coor13933 = {34.798256,31.260114};
        double average1=2;
        double average2=5;
        String[] des1={"line 3: 2 minutes", "line 4 :2 minutes"};
        String[] des2={"line 3: 5 minutes", "line 4 :5 minutes"};
        totalLoad.addFeature(coor13933,average1,average2,des1,des2);
        */
        return queries.mapper.valueToTree(totalLoad);
    }

    public static List<RealTime> filter_day(List<RealTime>  real_time_ref,String day){
        List<RealTime> ans=new ArrayList<RealTime>();
        String [] days={"","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        for (int i = 0; i < real_time_ref.size(); i++) {
            Calendar c = Calendar.getInstance();
            c.setTime(real_time_ref.get(i).getExpectedArrivalDate());
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            if(days[dayOfWeek].equals(day)){
                ans.add(real_time_ref.get(i));
            }
        }
        return ans;
    }
    private Map<Integer, List<String>> get_description_late(List<RealTime>  real_time){
        Map<Integer, List<String>> dictionary_description = new HashMap<Integer, List<String>>();//per station
        List<String> ans=new ArrayList<String>();
        for (int i = 0; i < real_time.size(); i++) {
            if(real_time.get(i).getRecordedAtTime_Time().compareTo(real_time.get(i).getExpectedArrivalTime())>=0){
                long time=((real_time.get(i).getRecordedAtTime_Time().getTime()-real_time.get(i).getExpectedArrivalTime().getTime())/1000)/60;
                String desciption_late="line "+ real_time.get(i).getPublishedLineName() + ": " +  time + " minutes";
                if(dictionary_description.containsKey(real_time.get(i).getStop().getStop_id())){
                    dictionary_description.get(real_time.get(i).getStop().getStop_id()).add(desciption_late);
                }
                else{
                    ans=new ArrayList<>();
                    dictionary_description.put(real_time.get(i).getStop().getStop_id(),ans);
                    dictionary_description.get(real_time.get(i).getStop().getStop_id()).add(desciption_late);
                }
            }
        }
        return  dictionary_description;
    }
    private Map<Integer, List<String>> get_description_early(List<RealTime>  real_time){
        Map<Integer, List<String>> dictionary_description = new HashMap<>();//per station
        List<String> ans;
        for (int i = 0; i < real_time.size(); i++) {
            if(real_time.get(i).getRecordedAtTime_Time().compareTo(real_time.get(i).getExpectedArrivalTime())<=0){
                long time=((real_time.get(i).getExpectedArrivalTime().getTime()-real_time.get(i).getRecordedAtTime_Time().getTime())/1000)/60;
                String desciption_late="line "+ real_time.get(i).getPublishedLineName() + ": " +  time + " minutes";
                if(dictionary_description.containsKey(real_time.get(i).getStop().getStop_id())){
                    dictionary_description.get(real_time.get(i).getStop().getStop_id()).add(desciption_late);
                }
                else{
                    ans=new ArrayList<>();
                    dictionary_description.put(real_time.get(i).getStop().getStop_id(),ans);
                    dictionary_description.get(real_time.get(i).getStop().getStop_id()).add(desciption_late);

                }
            }
        }
        return  dictionary_description;
    }
    private Map<Integer, Double> get_avg_late(List<RealTime>  real_time){
        Map<Integer, List<Long>> dictionary_late_double_list = new HashMap<>();//per station
        Map<Integer , Double> final_ans=new HashMap<>();//per station
        List<Long> ans;
        for (int i = 0; i < real_time.size(); i++) {
            if(real_time.get(i).getRecordedAtTime_Time().compareTo(real_time.get(i).getExpectedArrivalTime())>=0){
                long time=((real_time.get(i).getRecordedAtTime_Time().getTime()-real_time.get(i).getExpectedArrivalTime().getTime())/1000)/60;
                if(dictionary_late_double_list.containsKey(real_time.get(i).getStop().getStop_id())){
                    dictionary_late_double_list.get(real_time.get(i).getStop().getStop_id()).add(time);
                }
                else{
                    ans=new ArrayList<>();
                    dictionary_late_double_list.put(real_time.get(i).getStop().getStop_id(),ans);
                    dictionary_late_double_list.get(real_time.get(i).getStop().getStop_id()).add(time);
                }
            }
        }
        for ( Map.Entry<Integer, List<Long>> entry : dictionary_late_double_list.entrySet() ) {
            Integer  key = entry.getKey();
            List<Long> value = entry.getValue();
            long sum=0;
            for (int j = 0; j < value.size(); j++) {
                sum=sum+value.get(j);
            }
            double avg=sum/value.size();
            final_ans.put(key,avg);
        }
        return  final_ans;
    }
    private Map<Integer , Double> get_avg_early(List<RealTime>  real_time){
        Map<Integer, List<Long>> dictionary_late_double_list = new HashMap<>();//per station
        Map<Integer, Double> final_ans=new HashMap<>();//per station
        List<Long> ans;
        for (int i = 0; i < real_time.size(); i++) {
            if(real_time.get(i).getRecordedAtTime_Time().compareTo(real_time.get(i).getExpectedArrivalTime())<=0){
                long time=((real_time.get(i).getExpectedArrivalTime().getTime()-real_time.get(i).getRecordedAtTime_Time().getTime())/1000)/60;


                if(dictionary_late_double_list.containsKey(real_time.get(i).getStop().getStop_id())){
                    dictionary_late_double_list.get(real_time.get(i).getStop().getStop_id()).add(time);
                }
                else{
                    ans=new ArrayList<>();
                    dictionary_late_double_list.put(real_time.get(i).getStop().getStop_id(),ans);
                    dictionary_late_double_list.get(real_time.get(i).getStop().getStop_id()).add(time);
                }
            }
        }
        for ( Map.Entry<Integer , List<Long>> entry : dictionary_late_double_list.entrySet() ) {
            Integer key = entry.getKey();
            List<Long> value = entry.getValue();
            long sum=0;
            for (int j = 0; j < value.size(); j++) {
                sum=sum+value.get(j);
            }
            double avg=sum/value.size();
            final_ans.put(key,avg);
        }
        return  final_ans;
    }
}
