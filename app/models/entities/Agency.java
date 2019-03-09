package models.entities;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

@Entity
public class Agency extends Model{

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