
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*12.62*/("""
        """),format.raw/*13.9*/("""<title>"""),_display_(/*13.17*/title),format.raw/*13.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*14.54*/routes/*14.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*14.101*/("""">
        <!--<link rel="shortcut icon" type="image/png" href=""""),_display_(/*15.63*/routes/*15.69*/.Assets.versioned("images/favicon.png")),format.raw/*15.108*/("""">-->
        <!--BOOTSTRAP-->
        <link rel="stylesheet" href=""""),_display_(/*17.39*/routes/*17.45*/.Assets.versioned("outsiders/bootstrap-4.2.1-dist/css/bootstrap.min.css")),format.raw/*17.118*/("""" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <!--MAPBOX-->
        <!--<script src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.52.0/mapbox-gl.js'></script>-->
        <!--<link href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.52.0/mapbox-gl.css' rel='stylesheet' />-->
        <!--<style>-->
            <!--/*body """),format.raw/*22.24*/("""{"""),format.raw/*22.25*/(""" """),format.raw/*22.26*/("""margin:50%; padding:10%; """),format.raw/*22.51*/("""}"""),format.raw/*22.52*/("""*/-->
            <!--#map """),format.raw/*23.22*/("""{"""),format.raw/*23.23*/(""" """),format.raw/*23.24*/("""position:absolute; width:50%; height: 50%"""),format.raw/*23.65*/("""}"""),format.raw/*23.66*/("""-->
            <!--/*#map """),format.raw/*24.24*/("""{"""),format.raw/*24.25*/(""" """),format.raw/*24.26*/("""position:absolute; top:0; bottom:0; width:50%; height: 50%"""),format.raw/*24.84*/("""}"""),format.raw/*24.85*/("""*/-->
            <!--.grid-container """),format.raw/*25.33*/("""{"""),format.raw/*25.34*/("""-->
                <!--display: grid;-->
                <!--grid-column-gap: 10%;-->
                <!--grid-template-columns: auto auto auto;-->
                <!--/*background-color: #2196F3;*/-->
                <!--padding: 10px;-->
            <!--"""),format.raw/*31.17*/("""}"""),format.raw/*31.18*/("""-->

            <!--/*https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Grid_Layout/Basic_Concepts_of_Grid_Layout#Grid_lines*/-->
            <!--.map """),format.raw/*34.22*/("""{"""),format.raw/*34.23*/("""-->
                <!--grid-column-start: 1;-->
                <!--grid-column-end: 2;-->
                <!--grid-row-start: 1;-->
                <!--grid-row-end: 4;-->
            <!--"""),format.raw/*39.17*/("""}"""),format.raw/*39.18*/("""-->
            <!--.parameters """),format.raw/*40.29*/("""{"""),format.raw/*40.30*/("""-->
                <!--grid-column-start: 3;-->
                <!--grid-column-end: 4;-->
                <!--grid-row-start: 1;-->
                <!--grid-row-end: 4;-->
            <!--"""),format.raw/*45.17*/("""}"""),format.raw/*45.18*/("""-->
        <!--</style>-->
    </head>
    <body>
        """),_display_(/*49.10*/navigationbar()),format.raw/*49.25*/("""
        """),format.raw/*51.32*/("""
        """),_display_(/*52.10*/content),format.raw/*52.17*/("""

        """),format.raw/*54.9*/("""<script src=""""),_display_(/*54.23*/routes/*54.29*/.Assets.versioned("javascripts/main.js")),format.raw/*54.69*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*55.23*/routes/*55.29*/.Assets.versioned("outsiders/jquery-3.3.1.slim.min.js")),format.raw/*55.84*/(""""></script>
        <script src=""""),_display_(/*56.23*/routes/*56.29*/.Assets.versioned("outsiders/bootstrap-4.2.1-dist/js/bootstrap.min.js")),format.raw/*56.100*/(""""  integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Jan 04 17:38:36 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/play-java-seed/app/views/main.scala.html
                  HASH: ce0964662f9208b2e5d31e6215870f694563d466
                  MATRIX: 1206->260|1330->291|1357->292|1437->397|1473->406|1508->414|1534->419|1623->481|1638->487|1701->528|1793->593|1808->599|1869->638|1965->707|1980->713|2075->786|2496->1179|2525->1180|2554->1181|2607->1206|2636->1207|2691->1234|2720->1235|2749->1236|2818->1277|2847->1278|2902->1305|2931->1306|2960->1307|3046->1365|3075->1366|3141->1404|3170->1405|3455->1662|3484->1663|3667->1818|3696->1819|3914->2009|3943->2010|4003->2042|4032->2043|4250->2233|4279->2234|4366->2294|4402->2309|4439->2408|4476->2418|4504->2425|4541->2435|4582->2449|4597->2455|4658->2495|4742->2552|4757->2558|4833->2613|4894->2647|4909->2653|5002->2724
                  LINES: 33->7|38->8|39->9|42->12|43->13|43->13|43->13|44->14|44->14|44->14|45->15|45->15|45->15|47->17|47->17|47->17|52->22|52->22|52->22|52->22|52->22|53->23|53->23|53->23|53->23|53->23|54->24|54->24|54->24|54->24|54->24|55->25|55->25|61->31|61->31|64->34|64->34|69->39|69->39|70->40|70->40|75->45|75->45|79->49|79->49|80->51|81->52|81->52|83->54|83->54|83->54|83->54|84->55|84->55|84->55|85->56|85->56|85->56
                  -- GENERATED --
              */
          