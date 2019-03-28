
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


Seq[Any](format.raw/*7.32*/("""

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
                  DATE: Thu Mar 28 13:16:39 IST 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/FastLane/app/views/main.scala.html
                  HASH: 9766191357f6be080e1ba6b41e1f6d739b7b28f2
                  MATRIX: 1211->266|1336->296|1366->300|1449->408|1486->418|1521->426|1547->431|1637->494|1652->500|1715->541|1808->607|1823->613|1884->652|1982->723|1997->729|2092->802|2410->1092|2439->1093|2468->1094|2521->1119|2550->1120|2606->1148|2635->1149|2664->1150|2733->1191|2762->1192|2818->1220|2847->1221|2876->1222|2962->1280|2991->1281|3058->1320|3087->1321|3378->1584|3407->1585|3593->1743|3622->1744|3845->1939|3874->1940|3935->1973|3964->1974|4187->2169|4216->2170|4307->2234|4343->2249|4381->2350|4419->2361|4447->2368|4486->2380|4527->2394|4542->2400|4603->2440|4688->2498|4703->2504|4779->2559|4841->2594|4856->2600|4949->2671
                  LINES: 33->7|38->7|40->9|43->12|44->13|44->13|44->13|45->14|45->14|45->14|46->15|46->15|46->15|48->17|48->17|48->17|53->22|53->22|53->22|53->22|53->22|54->23|54->23|54->23|54->23|54->23|55->24|55->24|55->24|55->24|55->24|56->25|56->25|62->31|62->31|65->34|65->34|70->39|70->39|71->40|71->40|76->45|76->45|80->49|80->49|81->51|82->52|82->52|84->54|84->54|84->54|84->54|85->55|85->55|85->55|86->56|86->56|86->56
                  -- GENERATED --
              */
          