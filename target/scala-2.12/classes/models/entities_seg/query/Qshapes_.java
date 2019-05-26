package models.entities_seg.query;

import io.ebean.Database;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.query.assoc.QAssocsegs_;
import models.entities_seg.query.assoc.QAssocshapes_key_;
import models.entities_seg.shapes_;

/**
 * Query bean for shapes_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class Qshapes_ extends TQRootBean<shapes_,Qshapes_> {

  private static final Qshapes_ _alias = new Qshapes_(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static Qshapes_ alias() {
    return _alias;
  }

  public QAssocshapes_key_<Qshapes_> key;
  public QAssocsegs_<Qshapes_> seg_id;


  /**
   * Construct with a given Database.
   */
  public Qshapes_(Database server) {
    super(shapes_.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public Qshapes_() {
    super(shapes_.class);
  }

  /**
   * Construct for Alias.
   */
  private Qshapes_(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static QAssocshapes_key_<Qshapes_> key = _alias.key;
    public static QAssocsegs_<Qshapes_> seg_id = _alias.seg_id;
  }
}
