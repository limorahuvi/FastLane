package controllers;
import models.DevSchedForm;
import models.PassengersCountForm;
import models.SiriCsvForm;
import play.data.Form;
import play.data.FormFactory;
import javax.inject.Inject;
import models.*;
import play.mvc.*;
import com.fasterxml.jackson.databind.JsonNode;
import  play.libs.Json;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class VisualizationController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    @Inject
    FormFactory formFactory;


    public Result calculatePassengersCount() throws java.io.IOException {
        Form<PassengersCountForm> form = formFactory.form(PassengersCountForm.class).bindFromRequest();
        if (form.hasErrors()) {
            flash("danger", "Please Correct the Form Below");
            return badRequest(views.html.visualizations.passengersCount.passengersCount.render(form));
        }
        PassengersCountForm request = form.get();
        request.setResult(models.queries.queries.getResults(request));
        flash("success", "Form Sent Successfully");
        return ok(views.html.visualizations.passengersCount.passengersCountResult.render(request));
    }

    public Result calculateDevSched() throws java.io.IOException {
        Form<DevSchedForm> form = formFactory.form(DevSchedForm.class).bindFromRequest();
        if (form.hasErrors()) {
            flash("danger", "Please Correct the Form Below");
            return badRequest(views.html.visualizations.deviationSched.deviationSched.render(form));
        }
        DevSchedForm request = form.get();
        request.setResult(models.queries.queries.getResults(request));
        flash("success", "Form Sent Successfully");
        return ok(views.html.visualizations.deviationSched.devSchedResult.render(request));
    }

    public Result calculateSiriCsv() throws java.io.IOException {
        Form<SiriCsvForm> form = formFactory.form(SiriCsvForm.class).bindFromRequest();
        if (form.hasErrors()) {
            flash("danger", "Please Correct the Form Below");
            return badRequest(views.html.visualizations.siriCsv.siriCsv.render(form));
        }
            SiriCsvForm request = form.get();
            request.setResult(models.queries.queries.getResults(request));
            flash("success", "Form Sent Successfully");
            return ok(views.html.visualizations.siriCsv.siriCsvResult.render(request));
    }
}