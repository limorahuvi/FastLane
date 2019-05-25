package models.queries.devSched;
import java.util.ArrayList;
import java.util.List;
import models.queries.GeojsonTemplates.QueryFeature;



public class devSchedSingleFeature extends QueryFeature  {

   public List<properties> properties = new ArrayList<>();
    public geometry geometry=new geometry();


    public devSchedSingleFeature(double[] coor1, double average1,double average2,String description1,String description2) {
        properties.add(new properties(average1,description1));
        properties.add(new properties(average2,description2));
       this.geometry.coordinates=coor1;
    }

}
