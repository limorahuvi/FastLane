package models;

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



public class insertToDB {

    public insertToDB(String destDir) {
        try {
            Logger.debug("starting to insert DB: (time = " + new Date() +" )");
            /*insertToAgency(destDir);
            insertToRoutes(destDir);
            insertToStops(destDir);
            insertToCalendar(destDir);
            insertToShape(destDir);*/
            insertToTrips(destDir);
            insertToStopTimes(destDir);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertToAgency(String URL) throws SQLException {
        Logger.debug("strting insert to Agency table...   (start time = " + new Date() +" )");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL+"/agency.txt"), StandardCharsets.UTF_8));
            String line = null;
            while ((line = br.readLine() )!=null)
            {
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("agency")) {
                    String tmp[] = line.split(",");
                    Agency agency = new Agency();
                    agency.setAgency_id(Integer.parseInt(tmp[0]));
                    agency.setAgency_name(tmp[1]);
                    agency.setAgency_url(tmp[2]);
                    if (Agency.find.byId(Integer.parseInt(tmp[0]))==null)
                        agency.save();
                    else agency.update();
                }
            }
            br.close();
        } catch(IOException e){
            e.printStackTrace();

        }
        Logger.debug("Done insert to Agency table.  (end time = " + new Date() +" )" );
    }

    private void insertToRoutes(String URL) throws SQLException{
        Logger.debug("strting insert to Routes table... (start time = " + new Date() +" )");
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL+ "/routes.txt"), StandardCharsets.UTF_8));
            String line = null;
            while ((line = br.readLine() )!=null)
            {
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("route")) {
                    String tmp[] = line.split(",");
                    Routes route = new Routes();
                    route.setRoute_id(Integer.parseInt(tmp[0]));
                    Agency agency_id = Agency.find.byId(Integer.parseInt(tmp[1]));
                    route.setAgency_id(agency_id);
                    route.setRoute_long_name(tmp[3]);
                    route.setRoute_desc(tmp[4]);
                    route.setRoute_type(tmp[5]);
                    if (tmp.length>6)
                        route.setRoute_color(tmp[6]);
                    if (Routes.find.byId(Integer.parseInt(tmp[0]))!=null)
                        route.update();
                    else route.save();
                }
            }
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        Logger.debug("Done insert to Routes table.  (end time = " + new Date() +" )");
    }

    private void insertToStops(String URL) throws SQLException {
        Logger.debug("strting insert to Stops table...   (start time = " + new Date() +" )");

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL+ "/stops.txt"), StandardCharsets.UTF_8));
            String line = null;
            while ((line = br.readLine() )!=null)
            {
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("stop")) {
                    String tmp[] = line.split(",");
                    Stop stop = new Stop();

                    stop.setStop_id(Integer.parseInt(tmp[0]));
                    stop.setStop_code(Integer.parseInt(tmp[1]));
                    stop.setStop_name(tmp[2]);
                    stop.setStop_desc(tmp[3]);
                    Double stop_lat =  Double.parseDouble(tmp[4]);
                    Double stop_lot =  Double.parseDouble(tmp[5]);
                    Point stop_point = new Point(stop_lat , stop_lot); //("SRID=4674;POINT("+stop_lat+","+stop_lot+" )");
                    stop_point.setSrid(4326);
                    stop.setLoction(stop_point);
                    stop.setLocation_type(Boolean.parseBoolean(tmp[6]));
                    if (!(tmp[7].equals(""))){
                        Stop parent = Stop.find.byId(Integer.parseInt(tmp[7]));
                        stop.setParent_station(parent);
                    }

                    if (Stop.find.byId(Integer.parseInt(tmp[0]))!=null)
                        stop.update();
                    else stop.save();
                }
            }
            br.close();
        } catch(IOException e) { e.printStackTrace(); }
        Logger.debug("Done insert to Stops table. (end time = " + new Date() +" )");
    }

    private void insertToCalendar(String URL) throws SQLException {
        Logger.debug("strting insert to Calendar table...   (start time = " + new Date() +" )");
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL+ "/calendar.txt"), StandardCharsets.UTF_8));
            String line = null;
            while ((line = br.readLine() )!=null)
            {
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("service")) {
                    String tmp[] = line.split(",");
                    Calendar calendar = new Calendar();
                    calendar.setService_id(Integer.parseInt(tmp[0]));
                    String days_bytes = Calendar.mergeDayes(tmp[1],tmp[2],tmp[3],tmp[4],tmp[5],tmp[6],tmp[7]);
                    calendar.setDays_bytes(days_bytes);
                    SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
                    Date start_date = dateformat.parse(tmp[8]);
                    Date end_date = dateformat.parse(tmp[9]);
                    calendar.setStart_date(start_date);
                    calendar.setEnd_date(end_date);
                    if (Calendar.find.byId(Integer.parseInt(tmp[0]))!=null)
                        calendar.update();
                    else calendar.save();
                }
            }
            br.close();
        }
        catch(IOException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace();}
        Logger.debug("Done insert to Calendar table.   (end time = " + new Date() +" )");

    }


    private void insertToTrips(String URL) throws SQLException {
        Logger.debug("strting insert to Trips table...   (start time = " + new Date() +" )");
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL+ "/trips.txt"), StandardCharsets.UTF_8));
            String line = null;
            while ((line = br.readLine() )!=null)
            {
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("trip_id")) {
                    String tmp[] = line.split(",");
                    Trips trip = new Trips();
                    trip.setTrip_id(tmp[2]);
                    Routes route_id = Routes.find.byId(Integer.parseInt(tmp[0]));
                    trip.setRoute_id(route_id);
                    Calendar service_id = Calendar.find.byId(Integer.parseInt(tmp[1]));
                    trip.setService_id(service_id);
                    trip.setDirection_id(Boolean.parseBoolean(tmp[4]));
                    if (tmp.length>5) {
                        trip.setShape_id(Integer.parseInt(tmp[5]));
                    }
                    if (Trips.find.byId(tmp[2])!=null)
                        trip.update();
                    else trip.save();
                }
            }
            br.close();
        } catch(IOException e) { e.printStackTrace(); }
        Logger.debug("Done insert to Trips table.    (end time = " + new Date() +" )");
    }

    private void insertToShape(String URL) throws SQLException {
        Logger.debug("strting insert to Shapes table...  (start time = " + new Date() +" )");
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL+ "/shapes.txt"), StandardCharsets.UTF_8));
            String line = null;
            while ((line = br.readLine() )!=null)
            {
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("shape")) {
                    String tmp[] = line.split(",");
                    Shape shape = new Shape();
                    ShapeKey shapeKey = new ShapeKey();
                    shapeKey.setShape_id(Integer.parseInt(tmp[0]));
                    shapeKey.setShape_pt_sequence(Integer.parseInt(tmp[3]));
                    shape.setKey(shapeKey);
                    Double shape_pt_lat =  Double.parseDouble(tmp[1]);
                    Double shape_pt_lon =  Double.parseDouble(tmp[2]);
                    Point shape_point = new Point(shape_pt_lat , shape_pt_lon);
                    shape_point.setSrid(4326);
                    shape.setPoint(shape_point);
                    if (Shape.find.byId(shapeKey)!=null)
                        shape.update();
                    else shape.save();
                }
            }
            br.close();
        } catch(IOException e) { e.printStackTrace(); }
        Logger.debug("Done insert to Shapes table.   (end time = " + new Date() +" )");
    }

    private void insertToStopTimes(String URL) throws SQLException {
        Logger.debug("strting insert to Stop Times table... (start time = " + new Date() +" )");
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(URL+ "/stop_times.txt"), StandardCharsets.UTF_8));
            String line = null;
            while ((line = br.readLine() )!=null)
            {
                //Make sure the line is not null, not empty, and contains 2 comma char
                if (line != null && !line.equals("") && line.matches(".*[,].*[,].*") && !line.contains("stop")) {
                    String tmp[] = line.split(",");
                    StopTimes stopTime = new StopTimes();
                    Trips trip = Trips.find.byId(tmp[0]);
                    stopTime.setTrip(trip);
                    SimpleDateFormat time_format = new SimpleDateFormat("HH:MM:SS");
                    long arrivalTime = time_format.parse(tmp[1]).getTime();
                    Time arrival_time = new Time(arrivalTime);
                    //stopTime.setArrival_time(arrival_time);
                    stopTime.getStKey().setArrival_time(arrival_time);
                    Stop stop = Stop.find.byId(Integer.parseInt(tmp[3]));
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

                    if (StopTimes.find.byId(new StopTimesKey(trip.getTrip_id(),stop.getStop_id(),arrival_time)) !=null)
                        stopTime.update();
                    else stopTime.save();
                }
            }
            br.close();
        }
        catch(IOException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace();}
        Logger.debug("Done insert to Stop Times table.   (end time = " + new Date() +" )");

    }

}
