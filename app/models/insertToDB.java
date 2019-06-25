package models;

import io.ebean.Ebean;
import io.ebean.Transaction;
import play.Logger;

import models.entities.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import org.postgis.Point;
import java.util.Date;
import java.text.*;
import java.sql.Time;

import java.util.List;



public class insertToDB {

    private static String sourceDir = utilitiesFunc.createPath("sources");

    public insertToDB() {

    }

    public static void startInsert(){
        try {
            utilitiesFunc.logger.info("starting to insert DB: (time = " + new Date() +" )");
            Logger.info("starting to insert DB: (time = " + new Date() +" )");
            insertToPassengerCount("Passengers Count.csv");
            insertToAgency("agency.txt");
            insertToRoutes("routes.txt");
            insertToStops("stops.txt");
            insertToCalendar("calendar.txt");
            insertSIRItoRealTime("Historical real-time.csv");
            insertToShape("shapes.txt");
            insertToTrips("trips.txt");
            insertToStopTimes("stop_times.txt");
            insertToSiriCsv("BS_01_Mar_2019.csv");
            utilitiesFunc.logger.info("Done to insert DB: (time = " + new Date() +" )");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertToSiriCsv(String tableFile) throws SQLException {
        printToLogFile("start" , "SiriCsv");


        try {
            int i=0;
            BufferedReader br = readFileToBuffer(sourceDir+"\\"+tableFile);
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
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("id")&& !line.contains("a")) {
                    String tmp[] = line.split(",");
                    Long csv_record_id = Long.parseLong(cleanQuotationMarks(tmp[0]));
                    SiriCsv csv_record = SiriCsv.find.byId(csv_record_id);
                    if (csv_record == null)
                        csv_record = new SiriCsv();

                    // id field
                    csv_record.setId(Long.parseLong(cleanQuotationMarks(tmp[0])));

                    // RecordedAtTime field
                    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat time_format = new SimpleDateFormat("hh:mm:ss");
                    String recorded_time_and_date = cleanQuotationMarks(tmp[1]);
                    String csv_recorded_date = recorded_time_and_date.substring(0, 11);
                    String csv_recorded_time = recorded_time_and_date.substring(12, 20);

                    Date recordDate = dateformat.parse(csv_recorded_date);
                    long lRecord_time = time_format.parse(csv_recorded_time).getTime();
                    Time record_time = new Time(lRecord_time);

                    csv_record.setRecordedAtDate(recordDate);
                    csv_record.setRecordedAtTime(record_time);

                    // MonitoringRef -> stop
                    List<Stop> stopRefL = Stop.find.query().where().eq("stop_code", Integer.parseInt(cleanQuotationMarks(tmp[2]))).findList();
                    if (stopRefL.size() > 0) {
                        Stop stopRef = stopRefL.get(0);
                        csv_record.setStop(stopRef);
                    }

                    // LineRef -> route
                    // Fetching the relevant route by the lineRef
                    List<Routes> routesRefL = Routes.find.query().where().eq("route_id", Integer.parseInt(cleanQuotationMarks(tmp[3]))).findList();
                    if (routesRefL.size() > 0) {
                        Routes route = routesRefL.get(0);
                        //System.out.println("stop is: "+ stopRef.getStop_id());
                        csv_record.setRoute(route);
                    }

                    // DestinationRef -> destination stop
                    List<Stop> dest_stopRefL = Stop.find.query().where().eq("stop_code", Integer.parseInt(cleanQuotationMarks(tmp[7]))).findList();
                    if (stopRefL.size() > 0) {
                        Stop stopRef = stopRefL.get(0);
                        csv_record.setStop(stopRef);
                    }

                    // OriginAimedDepartureTime field
                    String csv_origin_time_and_date = cleanQuotationMarks(tmp[8]);
                    String csv_origin_date = csv_origin_time_and_date.substring(0, 11);
                    String csv_origin_time = csv_origin_time_and_date.substring(12, 20);

                    Date originDate = dateformat.parse(csv_origin_date);
                    lRecord_time = time_format.parse(csv_origin_time).getTime();
                    record_time = new Time(lRecord_time);

                    csv_record.setRecordedAtDate(recordDate);
                    csv_record.setRecordedAtTime(record_time);

                    // Longitude + Latitude -> Location
                    Float csv_longitude = Float.parseFloat(cleanQuotationMarks(tmp[9]));
                    Float csv_latitude = Float.parseFloat(cleanQuotationMarks(tmp[10]));
                    Point csv_location = new Point(csv_latitude, csv_longitude);
                    csv_location.setSrid(4326);

                    csv_record.setLocation(csv_location);

                    //VehicleRef
                    int csv_vehicleref = Integer.parseInt(cleanQuotationMarks(tmp[11]));
                    csv_record.setVehicleRef(csv_vehicleref);

                    // ExpectedArrivalTime
                    String expected_time_and_date = cleanQuotationMarks(tmp[13]);
                    String csv_expected_date = expected_time_and_date.substring(0, 11);
                    String csv_expected_time = expected_time_and_date.substring(12, 20);

                    recordDate = dateformat.parse(csv_expected_date);
                    lRecord_time = time_format.parse(csv_expected_time).getTime();
                    record_time = new Time(lRecord_time);

                    csv_record.setExpectedArrivalDate(recordDate);
                    csv_record.setExpectedArrivalTime(record_time);

                    // AimedArrivalTime
                    if (tmp.length == 15) {
                        String aimed_time_and_date = cleanQuotationMarks(tmp[14]);
                        String csv_aimed_date = aimed_time_and_date.substring(0, 11);
                        String csv_aimed_time = aimed_time_and_date.substring(12, 20);

                        recordDate = dateformat.parse(csv_aimed_date);
                        lRecord_time = time_format.parse(csv_aimed_time).getTime();
                        record_time = new Time(lRecord_time);

                        csv_record.setAimedArrivalDate(recordDate);
                        csv_record.setAimedArrivalTime(record_time);

                        // Save record
                        csv_record.save();
                        System.out.println(csv_record);
                        i++;
                    }
                }
                if ((line = br.readLine()) ==null || i==100){
                    transaction.commit();
                    transaction.end();
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        printToLogFile("done" , "Real Time");
    }

    public static void insertToPassengerCount(String tableFile) throws SQLException {
        printToLogFile("start" , "Passenger Count");

        try {
            int i=0;
            BufferedReader br = readFileToBuffer(sourceDir+"/"+tableFile);

            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = getCurrentTransaction(100);

                //Make sure the line is not null, not empty, and contains 2 comma char
                if (lineCheckers(line, "IdReportRow")) {
                    try {
                        String tmp[] = line.split(",");
                        if(tmp.length>56) {
                            PassengerCounts pc = new PassengerCounts();
                            pc.setTripId(Integer.parseInt(cleanQuotationMarks(tmp[56])));
                            pc.setPassengersContinue_rounded_final(Integer.parseInt(cleanQuotationMarks(tmp[54])));
                            pc.setPoint(stringToPoint(cleanQuotationMarks(tmp[38]),cleanQuotationMarks(tmp[39])));
                            pc.setDayNameHeb(cleanQuotationMarks(tmp[26]));
                            pc.setStation_order(cleanQuotationMarks(tmp[28]));

                            SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
                            Date dateKey = dateformat.parse(cleanQuotationMarks(tmp[22]));
                            pc.setDateKey(dateKey);
                            String timeString = cleanQuotationMarks(tmp[23]);
                            SimpleDateFormat time_format = new SimpleDateFormat("HH:mm");
                            long hourKeyLong = time_format.parse(timeString).getTime();
                            Time hourKey = new Time(hourKeyLong);
                            pc.setHourKey(hourKey);

                            pc.save();
                        }
                        i++;
                    }
                    catch(java.lang.IllegalArgumentException e1){
                        e1.printStackTrace();
                    }
                }
                if ((line = br.readLine()) ==null || i==100){
                    closeTransaction(transaction);
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace();}
        printToLogFile("done" , "Passenger Count");
    }

    public static void insertSIRItoRealTime(String tableFile) throws SQLException {
        printToLogFile("start" , "Real Time" +
                "");

        try {
            int i=0;
            BufferedReader br = readFileToBuffer(sourceDir+"/"+tableFile);
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = getCurrentTransaction(100);
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (lineCheckers(line,  "RecordedAtTime") && !line.contains("a") ) {
                    String tmp[] = line.split(",");
                    RealTime siri = RealTime.find.byId(Long.parseLong(cleanQuotationMarks(tmp[0])));
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
                    closeTransaction(transaction);
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace();}
        printToLogFile("done" , "Real Time");

    }

    public static String cleanQuotationMarks(String str) {
        if(str.length()>=2 && str.charAt(0) == '\"' && str.charAt(str.length()-1) == '\"') {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    public static void insertToAgency(String tableFile) throws SQLException {
        printToLogFile("start" , "Agency");

        try {
            int i=0;
            BufferedReader br = readFileToBuffer(sourceDir+"/"+tableFile);
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = getCurrentTransaction(51);

                //Make sure the line is not null, not empty, and contains 2 comma char
                if (lineCheckers( line, "agency")) {
                    String tmp[] = line.split(",");
                    Agency agency = Agency.find.byId(Integer.parseInt(tmp[0]));
                    if (agency==null)
                        agency = new Agency();
                    agency.setAgency_id(Integer.parseInt(tmp[0]));
                    agency.setAgency_name(tmp[1]);
                    agency.setAgency_url(tmp[2]);

                    agency.save();
                    i++;
                }
                if ((line = br.readLine()) ==null || i==51){
                    closeTransaction(transaction);
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) {e.printStackTrace(); }
        printToLogFile("done" , "Agency");
    }

    public static void insertToRoutes(String tableFile) throws SQLException{
        printToLogFile("start" , "Routes");
        try{
            int i=0;
            BufferedReader br = readFileToBuffer(sourceDir+"/"+tableFile);
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = getCurrentTransaction(100);
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (lineCheckers(line,"route")) {
                    String tmp[] = line.split(",");
                    Routes route = Routes.find.byId(Integer.parseInt(tmp[0]));
                    if (route == null)
                        route = new Routes();
                    route.setRoute_id(Integer.parseInt(tmp[0]));
                    Agency agency_id = Agency.find.byId(Integer.parseInt(tmp[1]));
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
                    closeTransaction(transaction);
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) {e.printStackTrace(); }
        printToLogFile("done" , "Routes");

    }

    public static void insertToStops(String tableFile) throws SQLException {
        printToLogFile("start" , "Stops");

        try{
            int i=0;
            BufferedReader br = readFileToBuffer(sourceDir+"/"+tableFile);
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = getCurrentTransaction(100);
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (lineCheckers(line,"stop")) {
                    String tmp[] = line.split(",");
                    Stop stop = Stop.find.byId(Long.valueOf(Integer.parseInt(tmp[0])));
                    if (stop ==null)
                        stop = new Stop();
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
                        Stop parent = Stop.find.byId(Long.valueOf(Integer.parseInt(tmp[7])));
                        stop.setParent_station(parent);
                        // }
                    }
                    stop.save();
                    i++;
                }
                if ((line = br.readLine()) ==null || i==100){
                    closeTransaction(transaction);
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) { e.printStackTrace(); }
        printToLogFile("done" , "Stops");
    }

    public static void insertToCalendar(String tableFile) throws SQLException {
        printToLogFile("start" , "Calendar");
        try{
            int i=0;
            BufferedReader br =  readFileToBuffer(sourceDir+"/"+tableFile);
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction =getCurrentTransaction(100);
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (lineCheckers(line, "service")) {
                    String tmp[] = line.split(",");
                    Calendar calendar = Calendar.find.byId(Integer.parseInt(tmp[0]));
                    if (calendar == null)
                        calendar = new Calendar();
                    calendar.setService_id(Integer.parseInt(tmp[0]));
                    String days_bytes = Calendar.mergeDayes(tmp[1],tmp[2],tmp[3],tmp[4],tmp[5],tmp[6],tmp[7]);
                    calendar.setDays_bytes(days_bytes);
                    SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
                    Date start_date = dateformat.parse(tmp[8]);
                    Date end_date = dateformat.parse(tmp[9]);
                    calendar.setStart_date(start_date);
                    calendar.setEnd_date(end_date);

                    calendar.save();
                    i++;
                }
                if ((line = br.readLine()) ==null || i==100){
                    closeTransaction(transaction);
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace();}
        printToLogFile("done" , "Calendar");
    }

    private static void insertToTrips(String tableFile) throws SQLException {
        printToLogFile("start" , "Trips");
        try{
            int i=0;
            BufferedReader br =  readFileToBuffer(sourceDir+"/"+tableFile);
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction =getCurrentTransaction(100);
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (lineCheckers(line , "trip_id")) {
                    String tmp[] = line.split(",");
                    Trips trip = Trips.find.byId(tmp[2]);
                    if (trip == null)
                        trip =new Trips();
                    trip.setTrip_id(tmp[2]);
                    Routes route_id = Routes.find.byId(Integer.parseInt(tmp[0]));
                    trip.setRoute_id(route_id);
                    Calendar service_id = Calendar.find.byId(Integer.parseInt(tmp[1]));
                    trip.setService_id(service_id);
                    trip.setDirection_id(Boolean.parseBoolean(tmp[4]));
                    if (tmp.length>5) {
                        trip.setShape_id(Integer.parseInt(tmp[5]));
                    }
                    trip.save();
                    i++;
                }
                if ((line = br.readLine()) ==null || i==100){
                    closeTransaction(transaction);
                    i=0;
                }
            }
            br.close();
        } catch(IOException e) { e.printStackTrace(); }
        printToLogFile("done" , "Trips");
    }

    private static void insertToShape(String tableFile) throws SQLException {
        printToLogFile("start" , "Shapes");
        try{
            int i=0;
            BufferedReader br =  readFileToBuffer(sourceDir+"/"+tableFile);
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = getCurrentTransaction(200);
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (lineCheckers(line , "shape")) {
                    String tmp[] = line.split(",");
                    ShapeKey shapeKey = new ShapeKey();
                    shapeKey.setShape_id(Integer.parseInt(tmp[0]));
                    shapeKey.setShape_pt_sequence(Integer.parseInt(tmp[3]));
                    Shape shape = Shape.find.byId(shapeKey);
                    if (shape==null)
                        shape = new Shape();
                    shape.setKey(shapeKey);
                    shape.setPoint(stringToPoint(tmp[1],tmp[2]));
                    shape.save();
                    i++;
                }
                if ((line = br.readLine()) ==null || i==200){
                    closeTransaction(transaction);
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) { e.printStackTrace(); }
        printToLogFile("done" , "Shapes");
    }

    private static void insertToStopTimes(String tableFile) throws SQLException {
        printToLogFile("start" , "Stop Times");
        try{
            int i=0;
            int index =0 ;
            BufferedReader br =  readFileToBuffer(sourceDir+"/"+tableFile);
            String line = br.readLine();
            while (line!=null)
            {
                Transaction transaction = getCurrentTransaction(500);
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("stop")) {
                    String tmp[] = line.split(",");
                    Trips trip = Trips.find.byId(tmp[0]);
                    SimpleDateFormat time_format = new SimpleDateFormat("HH:MM:SS");
                    long arrivalTime = time_format.parse(tmp[1]).getTime();
                    Time arrival_time = new Time(arrivalTime);
                    Stop stop = Stop.find.byId(Long.valueOf(Integer.parseInt(tmp[3])));
                    StopTimes stopTime = StopTimes.find.byId(new StopTimesKey(trip.getTrip_id(),stop.getStop_id(),arrival_time));
                    if (stopTime == null)
                        stopTime = new StopTimes();

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
                    }
                    stopTime.save();
                    i++;
                }
                if ((line = br.readLine()) ==null || i==500){
                    closeTransaction(transaction);
                    i=0;
                }
            }
            br.close();
        }
        catch(IOException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace();}
        printToLogFile("done" , "Stop Times");
    }

    /*================ utilities Function ================*/

    private static void printToLogFile(String action , String tableName) {
        if (action=="start")
            utilitiesFunc.logger.info("Starting insert to "+tableName+" table.   (Start time = " + new Date() +" )");
        else if (action == "done")
            utilitiesFunc.logger.info("Done insert to "+tableName+" table.   (End time = " + new Date() +" )");

    }

    private static BufferedReader readFileToBuffer(String fileName) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName), StandardCharsets.UTF_8));
        return br;
    }

    private static Transaction getCurrentTransaction(int batchNumber) {
        Transaction transaction = Ebean.currentTransaction();
        if (transaction == null) {
            transaction = Ebean.beginTransaction();
            transaction.setBatchMode(true);  // use JDBC batch
            transaction.setBatchSize(batchNumber);
        }
        return transaction;
    }

    private static void closeTransaction(Transaction transaction) {
        transaction.commit();
        transaction.end();
    }

    private static Boolean lineCheckers(String line , String guideWord){
        return line != null &&
                !line.equals("") &&
                line.matches(".*[,].*[,].*") &&
                !line.contains(guideWord);
    }

    private static Point stringToPoint(String lat , String lon){
        Double pt_lat =  Double.parseDouble(lat);
        Double pt_lon =  Double.parseDouble(lon);
        Point point = new Point(pt_lat , pt_lon);
        point.setSrid(4326);
        return point;
    }
}
