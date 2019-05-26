
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

object date extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[VisualizationForm],String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form : Form[VisualizationForm],field: String, label:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.62*/("""

"""),_display_(/*3.2*/helper/*3.8*/.inputDate(form(field), '_label -> label)),format.raw/*3.49*/("""
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
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/app/views/visualizations/parameters/date.scala.html
                  HASH: f03e49e6d3cee79b845f72f04383339e00f7cdbc
                  MATRIX: 1004->1|1159->61|1189->66|1202->72|1263->113
                  LINES: 28->1|33->1|35->3|35->3|35->3
                  -- GENERATED --
              */
          