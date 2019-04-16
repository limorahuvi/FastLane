package models.entities;

import org.postgis.Point;
import java.util.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import javax.persistence.*;

@Entity
public class Shape extends Model {

    @EmbeddedId
    private ShapeKey key;

    private Point point; //(shape_pt_lat	, shape_pt_lot)

    public ShapeKey getKey() {
        return key;
    }

    public void setKey(ShapeKey key) {
        this.key = key;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public static final Finder<ShapeKey, Shape> find = new Finder<>(Shape.class);
}