package models.queries.stations;

import com.fasterxml.jackson.databind.JsonNode;
import models.VisualizationForm;
import models.entities_seg.stop_;
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

        List<stop_> stops = stop_.find.query().where()
                .icontains("stop_desc", "באר שבע").findList();
        for(stop_ stop: stops){
            double[] coor = {stop.getLocation().y,stop.getLocation().x};
           // stations.addFeature(coor, stop.getStop_id(), stop.getStop_name());
            stations.addFeature(new StationFeature(coor, stop.getStop_id(), stop.getStop_name()));
        }
        return queries.mapper.valueToTree(stations);
    }
}
