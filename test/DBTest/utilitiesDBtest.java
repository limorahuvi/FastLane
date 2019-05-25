package DBTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import play.Logger;


public class utilitiesDBtest {

    public static Logger logger = null;


    public static String createPath(String direction) {
        String cwd = System.getProperty("user.dir");
        Path path = Paths.get(cwd);
        Path pathParent = path.getParent();
        Path filePath = Paths.get(pathParent.toString(), direction);
        return filePath.toString();
    }

    public static void deleteOutputTest(String dir) {
        File directory = new File(dir);
        String[]entries = directory.list();
        for(String s: entries){
            File currentFile = new File(directory.getPath(),s);
            currentFile.delete();
        }
        directory.delete();
        logger.info("Clearing outputTest folder");
    }


}
