package models.queries.siriCsv;

import com.fasterxml.jackson.databind.JsonNode;
import models.entities.PassengerCounts;
import models.entities.SiriCsv;
import models.SiriCsvForm;
import models.queries.GeojsonTemplates.QueryHandler;
import models.queries.queries;

public class siriCsvQueryHandler extends QueryHandler {

    public siriCsvQueryHandler(SiriCsvForm form) {
        super(form);
    }

    public JsonNode getResult() {
        int count = SiriCsv.find.query().findCount();
        return queries.mapper.valueToTree(count);

    }
}
