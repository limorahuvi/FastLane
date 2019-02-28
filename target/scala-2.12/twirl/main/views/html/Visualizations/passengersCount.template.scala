
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

"""),format.raw/*3.1*/("""<!--TODO add onClick to map ?to calculate map?-->
<!--TODO change hour to select-->
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
                  DATE: Mon Feb 25 22:23:50 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/app/views/Visualizations/passengersCount.scala.html
                  HASH: 630c3dc93828087a31174d149aad203935de0a1f
                  MATRIX: 992->1|1121->35|1151->39|1263->126|1310->165|1348->166|1376->168|1447->222|1484->223|1512->226|1525->232|1606->305|1644->306|1676->313|1690->319|1988->596|2021->603|2036->609|2111->663|2144->670|2159->676|2230->726|2263->733|2278->739|2391->830|2426->838|2498->880
                  LINES: 28->1|33->1|35->3|37->5|37->5|37->5|38->6|39->7|39->7|40->8|40->8|40->8|40->8|41->9|41->9|48->16|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19|53->21|54->22
                  -- GENERATED --
              */
          