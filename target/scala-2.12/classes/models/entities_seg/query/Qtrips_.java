package models.entities_seg.query;

import io.ebean.Database;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.query.assoc.QAssoccalendar_;
import models.entities_seg.query.assoc.QAssocroutes_;
import models.entities_seg.trips_;

/**
 * Query bean for trips_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class Qtrips_ extends TQRootBean<trips_,Qtrips_> {

  private static final Qtrips_ _alias = new Qtrips_(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static Qtrips_ alias() {
    return _alias;
  }

  public PString<Qtrips_> trip_id;
  public QAssocroutes_<Qtrips_> route_id;
  public QAssoccalendar_<Qtrips_> service_id;
  public PBoolean<Qtrips_> direction_id;
  public PInteger<Qtrips_> shape_id;


  /**
   * Construct with a given Database.
   */
  public Qtrips_(Database server) {
    super(trips_.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public Qtrips_() {
    super(trips_.class);
  }

  /**
   * Construct for Alias.
   */
  private Qtrips_(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<Qtrips_> trip_id = _alias.trip_id;
    public static QAssocroutes_<Qtrips_> route_id = _alias.route_id;
    public static QAssoccalendar_<Qtrips_> service_id = _alias.service_id;
    public static PBoolean<Qtrips_> direction_id = _alias.direction_id;
    public static PInteger<Qtrips_> shape_id = _alias.shape_id;
  }
}
