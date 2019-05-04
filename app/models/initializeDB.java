package models;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class initializeDB {

    private static initializeDB single_instance = null;
    private static Boolean is_initial = false;
    private String destDir = utilitiesFunc.createPath("output");

    private initializeDB() {
        is_initial = true;
        insertDataToDB(destDir);
    }

    public static initializeDB getInstance(){
        if (single_instance == null && !is_initial) {
            single_instance = new initializeDB();
        }
        return single_instance;
    }

    public static void insertDataToDB(String destDir){

        try {
            utilitiesFunc.writeToLog("LogFile.log");
            unzip(destDir);
            new insertToDB(destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void unzip(String destDir) throws IOException {
        File dir = new File(destDir);
        String gtfs_path = utilitiesFunc.createPath("sources/gtfs.zip");
        // create output directory if it doesn't
        if(!dir.exists()) {
            dir.mkdirs();

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
                    utilitiesFunc.logger.info("Unzipping to "+newFile.getAbsolutePath());
                    //create directories for sub directories in zip
                    new File(newFile.getParent()).mkdirs();
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


}
