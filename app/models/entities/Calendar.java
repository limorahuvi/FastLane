package models.entities;

import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;

@Entity
public class Calendar extends Model {

    @Id
    @Constraints.Min(10)
    public Integer route_id;

    @ManyToMany //foreign key to Agency.agency_id
    public Integer agency_id;

    @Column
    public String route_long_name;

    @Column
    public String route_desc;

    @Column
    public String route_color;


}
