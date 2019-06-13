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

    //private ActorRef writeToShapeActor;
    //private ActorRef readActorShape;
    private static ActorSystem system = ActorSystem.create("import-system");


    public static Props getProps() {
        return Props.create(ImportManagerActor.class);
    }

    //@Inject
    public ImportManagerActor() {
       // readActorShape = system.actorOf(ReadActor.getProps());
       // writeToShapeActor = system.actorOf(WriteToShapeActor.getProps(system));
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

    private void importFiles(String destDir){
        try {
            utilitiesFunc.writeToLog("LogFile.log");
            initializeDB.unzip(destDir);
            //actors :
            utilitiesFunc.logger.info("Start insert to shapes table");
            new insertToDB(destDir);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}