package models.queries.GeojsonTemplates;

import com.fasterxml.jackson.databind.JsonNode;
import models.queries.passengersCount.passengersCountSingleLoad;
import models.queries.queries;

import java.util.ArrayList;
import java.util.List;

public class QueryFeatureCollection {

    public String type = "FeatureCollection";
    public List<QueryFeature> features = new ArrayList<>();

    public void addFeature(QueryFeature feature){
        features.add(feature);
    }

    public JsonNode getResult(){
        return queries.mapper.valueToTree(features);
    }
}
