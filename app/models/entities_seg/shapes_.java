package models.entities_seg;

import io.ebean.Finder;
import io.ebean.Model;

import org.postgis.Point;

import javax.persistence.*;

@Entity
public class shapes_ extends Model {


    @Id
    private Integer shape_id;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "seg_id", referencedColumnName = "seg_id"),
        @JoinColumn(name = "shape_pt_sequence", referencedColumnName = "shape_pt_sequence")})
    private segs_ seg_id;


    public static final Finder<Integer, shapes_> find = new Finder<>(shapes_.class);

   public segs_ getSeg_id() {
        return seg_id;
    }

    public void setSeg_id(segs_ seg_id) {
        this.seg_id = seg_id;
    }
    public Integer getShape_id() {
        return shape_id;
    }

    public void setShape_id(Integer shape_id) {
        this.shape_id = shape_id;
    }



}
