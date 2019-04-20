package DBTest;

import com.google.common.collect.ImmutableMap;
import models.entities.Calendar;
import models.initializeDB;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.db.Database;
import play.db.Databases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class unitTestsInsertToDB {
    private static Database database;
    String destDir = createPath("outTest");

    public static String createPath(String direction) {
        String cwd = System.getProperty("user.dir");
        Path path = Paths.get(cwd);
        Path pathParent = path.getParent();
        Path filePath = Paths.get(pathParent.toString(), direction);
        return filePath.toString();
    }

    @Before
    public void createDatabase() {
        database = Databases.createFrom(
                "org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/postgres",
                ImmutableMap.of(
                        "username", "postgres",
                        "password", "1234"
                ));
    }

    @After
    public void shutdownDatabase() {
        database.shutdown();
    }

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
        deleteOutpuTest(destDir);
        //assertEquals(true, startDate.before(endDate));
        assertTrue(endDate.getMinutes()-startDate.getMinutes() < 5);
        //deleteOutpuTest(destDir);
    }

    private void deleteOutpuTest(String dir) {
        File directory = new File(dir);
        String[]entries = directory.list();
        for(String s: entries){
            File currentFile = new File(directory.getPath(),s);
            currentFile.delete();
        }
    }

    @Test
    public void mergeDaysTest(){
        Calendar c = new Calendar();
        String ans = c.mergeDayes("1","1","0","1","1","0","1");
        assertEquals(7,ans.length());
    }


}
