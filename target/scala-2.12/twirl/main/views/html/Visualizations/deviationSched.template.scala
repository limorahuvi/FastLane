
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

object deviationSched extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Form[DevSchedForm],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form : Form[DevSchedForm]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.29*/("""

"""),format.raw/*3.1*/("""<!--TODO change hour to select-->
<!--TODO add multiple dates selection-->
"""),_display_(/*5.2*/calculateDataLayout("Dev sched")/*5.34*/{_display_(Seq[Any](format.raw/*5.35*/("""
"""),format.raw/*6.1*/("""<h4>Deviation in schedule visualization description</h4>
""")))}/*7.2*/{_display_(Seq[Any](format.raw/*7.3*/("""
"""),_display_(/*8.2*/helper/*8.8*/.form(action = routes.VisualizationController.calculateDevSched())/*8.74*/{_display_(Seq[Any](format.raw/*8.75*/("""
"""),_display_(/*9.2*/helper/*9.8*/.select(form("day"), options=Seq(
("Sunday","Sunday"),
("Monday","Monday"),
("Tuesday","Tuesday"),
("Wednesday","Wednesday"),
("Thursday","Thursday"),
("Friday","Friday"),
("Saturday","Saturday")),'_label -> "Day")),format.raw/*16.43*/("""
"""),_display_(/*17.2*/helper/*17.8*/.select(form("startTime"),options=Seq(
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

), '_label -> "Start Time")),format.raw/*43.28*/("""
"""),_display_(/*44.2*/helper/*44.8*/.select(form("endTime"),options=Seq(
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

), '_label -> "End Time")),format.raw/*70.26*/("""

"""),format.raw/*72.1*/("""<input type="submit" value="Calculate">
""")))}),format.raw/*73.2*/("""


""")))}))
      }
    }
  }

  def render(form:Form[DevSchedForm]): play.twirl.api.HtmlFormat.Appendable = apply(form)

  def f:((Form[DevSchedForm]) => play.twirl.api.HtmlFormat.Appendable) = (form) => apply(form)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Mar 12 14:16:44 IST 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/FastLane/app/views/Visualizations/deviationSched.scala.html
                  HASH: 97d5826f08b07d548eaded45e17450282ac10197
                  MATRIX: 984->1|1106->28|1136->32|1239->110|1279->142|1317->143|1345->145|1421->204|1458->205|1486->208|1499->214|1573->280|1611->281|1639->284|1652->290|1894->511|1923->514|1937->520|2400->962|2429->965|2443->971|2902->1409|2933->1413|3005->1455
                  LINES: 28->1|33->1|35->3|37->5|37->5|37->5|38->6|39->7|39->7|40->8|40->8|40->8|40->8|41->9|41->9|48->16|49->17|49->17|75->43|76->44|76->44|102->70|104->72|105->73
                  -- GENERATED --
              */
          