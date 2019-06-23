package models.entities;

import io.ebean.Finder;
import io.ebean.Model;
import org.postgis.Point;
import play.data.format.Formats;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;
import java.util.Date;

@Entity
public class SiriCsv extends Model {

    @Id
    private Long id;

    private Date recordedAtDate;
    private Time recordedAtTime;

    @ManyToOne
    @JoinColumn(name = "stop", referencedColumnName = "stop_id")
    private Stop stop;  // by MonitoringRef to stop_code(stop)

    @ManyToOne
    @JoinColumn(name = "route", referencedColumnName = "route_id")
    private Routes route; //by LineRef
    @ManyToOne
    @JoinColumn(name = "dest_stop", referencedColumnName = "stop_id")
    private Stop destinationStop; // by DestinationRef to stop_code(stop)

    @Formats.DateTime(pattern="yyyy-MM-dd")
    private Date OriginAimedDepartureDate;
    private Time OriginAimedDepartureTime;

    private Point location;
    private int vehicleRef;

    @Formats.DateTime(pattern="yyyy-MM-dd")
    private Date expectedArrivalDate;
    private Time expectedArrivalTime;

    @Formats.DateTime(pattern="yyyy-MM-dd")
    private Date aimedArrivalDate;
    private Time aimedArrivalTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRecordedAtDate() {
        return recordedAtDate;
    }

    public void setRecordedAtDate(Date recordedAtDate) {
        this.recordedAtDate = recordedAtDate;
    }

    public Time getRecordedAtTime() {
        return recordedAtTime;
    }

    public void setRecordedAtTime(Time recordedAtTime) {
        this.recordedAtTime = recordedAtTime;
    }

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }

    public Routes getRoute() {
        return route;
    }

    public void setRoute(Routes route) {
        this.route = route;
    }

    public Stop getDestinationStop() {
        return destinationStop;
    }

    public void setDestinationStop(Stop destinationStop) {
        this.destinationStop = destinationStop;
    }

    public Date getOriginAimedDepartureDate() {
        return OriginAimedDepartureDate;
    }

    public void setOriginAimedDepartureDate(Date originAimedDepartureDate) {
        OriginAimedDepartureDate = originAimedDepartureDate;
    }

    public Time getOriginAimedDepartureTime() {
        return OriginAimedDepartureTime;
    }

    public void setOriginAimedDepartureTime(Time originAimedDepartureTime) {
        OriginAimedDepartureTime = originAimedDepartureTime;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public int getVehicleRef() {
        return vehicleRef;
    }

    public void setVehicleRef(int vehicleRef) {
        this.vehicleRef = vehicleRef;
    }

    public Date getExpectedArrivalDate() {
        return expectedArrivalDate;
    }

    public void setExpectedArrivalDate(Date expectedArrivalDate) {
        this.expectedArrivalDate = expectedArrivalDate;
    }

    public Time getExpectedArrivalTime() {
        return expectedArrivalTime;
    }

    public void setExpectedArrivalTime(Time expectedArrivalTime) {
        this.expectedArrivalTime = expectedArrivalTime;
    }


    public static final Finder<Long, SiriCsv> find = new Finder<>(SiriCsv.class);

    public Date getAimedArrivalDate() {
        return aimedArrivalDate;
    }

    public void setAimedArrivalDate(Date aimedArrivalDate) {
        this.aimedArrivalDate = aimedArrivalDate;
    }

    public Time getAimedArrivalTime() {
        return aimedArrivalTime;
    }

    public void setAimedArrivalTime(Time aimedArrivalTime) {
        this.aimedArrivalTime = aimedArrivalTime;
    }
}
