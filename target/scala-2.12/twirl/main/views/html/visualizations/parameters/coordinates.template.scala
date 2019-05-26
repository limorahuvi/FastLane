
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

object coordinates extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[VisualizationForm],String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form : Form[VisualizationForm],field: String, label:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.62*/("""



"""),_display_(/*5.2*/helper/*5.8*/.inputText(form(field), '_label -> label)),format.raw/*5.49*/("""






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
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/app/views/visualizations/parameters/coordinates.scala.html
                  HASH: 5daade5b2bac216d911213b5e4f3291173f1fcf8
                  MATRIX: 1011->1|1166->61|1200->70|1213->76|1274->117
                  LINES: 28->1|33->1|37->5|37->5|37->5
                  -- GENERATED --
              */
          