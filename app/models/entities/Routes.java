package models.entities;

import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;

@Entity
public class Routes extends Model {

    @Id
    private Integer route_id;
    @ManyToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "agency_id")
    private Agency agency_id; //foreign key to Agency.agency_id
    @Column(columnDefinition = "VARCHAR")
    private String route_long_name;
    @Column(columnDefinition = "VARCHAR")
    private String route_desc;
    @Column(columnDefinition = "VARCHAR")
    private String route_type;
    private Integer route_color;
}