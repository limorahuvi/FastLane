package models.queries.passengersCount;

/**
 * geometry of a feature in the geojsons collection
 */
public class geometry {
    public String type = "LineString";
    public double[][] coordinates = new double[2][2];
    public geometry(double[] coor1, double[] coor2) {
        this.coordinates[0]=coor1;
        this.coordinates[1]=coor2;
    }
}
