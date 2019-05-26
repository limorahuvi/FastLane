package models.entities_seg.query.assoc;

import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.query.Qshapes_;
import models.entities_seg.shapes_;

/**
 * Association query bean for Assocshapes_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocshapes_<R> extends TQAssocBean<shapes_,R> {

  public QAssocshapes_key_<R> key;
  public QAssocsegs_<R> seg_id;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<Qshapes_>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<Qshapes_>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<Qshapes_>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocshapes_(String name, R root) {
    super(name, root);
  }
}
