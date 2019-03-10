
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
        <link rel="stylesheet" href=""""),_display_(/*17.39*/routes/*17.45*/.Assets.versioned("outsiders/bootstrap-4.2.1-dist/css/bootstrap.min.css")),format.raw/*17.118*/("""">
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
        <script src=""""),_display_(/*56.23*/routes/*56.29*/.Assets.versioned("outsiders/bootstrap-4.2.1-dist/js/bootstrap.min.js")),format.raw/*56.100*/("""" ></script>
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
                  DATE: Sun Mar 10 11:07:32 IST 2019
                  SOURCE: C:/Users/user/workspace/final project/FastLane/app/views/main.scala.html
                  HASH: e028034ded775bc814346979e018f335c43b4b35
                  MATRIX: 1206->260|1330->291|1357->292|1437->397|1473->406|1508->414|1534->419|1623->481|1638->487|1701->528|1793->593|1808->599|1869->638|1965->707|1980->713|2075->786|2388->1071|2417->1072|2446->1073|2499->1098|2528->1099|2583->1126|2612->1127|2641->1128|2710->1169|2739->1170|2794->1197|2823->1198|2852->1199|2938->1257|2967->1258|3033->1296|3062->1297|3347->1554|3376->1555|3559->1710|3588->1711|3806->1901|3835->1902|3895->1934|3924->1935|4142->2125|4171->2126|4258->2186|4294->2201|4331->2300|4368->2310|4396->2317|4433->2327|4474->2341|4489->2347|4550->2387|4634->2444|4649->2450|4725->2505|4786->2539|4801->2545|4894->2616
                  LINES: 33->7|38->8|39->9|42->12|43->13|43->13|43->13|44->14|44->14|44->14|45->15|45->15|45->15|47->17|47->17|47->17|52->22|52->22|52->22|52->22|52->22|53->23|53->23|53->23|53->23|53->23|54->24|54->24|54->24|54->24|54->24|55->25|55->25|61->31|61->31|64->34|64->34|69->39|69->39|70->40|70->40|75->45|75->45|79->49|79->49|80->51|81->52|81->52|83->54|83->54|83->54|83->54|84->55|84->55|84->55|85->56|85->56|85->56
                  -- GENERATED --
              */
          