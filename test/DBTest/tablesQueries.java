package DBTest;
import models.entities.*;
import models.*;
import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.postgis.Point;

import java.util.Date;
import java.util.List;
import java.time.LocalTime;


import static org.junit.Assert.*;
/**
 * Class for testing quering data from tables
 */

public class tablesQueries extends BaseModelTest{
    private static String destDir = "";

    /**
     * Create log file for this specific test
     * create output dir for testing
     * @throws IOException
     */
    @BeforeClass
    public static void setup() throws IOException{
        utilitiesFunc.writeToLog("LogTest_tableQueries.log");
        utilitiesFunc.logger.info("tablesQueries TEST starts: \n");
        destDir =  utilitiesDBtest.createPath("outTest");
        File dir = new File(destDir);
        if(!dir.exists())
            dir.mkdirs();
        utilitiesFunc.unzip(destDir);

    }

    /**
     * Delete output directory
     */
    @AfterClass
    public static void teardown() {
        File dir = new File(destDir);
        if(dir.exists())
            utilitiesDBtest.deleteOutputTest(destDir);
        utilitiesFunc.logger.info("tablesQueries test ends... \n");
    }

    /**
     * Test the function insertToAgency
     * test if it is not null
     * test that a specific record was inserted
     * @throws SQLException
     */
    @Test
    public void testAgency() throws SQLException {
        insertToDB.insertToAgency("agency.txt");
        Agency agency = Agency.find.byId(45);
        assertNotNull(agency);
        assertEquals("http://www.callkav.gov.il/", agency.getAgency_url());

    }

    /**
     * Tests for measuring time insertion to tables
     * @throws SQLException
     * @throws IOException
     */
    @Test
    public void testInsertTime() throws SQLException, IOException {
        long startAgency =System.currentTimeMillis();
        insertToDB.insertToAgency("agency.txt");
        long endAgency = System.currentTimeMillis();
        long totaltimeAgency = (endAgency - startAgency);
        utilitiesFunc.logger.info("total time for agency table is: " + totaltimeAgency +" in milliseconds");
        assertTrue((totaltimeAgency/1000) < 10);

        long startRoutes = System.currentTimeMillis();
        insertToDB.insertToRoutes("routes.txt");
        long endRoutes = System.currentTimeMillis();
        long totaltimeRoutes = (endRoutes - startRoutes) ;
        utilitiesFunc.logger.info("total time for routes table is: " + totaltimeRoutes +" in milliseconds");
        assertTrue((totaltimeRoutes/ 1000) < 10);

        long startRealTime =System.currentTimeMillis();
        insertToDB.insertSIRItoRealTime("Historical real-time.csv");
        long endRealTime = System.currentTimeMillis();
        long totaltimeRealTime = (endRealTime - startRealTime) / 1000;
        System.out.println("the total is: "+ totaltimeRealTime +"in mili\n total time in sec: "+ totaltimeRealTime*1000);
        utilitiesFunc.logger.info("total time for Real time table is: " + totaltimeRealTime +" in milliseconds");
        assertTrue((totaltimeRealTime/ 1000) < 21);

    }
    /**
     *   Test function insertToCalendar
     *    test if a specific record was inserted to table
     *    and that it was deleted properly
     *    @throws SQLException
     */
    @Test
    public void testCalendar() throws SQLException {
       insertToDB.insertToCalendar("calendar.txt");
       //*validate a specific calendar id*//*
       Calendar.find.deleteById(63649722);
       Calendar c = Calendar.find.byId(63649722);
       assertNull(c);
    }

    /** Test function insertToStops
     * test function insertTpSIRIRealTime
     * test measuring insertion time
     * test that a complex query succeed
     * @throws SQLException
     */
    @Test
    public void testRealTime () throws SQLException, ParseException {
        insertToDB.insertToStops("stops.txt");
        insertToDB.insertSIRItoRealTime("Historical real-time.csv");
        SimpleDateFormat time_format = new SimpleDateFormat("hh:mm:ss");
        long sRecord_time = time_format.parse("13:30:00").getTime();
        long lRecord_time = time_format.parse("7:30:24").getTime();
        Time record_time1 = new Time(lRecord_time);
        Time record_time2 = new Time(sRecord_time);
        System.out.println("Time is: " +record_time1.toString());
        //*all recorded_at_time between 07 AM to 01 PM*//*
        List<RealTime> recordsTimeInRange = RealTime.find.query()
                .where().inRange("recorded_at_time_time",record_time1,record_time2)
                .findList();
       assertNotNull(recordsTimeInRange);
       Stop stop_id = new Stop();
       stop_id.setStop_id(26212);
       assertTrue("recordesAtTime_Time is grater than 100", recordsTimeInRange.size()> 100 );
        //*validate a specific stop in record*//*
        Integer stop = RealTime.find.query().where().eq("stop",stop_id).findCount();
       assertNotNull(stop);
       assertTrue(stop > 0);
        Stop not_a_stop = new Stop();
        stop_id.setStop_id(00000);
        RealTime nostop = RealTime.find.query().where().eq("stop", not_a_stop).findOne();
        assertNull(nostop);
    }


    /**
     * Test function insertTiPassangerCount
     *  test that a complex query succeed
     * @throws SQLException
     */
    @Test
    public void testPassengerCount () throws SQLException {
        insertToDB.insertToPassengerCount("Passengers Count.csv");
        Integer no_count = PassengerCounts.find.query().where()
                .eq("PassengersContinue_rounded_final", 14).findCount();
        assertNotNull(no_count);
        PassengerCounts pc = new PassengerCounts();
        pc.setPassengersContinue_rounded_final(0);
        PassengerCounts pass_no_count = PassengerCounts.find.query().where()
                .eq("PassengersContinue_rounded_final", 0).findOne();
        assertNull(pass_no_count);
    }


    /**
     * Test function insertToStops
     * test function insertTpSIRIRealTime
     * test measuring querying time
     * test that a complex query succeed from real time table
     * @throws SQLException
     */
    @Test
    public void queryTimeRT()throws SQLException {
        insertToDB.insertToStops("stops.txt");
        insertToDB.insertSIRItoRealTime("Historical real-time.csv");
        String coor1="34.81636627528721,31.27027517208913";
        String[] coor1_x_y= coor1.split(",");
        String coor2="34.7771416506549,31.24855754703961";
        String[] coor2_x_y=coor2.split(",");
        LocalTime t1 = LocalTime.parse("00" + ":00");
        LocalTime t2 = LocalTime.parse("10" + ":59");
        Point p1=new Point(Double.parseDouble(coor1_x_y[1]),Double.parseDouble(coor2_x_y[0]));
        Point p2=new Point(Double.parseDouble(coor2_x_y[1]),Double.parseDouble(coor1_x_y[0]));
        Point p3=new Point(Double.parseDouble(coor1_x_y[1]),Double.parseDouble(coor1_x_y[0]));
        Point p4=new Point(Double.parseDouble(coor2_x_y[1]),Double.parseDouble(coor2_x_y[0]));
        double max_x=Math.max(Math.max(p1.getX(),p2.getX()),Math.max(p3.getX(),p4.getX()));
        double min_x=Math.min(Math.min(p1.getX(),p2.getX()),Math.min(p3.getX(),p4.getX()));
        double max_y=Math.max(Math.max(p1.getY(),p2.getY()),Math.max(p3.getY(),p4.getY()));
        double min_y=Math.min(Math.min(p1.getY(),p2.getY()),Math.min(p3.getY(),p4.getY()));
        java.util.Calendar myCal = java.util.Calendar.getInstance();
        myCal.set(java.util.Calendar.YEAR, 2019);
        myCal.set(java.util.Calendar.MONTH,9);
        myCal.set(java.util.Calendar.DAY_OF_MONTH, 29);
        Date start_date = myCal.getTime();
        myCal.set(java.util.Calendar.YEAR, 2019);
        myCal.set(java.util.Calendar.MONTH,10);
        myCal.set(java.util.Calendar.DAY_OF_MONTH, 29);
        Date end_date = myCal.getTime();
        long start=System.currentTimeMillis();
        List<RealTime> real_time_ref = RealTime.find.query().where().between("expectedArrivalDate", start_date, end_date)
                .between("expectedArrivalTime", t1, t2).between("ST_X(location)", min_x,max_x).between("ST_Y(location)", min_y,max_y).findList();
        long finish=System.currentTimeMillis();
        long totalTime=(finish-start)/1000;//seconds
        assertTrue(totalTime < 10);
    }

    /**
     * test function insertToPassengerCount
     * test measuring querying time
     * test that a complex query succeed from Passengers Count table
     * @throws SQLException
     */
    @Test
    public void queryTimePC()throws SQLException {
        insertToDB.insertToPassengerCount("Passengers Count.csv");
        String coor1="34.81636627528721,31.27027517208913";
        String[] coor1_x_y= coor1.split(",");
        String coor2="34.7771416506549,31.24855754703961";
        String[] coor2_x_y=coor2.split(",");
        LocalTime t1 = LocalTime.parse("00" + ":00");
        LocalTime t2 = LocalTime.parse("10" + ":59");
        Point p1=new Point(Double.parseDouble(coor1_x_y[1]),Double.parseDouble(coor2_x_y[0]));
        Point p2=new Point(Double.parseDouble(coor2_x_y[1]),Double.parseDouble(coor1_x_y[0]));
        Point p3=new Point(Double.parseDouble(coor1_x_y[1]),Double.parseDouble(coor1_x_y[0]));
        Point p4=new Point(Double.parseDouble(coor2_x_y[1]),Double.parseDouble(coor2_x_y[0]));
        double max_x=Math.max(Math.max(p1.getX(),p2.getX()),Math.max(p3.getX(),p4.getX()));
        double min_x=Math.min(Math.min(p1.getX(),p2.getX()),Math.min(p3.getX(),p4.getX()));
        double max_y=Math.max(Math.max(p1.getY(),p2.getY()),Math.max(p3.getY(),p4.getY()));
        double min_y=Math.min(Math.min(p1.getY(),p2.getY()),Math.min(p3.getY(),p4.getY()));
        java.util.Calendar myCal = java.util.Calendar.getInstance();
        myCal.set(java.util.Calendar.YEAR, 2019);
        myCal.set(java.util.Calendar.MONTH,9);
        myCal.set(java.util.Calendar.DAY_OF_MONTH, 29);
        Date start_date = myCal.getTime();
        myCal.set(java.util.Calendar.YEAR, 2019);
        myCal.set(java.util.Calendar.MONTH,10);
        myCal.set(java.util.Calendar.DAY_OF_MONTH, 29);
        Date end_date = myCal.getTime();
        String day="Saturday";
        long start=System.currentTimeMillis();
        List<PassengerCounts> pcs = PassengerCounts.find.query()
                .where()
                .between("date_key", start_date, end_date)
                .between("hour_key", t1,t2)
                .contains("DayNameHeb", day.equals("All") ? "" : day)
                .between("ST_X(point)", min_x,max_x)
                .between("ST_Y(point)", min_y,max_y)
                .order().desc("TripId")
                .order().desc("station_order")
                .findList();
        long finish=System.currentTimeMillis();
        long totalTime=(finish-start)/1000;//seconds
        assertTrue(totalTime < 10);
    }


    /**
     * testing querying from stop table
     * testing measuring querying time
     * @throws SQLException
     */
    @Test
    public void queryTimeStations()throws SQLException {
        insertToDB.insertToStops("stops.txt");
        long start=System.currentTimeMillis();
        List<Stop> stops = Stop.find.query().where()
                .icontains("stop_desc", "באר שבע").findList();
        long finish=System.currentTimeMillis();
        long totalTime=(finish-start)/1000;//seconds
        assertTrue(totalTime < 5);


    }
}
