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
            utilitiesFunc.unzip(destDir);
           // new insertToDB(destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
