package database;

import javax.inject.*;

import play.db.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * his class responsible for the access to JDBC datasource.
 * The play.db package provides access to the default datasource, primarily through the play.db.Database class.
 */
@Singleton
class JavaApplicationDatabase {

    private Database db;
    private DatabaseExecutionContext executionContext;

    @Inject
    public JavaApplicationDatabase(Database db, DatabaseExecutionContext context) {
        this.db = db;
        this.executionContext = executionContext;
    }

   public CompletionStage<Integer> updateSomething() {
       return CompletableFuture.supplyAsync(() -> {
           return db.withConnection(connection -> {
               // do whatever you need with the db connection
               return 1;
           });
       }, executionContext);
   }
}