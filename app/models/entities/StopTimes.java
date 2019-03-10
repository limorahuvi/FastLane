package models.entities;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class StopTimes {

    @EmbeddedId
    private StopTimesKey stKey;
    private Time departure_time;
    private Integer stop_sequence;
    private Boolean pickup_types;
    private Boolean drop_off_type;
    private Integer shape_dist_traveled;


}
