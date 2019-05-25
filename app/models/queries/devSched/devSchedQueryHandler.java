package models.queries.devSched;

import models.DevSchedForm;
import java.time.LocalTime;
import java.util.*;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import models.entities.RealTime;
import models.queries.queries;
import org.postgis.Point;
import models.queries.GeojsonTemplates.QueryFeatureCollection;
import models.queries.GeojsonTemplates.QueryHandler;
public class devSchedQueryHandler extends QueryHandler   {



    public devSchedQueryHandler(DevSchedForm form) {
        super(form);
    }

    public JsonNode getResult() {
        Date start=form.getStartDate();
        Date end=form.getEndDate();

        String start_hour=form.getStartHour();
        String end_hour=form.getEndHour();

        List<RealTime> real_time_ref;
            LocalTime t1 = LocalTime.parse(start_hour + ":00");
            LocalTime t2 = LocalTime.parse(end_hour + ":59");
            real_time_ref = RealTime.find.query().where().between("expectedArrivalDate", start, end)
                    .between("expectedArrivalTime", t1, t2).between("ST_X(loction)", square[MIN_X],square[MAX_X]).between("ST_Y(loction)", square[MIN_Y],square[MAX_Y]).findList();
        String day=form.getDay();
        if(!(day.equals("All"))){
            real_time_ref=filter_day(real_time_ref,day);
        }

        QueryFeatureCollection  totalLoad = new QueryFeatureCollection ();
        for (int i = 0; i < real_time_ref.size(); i++) {

            int stop_id=real_time_ref.get(i).getStop().getStop_id();
            String des1_list=get_description_early_new(real_time_ref,stop_id);
            String des1_list2=get_description_late_new(real_time_ref,stop_id);
            double[] coor13933 = {real_time_ref.get(i).getLocation().getY(), real_time_ref.get(i).getLocation().getX()};

            totalLoad.addFeature(new devSchedSingleFeature(coor13933, get_avg_early_new(real_time_ref,real_time_ref.get(i).getStop().getStop_id()), get_avg_late_new(real_time_ref,real_time_ref.get(i).getStop().getStop_id()), des1_list, des1_list2));
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
