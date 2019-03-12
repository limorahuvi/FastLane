package models;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Date;


public abstract class VisualizationForm{

    // Time
    public Date startDate;
    public Date endDate;
    public String day;
    public String startHour;
    public String endHour;

    // Result
    public JsonNode result = null;
    public String resultString = "";

    // Coordinates
//    public final int NumberOfPointsNeeded = 2;
//    public Object[] points = null;
//    private int number_of_points_inserted;
    public String coor1="";
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

    // result
    public JsonNode getResult(){
        return result;
    }

    public void setResult(JsonNode result){
        this.result=result;
    }

    public String getResultString(){
        return resultString;
    }

    // coordinates
    public String getCoor1(){return coor1;}

    public void setCoor1(String coor){this.coor1=coor;}

    public String getCoor2(){return coor2;}

    public void setCoor2(String coor){this.coor2=coor;}

//    public int getNumberOfPointsNeeded(){return NumberOfPointsNeeded;};
//
//    public Object[] getPoints(){return points;}
//
//    public void setPoints(Object[] points){this.points=points;}

//    public boolean addPoint(String point){
//        if(points==null){
//            points = new String[NumberOfPointsNeeded];
//        }
//        if(number_of_points_inserted>=NumberOfPointsNeeded){
//            return false;
//        }
//        points[number_of_points_inserted++] = point;
//        return true;
//    }
//
//    public boolean removePoint(int index){
//        points[index]=points[--number_of_points_inserted];
//        return true;
//    }
//
//    public boolean removePoint(String coor){
//        for (int i=0; i<number_of_points_inserted; i++) {
//            if(points[i].equals(coor)){
//                return removePoint(i);
//            }
//        }
//        return false;
//    }
}

