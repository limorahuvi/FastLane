
package views.html

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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/main("Fast Lane")/*3.19*/ {_display_(Seq[Any](format.raw/*3.21*/("""
""")))}/*4.2*/{_display_(Seq[Any](format.raw/*4.3*/("""

"""),format.raw/*6.1*/("""<!-- Header -->
  <br></br>
<h1 align="center" style="color:#404040;"	><b>Welcome to Fast Lane!</b>
    <span align="right"><i class="fa fa-bus" style="font-size:50px;" ></i></span></h1>
<h2 align="center" style="color:#404040;"><b>Visualizing MOT Data</b></h2>
<p style="text-align:center; font-size:50px;"><img src=""""),_display_(/*11.58*/routes/*11.64*/.Assets.versioned("images/main.jpg")),format.raw/*11.100*/("""" ></p>

""")))}),format.raw/*13.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Mar 16 22:13:09 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/app/views/index.scala.html
                  HASH: b77928a824349d27f60e9c13130996b61e51151d
                  MATRIX: 941->1|1037->3|1067->8|1092->25|1131->27|1151->30|1188->31|1218->35|1569->359|1584->365|1642->401|1684->413
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|36->4|38->6|43->11|43->11|43->11|45->13
                  -- GENERATED --
              */
          