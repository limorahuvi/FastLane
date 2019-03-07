
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

"""),format.raw/*3.1*/("""<!--TODO add multiple dates selection-->
"""),_display_(/*4.2*/calculateDataLayout("Passengers Count")/*4.41*/{_display_(Seq[Any](format.raw/*4.42*/("""
"""),format.raw/*5.1*/("""<!--TODO description-->
<h3>Passengers count visualization description</h3>
""")))}/*7.2*/{_display_(Seq[Any](format.raw/*7.3*/("""

"""),_display_(/*9.2*/helper/*9.8*/.form(action = routes.VisualizationController.calculatePassengersCount())/*9.81*/{_display_(Seq[Any](format.raw/*9.82*/("""
    """),_display_(/*10.6*/helper/*10.12*/.select(form("day"), options=Seq(
        ("Sunday","Sunday"),
        ("Monday","Monday"),
        ("Tuesday","Tuesday"),
        ("Wednesday","Wednesday"),
        ("Thursday","Thursday"),
        ("Friday","Friday"),
        ("Saturday","Saturday")),'_label -> "Day")),format.raw/*17.51*/("""
    """),_display_(/*18.6*/helper/*18.12*/.select(form("startTime"),options=Seq(
        ("00", "00"),
        ("01", "01"),
        ("02", "02"),
        ("03", "03"),
        ("04", "04"),
        ("05", "05"),
        ("06", "06"),
        ("07", "07"),
        ("08", "08"),
        ("09", "09"),
        ("10", "10"),
        ("11", "11"),
        ("12", "12"),
        ("13", "13"),
        ("14", "14"),
        ("15", "15"),
        ("16", "16"),
        ("17", "17"),
        ("18", "18"),
        ("19", "19"),
        ("20", "20"),
        ("21", "21"),
        ("22", "22"),
        ("23", "23")), '_label -> "Start Time")),format.raw/*42.48*/("""

    """),_display_(/*44.6*/helper/*44.12*/.select(form("endTime"),options=Seq(
        ("00", "00"),
        ("01", "01"),
        ("02", "02"),
        ("03", "03"),
        ("04", "04"),
        ("05", "05"),
        ("06", "06"),
        ("07", "07"),
        ("08", "08"),
        ("09", "09"),
        ("10", "10"),
        ("11", "11"),
        ("12", "12"),
        ("13", "13"),
        ("14", "14"),
        ("15", "15"),
        ("16", "16"),
        ("17", "17"),
        ("18", "18"),
        ("19", "19"),
        ("20", "20"),
        ("21", "21"),
        ("22", "22"),
        ("23", "23")), '_label -> "End Time")),format.raw/*68.46*/("""

    """),_display_(/*70.6*/helper/*70.12*/.inputText(form("minPassengersForPublicLane"), '_label -> "Minimum Passengers For Public Lane")),format.raw/*70.107*/("""

    """),format.raw/*72.5*/("""<input type="submit" value="Calculate">
""")))}),format.raw/*73.2*/("""


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
                  DATE: Thu Mar 07 13:04:41 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/app/views/Visualizations/passengersCount.scala.html
                  HASH: 482816cb4741be8be80acfcf7ed0bc1e2b7382b0
                  MATRIX: 992->1|1121->35|1151->39|1219->82|1266->121|1304->122|1332->124|1428->203|1465->204|1495->209|1508->215|1589->288|1627->289|1660->296|1675->302|1973->579|2006->586|2021->592|2658->1208|2693->1217|2708->1223|3341->1835|3376->1844|3391->1850|3508->1945|3543->1953|3615->1995
                  LINES: 28->1|33->1|35->3|36->4|36->4|36->4|37->5|39->7|39->7|41->9|41->9|41->9|41->9|42->10|42->10|49->17|50->18|50->18|74->42|76->44|76->44|100->68|102->70|102->70|102->70|104->72|105->73
                  -- GENERATED --
              */
          