
package views.html.visualizations.deviationSched

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

"""),_display_(/*3.2*/visualizations/*3.16*/.layouts.calculateDataLayout("Dev sched")/*3.57*/{_display_(Seq[Any](format.raw/*3.58*/("""
"""),format.raw/*4.1*/("""<!--description-->
""")))}/*5.2*/{_display_(Seq[Any](format.raw/*5.3*/("""
    """),_display_(/*6.6*/helper/*6.12*/.form(action = routes.VisualizationController.calculateDevSched())/*6.78*/{_display_(Seq[Any](format.raw/*6.79*/("""
        """),_display_(/*7.10*/visualizations/*7.24*/.parameters.visualizationFormParameters(form.asInstanceOf[play.data.Form[models.VisualizationForm]])),format.raw/*7.124*/("""

    """),format.raw/*9.5*/("""<input type="submit" value="Calculate" id="submit"  onclick="showDiv()">
    """)))}),format.raw/*10.6*/("""
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
                  DATE: Tue Apr 30 19:36:03 IDT 2019
                  SOURCE: C:/Users/user/workspace/final project/FastLane/app/views/visualizations/deviationSched/deviationSched.scala.html
                  HASH: 769f380614eac29d8877d8aa5739b86186ee9b2f
                  MATRIX: 999->1|1121->28|1151->33|1173->47|1222->88|1260->89|1288->91|1326->112|1363->113|1395->120|1409->126|1483->192|1521->193|1558->204|1580->218|1701->318|1735->326|1844->405
                  LINES: 28->1|33->1|35->3|35->3|35->3|35->3|36->4|37->5|37->5|38->6|38->6|38->6|38->6|39->7|39->7|39->7|41->9|42->10
                  -- GENERATED --
              */
          