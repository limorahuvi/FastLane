package DBTest;
import models.entities.*;
import models.*;
import org.junit.*;

import javax.xml.transform.sax.SAXSource;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import static org.junit.Assert.*;


public class tablesQueries extends BaseModelTest{
    private static String destDir = "";
    private static String destRealTime = "";
    private static String destPc = "";
    @BeforeClass
    public static void setup() throws IOException{
        //utilitiesDBtest.writeToLoggerFile("tablesQueries TEST starts: \n");
        utilitiesFunc.writeToLog("LogTest.log");
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
                .eq("passengers_continue_rounded_sofi", 14).findCount();
        assertNotNull(no_count);
        PassengerCounts pc = new PassengerCounts();
        pc.setPassengersContinue_rounded_sofi(0);
        PassengerCounts pass_no_count = PassengerCounts.find.query().where()
                .eq("passengers_continue_rounded_sofi", 0).findOne();
        assertNull(pass_no_count);
    }


}
