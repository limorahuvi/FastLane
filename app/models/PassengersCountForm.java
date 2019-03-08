package models;
import com.fasterxml.jackson.databind.JsonNode;
import models.VisualizationForm;
import java.util.Date;
import play.data.validation.Constraints;
import play.data.validation.Constraints.Validate;

public class PassengersCountForm extends VisualizationForm{

    /* TODO add constraintes*/
    public Date startDate;
    public Date endDate;
    public String day;
    public String startTime;
    public String endTime;
    public int minPassengersForPublicLane;

    public PassengersCountForm(){

    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDay(){
        return day;
    }

    public void setDay(String day){
        this.day=day;
    }

    public String getStartTime(){
        return startTime;
    }

    public void setStartTime(String startTime){
        this.startTime=startTime;
    }

    public String getEndTime(){
        return endTime;
    }

    public void setEndTime(String endTime){
        this.endTime=endTime;
    }

    public int getMinPassengersForPublicLane(){
        return minPassengersForPublicLane;
    }

    public void setMinPassengersForPublicLane(int minPassengersForPublicLane){
        this.minPassengersForPublicLane=minPassengersForPublicLane;
    }

//    TODO print dates without time
    public String getParametersList(){
        return "Start Date: "+startDate+", "+
                "End Date: "+endDate+", "+
                "Day: "+day+", "+
                "Start Time: "+startTime+", "+
                "End Time: "+endTime+", "+
                "Minimum Passengers For Public Lane: "+minPassengersForPublicLane;
    }





}
