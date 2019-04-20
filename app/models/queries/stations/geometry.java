package models.queries.stations;

public class geometry {
    public String type = "Point";
    public double[] coordinates;
    public geometry(double[] coor) {
        this.coordinates=coor;
    }
}
