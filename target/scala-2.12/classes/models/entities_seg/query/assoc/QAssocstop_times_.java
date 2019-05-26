package models.entities_seg.query.assoc;

import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PTime;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.query.Qstop_times_;
import models.entities_seg.stop_times_;

/**
 * Association query bean for Assocstop_times_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocstop_times_<R> extends TQAssocBean<stop_times_,R> {

  public QAssocstop_times_key<R> stKey;
  public QAssocstop_<R> stop;
  public QAssoctrips_<R> trip;
  public PTime<R> departure_time;
  public PInteger<R> stop_sequence;
  public PBoolean<R> pickup_types;
  public PBoolean<R> drop_off_type;
  public PInteger<R> shape_dist_traveled;
  public PInteger<R> continue_passengers;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<Qstop_times_>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<Qstop_times_>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<Qstop_times_>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocstop_times_(String name, R root) {
    super(name, root);
  }
}
