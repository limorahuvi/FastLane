package models.handelSegments;
import io.ebean.Ebean;
import io.ebean.Transaction;
import models.entities_seg.*;
import models.utilitiesFunc;
import org.postgis.Point;
import play.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class insertToSegDB {

    public insertToSegDB(String destDir) {
        try {
            utilitiesFunc.logger.info("starting to insert to SEG DB: (time = " + new Date() +" )");
            //String pc_path = utilitiesFunc.createPath("sources/pc.csv");
            //insertToPassengerCount(pc_path);
            insertToAgency(destDir);
            insertToRoutes(destDir);
            insertToStops(destDir);
            insertToCalendar(destDir);
            //insertSIRItoRealTime(siri_path);
            insertToSegs(destDir);
            insertToShape(destDir);
            insertToTrips(destDir);
            insertToStopTimes(destDir);
            utilitiesFunc.logger.info("Done to insert DB: (time = " + new Date() +" )");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertToSegs(String URL) {
        utilitiesFunc.logger.info("starting insert to Segs table...  (start time = " + new Date() +" )");
        Logger.info("starting insert to Segs table...  (start time = " + new Date() +" )");
        try{
            int i=0;
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL+ "/segsNew.txt"), StandardCharsets.UTF_8));
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = Ebean.currentTransaction();
                if(transaction== null){
                    transaction = Ebean.beginTransaction();
                    transaction.setBatchMode(true);  // use JDBC batch
                    transaction.setBatchSize(200);
                }
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("seg")) {
                    String tmp[] = line.split(",");
                    segs_key_ segsKey = new segs_key_();
                    segsKey.setSeg_id(Integer.parseInt(tmp[0]));
                    segsKey.setShape_pt_sequence(Integer.parseInt(tmp[3]));
                    segs_ seg = segs_.find.byId(segsKey);
                    if (seg==null)
                        seg = new segs_();
                    seg.setKey(segsKey);
                    Double shape_pt_lat =  Double.parseDouble(tmp[1]);
                    Double shape_pt_lon =  Double.parseDouble(tmp[2]);
                    Point seg_point = new Point(shape_pt_lat , shape_pt_lon);
                    seg_point.setSrid(4326);
                    seg.setPoint(seg_point);
                    stop_ stop = new stop_();
                    if (tmp.length>4) {
                        stop.setStop_id(Integer.parseInt(tmp[4]));
                        seg.setStop_id(stop);
                    }
                    seg.save();
                    i++;
                }
                if ((line = br.readLine()) ==null || i==200){
                    transaction.commit();
                    transaction.end();
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) { e.printStackTrace(); }
        utilitiesFunc.logger.info("Done insert to Segs table.   (end time = " + new Date() +" )");
        Logger.info("Done insert to Segs table.   (end time = " + new Date() +" )");
    }


/*    public static void insertSIRItoRealTime(String URL) throws SQLException {
        utilitiesFunc.logger.info("starting insert to Real Time table...   (start time = " + new Date() +" )");
        Logger.info("starting insert to Real Time table...   (start time = " + new Date() +" )");
        try {
            int i=0;
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL),  "UTF-8"));
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = Ebean.currentTransaction();
                if(transaction== null){
                    transaction = Ebean.beginTransaction();
                    transaction.setBatchMode(true);  // use JDBC batch
                    transaction.setBatchSize(100);
                }
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("RecordedAtTime")&& !line.contains("a")) {
                    String tmp[] = line.split(",");
                     siri = RealTime.find.byId(Long.parseLong(cleanQuotationMarks(tmp[0])));
                    if (siri == null)
                        siri = new RealTime();
                    siri.setRealTime_id(Integer.parseInt(cleanQuotationMarks(tmp[0])));

                    String all_record_date = cleanQuotationMarks(tmp[1]);
                    String sRecord_date = all_record_date.substring(0, 11);
                    String sRecord_time = all_record_date.substring(12, 20);
                    //System.out.println("sRecord is: "+ sRecord_time);
                    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                    Date recordDate = dateformat.parse(sRecord_date);
                    SimpleDateFormat time_format = new SimpleDateFormat("hh:mm:ss");
                    long lRecord_time = time_format.parse(sRecord_time).getTime();
                    Time record_time = new Time(lRecord_time);
                    siri.setRecordedAtTime_Date(recordDate);
                    siri.setRecordedAtTime_Time(record_time);

                    siri.setPublishedLineName(cleanQuotationMarks(tmp[7]));

                    // Contact query bean
                    //List<Stop> stopRefL =Stop.find.query().where().eq("stop_code" , Integer.parseInt(cleanQuotationMarks(tmp[16]))).findList(); //findOne();
                    //System.out.println("stop code is: " + tmp[16]);
                    //Stop stopRef=Stop.find.query().where().eq("stop_code" , Integer.parseInt(cleanQuotationMarks(tmp[16]))).findOne();//stopRefL.get(0);
                    List<Stop> stopRefL = Stop.find.query().where().eq("stop_code", Integer.parseInt(cleanQuotationMarks(tmp[16]))).findList();
                    //  System.out.println(">> stop code is : " + tmp[16]  +"  list length : " + stopRefL.size() );
                    if (stopRefL.size() > 0) {
                        Stop stopRef = stopRefL.get(0);
                        //System.out.println("stop is: "+ stopRef.getStop_id());
                        siri.setStop_id(stopRef);
                        siri.setLocation(stopRef.getLocation());
                    }
                    String all_expected_date = cleanQuotationMarks(tmp[18]);
                    String sExpected_date = all_expected_date.substring(0,10);
                    String sExpected_time = all_expected_date.substring(12,20);
                    Date expectedDate = dateformat.parse(sExpected_date);
                    long lExpected_time = time_format.parse(sExpected_time).getTime();
                    Time expected_time = new Time(lExpected_time);
                    siri.setExpectedArrivalDate(expectedDate);
                    siri.setExpectedArrivalTime(expected_time);

                    siri.save();
                    i++;
                }
                if ((line = br.readLine()) ==null || i==100){
                    transaction.commit();
                    transaction.end();
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace();}
        utilitiesFunc.logger.info("Done insert to Real Time table.  (end time = " + new Date() +" )" );
        Logger.info("Done insert to Real Time table.  (end time = " + new Date() +" )" );
    }*/

    public static String cleanQuotationMarks(String str) {
        return str.substring(1,str.length()-1);
    }

    public static void insertToAgency(String URL) throws SQLException {
        utilitiesFunc.logger.info("starting insert to Agency table...   (start time = " + new Date() +" )");
        Logger.info("starting insert to Agency table...   (start time = " + new Date() +" )");
        try {
            int i=0;
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL+"/agency.txt"),  "UTF-8"));
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = Ebean.currentTransaction();
                if(transaction== null){
                    transaction = Ebean.beginTransaction();
                    transaction.setBatchMode(true);  // use JDBC batch
                    transaction.setBatchSize(51);
                }
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("agency")) {
                    String tmp[] = line.split(",");
                    agency_ agency = agency_.find.byId(Integer.parseInt(tmp[0]));
                    if (agency==null)
                        agency = new agency_();
                    agency.setAgency_id(Integer.parseInt(tmp[0]));
                    agency.setAgency_name(tmp[1]);
                    agency.setAgency_url(tmp[2]);

                    agency.save();
                    i++;
                }
                if ((line = br.readLine()) ==null || i==51){
                    transaction.commit();
                    transaction.end();
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) {e.printStackTrace(); }
        utilitiesFunc.logger.info("Done insert to Agency table.  (end time = " + new Date() +" )" );
        Logger.info("Done insert to Agency table.  (end time = " + new Date() +" )" );
    }

    private void insertToRoutes(String URL) throws SQLException{
        utilitiesFunc.logger.info("starting insert to Routes table... (start time = " + new Date() +" )");
        Logger.info("starting insert to Routes table... (start time = " + new Date() +" )");
        try{
            int i=0;
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL+ "/routesNew.txt"), StandardCharsets.UTF_8));
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = Ebean.currentTransaction();
                if(transaction== null){
                    transaction = Ebean.beginTransaction();
                    transaction.setBatchMode(true);  // use JDBC batch
                    transaction.setBatchSize(100);
                }
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("route")) {
                    String tmp[] = line.split(",");
                    routes_ route = routes_.find.byId(Integer.parseInt(tmp[0]));
                    if (route == null)
                        route = new routes_();
                    route.setRoute_id(Integer.parseInt(tmp[0]));
                    agency_ agency_id = agency_.find.byId(Integer.parseInt(tmp[1]));
                    route.setAgency_id(agency_id);
                    route.setRoute_long_name(tmp[3]);
                    route.setRoute_desc(tmp[4]);
                    route.setRoute_type(tmp[5]);
                    if (tmp.length>6)
                        route.setRoute_color(tmp[6]);
                    route.save();
                    i++;
                }
                if ((line = br.readLine()) ==null || i==100){
                    transaction.commit();
                    transaction.end();
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) {e.printStackTrace(); }
        utilitiesFunc.logger.info("Done insert to Routes table.  (end time = " + new Date() +" )");
        Logger.info("Done insert to Routes table.  (end time = " + new Date() +" )");
    }

    public static void insertToStops(String URL) throws SQLException {
        utilitiesFunc.logger.info("starting insert to Stops table...   (start time = " + new Date() +" )");
        Logger.info("starting insert to Stops table...   (start time = " + new Date() +" )");

        try{
            int i=0;
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL+ "/stopsNew.txt"), StandardCharsets.UTF_8));
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = Ebean.currentTransaction();
                if(transaction== null){
                    transaction = Ebean.beginTransaction();
                    transaction.setBatchMode(true);  // use JDBC batch
                    transaction.setBatchSize(100);
                }
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("stop")) {
                    String tmp[] = line.split(",");
                    stop_ stop = stop_.find.byId(Long.valueOf(Integer.parseInt(tmp[0])));
                    if (stop ==null)
                        stop = new stop_();
                    stop.setStop_id(Integer.parseInt(tmp[0]));
                    stop.setStop_code(Integer.parseInt(tmp[1]));
                    stop.setStop_name(tmp[2]);
                    stop.setStop_desc(tmp[3]);
                    Double stop_lat =  Double.parseDouble(tmp[4]);
                    Double stop_lon =  Double.parseDouble(tmp[5]);
                    Point stop_point = new Point(stop_lat , stop_lon);
                    stop_point.setSrid(4326);
                    stop.setLocation(stop_point);
                    stop.setLocation_type(Boolean.parseBoolean(tmp[6]));

                    if (tmp.length> 7 && !(tmp[7].equals(""))) {
                        //if (!(tmp[7].equals(""))) {
                        stop_ parent = stop_.find.byId(Long.valueOf(Integer.parseInt(tmp[7])));
                        stop.setParent_station(parent);
                        // }
                    }
                    stop.save();
                    i++;
                }
                if ((line = br.readLine()) ==null || i==100){
                    transaction.commit();
                    transaction.end();
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) { e.printStackTrace(); }
        utilitiesFunc.logger.info("Done insert to Stops table. (end time = " + new Date() +" )");
        Logger.info("Done insert to Stops table. (end time = " + new Date() +" )");
    }

    public static void insertToCalendar(String URL) throws SQLException {
        utilitiesFunc.logger.info("starting insert to Calendar table...   (start time = " + new Date() +" )");
        Logger.info("starting insert to Calendar table...   (start time = " + new Date() +" )");
        try{
            int i=0;
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL+ "/calendar.txt"), StandardCharsets.UTF_8));
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = Ebean.currentTransaction();
                if(transaction== null){
                    transaction = Ebean.beginTransaction();
                    transaction.setBatchMode(true);  // use JDBC batch
                    transaction.setBatchSize(100);
                }
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("service")) {
                    String tmp[] = line.split(",");
                    calendar_ calendar = calendar_.find.byId(Integer.parseInt(tmp[0]));
                    if (calendar == null)
                        calendar = new calendar_();
                    calendar.setService_id(Integer.parseInt(tmp[0]));
                    String days_bytes = calendar_.mergeDayes(tmp[1],tmp[2],tmp[3],tmp[4],tmp[5],tmp[6],tmp[7]);
                    calendar.setDays_bytes(days_bytes);
                    SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
                    Date start_date = dateformat.parse(tmp[9]);
                    Date end_date = dateformat.parse(tmp[8]);
                    calendar.setStart_date(start_date);
                    calendar.setEnd_date(end_date);

                    calendar.save();
                    i++;
                }
                if ((line = br.readLine()) ==null || i==100){
                    transaction.commit();
                    transaction.end();
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace();}
        utilitiesFunc.logger.info("Done insert to Calendar table.   (end time = " + new Date() +" )");
        Logger.info("Done insert to Calendar table.   (end time = " + new Date() +" )");
    }

    private void insertToTrips(String URL) throws SQLException {
        utilitiesFunc.logger.info("starting insert to Trips table...   (start time = " + new Date() +" )");
        Logger.info("starting insert to Trips table...   (start time = " + new Date() +" )");
        try{
            int i=0;
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL+ "/tripsNew.txt"), StandardCharsets.UTF_8));
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = Ebean.currentTransaction();
                if(transaction== null){
                    transaction = Ebean.beginTransaction();
                    transaction.setBatchMode(true);  // use JDBC batch
                    transaction.setBatchSize(100);
                }
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("trip_id")) {
                    String tmp[] = line.split(",");
                    trips_ trip = trips_.find.byId(tmp[2]);
                    if (trip == null)
                        trip =new trips_();
                    trip.setTrip_id(tmp[2]);
                    routes_ route_id = routes_.find.byId(Integer.parseInt(tmp[0]));
                    trip.setRoute_id(route_id);
                    calendar_ service_id = calendar_.find.byId(Integer.parseInt(tmp[1]));
                    trip.setService_id(service_id);
                    trip.setDirection_id(Boolean.parseBoolean(tmp[4]));
                    if (tmp.length>5) {
                        trip.setShape_id(Integer.parseInt(tmp[5]));
                    }
                    trip.save();
                    i++;
                }
                if ((line = br.readLine()) ==null || i==100){
                    transaction.commit();
                    transaction.end();
                    i=0;
                }
            }
            br.close();
        } catch(IOException e) { e.printStackTrace(); }
        utilitiesFunc.logger.info("Done insert to Trips table.    (end time = " + new Date() +" )");
        Logger.info("Done insert to Trips table.    (end time = " + new Date() +" )");
    }

    private void insertToShape(String URL) throws SQLException {
        utilitiesFunc.logger.info("starting insert to Shapes table...  (start time = " + new Date() +" )");
        Logger.info("starting insert to Shapes table...  (start time = " + new Date() +" )");
        try{
            int i=0;
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL+ "/shapesNew.txt"), StandardCharsets.UTF_8));
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = Ebean.currentTransaction();
                if(transaction== null){
                    transaction = Ebean.beginTransaction();
                    transaction.setBatchMode(true);  // use JDBC batch
                    transaction.setBatchSize(200);
                }
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("shape")) {
                    String tmp[] = line.split(",");

                   // shapes_key_ shapeKey = new shapes_key_();
                    segs_key_ seg_key = new segs_key_();
                   // shapeKey.setShape_id(Integer.parseInt(tmp[0]));
                    Integer shape_id = Integer.parseInt(tmp[0]);
                    seg_key.setSeg_id(Integer.parseInt(tmp[1]));
                    seg_key.setShape_pt_sequence(Integer.parseInt(tmp[2]));
                    segs_ segs = segs_.find.byId(seg_key);
                  //  shapeKey.setSegs_key(segs);
                  //  shapeKey.setShape_pt_sequence(Integer.parseInt(tmp[2]));
                    shapes_ shape = shapes_.find.byId(shape_id);

                    if (shape==null) {
                        shape = new shapes_();
                    }
                    shape.setShape_id(shape_id);
                    shape.setSeg_id(segs);

                   /* seg_key.setShape_pt_sequence(Integer.parseInt(tmp[2]));
                    seg_key.setSeg_id(Integer.parseInt(tmp[1]));
                    segs_ shapeSeg =  segs_.find.byId(seg_key);

                    shape.setSeg_id(shapeSeg);*/

                    shape.save();
                    i++;
                }
                if ((line = br.readLine()) ==null || i==200){
                    transaction.commit();
                    transaction.end();
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) { e.printStackTrace(); }
        utilitiesFunc.logger.info("Done insert to Shapes table.   (end time = " + new Date() +" )");
        Logger.info("Done insert to Shapes table.   (end time = " + new Date() +" )");
    }

    private void insertToStopTimes(String URL) throws SQLException {
        utilitiesFunc.logger.info("starting insert to Stop Times table... (start time = " + new Date() +" )");
        Logger.info("starting insert to Stop Times table... (start time = " + new Date() +" )");
        try{
            int i=0;
            int index =0 ;
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL+ "/stop_timesNew.txt"), StandardCharsets.UTF_8));
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = Ebean.currentTransaction();
                if(transaction== null){
                    transaction = Ebean.beginTransaction();
                    transaction.setBatchMode(true);  // use JDBC batch
                    transaction.setBatchSize(500);
                }
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("stop")) {
                    String tmp[] = line.split(",");
                    trips_ trip = trips_.find.byId(tmp[0]);
                    SimpleDateFormat time_format = new SimpleDateFormat("HH:MM:SS");
                    long arrivalTime = time_format.parse(tmp[1]).getTime();
                    Time arrival_time = new Time(arrivalTime);
                    stop_ stop = stop_.find.byId(Long.valueOf(Integer.parseInt(tmp[3])));
                    stop_times_ stopTime = stop_times_.find.byId(new stop_times_key(trip.getTrip_id(),stop.getStop_id(),arrival_time));
                    if (stopTime == null)
                        stopTime = new stop_times_();

                    stopTime.setTrip(trip);
                    stopTime.getStKey().setArrival_time(arrival_time);
                    stopTime.setStop(stop);
                    long departureTime = time_format.parse(tmp[2]).getTime();
                    Time departure_time = new Time(departureTime);
                    stopTime.setDeparture_time(departure_time);
                    stopTime.setStop_sequence(Integer.parseInt(tmp[4]));
                    stopTime.setPickup_types(Boolean.parseBoolean(tmp[5]));
                    stopTime.setDrop_off_type(Boolean.parseBoolean(tmp[6]));
                    if (tmp.length>7) {
                        stopTime.setShape_dist_traveled(Integer.parseInt(tmp[7]));
                        stopTime.setLoad(Integer.parseInt(tmp[8]));
                    }
                    stopTime.save();
                    i++;
                }
                if ((line = br.readLine()) ==null || i==500){
                    transaction.commit();
                    transaction.end();
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace();}
        utilitiesFunc.logger.info("Done insert to Stop Times table.   (end time = " + new Date() +" )");
        Logger.info("Done insert to Stop Times table.   (end time = " + new Date() +" )");
    }

}
