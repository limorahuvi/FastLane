package models.entities_seg.query.assoc;

import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.agency_;
import models.entities_seg.query.Qagency_;

/**
 * Association query bean for Assocagency_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocagency_<R> extends TQAssocBean<agency_,R> {

  public PInteger<R> agency_id;
  public PString<R> agency_name;
  public PString<R> agency_url;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<Qagency_>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<Qagency_>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<Qagency_>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocagency_(String name, R root) {
    super(name, root);
  }
}
