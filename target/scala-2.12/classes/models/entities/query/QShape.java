package models.entities.query;

import io.ebean.Database;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import javax.annotation.Generated;
import models.entities.Shape;
import models.entities.query.assoc.QAssocShapeKey;

/**
 * Query bean for Shape.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean
public class QShape extends TQRootBean<Shape,QShape> {

  private static final QShape _alias = new QShape(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QShape alias() {
    return _alias;
  }

  public QAssocShapeKey<QShape> key;


  /**
   * Construct with a given Database.
   */
  public QShape(Database server) {
    super(Shape.class, server);
  }

  /**
   * Construct using the default Database.
   */
  public QShape() {
    super(Shape.class);
  }

  /**
   * Construct for Alias.
   */
  private QShape(boolean dummy) {
    super(dummy);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  public static class Alias {
    public static QAssocShapeKey<QShape> key = _alias.key;
  }
}
