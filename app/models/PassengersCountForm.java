package models;
import com.fasterxml.jackson.databind.JsonNode;
import  play.libs.Json;
import models.VisualizationForm;
public class PassengersCountForm extends VisualizationForm{

    /* TODO add constraintes*/
    public String day;
    public String startTime;
    public String endTime;
    public int minPassengersForPublicLane;
    public String coor1;
    public String coor2;
    public JsonNode result;
    public String resultString;

    public PassengersCountForm(){

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

    public String getParametersList(){
        return "Day: "+day+", "+
                "Start Time: "+startTime+", "+
                "Start Time: "+startTime+", "+
                "End Time: "+endTime+", "+
                "Min Passengers For Public Lane: "+minPassengersForPublicLane+"\n"
                ;
    }

    public JsonNode getResult(){
        return result;
    }

    public void setResult(JsonNode result){
        this.result=result;
    }

    public String getResultString(){
        return resultString;
    }



}
