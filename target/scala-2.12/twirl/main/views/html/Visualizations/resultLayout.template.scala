
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

object resultLayout extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[VisualizationForm,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form: VisualizationForm)(map: Html)(index: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.51*/("""

"""),format.raw/*3.1*/("""<html>
    <head>
        <title>result</title>
    </head>
    <body>
        """),_display_(/*8.10*/form/*8.14*/.getParametersList()),format.raw/*8.34*/(""";
    </body>
</html>"""))
      }
    }
  }

  def render(form:VisualizationForm,map:Html,index:Html): play.twirl.api.HtmlFormat.Appendable = apply(form)(map)(index)

  def f:((VisualizationForm) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (form) => (map) => (index) => apply(form)(map)(index)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Mar 03 10:30:51 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/app/views/Visualizations/resultLayout.scala.html
                  HASH: a343ececd3c1dbfbf04e1a8a101e58e2f2aa4fa8
                  MATRIX: 991->1|1135->50|1165->54|1276->139|1288->143|1328->163
                  LINES: 28->1|33->1|35->3|40->8|40->8|40->8
                  -- GENERATED --
              */
          