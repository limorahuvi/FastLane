package models.queries.stations;

import com.fasterxml.jackson.databind.JsonNode;
import models.entities.Stop;
import models.queries.passengersCount.passengersCountSingleLoad;
import models.queries.queries;

import java.util.ArrayList;
import java.util.List;

public class stationsQueryHandler {
    String city;


    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }



    public JsonNode getResults() {
        Stations stations = new Stations();
//        double[] coor13933 = {34.798108,31.23819};
//        double[] coor18613 = {34.808931,31.226122};
//        double[] coor11783 = {34.812412,31.219766};
//        double[] coor18622 = {34.809946,31.213571};
//        stations.addFeature(coor13933, 1, "a");
//        stations.addFeature(coor18613, 2, "b");
//        stations.addFeature(coor11783, 3, "hhhhh");
//        stations.addFeature(coor18622, 4, "n");
        List<Stop> stops = Stop.find.query().where()
                .icontains("stop_desc", "באר שבע").findList();
        for(Stop stop: stops){
            double[] coor = {stop.getLoction().y,stop.getLoction().x};
            stations.addFeature(coor, stop.getStop_id(), stop.getStop_name());
        }
        return queries.mapper.valueToTree(stations);
    }
}
