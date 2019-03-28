package models.entities;

import javax.persistence.*;


@Entity
public class Trips {

    @Id
    @Column(columnDefinition = "varchar")
    private String trip_id;
    @Column(nullable = false)
    private Integer route_id;
    @Column(nullable = false)
    private Integer service_id;
    private Boolean direction_id;
    private Integer shape_id;
    

}