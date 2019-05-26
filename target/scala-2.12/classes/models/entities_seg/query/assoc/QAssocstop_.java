package models.entities_seg.query.assoc;

import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.query.Qstop_;
import models.entities_seg.stop_;

/**
 * Association query bean for Assocstop_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocstop_<R> extends TQAssocBean<stop_,R> {

  public PInteger<R> stop_id;
  public PInteger<R> stop_code;
  public PString<R> stop_name;
  public PString<R> stop_desc;
  public PBoolean<R> location_type;
  public QAssocstop_<R> parent_station;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<Qstop_>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<Qstop_>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<Qstop_>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocstop_(String name, R root) {
    super(name, root);
  }
}
