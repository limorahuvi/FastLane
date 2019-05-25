package models.entities.query.assoc;

import io.ebean.typequery.PInteger;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.ShapeKey;

/**
 * Association query bean for AssocShapeKey.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocShapeKey<R> extends TQAssocBean<ShapeKey,R> {

  public PInteger<R> shape_id;
  public PInteger<R> shape_pt_sequence;

  public QAssocShapeKey(String name, R root) {
    super(name, root);
  }
}
