
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

object resultLayout extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,Html,Html,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(styles: Html)(description: Html)(map: Html)(index: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.74*/("""

"""),format.raw/*3.1*/("""<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Passengers Count</title>
    <meta charset='utf-8' />
    <meta name='viewport' content='initial-scale=1,maximum-scale=1,user-scalable=no' />
    <!--BOOTSTRAP-->
    <link rel="stylesheet" href=""""),_display_(/*10.35*/routes/*10.41*/.Assets.versioned("outsiders/bootstrap-4.2.1-dist/css/bootstrap.min.css")),format.raw/*10.114*/("""" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <!--MAPBOX-->
    <script src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.52.0/mapbox-gl.js'></script>
    <link href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.52.0/mapbox-gl.css' rel='stylesheet' />
    <style>
        /*body """),format.raw/*15.16*/("""{"""),format.raw/*15.17*/(""" """),format.raw/*15.18*/("""margin:50%; padding:10%; """),format.raw/*15.43*/("""}"""),format.raw/*15.44*/("""*/
        #map """),format.raw/*16.14*/("""{"""),format.raw/*16.15*/(""" """),format.raw/*16.16*/("""position:absolute; width:70%; height: 80%"""),format.raw/*16.57*/("""}"""),format.raw/*16.58*/("""
        """),format.raw/*17.9*/(""".grid-container """),format.raw/*17.25*/("""{"""),format.raw/*17.26*/("""
            """),format.raw/*18.13*/("""display: grid;
            grid-column-gap: 10%;
            grid-template-columns: auto auto auto;
            /*background-color: #2196F3;*/
            padding: 10px;
        """),format.raw/*23.9*/("""}"""),format.raw/*23.10*/("""

        """),format.raw/*25.9*/("""/*https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Grid_Layout/Basic_Concepts_of_Grid_Layout#Grid_lines*/
        .map """),format.raw/*26.14*/("""{"""),format.raw/*26.15*/("""
            """),format.raw/*27.13*/("""grid-column-start: 1;
            grid-column-end: 2;
            grid-row-start: 1;
            grid-row-end: 4;
        """),format.raw/*31.9*/("""}"""),format.raw/*31.10*/("""
        """),format.raw/*32.9*/(""".parameters """),format.raw/*32.21*/("""{"""),format.raw/*32.22*/("""
            """),format.raw/*33.13*/("""grid-column-start: 4;
            grid-column-end: 5;
            grid-row-start: 1;
            grid-row-end: 4;
        """),format.raw/*37.9*/("""}"""),format.raw/*37.10*/("""

    """),format.raw/*39.5*/("""</style>
    <style type='text/css'>
        #info """),format.raw/*41.15*/("""{"""),format.raw/*41.16*/("""
            """),format.raw/*42.13*/("""display: block;
            position: relative;
            margin: 0px auto;
            width: 50%;
            padding: 10px;
            border: none;
            border-radius: 3px;
            font-size: 12px;
            text-align: center;
            color: #222;
            background: #fff;
        """),format.raw/*53.9*/("""}"""),format.raw/*53.10*/("""
    """),format.raw/*54.5*/("""</style>
    <!--<script src = "node_modules/clientside-require/dist/bundle.js"></script>-->
    <!--<script type="text/javascript" src="DemoData.js"></script>-->
    <link rel="stylesheet" href="https://js.arcgis.com/3.27/dijit/themes/claro/claro.css">
    <link rel="stylesheet" href="https://js.arcgis.com/3.27/esri/css/esri.css" />
    <script src="https://js.arcgis.com/3.27/"></script>
    """),_display_(/*60.6*/styles),format.raw/*60.12*/("""
"""),format.raw/*61.1*/("""</head>
    <body>
    """),_display_(/*63.6*/navigationbar()),format.raw/*63.21*/("""
    """),format.raw/*64.5*/("""<div class="grid-container">
        <div class="map"> <div id='map'><!--<pre id='info'></pre>--></div></div>
        """),_display_(/*66.10*/index),format.raw/*66.15*/("""
    """),format.raw/*67.5*/("""</div>
    <script>
        // var bounds = [
        //     [34.78471565, 31.2546456], // Southwest coordinates
        //     [34.8160659,31.27190740]  // Northeast coordinates
        // ];
        """),_display_(/*73.10*/map),format.raw/*73.13*/("""



    """),format.raw/*77.5*/("""</script>

    <script src=""""),_display_(/*79.19*/routes/*79.25*/.Assets.versioned("javascripts/main.js")),format.raw/*79.65*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*80.19*/routes/*80.25*/.Assets.versioned("outsiders/jquery-3.3.1.slim.min.js")),format.raw/*80.80*/(""""></script>
    <script src=""""),_display_(/*81.19*/routes/*81.25*/.Assets.versioned("outsiders/bootstrap-4.2.1-dist/js/bootstrap.min.js")),format.raw/*81.96*/(""""  integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>"""))
      }
    }
  }

  def render(title:String,styles:Html,description:Html,map:Html,index:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(styles)(description)(map)(index)

  def f:((String) => (Html) => (Html) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (styles) => (description) => (map) => (index) => apply(title)(styles)(description)(map)(index)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Mar 03 11:49:34 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/app/views/Visualizations/resultLayout.scala.html
                  HASH: 1506b1afefe9caafb641526ad2860437f671160a
                  MATRIX: 990->1|1157->73|1187->77|1480->343|1495->349|1590->422|1971->775|2000->776|2029->777|2082->802|2111->803|2156->820|2185->821|2214->822|2283->863|2312->864|2349->874|2393->890|2422->891|2464->905|2674->1088|2703->1089|2742->1101|2894->1225|2923->1226|2965->1240|3118->1366|3147->1367|3184->1377|3224->1389|3253->1390|3295->1404|3448->1530|3477->1531|3512->1539|3593->1592|3622->1593|3664->1607|4013->1929|4042->1930|4075->1936|4504->2339|4531->2345|4560->2347|4612->2373|4648->2388|4681->2394|4829->2515|4855->2520|4888->2526|5123->2734|5147->2737|5186->2749|5244->2780|5259->2786|5320->2826|5401->2880|5416->2886|5492->2941|5550->2972|5565->2978|5657->3049
                  LINES: 28->1|33->1|35->3|42->10|42->10|42->10|47->15|47->15|47->15|47->15|47->15|48->16|48->16|48->16|48->16|48->16|49->17|49->17|49->17|50->18|55->23|55->23|57->25|58->26|58->26|59->27|63->31|63->31|64->32|64->32|64->32|65->33|69->37|69->37|71->39|73->41|73->41|74->42|85->53|85->53|86->54|92->60|92->60|93->61|95->63|95->63|96->64|98->66|98->66|99->67|105->73|105->73|109->77|111->79|111->79|111->79|112->80|112->80|112->80|113->81|113->81|113->81
                  -- GENERATED --
              */
          