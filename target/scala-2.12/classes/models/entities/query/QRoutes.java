package models.entities.query;

import io.ebean.Database;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.Routes;
import models.entities.query.assoc.QAssocAgency;

/**
 * Query bean for Routes.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QRoutes extends TQRootBean<Routes,QRoutes> {

  private static final QRoutes _alias = new QRoutes(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QRoutes alias() {
    return _alias;
  }

  public PInteger<QRoutes> route_id;
  public QAssocAgency<QRoutes> agency_id;
  public PString<QRoutes> route_long_name;
  public PString<QRoutes> route_desc;
  public PString<QRoutes> route_type;
  public PString<QRoutes> route_color;


  /**
   * Construct with a given Database.
   */
  public QRoutes(Database server) {
    super(Routes.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public QRoutes() {
    super(Routes.class);
  }

  /**
   * Construct for Alias.
   */
  private QRoutes(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PInteger<QRoutes> route_id = _alias.route_id;
    public static QAssocAgency<QRoutes> agency_id = _alias.agency_id;
    public static PString<QRoutes> route_long_name = _alias.route_long_name;
    public static PString<QRoutes> route_desc = _alias.route_desc;
    public static PString<QRoutes> route_type = _alias.route_type;
    public static PString<QRoutes> route_color = _alias.route_color;
  }
}
