package controllers;
import actors.ImportManagerActorProtocol;
import akka.actor.ActorRef;
import models.DevSchedForm;
import models.PassengersCountForm;
import models.forms.SiriCsvForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import javax.inject.Inject;
import javax.inject.Named;
import play.api.Logger;

import models.*;
import play.data.DynamicForm;
import play.data.Form;
import java.io.IOException;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    final ActorRef importActor;

    @Inject
    public HomeController(@Named("managerActor") ActorRef importManagerActor)
    {
        importActor = importManagerActor;
    }

    public Result StartImport() {
        importActor.tell(new ImportManagerActorProtocol.StartImport(), ActorRef.noSender());
        return ok("starting import..");
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    @Inject
    FormFactory formFactory;
    public Result index() {
        return ok(views.html.index.render(models.queries.queries.getStations().toString()));

    }

    public Result siriCsv() {
        Form<SiriCsvForm> form = formFactory.form(SiriCsvForm.class);
        return ok(views.html.visualizations.siriCsv.siriCsv.render(form));
    }

    public Result passengersCount(){
        Form<PassengersCountForm> form = formFactory.form(PassengersCountForm.class);
        return ok(views.html.visualizations.passengersCount.passengersCount.render(form));
    }
    public Result deviationSched() {
        Form<DevSchedForm> form = formFactory.form(DevSchedForm.class);
        return ok(views.html.visualizations.deviationSched.deviationSched.render(form));
    }

    public Result instructions(){
        return ok(views.html.visualizations.calculateDataInstructions.render());
    }


}
