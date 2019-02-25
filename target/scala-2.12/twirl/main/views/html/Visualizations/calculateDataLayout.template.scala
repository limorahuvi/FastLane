
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
            #map """),format.raw/*18.18*/("""{"""),format.raw/*18.19*/(""" """),format.raw/*18.20*/("""position:absolute; width:80%; height: 80%"""),format.raw/*18.61*/("""}"""),format.raw/*18.62*/("""
            """),format.raw/*19.13*/("""/*#map """),format.raw/*19.20*/("""{"""),format.raw/*19.21*/(""" """),format.raw/*19.22*/("""position:absolute; top:0; bottom:0; width:50%; height: 50%"""),format.raw/*19.80*/("""}"""),format.raw/*19.81*/("""*/
            <!--.grid-container """),format.raw/*20.33*/("""{"""),format.raw/*20.34*/("""-->
                <!--display: grid;-->
                <!--grid-column-gap: 10%;-->
                <!--grid-template-columns: auto auto auto;-->
                <!--/*background-color: #2196F3;*/-->
                <!--padding: 10px;-->
            <!--"""),format.raw/*26.17*/("""}"""),format.raw/*26.18*/("""-->

            <!--/*https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Grid_Layout/Basic_Concepts_of_Grid_Layout#Grid_lines*/-->
            <!--.map """),format.raw/*29.22*/("""{"""),format.raw/*29.23*/("""-->
                <!--grid-column-start: 1;-->
                <!--grid-column-end: 2;-->
                <!--grid-row-start: 1;-->
                <!--grid-row-end: 4;-->
            <!--"""),format.raw/*34.17*/("""}"""),format.raw/*34.18*/("""-->
            <!--.parameters """),format.raw/*35.29*/("""{"""),format.raw/*35.30*/("""-->
                <!--grid-column-start: 3;-->
                <!--grid-column-end: 4;-->
                <!--grid-row-start: 1;-->
                <!--grid-row-end: 4;-->
            <!--"""),format.raw/*40.17*/("""}"""),format.raw/*40.18*/("""-->
        </style>
</head>
<body>
    """),_display_(/*44.6*/navigationbar()),format.raw/*44.21*/("""
    """),format.raw/*45.5*/("""</br>
    <div>"""),_display_(/*46.11*/description),format.raw/*46.22*/("""</div>
    </br>
    <div class="container">
        <div class="row">
            <div class="col-8">
                <div id='map'></div>
            </div>
            <div class="col">
                """),_display_(/*54.18*/parameters),format.raw/*54.28*/("""
            """),format.raw/*55.13*/("""</div>
        </div>
    </div>

    <!--<div class="grid-container">-->
        <!--<div class="map"> <div id='map'></div></div>-->
        <!--<div class="parameters">"""),_display_(/*61.38*/parameters),format.raw/*61.48*/("""</div>-->
    <!--</div>-->

   """),_display_(/*64.5*/calculateMap()),format.raw/*64.19*/("""
    """),format.raw/*65.5*/("""<script src=""""),_display_(/*65.19*/routes/*65.25*/.Assets.versioned("javascripts/main.js")),format.raw/*65.65*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*66.19*/routes/*66.25*/.Assets.versioned("outsiders/jquery-3.3.1.slim.min.js")),format.raw/*66.80*/(""""></script>
    <script src=""""),_display_(/*67.19*/routes/*67.25*/.Assets.versioned("outsiders/bootstrap-4.2.1-dist/js/bootstrap.min.js")),format.raw/*67.96*/(""""  integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
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
                  DATE: Mon Feb 25 09:35:43 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/app/views/Visualizations/calculateDataLayout.scala.html
                  HASH: c328503124f6a0be98d8c68d5d6c4dc3a7fbe776
                  MATRIX: 987->1|1134->53|1166->59|1240->159|1272->165|1306->173|1331->178|1416->237|1430->243|1491->284|1576->342|1591->348|1652->387|1739->447|1754->453|1849->526|2234->883|2263->884|2292->885|2345->910|2374->911|2423->932|2452->933|2481->934|2550->975|2579->976|2621->990|2656->997|2685->998|2714->999|2800->1057|2829->1058|2893->1094|2922->1095|3213->1358|3242->1359|3428->1517|3457->1518|3680->1713|3709->1714|3770->1747|3799->1748|4022->1943|4051->1944|4122->1989|4158->2004|4191->2010|4235->2027|4267->2038|4508->2252|4539->2262|4581->2276|4785->2453|4816->2463|4878->2499|4913->2513|4946->2519|4987->2533|5002->2539|5063->2579|5144->2633|5159->2639|5235->2694|5293->2725|5308->2731|5400->2802
                  LINES: 28->1|33->1|36->4|39->7|40->8|40->8|40->8|41->9|41->9|41->9|42->10|42->10|42->10|44->12|44->12|44->12|49->17|49->17|49->17|49->17|49->17|50->18|50->18|50->18|50->18|50->18|51->19|51->19|51->19|51->19|51->19|51->19|52->20|52->20|58->26|58->26|61->29|61->29|66->34|66->34|67->35|67->35|72->40|72->40|76->44|76->44|77->45|78->46|78->46|86->54|86->54|87->55|93->61|93->61|96->64|96->64|97->65|97->65|97->65|97->65|98->66|98->66|98->66|99->67|99->67|99->67
                  -- GENERATED --
              */
          