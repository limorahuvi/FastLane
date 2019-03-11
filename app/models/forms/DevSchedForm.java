package models;
import com.fasterxml.jackson.databind.JsonNode;
import  play.libs.Json;
import models.VisualizationForm;
public class DevSchedForm extends VisualizationForm{

    /* TODO add constraintes*/
    public String day;
    public String startTime;
    public String endTime;
    public String coor1;
    public String coor2;
    public JsonNode result_early;
    public JsonNode result_late;
    public String resultString_early;
    public String resultString_late;

    public DevSchedForm(){

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



    public String getParametersList(){
        return "Day: "+day+", "+
                "Start Time: "+startTime+", "+
                "End Time: "+endTime+"";
    }

    public JsonNode getResultEarly(){
        return result_early;
    }

    public JsonNode getResultLate(){
        return result_late;
    }

    public void setResult_early(JsonNode result){
        this.result_early=result;
    }
    public void setResult_late(JsonNode result){
        this.result_late=result;
    }

    public String getResultString_early(){
        return resultString_early;
    }

    public String getResultString_late(){
        return resultString_late;
    }



}
