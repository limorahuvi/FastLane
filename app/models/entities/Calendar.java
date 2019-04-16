package models.entities;

import play.data.validation.Constraints;
import javax.persistence.*;
import java.util.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;


@Entity
public class Calendar extends Model {

    @Id
    private Integer service_id	;

   // @Column(columnDefinition = "BIT(7)")
    private String days_bytes;
    private Date start_date; //YYYYMMDD
    private Date end_date; //YYYYMMDD


    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public String getDays_bytes() {
        return days_bytes;
    }

    public void setDays_bytes(String days_bytes) {
        this.days_bytes = days_bytes;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public static String mergeDayes(String sunday, String monday, String tuesday, String wednesday, String thursday, String friday,
                                     String saturday) {
        String week = sunday+monday+tuesday+wednesday+thursday+friday+saturday;
        return week;
    }

    public static final Finder<Integer, Calendar> find = new Finder<>(Calendar.class);
}

