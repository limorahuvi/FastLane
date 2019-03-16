package models;
import com.fasterxml.jackson.databind.JsonNode;
import models.VisualizationForm;
import play.data.validation.Constraints;
import play.data.validation.Constraints.Validate;

public class PassengersCountForm extends VisualizationForm{
    @Constraints.Required
    @Constraints.Min(0)
    public int minPassengersForPublicLane;

    public PassengersCountForm(){

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
                "Start Hour: "+startHour+", "+
                "End Hour: "+endHour+", "+
                "Minimum Passengers For Public Lane: "+minPassengersForPublicLane;
    }





}
