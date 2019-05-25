package models.entities.query.assoc;

import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.Stop;
import models.entities.query.QStop;

/**
 * Association query bean for AssocStop.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocStop<R> extends TQAssocBean<Stop,R> {

  public PInteger<R> stop_id;
  public PInteger<R> stop_code;
  public PString<R> stop_name;
  public PString<R> stop_desc;
  public PBoolean<R> location_type;
  public QAssocStop<R> parent_station;
  public QAssocRealTime<R> realTimeList;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QStop>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QStop>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QStop>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocStop(String name, R root) {
    super(name, root);
  }
}
