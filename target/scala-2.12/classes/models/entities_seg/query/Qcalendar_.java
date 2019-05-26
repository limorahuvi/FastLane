package models.entities_seg.query;

import io.ebean.Database;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.PUtilDate;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.calendar_;

/**
 * Query bean for calendar_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class Qcalendar_ extends TQRootBean<calendar_,Qcalendar_> {

  private static final Qcalendar_ _alias = new Qcalendar_(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static Qcalendar_ alias() {
    return _alias;
  }

  public PInteger<Qcalendar_> service_id;
  public PString<Qcalendar_> days_bytes;
  public PUtilDate<Qcalendar_> start_date;
  public PUtilDate<Qcalendar_> end_date;


  /**
   * Construct with a given Database.
   */
  public Qcalendar_(Database server) {
    super(calendar_.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public Qcalendar_() {
    super(calendar_.class);
  }

  /**
   * Construct for Alias.
   */
  private Qcalendar_(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PInteger<Qcalendar_> service_id = _alias.service_id;
    public static PString<Qcalendar_> days_bytes = _alias.days_bytes;
    public static PUtilDate<Qcalendar_> start_date = _alias.start_date;
    public static PUtilDate<Qcalendar_> end_date = _alias.end_date;
  }
}
