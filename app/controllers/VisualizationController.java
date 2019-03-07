package controllers;
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
    private Form<PassengersCountForm> form;

    public Result calculatePassengersCount() throws java.io.IOException{
        form = formFactory.form(PassengersCountForm.class).bindFromRequest();
        if(form.hasErrors()){
            flash("danger","Please Correct the Form Below");
            return badRequest(views.html.Visualizations.passengersCount.render(form));
        }
        PassengersCountForm request = form.get();
//        TODO calculate visualization data
        flash("success","Form Sent Successfully");
        return ok(views.html.Visualizations.passengersCountResult.render(request));
    }



}
