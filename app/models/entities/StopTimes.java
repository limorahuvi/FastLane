package models.entities;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;
import java.sql.Time;

@Entity
public class StopTimes extends Model{

    @EmbeddedId
    @ManyToOne
    @JoinColumn(name = "stop_id", referencedColumnName = "stop_id")
    @JoinColumn(name = "trip_id", referencedColumnName = "trip_id")
    private StopTimesKey stKey;
    private Time departure_time;
    private Integer stop_sequence;
    private Boolean pickup_types;
    private Boolean drop_off_type;
    private Integer shape_dist_traveled;

    public static final Finder<StopTimesKey, StopTimes> find = new Finder<>(StopTimes.class);

    public StopTimesKey getStKey() {
        return stKey;
    }

    public void setStKey(StopTimesKey stKey) {
        this.stKey = stKey;
    }

    public Time getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Time departure_time) {
        this.departure_time = departure_time;
    }

    public Integer getStop_sequence() {
        return stop_sequence;
    }

    public void setStop_sequence(Integer stop_sequence) {
        this.stop_sequence = stop_sequence;
    }

    public Boolean getPickup_types() {
        return pickup_types;
    }

    public void setPickup_types(Boolean pickup_types) {
        this.pickup_types = pickup_types;
    }

    public Boolean getDrop_off_type() {
        return drop_off_type;
    }

    public void setDrop_off_type(Boolean drop_off_type) {
        this.drop_off_type = drop_off_type;
    }

    public Integer getShape_dist_traveled() {
        return shape_dist_traveled;
    }

    public void setShape_dist_traveled(Integer shape_dist_traveled) {
        this.shape_dist_traveled = shape_dist_traveled;
    }
}
