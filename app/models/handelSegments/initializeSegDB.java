package models.handelSegments;

import models.utilitiesFunc;

import java.io.IOException;

public class initializeSegDB {

    private static initializeSegDB single_instance = null;
    private static Boolean is_initial = false;
    private String destDir = utilitiesFunc.createPath("seg_output");

    private initializeSegDB() {
        is_initial = true;
        insertDataToSegDB(destDir);
    }

    public static initializeSegDB getInstance(){
        if (single_instance == null && !is_initial) {
            single_instance = new initializeSegDB();
        }
        return single_instance;
    }

    public static void insertDataToSegDB(String destDir){

        utilitiesFunc.writeToLog("LogFileSeg.log");
        new insertToSegDB(destDir);
    }





}
