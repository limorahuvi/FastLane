package models.queries.passengersCount;

import org.postgis.Point;


public class PassengerCount {
    public PassengerCount(Point point, int curr_load, String currTripId) {
        this.point = point;
        this.load = curr_load;
        this.tripId = currTripId;
    }

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    private String tripId;
    private Integer load;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    private Point point;


    @Override
    public String toString() {
        return "PassengerCount{" +
                "tripId='" + tripId + '\'' +
                ", load=" + load +
                ", point=" + point +
                '}';
    }
}
