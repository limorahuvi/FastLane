
package views.html.visualizations.passengersCount

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

"""),_display_(/*3.2*/visualizations/*3.16*/.layouts.calculateDataLayout("Passengers Count")/*3.64*/{_display_(Seq[Any](format.raw/*3.65*/("""
"""),format.raw/*4.1*/("""<!--description-->
""")))}/*5.2*/{_display_(Seq[Any](format.raw/*5.3*/("""
    """),_display_(/*6.6*/helper/*6.12*/.form(action = routes.VisualizationController.calculatePassengersCount())/*6.85*/{_display_(Seq[Any](format.raw/*6.86*/("""
        """),_display_(/*7.10*/visualizations/*7.24*/.parameters.visualizationFormParameters(form.asInstanceOf[play.data.Form[models.VisualizationForm]])),format.raw/*7.124*/("""
        """),_display_(/*8.10*/helper/*8.16*/.inputText(form("minPassengersForPublicLane"), '_label -> "Minimum Passengers For Public Lane")),format.raw/*8.111*/("""
    """),format.raw/*9.5*/("""<input type="submit" value="Calculate" id="submit"  onclick="showDiv()">
    """)))}),format.raw/*10.6*/("""
""")))}),format.raw/*11.2*/("""
"""))
      }
    }
  }

  def render(form:Form[PassengersCountForm]): play.twirl.api.HtmlFormat.Appendable = apply(form)

  def f:((Form[PassengersCountForm]) => play.twirl.api.HtmlFormat.Appendable) = (form) => apply(form)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue May 21 20:43:40 IDT 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/app/views/visualizations/passengersCount/passengersCount.scala.html
                  HASH: bbe00c7e6d840c8eabd71e1e3d11c40444825eb5
                  MATRIX: 1008->1|1137->35|1167->40|1189->54|1245->102|1283->103|1311->105|1349->126|1386->127|1418->134|1432->140|1513->213|1551->214|1588->225|1610->239|1731->339|1768->350|1782->356|1898->451|1930->457|2039->536|2072->539
                  LINES: 28->1|33->1|35->3|35->3|35->3|35->3|36->4|37->5|37->5|38->6|38->6|38->6|38->6|39->7|39->7|39->7|40->8|40->8|40->8|41->9|42->10|43->11
                  -- GENERATED --
              */
          