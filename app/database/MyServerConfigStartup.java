package database;

import io.ebean.annotation.PersistBatch;
import io.ebean.config.ServerConfig;
import io.ebean.event.ServerConfigStartup;

/**
 * This class customise the Ebean server configuration by creating an instance of serverConfigStartup interface
 * to programmatically manipulate the Ebean ServerConfig before the server is initialized.
 */
public class MyServerConfigStartup implements ServerConfigStartup {
    public void onStart(ServerConfig serverConfig) {
        serverConfig.setDatabaseSequenceBatchSize(1);
        serverConfig.setPersistBatch(PersistBatch.ALL);
        serverConfig.setPersistBatchSize(500);
        serverConfig.setUpdateAllPropertiesInBatch(true);
    }
}