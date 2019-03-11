package models;
import com.fasterxml.jackson.databind.JsonNode;
import models.VisualizationForm;
import play.data.validation.Constraints;
import play.data.validation.Constraints.Validate;

public class PassengersCountForm extends VisualizationForm{

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
                "Start Time: "+startHour+", "+
                "End Time: "+endHour+", "+
                "Minimum Passengers For Public Lane: "+minPassengersForPublicLane;
    }





}
