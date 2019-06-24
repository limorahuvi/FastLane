package models.queries.stations;

import models.queries.GeojsonTemplates.QueryFeature;

/**
 * represents single feature in the geojsons feature collection
 * the feature contains the id and the name of the station
 */
public class StationFeature extends QueryFeature {
    public geometry geometry;
    public properties properties;

    public StationFeature(double[] coor, int id, String name) {
        this.properties=new properties(id, name);
        this.geometry=new geometry(coor);
    }
}
