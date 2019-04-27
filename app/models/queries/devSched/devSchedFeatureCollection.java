package models.queries.devSched;

import java.util.ArrayList;
import java.util.List;

public class devSchedFeatureCollection {
    public String type = "FeatureCollection";
    public List<devSchedSingleFeature> features = new ArrayList<>();

    public void addFeature(double[] coor1,double average1,double average2,String description1,String description2) {
        features.add(new devSchedSingleFeature(coor1,average1,average2,description1,description2));
    }
}
