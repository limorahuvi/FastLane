
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
            #map """),format.raw/*18.18*/("""{"""),format.raw/*18.19*/(""" """),format.raw/*18.20*/("""position:absolute; width:90%; height: 100%"""),format.raw/*18.62*/("""}"""),format.raw/*18.63*/("""
            """),format.raw/*19.13*/("""/*#map """),format.raw/*19.20*/("""{"""),format.raw/*19.21*/(""" """),format.raw/*19.22*/("""position:absolute; top:0; bottom:0; width:50%; height: 50%"""),format.raw/*19.80*/("""}"""),format.raw/*19.81*/("""*/

        </style>
</head>
<body>
    """),_display_(/*24.6*/navigationbar()),format.raw/*24.21*/("""
    """),format.raw/*25.5*/("""</br>
    <div>"""),_display_(/*26.11*/description),format.raw/*26.22*/("""</div>
    </br>
    <div class="container">
        <div class="row">
            <div class="col-8" >
                <div id='map'></div>
            </div>
            <div class="col">
                """),_display_(/*34.18*/parameters),format.raw/*34.28*/("""
            """),format.raw/*35.13*/("""</div>
        </div>
    </div>

   """),_display_(/*39.5*/calculateMap()),format.raw/*39.19*/("""
    """),format.raw/*40.5*/("""<script src=""""),_display_(/*40.19*/routes/*40.25*/.Assets.versioned("javascripts/main.js")),format.raw/*40.65*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*41.19*/routes/*41.25*/.Assets.versioned("outsiders/jquery-3.3.1.slim.min.js")),format.raw/*41.80*/(""""></script>
    <script src=""""),_display_(/*42.19*/routes/*42.25*/.Assets.versioned("outsiders/bootstrap-4.2.1-dist/js/bootstrap.min.js")),format.raw/*42.96*/(""""  integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
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
                  DATE: Thu Mar 28 13:16:39 IST 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/FastLane/app/views/Visualizations/calculateDataLayout.scala.html
                  HASH: a9cb6d0e523b1cf5d5cb1f5cd593e07bcf510960
                  MATRIX: 987->1|1134->53|1166->59|1240->159|1272->165|1306->173|1331->178|1416->237|1430->243|1491->284|1576->342|1591->348|1652->387|1739->447|1754->453|1849->526|2234->883|2263->884|2292->885|2345->910|2374->911|2423->932|2452->933|2481->934|2551->976|2580->977|2622->991|2657->998|2686->999|2715->1000|2801->1058|2830->1059|2902->1105|2938->1120|2971->1126|3015->1143|3047->1154|3289->1369|3320->1379|3362->1393|3430->1435|3465->1449|3498->1455|3539->1469|3554->1475|3615->1515|3696->1569|3711->1575|3787->1630|3845->1661|3860->1667|3952->1738
                  LINES: 28->1|33->1|36->4|39->7|40->8|40->8|40->8|41->9|41->9|41->9|42->10|42->10|42->10|44->12|44->12|44->12|49->17|49->17|49->17|49->17|49->17|50->18|50->18|50->18|50->18|50->18|51->19|51->19|51->19|51->19|51->19|51->19|56->24|56->24|57->25|58->26|58->26|66->34|66->34|67->35|71->39|71->39|72->40|72->40|72->40|72->40|73->41|73->41|73->41|74->42|74->42|74->42
                  -- GENERATED --
              */
          