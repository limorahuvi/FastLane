package models.queries.passengersCount;

import models.queries.GeojsonTemplates.QueryFeature;

public class passengersCountFeature extends QueryFeature {

    public properties properties;
    public geometry geometry;

    public passengersCountFeature(double[] coor1, double[] coor2, double load) {
        this.properties=new properties(load);
        this.geometry=new geometry(coor1, coor2);
    }
}