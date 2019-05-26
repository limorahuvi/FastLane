package models.entities_seg.query.assoc;

import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PTime;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.stop_times_key;

/**
 * Association query bean for Assocstop_times_key.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocstop_times_key<R> extends TQAssocBean<stop_times_key,R> {

  public PString<R> trip_id;
  public PInteger<R> stop_id;
  public PTime<R> arrival_time;

  public QAssocstop_times_key(String name, R root) {
    super(name, root);
  }
}
