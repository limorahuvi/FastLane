package models.entities.query;

import io.ebean.Database;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.Stop;
import models.entities.query.assoc.QAssocRealTime;
import models.entities.query.assoc.QAssocStop;

/**
 * Query bean for Stop.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QStop extends TQRootBean<Stop,QStop> {

  private static final QStop _alias = new QStop(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QStop alias() {
    return _alias;
  }

  public PInteger<QStop> stop_id;
  public PInteger<QStop> stop_code;
  public PString<QStop> stop_name;
  public PString<QStop> stop_desc;
  public PBoolean<QStop> location_type;
  public QAssocStop<QStop> parent_station;
  public QAssocRealTime<QStop> realTimeList;


  /**
   * Construct with a given Database.
   */
  public QStop(Database server) {
    super(Stop.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public QStop() {
    super(Stop.class);
  }

  /**
   * Construct for Alias.
   */
  private QStop(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PInteger<QStop> stop_id = _alias.stop_id;
    public static PInteger<QStop> stop_code = _alias.stop_code;
    public static PString<QStop> stop_name = _alias.stop_name;
    public static PString<QStop> stop_desc = _alias.stop_desc;
    public static PBoolean<QStop> location_type = _alias.location_type;
    public static QAssocStop<QStop> parent_station = _alias.parent_station;
    public static QAssocRealTime<QStop> realTimeList = _alias.realTimeList;
  }
}
