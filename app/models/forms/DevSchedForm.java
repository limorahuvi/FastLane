package models;
import com.fasterxml.jackson.databind.JsonNode;
import  play.libs.Json;
import models.VisualizationForm;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DevSchedForm extends VisualizationForm{

    public JsonNode result_early;
    public JsonNode result_late;
    public String resultString_early;
    public String resultString_late;

    public DevSchedForm(){

    }

    public String getParametersList(){
        String strDate="";
        String strDate2="";
        if(startDate!=null) {
            Date date = startDate;
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            strDate = formatter.format(date);
        }
        if(endDate!=null) {
            Date date2 = endDate;
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
            strDate2= formatter2.format(date2);
        }

        return "Start Date: "+strDate+", "+
                "End Date: "+strDate2+", "+
                "Day: "+day+", "+
                "Start Hour: "+startHour+", "+
                "End Hour: "+endHour;

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
