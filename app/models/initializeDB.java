package models;



import java.io.*;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class initializeDB {

    private static initializeDB single_instance = null;
    private static Boolean is_initial = false;

    private initializeDB() {
        is_initial = true;
        insertDataToDB();
    }

    public static initializeDB getInstance(){
        if (single_instance == null && !is_initial) {
            single_instance = new initializeDB();
        }
        return single_instance;
    }

    private static void insertDataToDB(){
        String destDir = "C:/Users/user/workspace/final project/output";
        try {
            unzip(destDir);
            insertToDB newdb = new insertToDB(destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void unzip(String destDir) throws IOException {
        File dir = new File(destDir);
        // create output directory if it doesn't
        if(!dir.exists()) {
            dir.mkdirs();

            FileInputStream fis;
            //buffer for read and write data to file
            byte[] buffer = new byte[1024];
            try {
                fis = new FileInputStream("C:/Users/user/Desktop/fastLanes/sources/gtfs.zip");
                ZipInputStream zis = new ZipInputStream(fis);
                ZipEntry ze = zis.getNextEntry();
                while(ze != null){
                    String fileName = ze.getName();
                    File newFile = new File(destDir + File.separator + fileName);
                    System.out.println("Unzipping to "+newFile.getAbsolutePath());
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
