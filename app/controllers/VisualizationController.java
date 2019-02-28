package controllers;
import play.data.Form;
import play.data.FormFactory;
import javax.inject.Inject;
import models.*;
import play.mvc.*;
//import javax.inject.Inject;
//import play.data.FormFactory;

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

    public Result calculatePassengersCount() {
        form = formFactory.form(PassengersCountForm.class).bindFromRequest();
        if(form.hasErrors()){
            flash("danger","Please Correct the Form Below");
            return badRequest(views.html.Visualizations.passengersCount.render(form));
        }
        PassengersCountForm request = form.get();
//        TODO calculate visualization data
        String load = "";
        flash("success","Form Sent Successfully");
        String day = request.getDay();
        return redirect(routes.VisualizationController.showPassengersCountResult("a","a","a",1,"a"));
    }

    public Result showPassengersCountResult(String day, String startTime, String endTime, int min, String result){
        return ok(views.html.Visualizations.passengersCountResult.render(day, startTime, endTime, min, result));
    }

}
