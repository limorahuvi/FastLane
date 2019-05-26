package models.entities_seg.query;

import io.ebean.Database;
import io.ebean.typequery.PBoolean;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PTime;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities_seg.query.assoc.QAssocstop_;
import models.entities_seg.query.assoc.QAssocstop_times_key;
import models.entities_seg.query.assoc.QAssoctrips_;
import models.entities_seg.stop_times_;

/**
 * Query bean for stop_times_.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class Qstop_times_ extends TQRootBean<stop_times_,Qstop_times_> {

  private static final Qstop_times_ _alias = new Qstop_times_(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static Qstop_times_ alias() {
    return _alias;
  }

  public QAssocstop_times_key<Qstop_times_> stKey;
  public QAssocstop_<Qstop_times_> stop;
  public QAssoctrips_<Qstop_times_> trip;
  public PTime<Qstop_times_> departure_time;
  public PInteger<Qstop_times_> stop_sequence;
  public PBoolean<Qstop_times_> pickup_types;
  public PBoolean<Qstop_times_> drop_off_type;
  public PInteger<Qstop_times_> shape_dist_traveled;
  public PInteger<Qstop_times_> continue_passengers;


  /**
   * Construct with a given Database.
   */
  public Qstop_times_(Database server) {
    super(stop_times_.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public Qstop_times_() {
    super(stop_times_.class);
  }

  /**
   * Construct for Alias.
   */
  private Qstop_times_(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static QAssocstop_times_key<Qstop_times_> stKey = _alias.stKey;
    public static QAssocstop_<Qstop_times_> stop = _alias.stop;
    public static QAssoctrips_<Qstop_times_> trip = _alias.trip;
    public static PTime<Qstop_times_> departure_time = _alias.departure_time;
    public static PInteger<Qstop_times_> stop_sequence = _alias.stop_sequence;
    public static PBoolean<Qstop_times_> pickup_types = _alias.pickup_types;
    public static PBoolean<Qstop_times_> drop_off_type = _alias.drop_off_type;
    public static PInteger<Qstop_times_> shape_dist_traveled = _alias.shape_dist_traveled;
    public static PInteger<Qstop_times_> continue_passengers = _alias.continue_passengers;
  }
}
