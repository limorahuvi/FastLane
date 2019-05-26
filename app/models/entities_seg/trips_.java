package models.entities_seg;

import io.ebean.Finder;
import models.entities.Trips;

import javax.persistence.*;

@Entity
public class trips_ {


    @Id
    @Column(columnDefinition = "varchar")
    private String trip_id;
    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "route_id")
    private routes_ route_id;
    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private calendar_ service_id;
    private Boolean direction_id;
    private Integer shape_id;

    public static final Finder<String, Trips> find = new Finder<>(Trips.class);

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public routes_ getRoute_id() {
        return route_id;
    }

    public void setRoute_id(routes_ route_id) {
        this.route_id = route_id;
    }

    public calendar_ getService_id() {
        return service_id;
    }

    public void setService_id(calendar_ service_id) {
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
