package models.entities_seg;

import io.ebean.Finder;
import io.ebean.Model;

import org.postgis.Point;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class shapes_ extends Model {

    @EmbeddedId
    private shapes_key_ key;

    @ManyToOne
    @JoinColumn(name = "seg_id", referencedColumnName = "seg_id")
    private segs_ seg_id;

   // private Point point; //(shape_pt_lat	, shape_pt_lot)

    public shapes_key_ getKey() {
        return key;
    }

    public void setKey(shapes_key_ key) {
        this.key = key;
    }

/*    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }*/

    public static final Finder<shapes_key_, shapes_> find = new Finder<>(shapes_.class);
    public segs_ getSeg_id() {
        return seg_id;
    }

    public void setSeg_id(segs_ seg_id) {
        this.seg_id = seg_id;
    }

    public static Finder<shapes_key_, shapes_> getFind() {
        return find;
    }
}
