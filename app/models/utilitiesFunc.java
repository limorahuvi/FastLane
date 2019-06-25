package models;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/***
 * This class has external function to helps the classes in models.
 */
public class utilitiesFunc {

    public static Logger logger = null;

    /**
     * creating a path for the given string file
     * @param direction
     * @return
     */
    public static String createPath(String direction) {
        String cwd = System.getProperty("user.dir");
        Path path = Paths.get(cwd);
        Path filePath = Paths.get(path.toString(), direction);
        return filePath.toString();
    }

    /**
     * all progress of the project is written into log file.
     * @param fileName
     */
    public static void writeToLog(String fileName) {
        logger = Logger.getLogger(fileName);
            FileHandler fh;

            try {
                // This block configure the logger with handler and formatter
                fh = new FileHandler(fileName);
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    /**
     *  extracting the gtfs.zip file.
     * @param destDir
     * @throws IOException
     */
    public static void unzip(String destDir) throws IOException {
        String gtfs_path = utilitiesFunc.createPath("sources/gtfs.zip");

            FileInputStream fis;
            //buffer for read and write data to file
            byte[] buffer = new byte[1024];
            try {
                fis = new FileInputStream(gtfs_path);
                ZipInputStream zis = new ZipInputStream(fis);
                ZipEntry ze = zis.getNextEntry();
                while(ze != null){
                    String fileName = ze.getName();
                    File newFile = new File(destDir + File.separator + fileName);
                    System.out.println("Unzipping to " +newFile.getAbsolutePath());
                    //create directories for sub directories in zip
                    FileOutputStream fos = new FileOutputStream(newFile);
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                    //close this ZipEntry
                    zis.closeEntry();
                    ze = zis.getNextEntry();
                }
                //close last ZipEntry
                zis.closeEntry();
                zis.close();
                fis.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

    }

}
