package models.queries.devSched;

/**
 * properties of a feature in the geojsons collection
 * average - average for lateness or preliminaries
 */
public class properties {
    public double average;
    public String description;
    public properties(double average,String description) {
       this.average=average;
       this.description=description;
    }
}
