
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

object calculateDataLayout extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(description: Html)(parameters: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.54*/("""


"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    """),format.raw/*7.58*/("""
    """),format.raw/*8.5*/("""<title>"""),_display_(/*8.13*/title),format.raw/*8.18*/("""</title>
    <link rel="stylesheet" media="screen" href=""""),_display_(/*9.50*/routes/*9.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*9.97*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*10.55*/routes/*10.61*/.Assets.versioned("images/favicon.png")),format.raw/*10.100*/("""">
    <!--BOOTSTRAP-->
    <link rel="stylesheet" href=""""),_display_(/*12.35*/routes/*12.41*/.Assets.versioned("outsiders/bootstrap-4.2.1-dist/css/bootstrap.min.css")),format.raw/*12.114*/("""" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <!--MAPBOX-->
    <script src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.52.0/mapbox-gl.js'></script>
    <link href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.52.0/mapbox-gl.css' rel='stylesheet' />
    <style>
            /*body """),format.raw/*17.20*/("""{"""),format.raw/*17.21*/(""" """),format.raw/*17.22*/("""margin:50%; padding:10%; """),format.raw/*17.47*/("""}"""),format.raw/*17.48*/("""*/
            #map """),format.raw/*18.18*/("""{"""),format.raw/*18.19*/(""" """),format.raw/*18.20*/("""position:absolute; width:50%; height: 50%"""),format.raw/*18.61*/("""}"""),format.raw/*18.62*/("""
            """),format.raw/*19.13*/("""/*#map """),format.raw/*19.20*/("""{"""),format.raw/*19.21*/(""" """),format.raw/*19.22*/("""position:absolute; top:0; bottom:0; width:50%; height: 50%"""),format.raw/*19.80*/("""}"""),format.raw/*19.81*/("""*/
            .grid-container """),format.raw/*20.29*/("""{"""),format.raw/*20.30*/("""
                """),format.raw/*21.17*/("""display: grid;
                grid-column-gap: 10%;
                grid-template-columns: auto auto auto;
                /*background-color: #2196F3;*/
                padding: 10px;
            """),format.raw/*26.13*/("""}"""),format.raw/*26.14*/("""

            """),format.raw/*28.13*/("""/*https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Grid_Layout/Basic_Concepts_of_Grid_Layout#Grid_lines*/
            .map """),format.raw/*29.18*/("""{"""),format.raw/*29.19*/("""
                """),format.raw/*30.17*/("""grid-column-start: 1;
                grid-column-end: 2;
                grid-row-start: 1;
                grid-row-end: 4;
            """),format.raw/*34.13*/("""}"""),format.raw/*34.14*/("""
            """),format.raw/*35.13*/(""".parameters """),format.raw/*35.25*/("""{"""),format.raw/*35.26*/("""
                """),format.raw/*36.17*/("""grid-column-start: 3;
                grid-column-end: 4;
                grid-row-start: 1;
                grid-row-end: 4;
            """),format.raw/*40.13*/("""}"""),format.raw/*40.14*/("""
        """),format.raw/*41.9*/("""</style>
</head>
<body>
    """),_display_(/*44.6*/navigationbar()),format.raw/*44.21*/("""
    """),format.raw/*45.5*/("""</br>
    <div>"""),_display_(/*46.11*/description),format.raw/*46.22*/("""</div>
    </br>
    <div class="grid-container">
        <div class="map"> <div id='map'></div></div>
        <div class="parameters">"""),_display_(/*50.34*/parameters),format.raw/*50.44*/("""</div>
    </div>

   """),_display_(/*53.5*/calculateMap()),format.raw/*53.19*/("""
    """),format.raw/*54.5*/("""<script src=""""),_display_(/*54.19*/routes/*54.25*/.Assets.versioned("javascripts/main.js")),format.raw/*54.65*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*55.19*/routes/*55.25*/.Assets.versioned("outsiders/jquery-3.3.1.slim.min.js")),format.raw/*55.80*/(""""></script>
    <script src=""""),_display_(/*56.19*/routes/*56.25*/.Assets.versioned("outsiders/bootstrap-4.2.1-dist/js/bootstrap.min.js")),format.raw/*56.96*/(""""  integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>
"""))
      }
    }
  }

  def render(title:String,description:Html,parameters:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(description)(parameters)

  def f:((String) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (description) => (parameters) => apply(title)(description)(parameters)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Jan 04 18:17:54 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/play-java-seed/app/views/Visualizations/calculateDataLayout.scala.html
                  HASH: f712042fadc11b2d2883cabc53a69605d14d0523
                  MATRIX: 987->1|1134->53|1166->59|1240->159|1272->165|1306->173|1331->178|1416->237|1430->243|1491->284|1576->342|1591->348|1652->387|1739->447|1754->453|1849->526|2234->883|2263->884|2292->885|2345->910|2374->911|2423->932|2452->933|2481->934|2550->975|2579->976|2621->990|2656->997|2685->998|2714->999|2800->1057|2829->1058|2889->1090|2918->1091|2964->1109|3195->1312|3224->1313|3268->1329|3424->1457|3453->1458|3499->1476|3669->1618|3698->1619|3740->1633|3780->1645|3809->1646|3855->1664|4025->1806|4054->1807|4091->1817|4149->1849|4185->1864|4218->1870|4262->1887|4294->1898|4461->2038|4492->2048|4544->2074|4579->2088|4612->2094|4653->2108|4668->2114|4729->2154|4810->2208|4825->2214|4901->2269|4959->2300|4974->2306|5066->2377
                  LINES: 28->1|33->1|36->4|39->7|40->8|40->8|40->8|41->9|41->9|41->9|42->10|42->10|42->10|44->12|44->12|44->12|49->17|49->17|49->17|49->17|49->17|50->18|50->18|50->18|50->18|50->18|51->19|51->19|51->19|51->19|51->19|51->19|52->20|52->20|53->21|58->26|58->26|60->28|61->29|61->29|62->30|66->34|66->34|67->35|67->35|67->35|68->36|72->40|72->40|73->41|76->44|76->44|77->45|78->46|78->46|82->50|82->50|85->53|85->53|86->54|86->54|86->54|86->54|87->55|87->55|87->55|88->56|88->56|88->56
                  -- GENERATED --
              */
          