package models.entities;

import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Calendar extends Model {

    @Id
    private Integer service_id	;

    private Integer agency_id; //foreign key to Agency.agency_id
    @Column(columnDefinition = "BIT(7)")
    private String days_bytes;
    private Date start_date; //YYYYMMDD
    private Date end_date; //YYYYMMDD



}

