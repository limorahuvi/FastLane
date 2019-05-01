package models.entities.query;

import io.ebean.Database;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.Trips;
import models.entities.query.assoc.QAssocCalendar;
import models.entities.query.assoc.QAssocRoutes;

/**
 * Query bean for Trips.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QTrips extends TQRootBean<Trips,QTrips> {

  private static final QTrips _alias = new QTrips(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QTrips alias() {
    return _alias;
  }

  public PString<QTrips> trip_id;
  public QAssocRoutes<QTrips> route_id;
  public QAssocCalendar<QTrips> service_id;
  public PBoolean<QTrips> direction_id;
  public PInteger<QTrips> shape_id;


  /**
   * Construct with a given Database.
   */
  public QTrips(Database server) {
    super(Trips.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public QTrips() {
    super(Trips.class);
  }

  /**
   * Construct for Alias.
   */
  private QTrips(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PString<QTrips> trip_id = _alias.trip_id;
    public static QAssocRoutes<QTrips> route_id = _alias.route_id;
    public static QAssocCalendar<QTrips> service_id = _alias.service_id;
    public static PBoolean<QTrips> direction_id = _alias.direction_id;
    public static PInteger<QTrips> shape_id = _alias.shape_id;
  }
}
