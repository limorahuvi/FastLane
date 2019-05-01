package models.entities.query.assoc;

import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.Trips;
import models.entities.query.QTrips;

/**
 * Association query bean for AssocTrips.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocTrips<R> extends TQAssocBean<Trips,R> {

  public PString<R> trip_id;
  public QAssocRoutes<R> route_id;
  public QAssocCalendar<R> service_id;
  public PBoolean<R> direction_id;
  public PInteger<R> shape_id;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QTrips>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QTrips>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QTrips>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocTrips(String name, R root) {
    super(name, root);
  }
}
