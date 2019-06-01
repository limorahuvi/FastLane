package models.entities_seg;

import io.ebean.Finder;
import io.ebean.Model;
import models.entities.RealTime;
import org.postgis.Point;

import javax.persistence.*;
import java.util.List;

@Entity
public class stop_ extends Model {

    @Id
    private Integer stop_id;
    private Integer stop_code;
    private String stop_name	;
    private String stop_desc;
    private Point location;  //(lat, lan)
    private Boolean location_type;

    @ManyToOne
    @JoinColumn(name = "parent_station_id", referencedColumnName = "stop_id")
    private stop_ parent_station;


    public static final Finder<Long, stop_> find = new Finder<>(stop_.class);

    public Integer getStop_id() {
        return stop_id;
    }

    public void setStop_id(Integer stop_id) {
        this.stop_id = stop_id;
    }

    public Integer getStop_code() {
        return stop_code;
    }

    public void setStop_code(Integer stop_code) {
        this.stop_code = stop_code;
    }

    public String getStop_name() {
        return stop_name;
    }

    public void setStop_name(String stop_name) {
        this.stop_name = stop_name;
    }

    public String getStop_desc() {
        return stop_desc;
    }

    public void setStop_desc(String stop_desc) {
        this.stop_desc = stop_desc;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Boolean getLocation_type() {
        return location_type;
    }

    public void setLocation_type(Boolean location_type) {
        this.location_type = location_type;
    }

    public stop_ getParent_station() {
        return parent_station;
    }

    public void setParent_station(stop_ parent_station) {
        this.parent_station = parent_station;
    }

}
