package models.entities_seg.query.assoc;

import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.query.Qroutes_;
import models.entities_seg.routes_;

/**
 * Association query bean for Assocroutes_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocroutes_<R> extends TQAssocBean<routes_,R> {

  public PInteger<R> route_id;
  public QAssocagency_<R> agency_id;
  public PString<R> route_long_name;
  public PString<R> route_desc;
  public PString<R> route_type;
  public PString<R> route_color;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<Qroutes_>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<Qroutes_>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<Qroutes_>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocroutes_(String name, R root) {
    super(name, root);
  }
}
