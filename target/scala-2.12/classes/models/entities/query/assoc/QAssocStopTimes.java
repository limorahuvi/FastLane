package models.entities.query.assoc;

import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PTime;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.StopTimes;
import models.entities.query.QStopTimes;

/**
 * Association query bean for AssocStopTimes.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocStopTimes<R> extends TQAssocBean<StopTimes,R> {

  public QAssocStopTimesKey<R> stKey;
  public QAssocStop<R> stop;
  public QAssocTrips<R> trip;
  public PTime<R> departure_time;
  public PInteger<R> stop_sequence;
  public PBoolean<R> pickup_types;
  public PBoolean<R> drop_off_type;
  public PInteger<R> shape_dist_traveled;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QStopTimes>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QStopTimes>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QStopTimes>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocStopTimes(String name, R root) {
    super(name, root);
  }
}
