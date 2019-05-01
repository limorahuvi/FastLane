package models.entities.query;

import io.ebean.Database;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PTime;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.PassengerCounts;

/**
 * Query bean for PassengerCounts.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QPassengerCounts extends TQRootBean<PassengerCounts,QPassengerCounts> {

  private static final QPassengerCounts _alias = new QPassengerCounts(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QPassengerCounts alias() {
    return _alias;
  }

  public PInteger<QPassengerCounts> pc_id;
  public PInteger<QPassengerCounts> TripId;
  public PInteger<QPassengerCounts> PassengersContinue_rounded_sofi;
  public PString<QPassengerCounts> DayNameHeb;
  public PString<QPassengerCounts> station_order;
  public PUtilDate<QPassengerCounts> DateKey;
  public PTime<QPassengerCounts> HourKey;


  /**
   * Construct with a given Database.
   */
  public QPassengerCounts(Database server) {
    super(PassengerCounts.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public QPassengerCounts() {
    super(PassengerCounts.class);
  }

  /**
   * Construct for Alias.
   */
  private QPassengerCounts(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PInteger<QPassengerCounts> pc_id = _alias.pc_id;
    public static PInteger<QPassengerCounts> TripId = _alias.TripId;
    public static PInteger<QPassengerCounts> PassengersContinue_rounded_sofi = _alias.PassengersContinue_rounded_sofi;
    public static PString<QPassengerCounts> DayNameHeb = _alias.DayNameHeb;
    public static PString<QPassengerCounts> station_order = _alias.station_order;
    public static PUtilDate<QPassengerCounts> DateKey = _alias.DateKey;
    public static PTime<QPassengerCounts> HourKey = _alias.HourKey;
  }
}
