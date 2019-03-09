package models.entities;

import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Routes extends Model {

    @Id
    @Constraints.Min(10)
    public Integer route_id;

    @ManyToOne //or @OneToMany need to check if it create a column
    public Integer agency_id; //foreign key to Agency.agency_id

    @Column
    public String route_long_name;

    @Column
    public String route_desc;

    @Column
    public String route_type;

    @Column
    public  Integer route_color;
}
