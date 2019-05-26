package models.entities_seg.query;

import io.ebean.Database;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.query.assoc.QAssocagency_;
import models.entities_seg.routes_;

/**
 * Query bean for routes_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class Qroutes_ extends TQRootBean<routes_,Qroutes_> {

  private static final Qroutes_ _alias = new Qroutes_(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static Qroutes_ alias() {
    return _alias;
  }

  public PInteger<Qroutes_> route_id;
  public QAssocagency_<Qroutes_> agency_id;
  public PString<Qroutes_> route_long_name;
  public PString<Qroutes_> route_desc;
  public PString<Qroutes_> route_type;
  public PString<Qroutes_> route_color;


  /**
   * Construct with a given Database.
   */
  public Qroutes_(Database server) {
    super(routes_.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public Qroutes_() {
    super(routes_.class);
  }

  /**
   * Construct for Alias.
   */
  private Qroutes_(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PInteger<Qroutes_> route_id = _alias.route_id;
    public static QAssocagency_<Qroutes_> agency_id = _alias.agency_id;
    public static PString<Qroutes_> route_long_name = _alias.route_long_name;
    public static PString<Qroutes_> route_desc = _alias.route_desc;
    public static PString<Qroutes_> route_type = _alias.route_type;
    public static PString<Qroutes_> route_color = _alias.route_color;
  }
}
