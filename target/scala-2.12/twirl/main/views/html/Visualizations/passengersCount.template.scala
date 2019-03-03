
package views.html.Visualizations

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object passengersCount extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Form[PassengersCountForm],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form : Form[PassengersCountForm]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.36*/("""

"""),format.raw/*3.1*/("""<!--TODO change hour to select-->
<!--TODO add multiple dates selection-->
"""),_display_(/*5.2*/calculateDataLayout("Passengers Count")/*5.41*/{_display_(Seq[Any](format.raw/*5.42*/("""
"""),format.raw/*6.1*/("""<h4>Passengers count visualization description</h4>
""")))}/*7.2*/{_display_(Seq[Any](format.raw/*7.3*/("""
"""),_display_(/*8.2*/helper/*8.8*/.form(action = routes.VisualizationController.calculatePassengersCount())/*8.81*/{_display_(Seq[Any](format.raw/*8.82*/("""
    """),_display_(/*9.6*/helper/*9.12*/.select(form("day"), options=Seq(
        ("Sunday","Sunday"),
        ("Monday","Monday"),
        ("Tuesday","Tuesday"),
        ("Wednesday","Wednesday"),
        ("Thursday","Thursday"),
        ("Friday","Friday"),
        ("Saturday","Saturday")),'_label -> "Day")),format.raw/*16.51*/("""
    """),_display_(/*17.6*/helper/*17.12*/.inputText(form("startTime"), '_label -> "Start Time")),format.raw/*17.66*/("""
    """),_display_(/*18.6*/helper/*18.12*/.inputText(form("endTime"), '_label -> "End Time")),format.raw/*18.62*/("""
    """),_display_(/*19.6*/helper/*19.12*/.inputText(form("minPassengersForPublicLane"), '_label -> "Min Passengers For Public Lane")),format.raw/*19.103*/("""

    """),format.raw/*21.5*/("""<input type="submit" value="Calculate">
""")))}),format.raw/*22.2*/("""


""")))}))
      }
    }
  }

  def render(form:Form[PassengersCountForm]): play.twirl.api.HtmlFormat.Appendable = apply(form)

  def f:((Form[PassengersCountForm]) => play.twirl.api.HtmlFormat.Appendable) = (form) => apply(form)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Mar 03 10:28:37 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/app/views/Visualizations/passengersCount.scala.html
                  HASH: 9b0b8a380891497d1ee00e88841136bb1f2d7842
                  MATRIX: 992->1|1121->35|1151->39|1254->117|1301->156|1339->157|1367->159|1438->213|1475->214|1503->217|1516->223|1597->296|1635->297|1667->304|1681->310|1979->587|2012->594|2027->600|2102->654|2135->661|2150->667|2221->717|2254->724|2269->730|2382->821|2417->829|2489->871
                  LINES: 28->1|33->1|35->3|37->5|37->5|37->5|38->6|39->7|39->7|40->8|40->8|40->8|40->8|41->9|41->9|48->16|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|53->21|54->22
                  -- GENERATED --
              */
          