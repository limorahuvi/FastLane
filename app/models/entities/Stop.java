package models.entities;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.postgis.Point;
import io.ebean.*;
import javax.persistence.*;

@Entity
public class Stop extends Model{

    @Id
    private Integer stop_id;
    private Integer stop_code;
    private String stop_name	;
    private String stop_desc;
    private Point loction;  //(lat, lan)
    private Boolean location_type;
    @ManyToOne
    @JoinColumn(name = "parent_station_id", referencedColumnName = "stop_id")
    private Stop parent_station;


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

    public Point getLoction() {
        return loction;
    }

    public void setLoction(Point loction) {
        this.loction = loction;
    }

    public Boolean getLocation_type() {
        return location_type;
    }

    public void setLocation_type(Boolean location_type) {
        this.location_type = location_type;
    }

    public Stop getParent_station() {
        return parent_station;
    }

    public void setParent_station(Stop parent_station) {
        this.parent_station = parent_station;
    }

    public static final Finder<Integer, Stop> find = new Finder<>(Stop.class);
}
