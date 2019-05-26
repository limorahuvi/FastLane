package models.entities_seg.query.assoc;

import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.query.Qtrips_;
import models.entities_seg.trips_;

/**
 * Association query bean for Assoctrips_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssoctrips_<R> extends TQAssocBean<trips_,R> {

  public PString<R> trip_id;
  public QAssocroutes_<R> route_id;
  public QAssoccalendar_<R> service_id;
  public PBoolean<R> direction_id;
  public PInteger<R> shape_id;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<Qtrips_>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<Qtrips_>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<Qtrips_>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssoctrips_(String name, R root) {
    super(name, root);
  }
}
