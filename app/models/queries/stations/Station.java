package models.queries.stations;

public class Station {
    /*[
    {
      "type": "Feature",
      "geometry": {
        "type": "Point",
        "coordinates":  [ 34.788481,31.245344 ]
      },
      "properties": {
        "id":669,
        "name":"שדרות דוד טוביהו/סוקולוב"
      }
    }*/
    public String type = "Feature";
    public geometry geometry;
    public properties properties;

    public Station(double[] coor, int id, String name) {
        this.properties=new properties(id, name);
        this.geometry=new geometry(coor);
    }
}
