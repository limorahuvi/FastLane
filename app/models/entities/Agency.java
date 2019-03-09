package models.entities;

import io.ebean.Model;
import play.data.validation.Constraints;
import javax.persistence.*;


@Entity
public class Agency extends Model {

    @Id
    @Constraints.Min(10)
    public Integer agency_id;

    @Column
    @Constraints.Required
    public String agency_name;

    @Column
    public String agency_url;

    // public static final Finder<Long, Task> find = new Finder<>(Task.class);
}