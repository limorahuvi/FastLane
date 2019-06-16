package actors;

import models.utilitiesFunc;

public class ImportManagerActorProtocol {

    public static class StartImport {
        public final String sourceDir;

        public StartImport() {
            this.sourceDir = utilitiesFunc.createPath("output");
        }
    }

    public static class Done {
        public final String doneFileName;

        public Done(String fileName) {
            this.doneFileName = fileName;
        }
    }

}

