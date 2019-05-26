package models.entities_seg.query;

import io.ebean.Database;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.agency_;

/**
 * Query bean for agency_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class Qagency_ extends TQRootBean<agency_,Qagency_> {

  private static final Qagency_ _alias = new Qagency_(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static Qagency_ alias() {
    return _alias;
  }

  public PInteger<Qagency_> agency_id;
  public PString<Qagency_> agency_name;
  public PString<Qagency_> agency_url;


  /**
   * Construct with a given Database.
   */
  public Qagency_(Database server) {
    super(agency_.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public Qagency_() {
    super(agency_.class);
  }

  /**
   * Construct for Alias.
   */
  private Qagency_(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PInteger<Qagency_> agency_id = _alias.agency_id;
    public static PString<Qagency_> agency_name = _alias.agency_name;
    public static PString<Qagency_> agency_url = _alias.agency_url;
  }
}
