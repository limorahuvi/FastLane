package models.queries.passengersCount;

import models.PassengersCountForm;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.entities.PassengerCounts;
import models.queries.queries;
import org.postgis.Point;

public class passengersCountQueryHandler {

    private final int MIN_X = 0;
    private final int MAX_X = 1;
    private final int MIN_Y = 2;
    private final int MAX_Y = 3;
    private final int STOP1 = 0;
    private final int STOP2 = 1;
    private final int LOAD = 2;
    PassengersCountForm form;

    public passengersCountQueryHandler(PassengersCountForm form) {
        this.form = form;
    }

    public JsonNode getResult() {
        double[] square = getSquareArea();
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
        passengersCountTotalLoad totalLoad = getPassengersCountTotalLoad(pcs);
        return queries.mapper.valueToTree(totalLoad);
    }

    private double[] getSquareArea() {
        double[] square = new double[4];
        String coor1=form.getCoor1();
        String[] coor1_x_y= coor1.split(",");
        String coor2=form.getCoor2();
        String[] coor2_x_y=coor2.split(",");
        Point p1=new Point(Double.parseDouble(coor1_x_y[1]),Double.parseDouble(coor2_x_y[0]));
        Point p2=new Point(Double.parseDouble(coor2_x_y[1]),Double.parseDouble(coor1_x_y[0]));
        Point p3=new Point(Double.parseDouble(coor1_x_y[1]),Double.parseDouble(coor1_x_y[0]));
        Point p4=new Point(Double.parseDouble(coor2_x_y[1]),Double.parseDouble(coor2_x_y[0]));
        square[MAX_X]=Math.max(Math.max(p1.getX(),p2.getX()),Math.max(p3.getX(),p4.getX()));
        square[MIN_X]=Math.min(Math.min(p1.getX(),p2.getX()),Math.min(p3.getX(),p4.getX()));
        square[MAX_Y]=Math.max(Math.max(p1.getY(),p2.getY()),Math.max(p3.getY(),p4.getY()));
        square[MIN_Y]=Math.min(Math.min(p1.getY(),p2.getY()),Math.min(p3.getY(),p4.getY()));
        return square;
    }

    private passengersCountTotalLoad getPassengersCountTotalLoad(List<PassengerCounts> pcs) {
        passengersCountTotalLoad totalLoad = new passengersCountTotalLoad();
        for(int i=0; i<pcs.size()-1; i++){
            if(pcs.get(i).getTripId()-pcs.get(i+1).getTripId()==0){
                double[] coorFrom = getCoor(pcs,i);
                double[] coorTo = getCoor(pcs,i+1);
                totalLoad.addFeature(coorFrom, coorTo, pcs.get(i).getPassengersContinue_rounded_sofi(),form.getMinPassengersForPublicLane());
            }
        }
        return totalLoad;
    }

    private double[] getCoor(List<PassengerCounts> pcs, int i) {
        double[] coor = new double[2];
        coor[0] = pcs.get(i).getPoint().y;
        coor[1] = pcs.get(i).getPoint().x;
        return coor;
    }

    private passengersCountTotalLoad getDemoPassengersCountTotalLoad() {
        passengersCountTotalLoad totalLoad = new passengersCountTotalLoad();
        double[] coor13933 = {34.798108,31.23819};
        double[] coor18613 = {34.808931,31.226122};
        double[] coor11783 = {34.812412,31.219766};
        double[] coor18622 = {34.809946,31.213571};
        totalLoad.addFeature(coor13933, coor18613, 11,form.getMinPassengersForPublicLane());
        totalLoad.addFeature(coor18613, coor11783, 8,form.getMinPassengersForPublicLane());
        totalLoad.addFeature(coor11783, coor18622, 7,form.getMinPassengersForPublicLane());
        return totalLoad;
    }


}
