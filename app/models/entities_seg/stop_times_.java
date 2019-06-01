package models.entities_seg;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class stop_times_ extends Model {

    @EmbeddedId
    private stop_times_key stKey;
    @ManyToOne
    @JoinColumn(name = "stop_id", insertable = false, updatable = false)
    private stop_ stop;
    @ManyToOne
    @JoinColumn(name = "trip_id", insertable = false, updatable = false)
    private trips_ trip;
    /* @JoinColumn(name = "arrival_time", insertable = false, updatable = false)
     private Time arrival_time;*/
    private Time departure_time;
    private Integer stop_sequence;
    private Boolean pickup_types;
    private Boolean drop_off_type;
    private Integer shape_dist_traveled;
    private Integer continue_passengers;
    private Integer load ;//passanger count

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    public Integer getContinue_passengers() {
        return continue_passengers;
    }

    public void setContinue_passengers(Integer continue_passengers) {
        this.continue_passengers = continue_passengers;
    }


    public static final Finder<stop_times_key, stop_times_> find = new Finder<>(stop_times_.class);


    public stop_times_() {
        stKey= new stop_times_key();
    }

    public stop_times_key getStKey() {
        return stKey;
    }

    public void setStKey(stop_times_key stKey) {
        this.stKey = stKey;
    }

    public stop_ getStop() {
        return stop;
    }
    public void setStop(stop_ stop) {
        this.stop = stop;
        stKey.stop_id = stop.getStop_id();
    }
    public trips_ getTrip() {
        return trip;
    }

    public void setTrip(trips_ trip) {
        this.trip = trip;
        stKey.trip_id = trip.getTrip_id();
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
