package models.entities;

import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;


@Entity
public class Agency extends Model{

    @Id
    private Integer agency_id;
    @Column(columnDefinition = "varchar(50) not null")
    private String agency_name;
    @Column(columnDefinition = "varchar")
    private String agency_url;

    public Integer getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(Integer agency_id) {
        this.agency_id = agency_id;
    }

    public String getAgency_name() {
        return agency_name;
    }

    public void setAgency_name(String agency_name) {
        this.agency_name = agency_name;
    }

    public String getAgency_url() {
        return agency_url;
    }

    public void setAgency_url(String agency_url) {
        this.agency_url = agency_url;
    }

    public static final Finder<Integer, Agency> find = new Finder<>(Agency.class);
}