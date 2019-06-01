package models.entities_seg;


import javax.persistence.Embeddable;

@Embeddable
public class segs_key_  {

    private Integer seg_id;
    private Integer shape_pt_sequence;

    public segs_key_() {}

    public segs_key_(Integer s_id, Integer s_seq) {
        this.setSeg_id(s_id);
        this.setShape_pt_sequence(s_seq);
    }

    public Integer getSeg_id() {
        return seg_id;
    }

    public void setSeg_id(Integer seg_id) {
        this.seg_id = seg_id;
    }

    public Integer getShape_pt_sequence() {
        return shape_pt_sequence;
    }

    public void setShape_pt_sequence(Integer shape_sequence) {
        this.shape_pt_sequence = shape_sequence;
    }
    public int hashCode() {
        return this.seg_id+this.shape_pt_sequence;
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof segs_key_)) return false;
        segs_key_ sk = (segs_key_) obj;
        return sk.seg_id == this.seg_id && sk.shape_pt_sequence.equals(this.shape_pt_sequence);
    }
}
