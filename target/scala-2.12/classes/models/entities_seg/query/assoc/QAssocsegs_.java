package models.entities_seg.query.assoc;

import io.ebean.typequery.PInteger;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.query.Qsegs_;
import models.entities_seg.segs_;

/**
 * Association query bean for Assocsegs_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocsegs_<R> extends TQAssocBean<segs_,R> {

  public QAssocshapes_key_<R> key;
  public PInteger<R> seg_id;

  /**
   * Eagerly fetch this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetch(TQProperty<Qsegs_>... properties) {
    return fetchProperties(properties);
  }

  /**
   * Eagerly fetch this association using a 'query join' loading the specified properties.
   */
  @SafeVarargs
  public final R fetchQuery(TQProperty<Qsegs_>... properties) {
    return fetchQueryProperties(properties);
  }

  /**
   * Use lazy loading for this association loading the specified properties.
   */
  @SafeVarargs
  public final R fetchLazy(TQProperty<Qsegs_>... properties) {
    return fetchLazyProperties(properties);
  }

  public QAssocsegs_(String name, R root) {
    super(name, root);
  }
}
