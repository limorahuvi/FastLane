package models.entities_seg;

import io.ebean.Finder;
import io.ebean.Model;
import org.postgis.Point;

import javax.persistence.*;

@Entity
public class segs_ extends Model {

    @EmbeddedId
    private segs_key_ key;

    private Point point; //(shape_pt_lat	, shape_pt_lot)
    @ManyToOne
    @JoinColumn(name = "stop_id", referencedColumnName = "stop_id")
    private stop_ stop_id;

    public segs_key_ getKey() {
        return key;
    }
    public void setKey(segs_key_ key) {
        this.key = key;
    }
    public Point getPoint() {
        return point;
    }
    public void setPoint(Point point) {
        this.point = point;
    }
    public static final Finder<segs_key_, segs_> find = new Finder<>(segs_.class);
    public stop_ getStop_id() { return stop_id;}
    public void setStop_id(stop_ stop_id) { this.stop_id = stop_id; }



}
