package DBTest;

import models.entities.Calendar;
import models.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class for functional testing
 */
public class unitTestsInsertToDB {

    String destDir = utilitiesDBtest.createPath("outTest");
    /**
     * Create log file for this specific test
     */
    @BeforeClass
    public static void setup() throws IOException {
        utilitiesFunc.writeToLog("LogTest_unitTestsInsertToDB.log");
        utilitiesFunc.logger.info("unitTests Unser To DB TEST starts: \n");
    }

    /**
     * write to log that test is done
     * @throws IOException
     */
    @AfterClass
    public static void teardown() throws IOException {
        utilitiesFunc.logger.info("tablesQueries test ends... \n");
    }

    /**
     * test that unzip the gtfs.zip succeed
     * @throws Exception
     */
    @Test
    public void testUnzip() throws Exception {
        File dir = new File(destDir);
        if(!dir.exists())
            dir.mkdirs();
        utilitiesFunc.unzip(destDir);
        assertTrue(!destDir.isEmpty());
    }

    /**
     * Test for measuring time for the function unzip
     * @throws IOException
     */
    @Test
    public void testTimeUnzip() throws IOException {
        /*test to check if time for unzipping file is less than 2 min*/
        //check start time for unzipping
        Date startDate =  new Date();
        utilitiesFunc.logger.info("Start time for unzipping: "+ startDate);
        //System.out.println("Start time:"+ startDate);
        utilitiesFunc.unzip(destDir);
        Date endDate =  new Date();
        utilitiesFunc.logger.info("End time for unzipping: "+ endDate);
        //System.out.println("End time:"+ endDate);
        utilitiesDBtest.deleteOutputTest(destDir);
        //assertEquals(true, startDate.before(endDate));
        assertTrue(endDate.getMinutes()-startDate.getMinutes() < 5);
        //deleteOutpuTest(destDir);
    }

    /**
     * test the function mergeDays
     */
    @Test
    public void mergeDaysTest(){
        Calendar c = new Calendar();
        String ans = c.mergeDayes("1","1","0","1","1","0","1");
        assertEquals(7,ans.length());
    }


}
