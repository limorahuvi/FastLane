package models.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;

@Embeddable
public class StopTimesKey {

    private Trips trip_id	;
    private Stop stop_id;
    private Time arrival_time;



    public int hashCode() {
        return this.getTrip_id().getTrip_id().hashCode()+ this.getStop_id().getStop_id()+(int) this.getArrival_time().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof StopTimesKey)) return false;
        StopTimesKey st = (StopTimesKey) obj;
        return st.getTrip_id() == this.getTrip_id() && st.getStop_id() == this.getStop_id() && st.getArrival_time().equals(this.getArrival_time());
    }

    public Trips getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(Trips trip_id) {
        this.trip_id = trip_id;
    }

    public Stop getStop_id() {
        return stop_id;
    }

    public void setStop_id(Stop stop_id) {
        this.stop_id = stop_id;
    }

    public Time getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Time arrival_time) {
        this.arrival_time = arrival_time;
    }
}