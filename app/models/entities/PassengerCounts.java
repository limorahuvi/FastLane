package models.entities;

import io.ebean.Model;
import org.postgis.Point;

import javax.persistence.*;
import java.util.*;
import io.ebean.*;
import javax.persistence.Entity;
import java.sql.Time;
import play.data.format.*;

@Entity
public class PassengerCounts extends Model {
    @Id @GeneratedValue
    private Integer pc_id ;
    private Integer TripId; //col 56

    private Integer PassengersContinue_rounded_final;  //col 54

    private Point point; //Lat+long (38,39)

    private String DayNameHeb; // col 26

    public String getStation_order() {
        return station_order;
    }

    public void setStation_order(String station_order) {
        this.station_order = station_order;
    }

    private String station_order; // col 28

    @Formats.DateTime(pattern="yyyy-MM-dd")
    private Date DateKey; //col 22

    private Time HourKey; // col 23

    public static final Finder<Long, PassengerCounts> find = new Finder<>(PassengerCounts.class);

    public Integer getPc_id() {
        return pc_id;
    }

    public void setPc_id(Integer pc_id) {
        this.pc_id = pc_id;
    }

    public Integer getTripId() {
        return TripId;
    }

    public void setTripId(Integer tripId) {
        TripId = tripId;
    }

    public Integer getPassengersContinue_rounded_final() {
        return PassengersContinue_rounded_final;
    }

    public void setPassengersContinue_rounded_final(Integer passengersContinue_rounded_final) {
        PassengersContinue_rounded_final = passengersContinue_rounded_final;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getDayNameHeb() {
        return DayNameHeb;
    }

    public void setDayNameHeb(String dayNameHeb) {
        DayNameHeb = getDay(dayNameHeb);
    }

    private String getDay(String day) {
        switch (day){
            case "ראשון": return "Sunday";
            case "שני": return "Monday";
            case "שלישי": return "Tuesday";
            case "רביעי": return "Wednesday";
            case "חמישי": return "Thursday";
            case "שישי": return "Friday";
            case "שבת": return "Saturday";
            default: return "";
        }
    }

    public Date getDateKey() {
        return DateKey;
    }

    public void setDateKey(Date dateKey) {
        DateKey = dateKey;
    }

    public Time getHourKey() {
        return HourKey;
    }

    public void setHourKey(Time hourKey) {
        HourKey = hourKey;
    }

    public String toString(){
        return "pc_id: "+pc_id+" "+
                "TripId: "+TripId+" "+
                "PassengersContinue_rounded_final: "+ PassengersContinue_rounded_final +" "+
                "point: "+point+" "+
                "station_order: "+station_order+" "+
                "DayNameHeb: "+DayNameHeb+" "+
                "DateKey: "+DateKey+" "+
                "HourKey: "+HourKey+" ";

    }
}
