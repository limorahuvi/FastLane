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
        String json="{\"type\":\"FeatureCollection\",\"features\":[{\"type\":\"Feature\",\"properties\":{\"load\":0.11},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.798108,31.23819],[34.808931,31.226122]]}},{\"type\":\"Feature\",\"properties\":{\"load\":1},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.808931,31.226122],[34.812412,31.219766]]}},{\"type\":\"Feature\",\"properties\":{\"load\":1},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.812412,31.219766],[34.809946,31.213571]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.04},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.809946,31.213571],[34.809186,31.215779]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.24},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.798108,31.23819],[34.806417,31.226678]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.24},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.806417,31.226678],[34.808931,31.226122]]}},{\"type\":\"Feature\",\"properties\":{\"load\":1},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.808931,31.226122],[34.811384,31.228069]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.09},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.811384,31.228069],[34.813072,31.224984]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.06},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.813072,31.224984],[34.812412,31.219766]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.06},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.812412,31.219766],[34.812557,31.216835]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.03},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.812557,31.216835],[34.809946,31.213571]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.01},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.797758,31.242608],[34.798108,31.23819]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.01},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.797758,31.242608],[34.798108,31.23819]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.3},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.798108,31.23819],[34.806417,31.226678]]}},{\"type\":\"Feature\",\"properties\":{\"load\":1},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.806417,31.226678],[34.808931,31.226122]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.15},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.808931,31.226122],[34.811384,31.228069]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.13},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.811384,31.228069],[34.813072,31.224984]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.11},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.813072,31.224984],[34.812412,31.219766]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.09},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.812412,31.219766],[34.812557,31.216835]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.06},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.812557,31.216835],[34.809946,31.213571]]}},{\"type\":\"Feature\",\"properties\":{\"load\":0.04},\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[34.809946,31.213571],[34.809186,31.215779]]}}]}";
        request.resultString = json;
        request.result=Json.parse(json);
        return ok(views.html.Visualizations.passengersCountResult.render(request));
    }



}
