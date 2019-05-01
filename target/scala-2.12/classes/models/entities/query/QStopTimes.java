package models.entities.query;

import io.ebean.Database;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PTime;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.StopTimes;
import models.entities.query.assoc.QAssocStop;
import models.entities.query.assoc.QAssocStopTimesKey;
import models.entities.query.assoc.QAssocTrips;

/**
 * Query bean for StopTimes.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QStopTimes extends TQRootBean<StopTimes,QStopTimes> {

  private static final QStopTimes _alias = new QStopTimes(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QStopTimes alias() {
    return _alias;
  }

  public QAssocStopTimesKey<QStopTimes> stKey;
  public QAssocStop<QStopTimes> stop;
  public QAssocTrips<QStopTimes> trip;
  public PTime<QStopTimes> departure_time;
  public PInteger<QStopTimes> stop_sequence;
  public PBoolean<QStopTimes> pickup_types;
  public PBoolean<QStopTimes> drop_off_type;
  public PInteger<QStopTimes> shape_dist_traveled;


  /**
   * Construct with a given Database.
   */
  public QStopTimes(Database server) {
    super(StopTimes.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public QStopTimes() {
    super(StopTimes.class);
  }

  /**
   * Construct for Alias.
   */
  private QStopTimes(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static QAssocStopTimesKey<QStopTimes> stKey = _alias.stKey;
    public static QAssocStop<QStopTimes> stop = _alias.stop;
    public static QAssocTrips<QStopTimes> trip = _alias.trip;
    public static PTime<QStopTimes> departure_time = _alias.departure_time;
    public static PInteger<QStopTimes> stop_sequence = _alias.stop_sequence;
    public static PBoolean<QStopTimes> pickup_types = _alias.pickup_types;
    public static PBoolean<QStopTimes> drop_off_type = _alias.drop_off_type;
    public static PInteger<QStopTimes> shape_dist_traveled = _alias.shape_dist_traveled;
  }
}
