package models;
import com.fasterxml.jackson.databind.JsonNode;


public abstract class VisualizationForm{
    public JsonNode result = null;
    public abstract String getParametersList();
}