package models.queries.passengersCount;

import io.ebean.Ebean;
import io.ebean.Expr;
import models.PassengersCountForm;

import java.time.LocalTime;
import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import models.entities.PassengerCounts;
import models.entities_seg.*;
import models.queries.GeojsonTemplates.QueryFeatureCollection;
import models.queries.GeojsonTemplates.QueryHandler;
import models.queries.queries;

public class passengersCountQueryHandler extends QueryHandler {

    private final int STOP1 = 0;
    private final int STOP2 = 1;
    private final int LOAD = 2;

    public passengersCountQueryHandler(PassengersCountForm form) {
        super(form);
    }

    public JsonNode getResult() {
        List<calendar_> calendar_match = getMatchedCalendar();
        List<segs_> segs_match = getMatchedSegs();
        Set segs_set = SegsListToSet(segs_match);
        List<shapes_> shapes_match = getMatchedShapes(segs_set);
        List<trips_> trips_match = getMatchedTrips(ShapesListToSet(shapes_match), CalendarListToSet(calendar_match));
        List<stop_times_> stops_times_match = getMatchedStopTimes(TripsToSet(trips_match));
        List<PassengerCount> pcs = createPassengerCountObjects(segs_match, shapes_match, trips_match, stops_times_match);
//        return queries.mapper.valueToTree(getDemoPassengersCountTotalLoad());
        QueryFeatureCollection totalLoad = getPassengersCountTotalLoad(pcs);

        return queries.mapper.valueToTree(totalLoad);
    }


    private List<PassengerCount> createPassengerCountObjects(List<segs_> segs_match, List<shapes_> shapes_match, List<trips_> trips_match, List<stop_times_> stops_times_match) {
        List<PassengerCount> result = new LinkedList<>();
        String handledTripId = "";
        int currStopId = -1;

        int currShapeId = -1;
        int currSegIndex = -1;
        List<StopPoint> currPoints = new LinkedList<>();
        for(int i = 0; i<stops_times_match.size(); i++){
            String currTripId = stops_times_match.get(i).getTrip().getTrip_id();
            if(!handledTripId.equals(currTripId)){
                handledTripId = currTripId;
                currShapeId = stops_times_match.get(i).getTrip().getShape_id();
                currPoints = getAllSPointsByShapeId(currShapeId);
                currStopId = stops_times_match.get(i).getStop().getStop_id();
                currSegIndex = getCurrPointIndex(currStopId, currPoints);
            }

            int curr_load = stops_times_match.get(i).getLoad();
            /* handle only segs till end */
            if(i + 1 == stops_times_match.size() ||
                stops_times_match.get(i).getTrip().getTrip_id().equals(stops_times_match.get(i+1).getTrip().getTrip_id())){
                currSegIndex = createPassengerCounts(currSegIndex, currPoints, currTripId, curr_load, -1, result);
            }

            /* still in same trip - handle till next stop id */
            else{
                currSegIndex = createPassengerCounts(currSegIndex, currPoints,currTripId, curr_load, stops_times_match.get(i+1).getStop().getStop_id(), result);
            }
        }

        return result;
    }

    private int createPassengerCounts(int currSegIndex, List<StopPoint> points, String currTripId, int curr_load, int nextStopId, List<PassengerCount> newPcList) {
        for(; currSegIndex<points.size() && points.get(currSegIndex).getStopId()!=nextStopId; currSegIndex++){
            PassengerCount new_pc = new PassengerCount(points.get(currSegIndex).getPoint(), curr_load, currTripId);
//            System.out.println(new_pc);
            newPcList.add(new_pc);
        }
        return currSegIndex;
    }

    private int getCurrPointIndex(int currStopId, List<StopPoint> points) {
        for(int i = 0; i<points.size(); i++){
            if(currStopId == points.get(i).getStopId()){
                return i;
            }
        }
        return 0;
    }

    private List<StopPoint> getAllSPointsByShapeId(int currShapeId) {
        List<shapes_> shapes = shapes_.find.query()
                .where()
                .eq("shape_id", currShapeId)
                .order().desc("shape_pt_sequence")
                .findList();

        List<Integer> matchedSegs = new LinkedList<>();
        for(shapes_ s : shapes){
            matchedSegs.add(s.getSeg_id().getKey().getSeg_id());
        }

        List<segs_> allSegs =
                Ebean.find(segs_.class).findList();

        List<StopPoint> points = new LinkedList<>();
        for(segs_ s : allSegs){
            if(matchedSegs.contains(s.getKey().getSeg_id())){
                int stop = -1;
                if (s.getStop_id()!=null){
                    stop = s.getStop_id().getStop_id();
                }
                points.add(new StopPoint(s.getPoint(), stop));
            }
        }
        return points;
    }

    private List<stop_times_> getMatchedStopTimes(Set<trips_> trips) {
        List<stop_times_> list =
                Ebean.find(stop_times_.class).findList();

        List<stop_times_> stop_times =  Ebean.filter(stop_times_.class)
                .in("trip",trips)
                .sort("trip_id")
                .sort("stop_sequence")
                .between("departure_time", LocalTime.parse(form.getStartHour() + ":00"), LocalTime.parse(form.getEndHour() + ":59"))
                .filter(list);
        /* DEBUG
        System.out.println("stop times");
        for(stop_times_ s : stop_times){
            System.out.println(s.getTrip().getTrip_id()+" "+s.getStop_sequence()+" "+s.getStop().getStop_id() +" "+s.getLoad());
        }*/
        return stop_times;
    }

    private Set<trips_> TripsToSet(List<trips_> trips_match) {
        Set<trips_> result = new HashSet<>();
        result.addAll(trips_match);
        return result;
    }



    private List<trips_> getMatchedTrips(Set<Integer> shapes, Set<calendar_> calendar) {
        List<trips_> list =
                Ebean.find(trips_.class).findList();

        List<trips_> trips =  Ebean.filter(trips_.class)
                .sort("trip_id")
                .in("shape_id",shapes) //add service
                .filter(list);

        /* DEBUG
        System.out.println("calendar");
        for(calendar_ s : calendar){
            System.out.println(s.getService_id());
        } System.out.println("shapes");

        System.out.println("trips");
        for(trips_ s : trips){
            System.out.println(s.getTrip_id());
            System.out.println(s.getShape_id());
        }*/

        return trips;
    }

    private Set CalendarListToSet(List<calendar_> calendar_match) {
        Set result = new HashSet();
        result.addAll(calendar_match);
        return result;
    }

    private Set ShapesListToSet(List<shapes_> shapes_match) {
        Set result = new HashSet();
//        result.addAll(shapes_match);
        for(shapes_ s : shapes_match){
            result.add(s.getShape_id());
        }
        return result;
    }

    private int[] SegsListToArray(List<segs_> segs_match) {
        int[] result = new int [segs_match.size()];
//        System.out.println("SegsListToArray");
        for(int i=0; i<segs_match.size(); i++){
            result[i] = segs_match.get(i).getKey().getSeg_id();
            /* DEBUG */
//            System.out.println( result[i]);
        }
        return result;
    }

    private Set SegsListToSet(List<segs_> segs_match) {
        Set result = new HashSet<>();
        result.addAll(segs_match);
        /*for(int i=0; i<segs_match.size(); i++){
            result.add(segs_match.get(i).getKey().getSeg_id());
        }*/
        return result;
    }

    // get shapes according to segs
    private List<shapes_> getMatchedShapes(Set segs) {
        List<shapes_> list =
                Ebean.find(shapes_.class).findList();

        List<shapes_> shapes =  Ebean.filter(shapes_.class)
                .in("seg_id",segs)
                .filter(list);

        /* DEBUG
        System.out.println("shapes");
        for(shapes_ s : shapes){
            System.out.println(s.getSeg_id());
            System.out.println(s.getShape_id());
        }*/

        return shapes;
    }

    // get segs according to coors
    private List<segs_> getMatchedSegs() {
        List<segs_> segs = segs_.find.query()
                .where()
                .between("ST_X(point)", square[MIN_X],square[MAX_X])
                .between("ST_Y(point)", square[MIN_Y],square[MAX_Y])
                .findList();

        /* DEBUG
        System.out.println("segs");
        for(segs_ s : segs){
            System.out.println(s.getStop_id());
            System.out.println(s.getKey());
        }*/
        return segs;
    }

    // get calenders records according to dates & day
    private List<calendar_> getMatchedCalendar() {
        List<calendar_> result = calendar_.find.query()
                .where()
                .in("days_bytes", getDayInBytes(form.getDay()))
                .or(
                    Expr.or(
                            Expr.and(
                                    Expr.between("start_date", form.getStartDate(), form.getEndDate()),
                                    Expr.between("end_date", form.getStartDate(), form.getEndDate())),
                            Expr.and(
                                    Expr.le("start_date", form.getStartDate()),
                                    Expr.between("end_date", form.getStartDate(), form.getEndDate()))
                            ),
                    Expr.or(
                            Expr.and(
                                    Expr.between("start_date", form.getStartDate(), form.getEndDate()),
                                    Expr.ge("end_date", form.getEndDate())),
                            Expr.and(
                                    Expr.le("start_date", form.getStartDate()),
                                    Expr.ge("end_date", form.getEndDate()))
                            ))
                .findList();

        /* DEBUG
        System.out.println("form:");
        System.out.println(form.startDate);
        System.out.println(form.endDate);
        System.out.println("calendar:");
        for(calendar_ c : result){
            System.out.println(c.getDays_bytes());
            System.out.println(c.getStart_date());
            System.out.println(c.getEnd_date());
            System.out.println("");
        }*/

        return result;
    }

    String[] all_days = getAllPossibleStringDays();
    private String[] getDayInBytes(String day) {
        String[] days = null;

        int day_as_int = -1;
        if(day.equals("Sunday")) day_as_int = 0;
        if(day.equals("Sunday")) day_as_int = 0;
        if(day.equals("Monday")) day_as_int = 1;
        if(day.equals("Tuesday")) day_as_int = 2;
        if(day.equals("Wednesday")) day_as_int = 3;
        if(day.equals("Thursday")) day_as_int = 4;
        if(day.equals("Friday")) day_as_int = 5;
        if(day.equals("Saturday")) day_as_int = 6;

        if(day_as_int == -1){
            days = all_days;
        }
        else{
            days = changePossibleStringDaysAccordingToDay(day_as_int);
        }

        /* DEBUG
        System.out.println("changePossibleStringDaysAccordingToDay: " +form.getDay() +""+day_as_int);
        for(int i=0; i<all_days.length; i++){
            System.out.println(days[i]);
        }*/

        return days;
    }

    private String[] changePossibleStringDaysAccordingToDay(int day) {
        String[] days = new String[all_days.length];
        for(int i = 0 ; i<all_days.length; i++){
            StringBuilder new_day = new StringBuilder(all_days[i]);
            new_day.setCharAt(day, '1');
            days[i] = new_day.toString();
        }
        return days;
    }

    private String[] getAllPossibleStringDays() {
        int total_options = (int)Math.pow(2,7);
        String[] result = new String[total_options];
        for(int i=0; i<total_options; i++){
            String num = Integer.toString(i, 2);
            while(num.length()<7){
                num = '0'+num;
            }
            result[i]=num;
        }
        return result;
    }


/*
    public JsonNode getResultWithoutSegs() {

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
    }*/


    private QueryFeatureCollection getPassengersCountTotalLoad(List<PassengerCount> pcs) {
        QueryFeatureCollection totalLoad = new QueryFeatureCollection();
        int minPassengersForPublicLane = ((PassengersCountForm)(form)).getMinPassengersForPublicLane();
        for(int i=0; i<pcs.size()-1; i++){
            PassengerCount currPC = pcs.get(i);
            PassengerCount nextPC = pcs.get(i+1);
            if(currPC.getTripId().equals(nextPC.getTripId())){
                double[] coorFrom = getCoor(currPC);
                double[] coorTo = getCoor(nextPC);
                double pcLoad = currPC.getLoad();
                double relativeLoad = minPassengersForPublicLane == 0||pcLoad>minPassengersForPublicLane ? 1 : (double)pcLoad/minPassengersForPublicLane;
                totalLoad.addFeature(new passengersCountFeature(coorFrom, coorTo, relativeLoad));
            }
        }
        return totalLoad;
    }

    private double[] getCoor(PassengerCount pc) {
        double[] coor = new double[2];
        coor[0] = pc.getPoint().y;
        coor[1] = pc.getPoint().x;
        return coor;
    }

    private QueryFeatureCollection getDemoPassengersCountTotalLoad() {
        QueryFeatureCollection totalLoad = new QueryFeatureCollection();
        double[] coor13933 = {34.798108,31.23819};
        double[] coor18613 = {34.808931,31.226122};
        double[] coor11783 = {34.812412,31.219766};
        double[] coor18622 = {34.809946,31.213571};
        totalLoad.addFeature(new passengersCountFeature(coor13933,coor18613,0.3));
        totalLoad.addFeature(new passengersCountFeature(coor18613, coor11783,0.6));
        totalLoad.addFeature(new passengersCountFeature(coor11783, coor18622,0.9));
        return totalLoad;
    }


}
