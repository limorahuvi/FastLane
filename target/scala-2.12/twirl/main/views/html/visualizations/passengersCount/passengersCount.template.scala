
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
  def apply/*2.2*/(form : Form[PassengersCountForm]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.36*/("""

"""),_display_(/*4.2*/visualizations/*4.16*/.layouts.calculateDataLayout("Passengers Count")/*4.64*/{_display_(Seq[Any](format.raw/*4.65*/("""
"""),format.raw/*5.1*/("""<!--description-->
""")))}/*6.2*/{_display_(Seq[Any](format.raw/*6.3*/("""
    """),_display_(/*7.6*/helper/*7.12*/.form(action = routes.VisualizationController.calculatePassengersCount())/*7.85*/{_display_(Seq[Any](format.raw/*7.86*/("""
        """),_display_(/*8.10*/visualizations/*8.24*/.parameters.visualizationFormParameters(form.asInstanceOf[play.data.Form[models.VisualizationForm]])),format.raw/*8.124*/("""
        """),_display_(/*9.10*/helper/*9.16*/.inputText(form("minPassengersForPublicLane"), '_label -> "Minimum Passengers For Public Lane")),format.raw/*9.111*/("""
    """),format.raw/*10.5*/("""<input type="submit" value="Calculate" id="submit"  onclick="showDiv()">
    <div id="showme"  style="display:none;"></div>
    <div id="loadingGif" style="display:none; size:1px;"><img src="https://media.giphy.com/media/3oEjI6SIIHBdRxXI40/giphy.gif" height="120" width="120"></div>
    """)))}),format.raw/*13.6*/("""
""")))}),format.raw/*14.2*/("""

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
                  DATE: Sat May 25 20:17:00 IDT 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/app/views/visualizations/passengersCount/passengersCount.scala.html
                  HASH: 34e9b2b79855aefa06be1dd3e365df5c58fadf79
                  MATRIX: 1008->3|1137->37|1167->42|1189->56|1245->104|1283->105|1311->107|1349->128|1386->129|1418->136|1432->142|1513->215|1551->216|1588->227|1610->241|1731->341|1768->352|1782->358|1898->453|1931->459|2252->750|2285->753
                  LINES: 28->2|33->2|35->4|35->4|35->4|35->4|36->5|37->6|37->6|38->7|38->7|38->7|38->7|39->8|39->8|39->8|40->9|40->9|40->9|41->10|44->13|45->14
                  -- GENERATED --
              */
          