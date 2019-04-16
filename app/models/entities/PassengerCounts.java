package models.entities;

import io.ebean.Model;
import org.postgis.Point;
import play.data.validation.Constraints;
import javax.persistence.*;
import java.util.*;
import io.ebean.*;
import javax.persistence.Entity;
import java.sql.Time;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class PassengerCounts extends Model {
    @Id @GeneratedValue
    private Integer pc_id ;
    private Integer TripId; //col 58

    private Integer PassengersContinue_rounded_sofi;  //col 56

    private Point point; //Lat+long (40,41)

    private String DayNameHeb; // col 28

    @Formats.DateTime(pattern="yyyy-MM-dd")
    private Date DateKey; //col 24

    private Time HourKey; // col 25

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

    public Integer getPassengersContinue_rounded_sofi() {
        return PassengersContinue_rounded_sofi;
    }

    public void setPassengersContinue_rounded_sofi(Integer passengersContinue_rounded_sofi) {
        PassengersContinue_rounded_sofi = passengersContinue_rounded_sofi;
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
        DayNameHeb = dayNameHeb;
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
}