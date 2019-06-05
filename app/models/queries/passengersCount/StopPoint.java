package models.queries.passengersCount;

import org.postgis.Point;

public class StopPoint {
    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    Point point;

    public Integer getStopId() {
        return stopId;
    }

    public void setStopId(Integer stopId) {
        this.stopId = stopId;
    }

    Integer stopId;
    public StopPoint(Point point, Integer stop_id) {
        this.point = point;
        this.stopId = stop_id;
    }
}
