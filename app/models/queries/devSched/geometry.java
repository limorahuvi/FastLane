package models.queries.devSched;

public class geometry {
    public String type = "Point";
    public double[] coordinates = new double[2];
    public geometry(double[] coor1) {
        this.coordinates=coor1;
    }
}
