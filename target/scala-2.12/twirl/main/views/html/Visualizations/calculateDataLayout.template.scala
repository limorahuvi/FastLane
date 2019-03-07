
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
"""),format.raw/*2.1*/("""<!--TODO receive form-->
<!--TODO save coors to form-->

<!DOCTYPE html>
<html lang="en">
<head>
    """),format.raw/*8.58*/("""
    """),format.raw/*9.5*/("""<title>"""),_display_(/*9.13*/title),format.raw/*9.18*/("""</title>
    <link rel="stylesheet" media="screen" href=""""),_display_(/*10.50*/routes/*10.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*10.97*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*11.55*/routes/*11.61*/.Assets.versioned("images/favicon.png")),format.raw/*11.100*/("""">
    <!--BOOTSTRAP-->
    <link rel="stylesheet" href=""""),_display_(/*13.35*/routes/*13.41*/.Assets.versioned("outsiders/bootstrap-4.2.1-dist/css/bootstrap.min.css")),format.raw/*13.114*/("""" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <!--MAPBOX-->
    <script src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.52.0/mapbox-gl.js'></script>
    <link href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.52.0/mapbox-gl.css' rel='stylesheet' />
    <style>
        #map """),format.raw/*18.14*/("""{"""),format.raw/*18.15*/(""" """),format.raw/*18.16*/("""position:absolute; width:60%; height: 70%"""),format.raw/*18.57*/("""}"""),format.raw/*18.58*/("""

        """),format.raw/*20.9*/(""".grid-container """),format.raw/*20.25*/("""{"""),format.raw/*20.26*/("""
            """),format.raw/*21.13*/("""display: grid;
            grid-column-gap: 10%;
            grid-template-columns: auto auto auto;
            /*background-color: #2196F3;*/
            padding: 10px;
        """),format.raw/*26.9*/("""}"""),format.raw/*26.10*/("""

        """),format.raw/*28.9*/("""/*https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Grid_Layout/Basic_Concepts_of_Grid_Layout#Grid_lines*/
        .map """),format.raw/*29.14*/("""{"""),format.raw/*29.15*/("""
            """),format.raw/*30.13*/("""grid-column-start: 1;
            grid-column-end: 2;
            grid-row-start: 1;
            grid-row-end: 4;
        """),format.raw/*34.9*/("""}"""),format.raw/*34.10*/("""
        """),format.raw/*35.9*/(""".parameters """),format.raw/*35.21*/("""{"""),format.raw/*35.22*/("""
            """),format.raw/*36.13*/("""grid-column-start: 4;
            grid-column-end: 5;
            grid-row-start: 1;
            grid-row-end: 4;
        """),format.raw/*40.9*/("""}"""),format.raw/*40.10*/("""

     """),format.raw/*42.6*/("""</style>
</head>
<body>
    """),_display_(/*45.6*/navigationbar()),format.raw/*45.21*/("""
    """),format.raw/*46.5*/("""</br>
    <div>"""),_display_(/*47.11*/description),format.raw/*47.22*/("""</div>
    </br>
    <div class="grid-container">
        <div class="map"> <div id='map'><!--<pre id='info'></pre>--></div></div>
        <div class="parameters"> """),_display_(/*51.35*/parameters),format.raw/*51.45*/("""</div>

    </div>
   """),_display_(/*54.5*/calculateMap()),format.raw/*54.19*/("""
    """),format.raw/*55.5*/("""<script src=""""),_display_(/*55.19*/routes/*55.25*/.Assets.versioned("javascripts/main.js")),format.raw/*55.65*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*56.19*/routes/*56.25*/.Assets.versioned("outsiders/jquery-3.3.1.slim.min.js")),format.raw/*56.80*/(""""></script>
    <script src=""""),_display_(/*57.19*/routes/*57.25*/.Assets.versioned("outsiders/bootstrap-4.2.1-dist/js/bootstrap.min.js")),format.raw/*57.96*/(""""  integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
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
                  DATE: Thu Mar 07 13:14:38 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/app/views/Visualizations/calculateDataLayout.scala.html
                  HASH: 285589a97dafaecdb7b01fb42dad33a416b2dc7f
                  MATRIX: 987->1|1134->53|1162->55|1296->215|1328->221|1362->229|1387->234|1473->293|1488->299|1550->340|1635->398|1650->404|1711->443|1798->503|1813->509|1908->582|2287->933|2316->934|2345->935|2414->976|2443->977|2482->989|2526->1005|2555->1006|2597->1020|2807->1203|2836->1204|2875->1216|3027->1340|3056->1341|3098->1355|3251->1481|3280->1482|3317->1492|3357->1504|3386->1505|3428->1519|3581->1645|3610->1646|3646->1655|3704->1687|3740->1702|3773->1708|3817->1725|3849->1736|4045->1905|4076->1915|4128->1941|4163->1955|4196->1961|4237->1975|4252->1981|4313->2021|4394->2075|4409->2081|4485->2136|4543->2167|4558->2173|4650->2244
                  LINES: 28->1|33->1|34->2|40->8|41->9|41->9|41->9|42->10|42->10|42->10|43->11|43->11|43->11|45->13|45->13|45->13|50->18|50->18|50->18|50->18|50->18|52->20|52->20|52->20|53->21|58->26|58->26|60->28|61->29|61->29|62->30|66->34|66->34|67->35|67->35|67->35|68->36|72->40|72->40|74->42|77->45|77->45|78->46|79->47|79->47|83->51|83->51|86->54|86->54|87->55|87->55|87->55|87->55|88->56|88->56|88->56|89->57|89->57|89->57
                  -- GENERATED --
              */
          