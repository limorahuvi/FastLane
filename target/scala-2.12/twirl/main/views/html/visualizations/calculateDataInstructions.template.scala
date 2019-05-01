
package views.html.visualizations

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

object calculateDataInstructions extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main("Instructions")/*1.22*/ {_display_(Seq[Any](format.raw/*1.24*/("""
"""),format.raw/*2.1*/("""<!--header-->
<style>
    div#description"""),format.raw/*4.20*/("""{"""),format.raw/*4.21*/("""
            """),format.raw/*5.13*/("""padding-left: 25%;
            padding-right: 25%;

        """),format.raw/*8.9*/("""}"""),format.raw/*8.10*/("""
"""),format.raw/*9.1*/("""</style>
""")))}/*10.2*/{_display_(Seq[Any](format.raw/*10.3*/("""
"""),format.raw/*11.1*/("""<!--body-->
<div align="center">
    <h3>Instructions For Calculating Data</h3>
</div>
</br>
</br>
<div id="description" align="center">
<p>
    <h4>General Parameters</h4>
    </br>

    <b>Start\End Date</b>
    </br>
    The data will be calculated from start date till end date
    </br>
    </br>


    <b>Day</b>
    </br>
    The data will be calculated from start date till end date only in the chosen day
    </br>
    Choose "All" to calculate all dates between atart date and end date
    </br>
    </br>

    <b>Start\End Hour</b>
    </br>
    The data will be calculated from start hour till end hour in the selected dates.
    </br>
    </br>

    <b>Coordinates</b>
    </br>
    <!--TODO add drawing?-->
    Choose 2 markers on the map
    The data will be calculated as a square between the 2 markers
    </br>
    </br>
    </br>

    <h4>Passengers Count Parameters</h4>
    </br>

    <b>Minimum Passengers For Public Lane</b>
    </br>
    Insert the minimum number of passengers for turning a lane to public
    </br>
    </br>

</p>
</div>
""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Apr 30 19:36:03 IDT 2019
                  SOURCE: C:/Users/user/workspace/final project/FastLane/app/views/visualizations/calculateDataInstructions.scala.html
                  HASH: f1daae3964abcbfab442ad209e99697c7f36ba54
                  MATRIX: 1065->1|1093->21|1132->23|1160->25|1230->68|1258->69|1299->83|1388->146|1416->147|1444->149|1473->160|1511->161|1540->163
                  LINES: 33->1|33->1|33->1|34->2|36->4|36->4|37->5|40->8|40->8|41->9|42->10|42->10|43->11
                  -- GENERATED --
              */
          