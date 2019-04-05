package models;
import com.fasterxml.jackson.databind.JsonNode;
import models.VisualizationForm;
import play.data.validation.Constraints;
import play.data.validation.Constraints.Validate;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PassengersCountForm extends VisualizationForm{
    @Constraints.Required
    @Constraints.Min(1)
    public int minPassengersForPublicLane;

    public PassengersCountForm(){

    }


    public int getMinPassengersForPublicLane(){
        return minPassengersForPublicLane;
    }

    public void setMinPassengersForPublicLane(int minPassengersForPublicLane){
        this.minPassengersForPublicLane=minPassengersForPublicLane;
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
                    "End Hour: "+endHour+", "+
                    "Minimum Passengers For Public Lane: "+minPassengersForPublicLane;

    }





}
