package DBTest;

import models.entities.Calendar;
import models.*;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class unitTestsInsertToDB {

    String destDir = utilitiesDBtest.createPath("outTest");

    @Test
    public void testUnzip() throws Exception {
        initializeDB.unzip(destDir);
        assertTrue(!destDir.isEmpty());
    }

    @Test
    public void testTimeUnzip() throws IOException {
        /*test to check if time for unzipping file is less than 2 min*/
        //check start time for unzipping
        Date startDate =  new Date();
        System.out.println("Start time:"+ startDate);
        initializeDB.unzip(destDir);
        Date endDate =  new Date();
        System.out.println("End time:"+ endDate);
        utilitiesDBtest.deleteOutpuTest(destDir);
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

/*    @Test
    public void cleanQuotationMarksTest()  throws IOException{
        initializeDB init = initializeDB.getInstance();
        init.unzip(destDir);
        insertToDB  instDB = new insertToDB(destDir);
        String ans = instDB.cleanQuotationMarks("'Hi there test'");
        assertEquals("Hi there test", ans);
    }*/

}
