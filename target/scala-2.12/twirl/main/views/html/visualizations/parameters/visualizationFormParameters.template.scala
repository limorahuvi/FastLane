
package views.html.visualizations.parameters

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

object visualizationFormParameters extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Form[VisualizationForm],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form : Form[VisualizationForm]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.34*/("""

"""),_display_(/*3.2*/visualizations/*3.16*/.parameters.date(form, "startDate", "Start Date")),format.raw/*3.65*/("""
"""),_display_(/*4.2*/visualizations/*4.16*/.parameters.date(form, "endDate", "End Date")),format.raw/*4.61*/("""
"""),_display_(/*5.2*/visualizations/*5.16*/.parameters.day(form, "day", "Day")),format.raw/*5.51*/("""
"""),_display_(/*6.2*/visualizations/*6.16*/.parameters.hour(form, "startHour", "Start Hour")),format.raw/*6.65*/("""
"""),_display_(/*7.2*/visualizations/*7.16*/.parameters.hour(form, "endHour", "End Hour")),format.raw/*7.61*/("""
"""),_display_(/*8.2*/visualizations/*8.16*/.parameters.coordinates(form, "coor1", "First Coordinate")),format.raw/*8.74*/("""
"""),_display_(/*9.2*/visualizations/*9.16*/.parameters.coordinates(form, "coor2", "Second Coordinate")),format.raw/*9.75*/("""
"""),format.raw/*10.1*/("""<div>
    <button type="button" onclick="update_label()">update coordinates</button>
    <button type="button" onclick="removeCoordinates()">Clear coordinates</button>
</div>
</br>

"""))
      }
    }
  }

  def render(form:Form[VisualizationForm]): play.twirl.api.HtmlFormat.Appendable = apply(form)

  def f:((Form[VisualizationForm]) => play.twirl.api.HtmlFormat.Appendable) = (form) => apply(form)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat May 25 19:10:53 IDT 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/app/views/visualizations/parameters/visualizationFormParameters.scala.html
                  HASH: c257e13e98b7da49be9e9c4709ab2dedd4590390
                  MATRIX: 1013->1|1140->33|1170->38|1192->52|1261->101|1289->104|1311->118|1376->163|1404->166|1426->180|1481->215|1509->218|1531->232|1600->281|1628->284|1650->298|1715->343|1743->346|1765->360|1843->418|1871->421|1893->435|1972->494|2001->496
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|36->4|36->4|37->5|37->5|37->5|38->6|38->6|38->6|39->7|39->7|39->7|40->8|40->8|40->8|41->9|41->9|41->9|42->10
                  -- GENERATED --
              */
          