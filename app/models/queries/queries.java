package models.queries;

import com.fasterxml.jackson.databind.JsonNode;
import models.DevSchedForm;
import models.PassengersCountForm;
import models.entities.RealTime;
import models.SiriCsvForm;
import models.queries.passengersCount.passengersCountQueryHandler;
import models.queries.devSched.devSchedQueryHandler;
import models.queries.siriCsv.siriCsvQueryHandler;
import models.queries.stations.stationsQueryHandler;
import org.postgis.Point;
import play.libs.Json;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * handles visualizations queries
 */
public class queries {

    static JsonNode stations = null;
    public static ObjectMapper mapper = new ObjectMapper();


    /**
     * @return geojson of all stations (ONLY beer sheva)
     */
    public static JsonNode getStations(){
        stationsQueryHandler handler = new stationsQueryHandler(null);
        return handler.getResults();
    }

    /* VISUALIZATIONS */
    /**
     * @param form - passengers count parameters filtering
     * @return
     */
    public static JsonNode getResults(PassengersCountForm form){
        passengersCountQueryHandler handler = new passengersCountQueryHandler(form);
        return handler.getResult();
    }

    /**
     * @param form - DevSched parameters filtering
     * @return
     */
    public static JsonNode getResults(DevSchedForm form){
        devSchedQueryHandler handler = new devSchedQueryHandler(form);
        return handler.getResult();
    }


    public static JsonNode getResults(SiriCsvForm form){
        siriCsvQueryHandler handler = new siriCsvQueryHandler(form);
        return handler.getResult();
    }


}
