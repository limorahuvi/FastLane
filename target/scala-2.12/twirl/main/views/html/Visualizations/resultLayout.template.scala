
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

object resultLayout extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(parameters : String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.23*/("""

"""),format.raw/*3.1*/("""<html>
    <head>
        <title>result</title>
    </head>
    <body>
        """),_display_(/*8.10*/parameters),format.raw/*8.20*/("""
    """),format.raw/*9.5*/("""</body>
</html>"""))
      }
    }
  }

  def render(parameters:String): play.twirl.api.HtmlFormat.Appendable = apply(parameters)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (parameters) => apply(parameters)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Feb 25 12:36:00 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/app/views/Visualizations/resultLayout.scala.html
                  HASH: 4500e56c20214d1aba4f167dcf50a2ab53f2c64d
                  MATRIX: 970->1|1086->22|1116->26|1227->111|1257->121|1289->127
                  LINES: 28->1|33->1|35->3|40->8|40->8|41->9
                  -- GENERATED --
              */
          