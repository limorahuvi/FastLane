package models.entities.query.assoc;

import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PTime;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.StopTimesKey;

/**
 * Association query bean for AssocStopTimesKey.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAssocStopTimesKey<R> extends TQAssocBean<StopTimesKey,R> {

  public PString<R> trip_id;
  public PInteger<R> stop_id;
  public PTime<R> arrival_time;

  public QAssocStopTimesKey(String name, R root) {
    super(name, root);
  }
}
