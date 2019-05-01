
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

object day extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[VisualizationForm],String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form : Form[VisualizationForm],field: String, label:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.62*/("""

"""),_display_(/*3.2*/helper/*3.8*/.select(form(field), options=Seq(
("All","All"),
("Sunday","Sunday"),
("Monday","Monday"),
("Tuesday","Tuesday"),
("Wednesday","Wednesday"),
("Thursday","Thursday"),
("Friday","Friday"),
("Saturday","Saturday")),'_label -> label)))
      }
    }
  }

  def render(form:Form[VisualizationForm],field:String,label:String): play.twirl.api.HtmlFormat.Appendable = apply(form,field,label)

  def f:((Form[VisualizationForm],String,String) => play.twirl.api.HtmlFormat.Appendable) = (form,field,label) => apply(form,field,label)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Apr 30 19:36:04 IDT 2019
                  SOURCE: C:/Users/user/workspace/final project/FastLane/app/views/visualizations/parameters/day.scala.html
                  HASH: a2536fc461adbc4b5b4fb89f6f15f35113122a0f
                  MATRIX: 1003->1|1158->61|1188->66|1201->72
                  LINES: 28->1|33->1|35->3|35->3
                  -- GENERATED --
              */
          