package models.queries.stations;

/**
 * represents the geometry of a single station
 */
public class geometry {
    public String type = "Point";
    public double[] coordinates;
    public geometry(double[] coor) {
        this.coordinates=coor;
    }
}
