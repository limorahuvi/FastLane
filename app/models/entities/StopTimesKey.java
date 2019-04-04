package models.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;
import models.entities.Stop;
import models.entities.Trips;



@Embeddable
public class StopTimesKey {

    public String  trip_id;
    public Integer  stop_id;
    public Time arrival_time;

    public int hashCode() {
        return  (int)this.trip_id.hashCode() +
                this.stop_id +
                (int)this.arrival_time.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof StopTimesKey)) return false;
        StopTimesKey st = (StopTimesKey) obj;
        return trip_id.equals(st.trip_id) && stop_id == st.stop_id && arrival_time.equals(st.arrival_time);
    }

    public StopTimesKey(String trip_id, Integer stop_id, Time arrival_time) {
        this.trip_id = trip_id;
        this.stop_id = stop_id;
        this.arrival_time = arrival_time;
    }

    public StopTimesKey() { }

    public Time getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Time arrival_time) {
        this.arrival_time = arrival_time;
    }
}