package models.entities;

import javax.persistence.Embeddable;

@Embeddable
public class ShapeKey {
    private Integer shape_id;
    private Integer shape_pt_sequence;

    public ShapeKey() {}

    public ShapeKey(Integer s_id, Integer s_seq) {
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
        if (!(obj instanceof ShapeKey)) return false;
        ShapeKey sk = (ShapeKey) obj;
        return sk.shape_id == this.shape_id && sk.shape_pt_sequence.equals(this.shape_pt_sequence);
    }

}
