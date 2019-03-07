package models;
import com.fasterxml.jackson.databind.JsonNode;


public abstract class VisualizationForm{
    public JsonNode result = null;
    public String resultString = "";
    public abstract String getParametersList();
    public JsonNode getResult(){
        return result;
    }

    public void setResult(JsonNode result){
        this.result=result;
    }

    public String getResultString(){
        return resultString;
    }
}

