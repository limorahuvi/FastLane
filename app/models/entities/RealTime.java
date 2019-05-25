package models.entities;

import io.ebean.Model;
import org.postgis.Point;

import javax.persistence.*;
import java.util.*;
import io.ebean.*;
import play.data.format.*;

import javax.persistence.Entity;
import java.sql.Time;

@Entity
public class RealTime extends Model {
    @Id
    private Integer realTime_id;
    @ManyToOne
    @JoinColumn(name = "stop", referencedColumnName = "stop_id")
    private Stop stop;  // by stopPointRef to stop_code(stop)   //col 16
    private String publishedLineName;  //col 7
    private Point location;  // (col 14 , col 15) get from stop
    @Formats.DateTime(pattern="yyyy-MM-dd")
    private Date expectedArrivalDate;   //col 18
    private Time expectedArrivalTime;  //col 18
    @Formats.DateTime(pattern="yyyy-MM-dd")
    private Date recordedAtTime_Date;   //col 1
    private Time recordedAtTime_Time;   //col 1

    public static final Finder<Long, RealTime> find = new Finder<>(RealTime.class);

    public Stop getStop() {
        return stop;
    }

    public void setStop_id(Stop stop) {
        this.stop = stop;
    }

    public Date getExpectedArrivalDate() {
        return expectedArrivalDate;
    }

    public void setExpectedArrivalDate(Date expectedArrivalDate) {
        this.expectedArrivalDate = expectedArrivalDate;
    }

    public Time getExpectedArrivalTime() {
        return expectedArrivalTime;
    }

    public void setExpectedArrivalTime(Time expectedArrivalTime) {
        this.expectedArrivalTime = expectedArrivalTime;
    }

    public Integer getRealTime_id() {
        return realTime_id;
    }

    public void setRealTime_id(Integer realTime_id) {
        this.realTime_id = realTime_id;
    }

    public Date getRecordedAtTime_Date() {
        return recordedAtTime_Date;
    }

    public void setRecordedAtTime_Date(Date recordedAtTime_Date) {
        this.recordedAtTime_Date = recordedAtTime_Date;
    }

    public Time getRecordedAtTime_Time() {
        return recordedAtTime_Time;
    }

    public void setRecordedAtTime_Time(Time recordedAtTime_Time) {
        this.recordedAtTime_Time = recordedAtTime_Time;
    }

    public String getPublishedLineName() {
        return publishedLineName;
    }

    public void setPublishedLineName(String publishedLineName) {
        this.publishedLineName = publishedLineName;
    }


    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
