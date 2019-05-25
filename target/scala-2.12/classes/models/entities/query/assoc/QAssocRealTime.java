package models.entities.query.assoc;

import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PTime;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.RealTime;
import models.entities.query.QRealTime;

/**
 * Association query bean for AssocRealTime.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocRealTime<R> extends TQAssocBean<RealTime,R> {

  public PInteger<R> realTime_id;
  public QAssocStop<R> stop;
  public PString<R> publishedLineName;
  public PUtilDate<R> expectedArrivalDate;
  public PTime<R> expectedArrivalTime;
  public PUtilDate<R> recordedAtTime_Date;
  public PTime<R> recordedAtTime_Time;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QRealTime>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QRealTime>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QRealTime>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocRealTime(String name, R root) {
    super(name, root);
  }
}
