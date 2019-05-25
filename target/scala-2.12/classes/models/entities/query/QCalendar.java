package models.entities.query;

import io.ebean.Database;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.Calendar;

/**
 * Query bean for Calendar.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QCalendar extends TQRootBean<Calendar,QCalendar> {

  private static final QCalendar _alias = new QCalendar(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QCalendar alias() {
    return _alias;
  }

  public PInteger<QCalendar> service_id;
  public PString<QCalendar> days_bytes;
  public PUtilDate<QCalendar> start_date;
  public PUtilDate<QCalendar> end_date;


  /**
   * Construct with a given Database.
   */
  public QCalendar(Database server) {
    super(Calendar.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public QCalendar() {
    super(Calendar.class);
  }

  /**
   * Construct for Alias.
   */
  private QCalendar(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PInteger<QCalendar> service_id = _alias.service_id;
    public static PString<QCalendar> days_bytes = _alias.days_bytes;
    public static PUtilDate<QCalendar> start_date = _alias.start_date;
    public static PUtilDate<QCalendar> end_date = _alias.end_date;
  }
}
