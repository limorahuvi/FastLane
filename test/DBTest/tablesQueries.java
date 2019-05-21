package DBTest;
import models.entities.*;
import models.*;
import org.junit.*;
import org.postgis.Point;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import static org.junit.Assert.*;


public class tablesQueries extends BaseModelTest{
    private static String destDir = "";

    @BeforeClass
    public static void setup() throws IOException{
        //devSchedQueryHandlerTest.writeToLoggerFile("tablesQueries TEST starts: \n");
        utilitiesFunc.writeToLog("LogTest.log");
        utilitiesFunc.logger.info("tablesQueries TEST starts: \n");
        destDir =  utilitiesDBtest.createPath("outTest");
        initializeDB.unzip(destDir);

    }

    @AfterClass
    public static void teardown() throws IOException {
        utilitiesDBtest.deleteOutputTest(destDir);
        utilitiesFunc.logger.info("tablesQueries test ends... \n");
    }

    @Test
    public void findById() throws SQLException {
        insertToDB.insertToAgency(destDir);
        Agency agency = Agency.find.byId(45);
        assertNotNull(agency);
        assertEquals("http://www.callkav.gov.il/", agency.getAgency_url());

    }
    @Test
    public void find() throws SQLException {
        insertToDB.insertToCalendar(destDir);
        Calendar.find.deleteById(63649722);
        Calendar c = Calendar.find.byId(63649722);
        assertNull(c);
        //Calendar calendars = Calendar.find.query("select days_bytes as days from agency where days >8").findOne();
        //assertNotNull(calendars);
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
                .between("ST_X(loction)",min_x,max_x).between("ST_Y(loction)",min_y,max_y).findList();

        long finish=System.currentTimeMillis();
        long totalTime=(finish-start)/1000;//seconds
        assertTrue(totalTime < 10);
    }


}
