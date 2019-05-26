package models.entities_seg.query.assoc;

import io.ebean.typequery.PInteger;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.shapes_key_;

/**
 * Association query bean for Assocshapes_key_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocshapes_key_<R> extends TQAssocBean<shapes_key_,R> {

  public PInteger<R> shape_id;
  public PInteger<R> shape_pt_sequence;

  public QAssocshapes_key_(String name, R root) {
    super(name, root);
  }
}
