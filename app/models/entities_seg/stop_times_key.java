package models.entities_seg;
import javax.persistence.Embeddable;
import java.sql.Time;

@Embeddable
public class stop_times_key {
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
        if (!(obj instanceof stop_times_key)) return false;
        stop_times_key st = (stop_times_key) obj;
        return trip_id.equals(st.trip_id) && stop_id == st.stop_id && arrival_time.equals(st.arrival_time);
    }

    public stop_times_key(String trip_id, Integer stop_id, Time arrival_time) {
        this.trip_id = trip_id;
        this.stop_id = stop_id;
        this.arrival_time = arrival_time;
    }

    public stop_times_key() { }

    public Time getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Time arrival_time) {
        this.arrival_time = arrival_time;
    }
}
