package models.entities;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shape extends Model {

    @Id
    @Column
    public Integer shape_id;

    @Column
    public Float shape_pt_lat;

    @Column
    public Float shape_pt_lot;

    @Id
    @Column
    public Integer shape_pt_sequence;
}

