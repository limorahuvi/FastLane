package models.entities_seg;


import io.ebean.Model;

import javax.persistence.Embeddable;

@Embeddable
public class shapes_key_ extends Model {

    private Integer shape_id;
    private Integer shape_pt_sequence;

    public shapes_key_() {}

    public shapes_key_(Integer s_id, Integer s_seq) {
        this.setShape_id(s_id);
        this.setShape_pt_sequence(s_seq);
    }

    public Integer getShape_id() {
        return shape_id;
    }

    public void setShape_id(Integer shape_id) {
        this.shape_id = shape_id;
    }

    public Integer getShape_pt_sequence() {
        return shape_pt_sequence;
    }

    public void setShape_pt_sequence(Integer shape_pt_sequence) {
        this.shape_pt_sequence = shape_pt_sequence;
    }
    public int hashCode() {
        return this.shape_id+this.shape_pt_sequence;
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof shapes_key_)) return false;
        shapes_key_ sk = (shapes_key_) obj;
        return sk.shape_id == this.shape_id && sk.shape_pt_sequence.equals(this.shape_pt_sequence);
    }

}
