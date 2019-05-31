package models.entities_seg;

import io.ebean.Finder;
import io.ebean.Model;
import org.postgis.Point;

import javax.persistence.*;

@Entity
public class segs_ extends Model {

    @EmbeddedId
    private shapes_key_ key;
    private Integer seg_id;
    private Point point; //(shape_pt_lat	, shape_pt_lot)
    private stop_ stop_id;

    public shapes_key_ getKey() {
        return key;
    }
    public void setKey(shapes_key_ key) {
        this.key = key;
    }
    public Point getPoint() {
        return point;
    }
    public void setPoint(Point point) {
        this.point = point;
    }
    public static final Finder<shapes_key_, shapes_> find = new Finder<>(shapes_.class);
    public void setSeg_id(Integer seg_id) { this.seg_id = seg_id; }
    public stop_ getStop_id() { return stop_id;}
    public void setStop_id(stop_ stop_id) { this.stop_id = stop_id; }
    public Integer getSeg_id() { return seg_id; }


}
