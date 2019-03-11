package models;
import com.fasterxml.jackson.databind.JsonNode;
import  play.libs.Json;
import models.VisualizationForm;
public class DevSchedForm extends VisualizationForm{

    public JsonNode result_early;
    public JsonNode result_late;
    public String resultString_early;
    public String resultString_late;

    public DevSchedForm(){

    }

    public String getParametersList(){
        return "Start Date: "+startDate+", "+
                "End Date: "+endDate+", "+
                "Day: "+day+", "+
                "Start Time: "+startHour+", "+
                "End Time: "+endHour;
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
