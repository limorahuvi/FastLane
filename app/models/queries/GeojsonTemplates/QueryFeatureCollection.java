package models.queries.GeojsonTemplates;

import models.queries.passengersCount.passengersCountSingleLoad;

import java.util.ArrayList;
import java.util.List;

public class QueryFeatureCollection {

    public String type = "FeatureCollection";
    public List<QueryFeature> features = new ArrayList<>();

    public void addFeature(QueryFeature feature){
        features.add(feature);
    }

}
