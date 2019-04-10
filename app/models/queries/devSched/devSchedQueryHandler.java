package models.queries.devSched;

import models.DevSchedForm;

import java.util.LinkedList;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.queries.queries;
import play.libs.Json;

public class devSchedQueryHandler {

    DevSchedForm form;

    public devSchedQueryHandler(DevSchedForm form) {
        this.form = form;
    }

    public JsonNode getResult() {
//        TODO get results from query!
        devSchedFeatureCollection totalLoad = new devSchedFeatureCollection();
        double[] coor13933 = {34.798256,31.260114};
        double average1=2;
        double average2=5;
        String[] des1={"line 3: 2 minutes", "line 4 :2 minutes"};
        String[] des2={"line 3: 5 minutes", "line 4 :5 minutes"};
        totalLoad.addFeature(coor13933,average1,average2,des1,des2);
        return queries.mapper.valueToTree(totalLoad);
    }


}
