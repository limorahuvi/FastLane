package models.queries.passengersCount;

import models.PassengersCountForm;

import java.util.LinkedList;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.queries.queries;

public class passengersCountQueryHandler {

    private final int STOP1 = 0;
    private final int STOP2 = 1;
    private final int LOAD = 2;
    PassengersCountForm form;

    public passengersCountQueryHandler(PassengersCountForm form) {
        this.form = form;
    }

    public JsonNode getResult() {
//        TODO get results from query!
        passengersCountTotalLoad totalLoad = new passengersCountTotalLoad();
        double[] coor13933 = {34.798108,31.23819};
        double[] coor18613 = {34.808931,31.226122};
        double[] coor11783 = {34.812412,31.219766};
        double[] coor18622 = {34.809946,31.213571};
        totalLoad.addFeature(coor13933, coor18613, 11,form.getMinPassengersForPublicLane());
        totalLoad.addFeature(coor18613, coor11783, 8,form.getMinPassengersForPublicLane());
        totalLoad.addFeature(coor11783, coor18622, 7,form.getMinPassengersForPublicLane());
        return queries.mapper.valueToTree(totalLoad);
    }


}
