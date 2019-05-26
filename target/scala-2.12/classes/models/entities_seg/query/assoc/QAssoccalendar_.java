package models.entities_seg.query.assoc;

import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.calendar_;
import models.entities_seg.query.Qcalendar_;

/**
 * Association query bean for Assoccalendar_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssoccalendar_<R> extends TQAssocBean<calendar_,R> {

  public PInteger<R> service_id;
  public PString<R> days_bytes;
  public PUtilDate<R> start_date;
  public PUtilDate<R> end_date;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<Qcalendar_>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<Qcalendar_>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<Qcalendar_>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssoccalendar_(String name, R root) {
    super(name, root);
  }
}
