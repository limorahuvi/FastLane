package controllers;
import models.DevSchedForm;
import models.PassengersCountForm;
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


    public Result calculatePassengersCount() throws java.io.IOException{
        Form<PassengersCountForm> form = formFactory.form(PassengersCountForm.class).bindFromRequest();
        if(form.hasErrors()){
            flash("danger","Please Correct the Form Below");
            return badRequest(views.html.visualizations.passengersCount.passengersCount.render(form));
        }
        PassengersCountForm request = form.get();
//        TODO calculate visualization data
        flash("success","Form Sent Successfully");
        return ok(views.html.visualizations.passengersCount.passengersCountResult.render(request));
    }

    public Result calculateDevSched() throws java.io.IOException{
        Form<DevSchedForm> form2 = formFactory.form(DevSchedForm.class).bindFromRequest();
        if(form2.hasErrors()){
            flash("danger","Please Correct the Form Below");
            return badRequest(views.html.visualizations.deviationSched.deviationSched.render(form2));
        }
        DevSchedForm request = form2.get();
//        TODO calculate visualization data
        flash("success","Form Sent Successfully");



        String json_late="{                \"type\": \"FeatureCollection\",                 \"features\": [{             \"type\": \"Feature\",                     \"geometry\": {                 \"type\": \"Point\",                         \"coordinates\": [34.798256,31.260114]             },             \"properties\": {                 \"average\":2,                         \"description\": \"line 3: 2 minutes, line 4 :2 minutes\"             }         }]}";



        String json_early="{                \"type\": \"FeatureCollection\",                 \"features\": [{             \"type\": \"Feature\",                     \"geometry\": {                 \"type\": \"Point\",                         \"coordinates\": [34.798256,31.260114]             },             \"properties\": {                 \"average\":2,                         \"description\": \"line 3: 2 minutes, line 4 :2 minutes\"             }         }]}";


        request.resultString_early = json_early;
        request.resultString_late=json_late;
        request.result_early=Json.parse(json_early);
        request.result_late=Json.parse(json_late);
        return ok(views.html.visualizations.deviationSched.devSchedResult.render(request));
    }



}
