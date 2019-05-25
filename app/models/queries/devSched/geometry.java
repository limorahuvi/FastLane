package models.queries.devSched;

public class geometry {
    public String type = "Point";
    public double[] coordinates ;
    public geometry(double[] coor1) {
        this.coordinates=coor1;
    }
    public geometry() {}
}
