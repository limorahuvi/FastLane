package models.entities_seg.query;

import io.ebean.Database;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.query.assoc.QAssocstop_;
import models.entities_seg.stop_;

/**
 * Query bean for stop_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class Qstop_ extends TQRootBean<stop_,Qstop_> {

  private static final Qstop_ _alias = new Qstop_(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static Qstop_ alias() {
    return _alias;
  }

  public PInteger<Qstop_> stop_id;
  public PInteger<Qstop_> stop_code;
  public PString<Qstop_> stop_name;
  public PString<Qstop_> stop_desc;
  public PBoolean<Qstop_> location_type;
  public QAssocstop_<Qstop_> parent_station;


  /**
   * Construct with a given Database.
   */
  public Qstop_(Database server) {
    super(stop_.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public Qstop_() {
    super(stop_.class);
  }

  /**
   * Construct for Alias.
   */
  private Qstop_(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PInteger<Qstop_> stop_id = _alias.stop_id;
    public static PInteger<Qstop_> stop_code = _alias.stop_code;
    public static PString<Qstop_> stop_name = _alias.stop_name;
    public static PString<Qstop_> stop_desc = _alias.stop_desc;
    public static PBoolean<Qstop_> location_type = _alias.location_type;
    public static QAssocstop_<Qstop_> parent_station = _alias.parent_station;
  }
}
