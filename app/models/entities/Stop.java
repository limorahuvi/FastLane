package models.entities;

import org.postgis.Point;

import javax.persistence.*;

@Entity
public class Stop {

    @Id
    private Integer stop_id;
    private Integer stop_code;
    private String privatestop_name	;
    private String stop_desc;
    private Point loction;
    private int location_type;
    private Integer parent_station;
}
