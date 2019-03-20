package models.queries;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.libs.Json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;

public class queries {
    private static JsonNode stations = null;

    public static JsonNode getStations(){
        return readJsonFromFile("stations");
    }

    public static JsonNode getResults(PassengersCountForm form){
        return readJsonFromFile("passengersCount");
    }

    public static JsonNode getResults(DevSchedForm form){
        return readJsonFromFile("devSched");
    }

    private static JsonNode readJsonFromFile(String fileName){
        try {
            File initialFile = new File("app/models/queries/"+fileName+".json");
            InputStream targetStream = new FileInputStream(initialFile);
            return Json.parse(targetStream);
        } catch (IOException e) {
            return null;
        }
    }

}
