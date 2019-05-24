package models.queries.GeojsonTemplates;

import models.VisualizationForm;
import org.postgis.Point;

import java.util.ArrayList;
import java.util.List;

public class QueryHandler {

    public VisualizationForm form;

    /* square area on the map */
    public double[] square = new double[4];
    public final int MIN_X = 0;
    public final int MAX_X = 1;
    public final int MIN_Y = 2;
    public final int MAX_Y = 3;

    public String type = "FeatureCollection";
    public List<QueryFeature> features = new ArrayList<>();

    public QueryHandler(VisualizationForm form){
        this.form = form;
        if(form != null)
            getSquareArea();
    }

    public void addFeature(QueryFeature feature){
        features.add(feature);
    }

    private void getSquareArea() {
        String coor1=form.getCoor1();
        String[] coor1_x_y= coor1.split(",");
        String coor2=form.getCoor2();
        String[] coor2_x_y=coor2.split(",");
        Point p1=new Point(Double.parseDouble(coor1_x_y[1]),Double.parseDouble(coor2_x_y[0]));
        Point p2=new Point(Double.parseDouble(coor2_x_y[1]),Double.parseDouble(coor1_x_y[0]));
        Point p3=new Point(Double.parseDouble(coor1_x_y[1]),Double.parseDouble(coor1_x_y[0]));
        Point p4=new Point(Double.parseDouble(coor2_x_y[1]),Double.parseDouble(coor2_x_y[0]));
        square[MAX_X]=Math.max(Math.max(p1.getX(),p2.getX()),Math.max(p3.getX(),p4.getX()));
        square[MIN_X]=Math.min(Math.min(p1.getX(),p2.getX()),Math.min(p3.getX(),p4.getX()));
        square[MAX_Y]=Math.max(Math.max(p1.getY(),p2.getY()),Math.max(p3.getY(),p4.getY()));
        square[MIN_Y]=Math.min(Math.min(p1.getY(),p2.getY()),Math.min(p3.getY(),p4.getY()));
    }

}
