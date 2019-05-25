package models.entities.query;

import io.ebean.Database;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.Agency;

/**
 * Query bean for Agency.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QAgency extends TQRootBean<Agency,QAgency> {

  private static final QAgency _alias = new QAgency(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QAgency alias() {
    return _alias;
  }

  public PInteger<QAgency> agency_id;
  public PString<QAgency> agency_name;
  public PString<QAgency> agency_url;


  /**
   * Construct with a given Database.
   */
  public QAgency(Database server) {
    super(Agency.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public QAgency() {
    super(Agency.class);
  }

  /**
   * Construct for Alias.
   */
  private QAgency(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static PInteger<QAgency> agency_id = _alias.agency_id;
    public static PString<QAgency> agency_name = _alias.agency_name;
    public static PString<QAgency> agency_url = _alias.agency_url;
  }
}
