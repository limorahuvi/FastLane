package models.entities_seg;

import io.ebean.Model;

public class segs_key_ extends Model {

    private Integer seg_id;
    private Integer shape_sequence;

    public segs_key_() {}

    public segs_key_(Integer s_id, Integer s_seq) {
        this.setSeg_id(s_id);
        this.setShape_pt_sequence(s_seq);
    }

    public Integer getSeg_id() {
        return seg_id;
    }

    public void setSeg_id(Integer shape_id) {
        this.seg_id = seg_id;
    }

    public Integer getShape_pt_sequence() {
        return shape_sequence;
    }

    public void setShape_pt_sequence(Integer shape_sequence) {
        this.shape_sequence = shape_sequence;
    }
    public int hashCode() {
        return this.seg_id+this.shape_sequence;
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof segs_key_)) return false;
        segs_key_ sk = (segs_key_) obj;
        return sk.seg_id == this.seg_id && sk.shape_sequence.equals(this.shape_sequence);
    }
}
