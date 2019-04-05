package models.queries.passengersCount;

public class passengersCountSingleLoad {
    /*{"type":"Feature",
        "properties":{"load":0.11},
        "geometry":{
            "type":"LineString",
            "coordinates":[[34.798108,31.23819],[34.808931,31.226122]]}}*/
    public properties properties;
    public geometry geometry;

    public passengersCountSingleLoad(double[] coor1, double[] coor2, double load) {
        this.properties=new properties(load);
        this.geometry=new geometry(coor1, coor2);
    }
}
