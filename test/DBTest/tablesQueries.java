package DBTest;
import models.entities.*;
import models.*;
import org.junit.*;

import java.io.IOException;
import java.sql.SQLException;


import static org.junit.Assert.*;


public class tablesQueries extends BaseModelTest{
    private static String destDir = "";

    @BeforeClass
    public static void setup() throws IOException{
        //utilitiesDBtest.writeToLoggerFile("tablesQueries TEST starts: \n");
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

}
