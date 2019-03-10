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
    private Integer agency_id;
    @Column(columnDefinition = "varchar(50) not null")
    private String agency_name;
    @Column(columnDefinition = "varchar")
    private String agency_url;

    // public static final Finder<Long, Task> find = new Finder<>(Task.class);
}