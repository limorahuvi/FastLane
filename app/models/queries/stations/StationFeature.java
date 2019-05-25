package models.queries.stations;

import models.queries.GeojsonTemplates.QueryFeature;

public class StationFeature extends QueryFeature {
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
    public geometry geometry;
    public properties properties;

    public StationFeature(double[] coor, int id, String name) {
        this.properties=new properties(id, name);
        this.geometry=new geometry(coor);
    }
}
