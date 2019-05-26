
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

object hour extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[VisualizationForm],String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form : Form[VisualizationForm],field: String, label:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.62*/("""

"""),_display_(/*3.2*/helper/*3.8*/.select(form(field),options=Seq(
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
("23", "23")), '_label -> label)),format.raw/*27.33*/("""
"""))
      }
    }
  }

  def render(form:Form[VisualizationForm],field:String,label:String): play.twirl.api.HtmlFormat.Appendable = apply(form,field,label)

  def f:((Form[VisualizationForm],String,String) => play.twirl.api.HtmlFormat.Appendable) = (form,field,label) => apply(form,field,label)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat May 25 19:10:53 IDT 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/app/views/visualizations/parameters/hour.scala.html
                  HASH: 434e1da0a33ead883ad74ae5690d80a66c025806
                  MATRIX: 1004->1|1159->61|1189->66|1202->72|1634->483
                  LINES: 28->1|33->1|35->3|35->3|59->27
                  -- GENERATED --
              */
          