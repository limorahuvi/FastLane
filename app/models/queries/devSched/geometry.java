package models.queries.devSched;

/**
 * geometry of a feature in the geojsons collection
 */
public class geometry {
    public String type = "Point";
    public double[] coordinates ;
    public geometry(double[] coor1) {
        this.coordinates=coor1;
    }
    public geometry() {}
}
