package database;

import io.ebean.annotation.PersistBatch;
import io.ebean.config.ServerConfig;
import io.ebean.event.ServerConfigStartup;

public class MyServerConfigStartup implements ServerConfigStartup {
    public void onStart(ServerConfig serverConfig) {
        serverConfig.setDatabaseSequenceBatchSize(1);
        serverConfig.setPersistBatch(PersistBatch.ALL);
        serverConfig.setPersistBatchSize(500);
        serverConfig.setUpdateAllPropertiesInBatch(true);
    }
}