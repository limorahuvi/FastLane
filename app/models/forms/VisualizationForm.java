package models;
import com.fasterxml.jackson.databind.JsonNode;
import play.data.validation.Constraints;
import java.util.Date;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.Validatable;
import play.data.validation.Constraints.Validate;

@Validate
public abstract class VisualizationForm implements Validatable<ValidationError>{

    // Time
    @Constraints.Required
    public Date startDate;
    @Constraints.Required
    public Date endDate;
    public String day;
    public String startHour;
    public String endHour;

    // Result
    public JsonNode result = null;
    public String resultString = "";

    // Coordinates
    @Constraints.Required
    public String coor1="";
    @Constraints.Required
    public String coor2="";


    //  abstract
    public abstract String getParametersList();

    //time
    public String getDay(){
        return day;
    }

    public void setDay(String day){
        this.day=day;
    }

    public String getStartHour(){
        return startHour;
    }

    public void setStartHour(String startHour){
        this.startHour=startHour;
    }

    public String getEndHour(){
        return endHour;
    }

    public void setEndHour(String endHour){
        this.endHour=endHour;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    // result
    public JsonNode getResult(){
        return result;
    }

    public void setResult(JsonNode result){
        this.result=result;
        this.resultString=result.toString();
    }

    public String getResultString(){
        return resultString;
    }

    // coordinates
    public String getCoor1(){return coor1;}

    public void setCoor1(String coor){this.coor1=coor;}

    public String getCoor2(){return coor2;}

    public void setCoor2(String coor){this.coor2=coor;}

    @Override
    public ValidationError validate() {
        if (endDate!=null&&startDate!=null&&endDate.before(startDate)) {
            return new ValidationError("endDate", "start date should be before end date");
        }
        if (Integer.parseInt(startHour)>Integer.parseInt(endHour)) {
            return new ValidationError("endHour", "start hour should be before end hour");
        }
        return null;
    }
}

