package models.entities.query.assoc;

import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PTime;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.PassengerCounts;
import models.entities.query.QPassengerCounts;

/**
 * Association query bean for AssocPassengerCounts.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocPassengerCounts<R> extends TQAssocBean<PassengerCounts,R> {

  public PInteger<R> pc_id;
  public PInteger<R> TripId;
  public PInteger<R> PassengersContinue_rounded_final;
  public PString<R> DayNameHeb;
  public PString<R> station_order;
  public PUtilDate<R> DateKey;
  public PTime<R> HourKey;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QPassengerCounts>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QPassengerCounts>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QPassengerCounts>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocPassengerCounts(String name, R root) {
    super(name, root);
  }
}
