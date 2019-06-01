package models.entities_seg;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;

@Entity
public class agency_ extends Model {

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

    public static final Finder<Integer, agency_> find = new Finder<>(agency_.class);
}
