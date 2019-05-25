package models.queries.stations;

import com.fasterxml.jackson.databind.JsonNode;
import models.VisualizationForm;
import models.entities.Stop;
import models.queries.GeojsonTemplates.QueryFeatureCollection;
import models.queries.GeojsonTemplates.QueryHandler;
import models.queries.queries;

import java.util.List;

public class stationsQueryHandler extends QueryHandler {
    public stationsQueryHandler(VisualizationForm form) {
        super(form);
    }

    public JsonNode getResults() {
        QueryFeatureCollection stations = new QueryFeatureCollection();

        List<Stop> stops = Stop.find.query().where()
                .icontains("stop_desc", "באר שבע").findList();
        for(Stop stop: stops){
            double[] coor = {stop.getLocation().y,stop.getLocation().x};
            stations.addFeature(new StationFeature(coor, stop.getStop_id(), stop.getStop_name()));
        }
        return queries.mapper.valueToTree(stations);
    }
}
