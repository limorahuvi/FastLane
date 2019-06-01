package models.entities_seg;


import io.ebean.Model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class shapes_key_  {


    private Integer shape_id;

  /*  @ManyToOne
    @JoinColumn(name = "seg_id", referencedColumnName = "seg_id")*/
    private segs_ segs_key;

    public shapes_key_() {}

    public shapes_key_(Integer s_id, segs_ segs_) {
        this.setShape_id(s_id);
        this.setSegs_key(segs_);
    }

    public Integer getShape_id() {
        return shape_id;
    }

    public void setShape_id(Integer shape_id) {
        this.shape_id = shape_id;
    }

    public segs_ getSegs_key() {
        return segs_key;
    }

    public void setSegs_key(segs_ segs_) {
        this.segs_key = segs_;
    }
    public int hashCode() {
        return this.shape_id+this.segs_key.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof shapes_key_)) return false;
        shapes_key_ sk = (shapes_key_) obj;
        return sk.shape_id == this.shape_id && sk.segs_key.equals(this.segs_key);
    }

}
