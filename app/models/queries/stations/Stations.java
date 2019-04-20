package models.queries.stations;

import java.util.ArrayList;
import java.util.List;

public class Stations {
    public String type = "FeatureCollection";
    public List<Station> features = new ArrayList<>();

    public void addFeature(double[] coor, int id, String name) {
        features.add(new Station(coor, id, name));
    }
}
