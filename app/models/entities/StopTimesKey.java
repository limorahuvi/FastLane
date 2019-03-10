package models.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Time;

@Embeddable
public class StopTimesKey {
    @Column(columnDefinition = "varchar")
    private String trip_id	;
    private Integer stop_id;
    private Time arrival_time;

    public int hashCode() {
        return (int)this.trip_id.hashCode()+this.stop_id+(int)this.arrival_time.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof StopTimesKey)) return false;
        StopTimesKey st = (StopTimesKey) obj;
        return st.trip_id == this.trip_id && st.stop_id == this.stop_id && st.arrival_time.equals(this.arrival_time);
    }


}