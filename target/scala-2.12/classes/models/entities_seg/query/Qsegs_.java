package models.entities_seg.query;

import io.ebean.Database;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.query.assoc.QAssocshapes_key_;
import models.entities_seg.segs_;

/**
 * Query bean for segs_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class Qsegs_ extends TQRootBean<segs_,Qsegs_> {

  private static final Qsegs_ _alias = new Qsegs_(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static Qsegs_ alias() {
    return _alias;
  }

  public QAssocshapes_key_<Qsegs_> key;
  public PInteger<Qsegs_> seg_id;


  /**
   * Construct with a given Database.
   */
  public Qsegs_(Database server) {
    super(segs_.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public Qsegs_() {
    super(segs_.class);
  }

  /**
   * Construct for Alias.
   */
  private Qsegs_(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static QAssocshapes_key_<Qsegs_> key = _alias.key;
    public static PInteger<Qsegs_> seg_id = _alias.seg_id;
  }
}
