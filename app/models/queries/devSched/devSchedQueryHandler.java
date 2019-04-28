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
             real_time_ref=RealTime.find.query().where().between("expectedArrivalDate" , start, end )
                    .between("ST_X(loction)",min_x,max_x).between("ST_Y(loction)",min_y,max_y).findList();
        }
        else {
            LocalTime t1 = LocalTime.parse(start_hour + ":00");
            LocalTime t2 = LocalTime.parse(end_hour + ":00");
            real_time_ref = RealTime.find.query().where().between("expectedArrivalDate", start, end)
                    .between("expectedArrivalTime", t1, t2).between("ST_X(loction)", min_x, max_x).between("ST_Y(loction)", min_y, max_y).findList();
        }
        String day=form.getDay();
        if(!(day.equals("All"))){
            real_time_ref=filter_day(real_time_ref,day);
        }

        devSchedFeatureCollection totalLoad = new devSchedFeatureCollection();
        for (int i = 0; i < real_time_ref.size(); i++) {

            int stop_id=real_time_ref.get(i).getStop().getStop_id();
            String des1_list=get_description_early_new(real_time_ref,stop_id);
            String des1_list2=get_description_late_new(real_time_ref,stop_id);
            double[] coor13933 = {real_time_ref.get(i).getLoction().getY(), real_time_ref.get(i).getLoction().getX()};

            totalLoad.addFeature(coor13933, get_avg_early_new(real_time_ref,real_time_ref.get(i).getStop().getStop_id()), get_avg_late_new(real_time_ref,real_time_ref.get(i).getStop().getStop_id()), des1_list, des1_list2);
            real_time_ref.removeIf(r -> r.getStop().getStop_id() == stop_id);
        }
        return queries.mapper.valueToTree(totalLoad);

    }

    public static List<RealTime> filter_day(List<RealTime>  real_time_ref,String day){
        String [] days={"","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        List<RealTime> ans=new ArrayList<>();
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

    private String get_description_early_new(List<RealTime>  real_time,int stop_id){
        long time;
        String desciption_late="";
        for (int i = 0; i < real_time.size()-1; i++) {
            if(real_time.get(i).getStop().getStop_id()==stop_id) {
                if (real_time.get(i).getRecordedAtTime_Time().compareTo(real_time.get(i).getExpectedArrivalTime()) <= 0) {
                    time = ((real_time.get(i).getExpectedArrivalTime().getTime() - real_time.get(i).getRecordedAtTime_Time().getTime()) / 1000) / 60;
                        desciption_late = desciption_late + "line " + real_time.get(i).getPublishedLineName() + ": " + time + " minutes | ";
                }
            }
        }
/*
        if(desciption_late.length()>2){
            desciption_late=desciption_late.substring(0, (desciption_late.length()-2))+"." ;
        }
        */
        return desciption_late;
    }
    private String get_description_late_new(List<RealTime>  real_time,int stop_id){
        long time;
        String desciption_late="";
        for (int i = 0; i < real_time.size(); i++) {
            if(real_time.get(i).getStop().getStop_id()==stop_id) {
                if (real_time.get(i).getRecordedAtTime_Time().compareTo(real_time.get(i).getExpectedArrivalTime()) >= 0) {
                    time = ((real_time.get(i).getRecordedAtTime_Time().getTime() - real_time.get(i).getExpectedArrivalTime().getTime()) / 1000) / 60;
                        desciption_late = desciption_late + "line " + real_time.get(i).getPublishedLineName() + ": " + time + " minutes | ";
                }
            }
        }
/*
        if(desciption_late.length()>2){
            desciption_late=desciption_late.substring(0, (desciption_late.length()-2))+"." ;
        }
        */
        return  desciption_late;
    }


    private Double get_avg_late_new(List<RealTime>  real_time,int stop_id){
       double avg=0;
        long sum=0;
        int count=0;
        for (int i = 0; i < real_time.size(); i++) {
            if(real_time.get(i).getStop().getStop_id()==stop_id) {
                if (real_time.get(i).getRecordedAtTime_Time().compareTo(real_time.get(i).getExpectedArrivalTime()) >= 0) {
                    long time = ((real_time.get(i).getRecordedAtTime_Time().getTime() - real_time.get(i).getExpectedArrivalTime().getTime()) / 1000) / 60;
                    sum=sum+time;
                    count++;
                }
            }
        }
        if(count!=0){
            avg=sum/count;
        }
       return avg;
    }

    private Double get_avg_early_new(List<RealTime>  real_time,int stop_id){
         double avg=0;
        double sum=0;
        int count=0;
        for (int i = 0; i < real_time.size(); i++) {
            if(real_time.get(i).getStop().getStop_id()==stop_id) {
                if (real_time.get(i).getRecordedAtTime_Time().compareTo(real_time.get(i).getExpectedArrivalTime()) <= 0) {
                    long time=((real_time.get(i).getExpectedArrivalTime().getTime()-real_time.get(i).getRecordedAtTime_Time().getTime())/1000)/60;
                    sum=sum+time;
                    count++;
                }
            }
        }
        if(count!=0){
            avg=sum/count;
        }
        return avg;
    }
}
