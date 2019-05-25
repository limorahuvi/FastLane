package models.entities.query;

import io.ebean.Database;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PTime;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.RealTime;
import models.entities.query.assoc.QAssocStop;

/**
 * Query bean for RealTime.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QRealTime extends TQRootBean<RealTime,QRealTime> {

  private static final QRealTime _alias = new QRealTime(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QRealTime alias() {
    return _alias;
  }

  public PInteger<QRealTime> realTime_id;
  public QAssocStop<QRealTime> stop;
  public PString<QRealTime> publishedLineName;
  public PUtilDate<QRealTime> expectedArrivalDate;
  public PTime<QRealTime> expectedArrivalTime;
  public PUtilDate<QRealTime> recordedAtTime_Date;
  public PTime<QRealTime> recordedAtTime_Time;


  /**
   * Construct with a given Database.
   */
  public QRealTime(Database server) {
    super(RealTime.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public QRealTime() {
    super(RealTime.class);
  }

  /**
   * Construct for Alias.
   */
  private QRealTime(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PInteger<QRealTime> realTime_id = _alias.realTime_id;
    public static QAssocStop<QRealTime> stop = _alias.stop;
    public static PString<QRealTime> publishedLineName = _alias.publishedLineName;
    public static PUtilDate<QRealTime> expectedArrivalDate = _alias.expectedArrivalDate;
    public static PTime<QRealTime> expectedArrivalTime = _alias.expectedArrivalTime;
    public static PUtilDate<QRealTime> recordedAtTime_Date = _alias.recordedAtTime_Date;
    public static PTime<QRealTime> recordedAtTime_Time = _alias.recordedAtTime_Time;
  }
}
