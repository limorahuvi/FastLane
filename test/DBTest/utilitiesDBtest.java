package DBTest;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import play.Logger;


public class utilitiesDBtest {

    public static String createPath(String direction) {
        String cwd = System.getProperty("user.dir");
        Path path = Paths.get(cwd);
        Path pathParent = path.getParent();
        Path filePath = Paths.get(pathParent.toString(), direction);
        return filePath.toString();
    }

    public static void deleteOutpuTest(String dir) {
        File directory = new File(dir);
        String[]entries = directory.list();
        for(String s: entries){
            File currentFile = new File(directory.getPath(),s);
            currentFile.delete();
        }
        directory.delete();
        Logger.info("Clearing outputTest folder");
    }
}
