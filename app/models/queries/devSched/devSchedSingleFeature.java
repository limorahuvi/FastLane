package models.queries.devSched;
import java.util.ArrayList;
import java.util.List;


public class devSchedSingleFeature {
   /*
   {
    "type": "Feature",
    "geometry": {
      "type": "Point",
      "coordinates": [34.798256,31.260114]
    },
    "properties": [{
      "average":2,
      "description": ["line 3: 2 minutes", "line 4 :2 minutes"]
    },
      { "average":5,
        "description": ["line 3: 5 minutes", "line 4 :5 minutes"]}]

  }

    */
   public List<properties> properties = new ArrayList<>();
    public geometry geometry;

    public devSchedSingleFeature(double[] coor1, double average1,double average2,String[]description1,String[]description2) {
        properties.add(new properties(average1,description1));
        properties.add(new properties(average2,description2));
        this.geometry=new geometry(coor1);
    }
}
