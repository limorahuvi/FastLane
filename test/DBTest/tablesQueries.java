package DBTest;
import models.entities.*;
import models.*;
import org.junit.*;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.postgis.Point;
import java.util.List;


import static org.junit.Assert.*;


public class tablesQueries extends BaseModelTest{
    private static String destDir = "";
    private static String destRealTime = "";
    private static String destPc = "";

    @BeforeClass
    public static void setup() throws IOException{
        //utilitiesDBtest.writeToLoggerFile("tablesQueries TEST starts: \n");
        utilitiesFunc.writeToLog("LogTest_tableQueries.log");
        utilitiesFunc.logger.info("tablesQueries TEST starts: \n");
        destDir =  utilitiesDBtest.createPath("outTest");
        destRealTime = utilitiesDBtest.createPath("sources/DFoutputBS_cluster2018-09-29_1.csv");
        destPc = utilitiesDBtest.createPath("sources/pc.csv");
        initializeDB.unzip(destDir);

    }

    @AfterClass
    public static void teardown() throws IOException {
        utilitiesDBtest.deleteOutputTest(destDir);
        utilitiesFunc.logger.info("tablesQueries test ends... \n");
    }

    @Test
    public void testAgency() throws SQLException {
        insertToDB.insertToAgency(destDir);
        Agency agency = Agency.find.byId(45);
        assertNotNull(agency);
        assertEquals("http://www.callkav.gov.il/", agency.getAgency_url());

    }
    @Test
    public void testCalendar() throws SQLException {
       insertToDB.insertToCalendar(destDir);
            /*validate a specific calendar id*/
       Calendar.find.deleteById(63649722);
       Calendar c = Calendar.find.byId(63649722);
       assertNull(c);
    }

    @Test
    public void testRealTime () throws SQLException, ParseException {
        insertToDB.insertToStops(destDir);
        insertToDB.insertSIRItoRealTime(destRealTime);
        SimpleDateFormat time_format = new SimpleDateFormat("hh:mm:ss");
        long sRecord_time = time_format.parse("13:30:00").getTime();
        long lRecord_time = time_format.parse("7:30:24").getTime();
        Time record_time1 = new Time(lRecord_time);
        Time record_time2 = new Time(sRecord_time);
        System.out.println("Time is: " +record_time1.toString());
        /*all recorded_at_time between 07 AM to 01 PM*/
        List<RealTime> recordsTimeInRange = RealTime.find.query()
                .where().inRange("recorded_at_time_time",record_time1,record_time2)
                .findList();
       assertNotNull(recordsTimeInRange);
       Stop stop_id = new Stop();
       stop_id.setStop_id(26212);
       assertTrue("recordesAtTime_Time is grater than 50", recordsTimeInRange.size()> 100 );
        /*validate a specific stop in record*/
        Integer stop = RealTime.find.query().where().eq("stop",stop_id).findCount();
       assertNotNull(stop);
       assertTrue(stop > 0);
        Stop not_a_stop = new Stop();
        stop_id.setStop_id(00000);
        RealTime nostop = RealTime.find.query().where().eq("stop", not_a_stop).findOne();
        assertNull(nostop);
    }

    @Test
    public void testPassengerCount () throws SQLException {
        insertToDB.insertToPassengerCount(destPc);
        Integer no_count = PassengerCounts.find.query().where()
                .eq("PassengersContinue_rounded_final", 14).findCount();
        assertNotNull(no_count);
        PassengerCounts pc = new PassengerCounts();
        pc.setPassengersContinue_rounded_final(0);
        PassengerCounts pass_no_count = PassengerCounts.find.query().where()
                .eq("PassengersContinue_rounded_final", 0).findOne();
        assertNull(pass_no_count);
    }

    @Test
    public void queryTime()throws SQLException {
        insertToDB insert_db=new insertToDB(destDir);
        String coor1="34.81636627528721,31.27027517208913";
        String[] coor1_x_y= coor1.split(",");
        String coor2="34.7771416506549,31.24855754703961";
        String[] coor2_x_y=coor2.split(",");
        Point p1=new Point(Double.parseDouble(coor1_x_y[1]),Double.parseDouble(coor2_x_y[0]));
        Point p2=new Point(Double.parseDouble(coor2_x_y[1]),Double.parseDouble(coor1_x_y[0]));
        Point p3=new Point(Double.parseDouble(coor1_x_y[1]),Double.parseDouble(coor1_x_y[0]));
        Point p4=new Point(Double.parseDouble(coor2_x_y[1]),Double.parseDouble(coor2_x_y[0]));
        double max_x=Math.max(Math.max(p1.getX(),p2.getX()),Math.max(p3.getX(),p4.getX()));
        double min_x=Math.min(Math.min(p1.getX(),p2.getX()),Math.min(p3.getX(),p4.getX()));
        double max_y=Math.max(Math.max(p1.getY(),p2.getY()),Math.max(p3.getY(),p4.getY()));
        double min_y=Math.min(Math.min(p1.getY(),p2.getY()),Math.min(p3.getY(),p4.getY()));
        long start=System.currentTimeMillis();

        List<RealTime> real_time_ref= RealTime.find.query().where().between("expectedArrivalDate" , "2018-09-29", "2018-10-29" )
                .between("ST_X(location)",min_x,max_x).between("ST_Y(location)",min_y,max_y).findList();

        long finish=System.currentTimeMillis();
        long totalTime=(finish-start)/1000;//seconds
        assertTrue(totalTime < 10);
    }



}
