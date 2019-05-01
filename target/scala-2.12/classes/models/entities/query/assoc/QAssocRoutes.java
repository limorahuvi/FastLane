package models.entities.query.assoc;

import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.Routes;
import models.entities.query.QRoutes;

/**
 * Association query bean for AssocRoutes.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocRoutes<R> extends TQAssocBean<Routes,R> {

  public PInteger<R> route_id;
  public QAssocAgency<R> agency_id;
  public PString<R> route_long_name;
  public PString<R> route_desc;
  public PString<R> route_type;
  public PString<R> route_color;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<QRoutes>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<QRoutes>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<QRoutes>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocRoutes(String name, R root) {
    super(name, root);
  }
}
