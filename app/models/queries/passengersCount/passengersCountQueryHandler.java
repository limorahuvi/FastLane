package models.queries.passengersCount;

import models.PassengersCountForm;

import java.time.LocalTime;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import models.entities.PassengerCounts;
import models.queries.GeojsonTemplates.QueryFeatureCollection;
import models.queries.GeojsonTemplates.QueryHandler;
import models.queries.queries;

/**
 * handles the passengers count query
 */
public class passengersCountQueryHandler extends QueryHandler {

    private final int STOP1 = 0;
    private final int STOP2 = 1;
    private final int LOAD = 2;

    public passengersCountQueryHandler(PassengersCountForm form) {
        super(form);
    }

    public JsonNode getResult() {

        List<PassengerCounts> pcs = PassengerCounts.find.query()
                .where()
                .between("date_key", form.getStartDate(), form.getEndDate())
                .between("hour_key", LocalTime.parse(form.getStartHour() + ":00"), LocalTime.parse(form.getEndHour() + ":00"))
                .contains("DayNameHeb", form.getDay().equals("All") ? "" : form.getDay())
                .between("ST_X(point)", square[MIN_X],square[MAX_X])
                .between("ST_Y(point)", square[MIN_Y],square[MAX_Y])
                .order().desc("TripId")
                .order().desc("station_order")
                .findList();
        QueryFeatureCollection totalLoad = getPassengersCountTotalLoad(pcs);
        return queries.mapper.valueToTree(totalLoad);
    }



    private QueryFeatureCollection getPassengersCountTotalLoad(List<PassengerCounts> pcs) {
        QueryFeatureCollection totalLoad = new QueryFeatureCollection();
        int minPassengersForPublicLane = ((PassengersCountForm)(form)).getMinPassengersForPublicLane();
        for(int i=0; i<pcs.size()-1; i++){
            PassengerCounts currPC = pcs.get(i);
            PassengerCounts nextPC = pcs.get(i+1);
            if(currPC.getTripId()-nextPC.getTripId()==0){
                double[] coorFrom = getCoor(currPC);
                double[] coorTo = getCoor(nextPC);
                double pcLoad = currPC.getPassengersContinue_rounded_final();
                double relativeLoad = minPassengersForPublicLane == 0||pcLoad>minPassengersForPublicLane ? 1 : (double)pcLoad/minPassengersForPublicLane;
                totalLoad.addFeature(new passengersCountFeature(coorFrom, coorTo, relativeLoad));
            }
        }
        return totalLoad;
    }

        private double[] getCoor (PassengerCounts pc){
            double[] coor = new double[2];
            coor[0] = pc.getPoint().y;
            coor[1] = pc.getPoint().x;
            return coor;
        }


}
