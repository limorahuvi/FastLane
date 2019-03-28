package models.queries.passengersCount;

import java.util.ArrayList;
import java.util.List;

public class passengersCountTotalLoad {
    public String type = "FeatureCollection";
    public List<passengersCountSingleLoad> features = new ArrayList<>();

    public void addFeature(double[] coor1, double[] coor2, int load, int loadFactor) {
        double relativeLoad = loadFactor == 0||load>loadFactor ? 1 : load/loadFactor;
        features.add(new passengersCountSingleLoad(coor1,coor2,relativeLoad));
    }
}
