package actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import models.initializeDB;
import models.insertToDB;
import models.utilitiesFunc;
import actors.ImportManagerActorProtocol.*;

import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class ImportManagerActor extends AbstractActor {

    private static ActorSystem system = ActorSystem.create("import-system");


    public static Props getProps() {
        return Props.create(ImportManagerActor.class);
    }

    
    public ImportManagerActor() {
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        StartImport.class,
                        startImportInstance -> {
                            importFiles(startImportInstance.sourceDir);
                        })
                .build();
    }


    private void importFiles(String destDir) {

        try {
            utilitiesFunc.writeToLog("LogFile.log");
            utilitiesFunc.unzip(destDir);
            utilitiesFunc.logger.info("Start insert to shapes table");
            insertToDB.startInsert();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}