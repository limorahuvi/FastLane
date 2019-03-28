package models.entities;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

@Entity
public class Trips extends Model{

    @Id
    @Column(columnDefinition = "varchar")
    private String trip_id;
    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "route_id")
    private Routes route_id;
    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Calendar service_id;
    private Boolean direction_id;
    private Integer shape_id;

    public static final Finder<Integer, Trips> find = new Finder<>(Trips.class);

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public Routes getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Routes route_id) {
        this.route_id = route_id;
    }

    public Calendar getService_id() {
        return service_id;
    }

    public void setService_id(Calendar service_id) {
        this.service_id = service_id;
    }

    public Boolean getDirection_id() {
        return direction_id;
    }

    public void setDirection_id(Boolean direction_id) {
        this.direction_id = direction_id;
    }

    public Integer getShape_id() {
        return shape_id;
    }

    public void setShape_id(Integer shape_id) {
        this.shape_id = shape_id;
    }
}