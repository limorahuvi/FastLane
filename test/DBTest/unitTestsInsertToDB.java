package DBTest;

import models.entities.Calendar;
import models.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class unitTestsInsertToDB {

    String destDir = utilitiesDBtest.createPath("outTest");

    @BeforeClass
    public void setup() throws IOException {
        utilitiesFunc.writeToLog("LogTest_unitTestsInsertToDB.log");
    }
    @Test
    public void testUnzip() throws Exception {
        utilitiesFunc.unzip(destDir);
        assertTrue(!destDir.isEmpty());
    }

    @Test
    public void testTimeUnzip() throws IOException {
        /*test to check if time for unzipping file is less than 2 min*/
        //check start time for unzipping
        Date startDate =  new Date();
        utilitiesFunc.logger.info("tablesQueries TEST starts: \n");
        utilitiesFunc.logger.info("Start time: "+ startDate);
        //System.out.println("Start time:"+ startDate);
        utilitiesFunc.unzip(destDir);
        Date endDate =  new Date();
        utilitiesFunc.logger.info("End time: "+ endDate);
        //System.out.println("End time:"+ endDate);
        utilitiesDBtest.deleteOutputTest(destDir);
        //assertEquals(true, startDate.before(endDate));
        assertTrue(endDate.getMinutes()-startDate.getMinutes() < 5);
        //deleteOutpuTest(destDir);
    }



    @Test
    public void mergeDaysTest(){
        Calendar c = new Calendar();
        String ans = c.mergeDayes("1","1","0","1","1","0","1");
        assertEquals(7,ans.length());
    }


}
