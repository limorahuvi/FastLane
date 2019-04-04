
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
        ("h0", "00"),
        ("h1", "01"),
        ("h2", "02"),
        ("h3", "03"),
        ("h4", "04"),
        ("h5", "05"),
        ("h6", "06"),
        ("h7", "07"),
        ("h8", "08"),
        ("h9", "09"),
        ("h10", "10"),
        ("h11", "11"),
        ("h12", "12"),
        ("h13", "13"),
        ("h14", "14"),
        ("h15", "15"),
        ("h16", "16"),
        ("h17", "17"),
        ("h18", "18"),
        ("h19", "19"),
        ("h20", "20"),
        ("h21", "21"),
        ("h22", "22"),
        ("h23", "23")

        ), '_label -> "Start Time")),format.raw/*44.36*/("""
    """),_display_(/*45.6*/helper/*45.12*/.select(form("endTime"),options=Seq(
        ("h0", "00"),
        ("h1", "01"),
        ("h2", "02"),
        ("h3", "03"),
        ("h4", "04"),
        ("h5", "05"),
        ("h6", "06"),
        ("h7", "07"),
        ("h8", "08"),
        ("h9", "09"),
        ("h10", "10"),
        ("h11", "11"),
        ("h12", "12"),
        ("h13", "13"),
        ("h14", "14"),
        ("h15", "15"),
        ("h16", "16"),
        ("h17", "17"),
        ("h18", "18"),
        ("h19", "19"),
        ("h20", "20"),
        ("h21", "21"),
        ("h22", "22"),
        ("h23", "23")

        ), '_label -> "End Time")),format.raw/*71.34*/("""
    """),_display_(/*72.6*/helper/*72.12*/.inputText(form("minPassengersForPublicLane"), '_label -> "Min Passengers For Public Lane")),format.raw/*72.103*/("""

    """),format.raw/*74.5*/("""<input type="submit" value="Calculate">
""")))}),format.raw/*75.2*/("""


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
                  DATE: Wed Apr 03 16:33:34 IDT 2019
                  SOURCE: C:/Users/user/workspace/final project/FastLane/app/views/Visualizations/passengersCount.scala.html
                  HASH: ebdbc2cfa8a99dff86f127dd61ffb7709e0a6441
                  MATRIX: 992->1|1121->35|1151->39|1254->117|1301->156|1339->157|1367->159|1438->213|1475->214|1505->219|1518->225|1599->298|1637->299|1670->306|1685->312|1983->589|2016->596|2031->602|2694->1244|2727->1251|2742->1257|3401->1895|3434->1902|3449->1908|3562->1999|3597->2007|3669->2049
                  LINES: 28->1|33->1|35->3|37->5|37->5|37->5|38->6|39->7|39->7|41->9|41->9|41->9|41->9|42->10|42->10|49->17|50->18|50->18|76->44|77->45|77->45|103->71|104->72|104->72|104->72|106->74|107->75
                  -- GENERATED --
              */
          