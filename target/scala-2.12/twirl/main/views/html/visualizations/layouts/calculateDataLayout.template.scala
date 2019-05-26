
package views.html.visualizations.layouts

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

"""),_display_(/*3.2*/main(title)/*3.13*/{_display_(Seq[Any](format.raw/*3.14*/("""
"""),format.raw/*4.1*/("""<link rel="shortcut icon" type="image/png" href=""""),_display_(/*4.51*/routes/*4.57*/.Assets.versioned("images/favicon.png")),format.raw/*4.96*/("""">
"""),_display_(/*5.2*/imports/*5.9*/.mapbox()),format.raw/*5.18*/("""
"""),format.raw/*6.1*/("""<style>
       #map """),format.raw/*7.13*/("""{"""),format.raw/*7.14*/(""" """),format.raw/*7.15*/("""position:relative; width:100%; height: 80%"""),format.raw/*7.57*/("""}"""),format.raw/*7.58*/("""

       """),format.raw/*9.8*/(""".grid-container """),format.raw/*9.24*/("""{"""),format.raw/*9.25*/("""
           """),format.raw/*10.12*/("""display: grid;
           <!--grid-column-gap: 2%;-->
           grid-template-columns: repeat(auto-fit) ;
           /*background-color: #2196F3;*/
           padding: 5%;
       """),format.raw/*15.8*/("""}"""),format.raw/*15.9*/("""

       """),format.raw/*17.8*/("""/*https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Grid_Layout/Basic_Concepts_of_Grid_Layout#Grid_lines*/
       .map """),format.raw/*18.13*/("""{"""),format.raw/*18.14*/("""
           """),format.raw/*19.12*/("""grid-column-start: 2;
           grid-column-end: 5;
           <!--grid-row-start: 1;-->
           <!--grid-row-end: 4;-->
           <!--padding-right: 5%;-->
       """),format.raw/*24.8*/("""}"""),format.raw/*24.9*/("""
       """),format.raw/*25.8*/(""".parameters """),format.raw/*25.20*/("""{"""),format.raw/*25.21*/("""
           """),format.raw/*26.12*/("""grid-column-start: 1;
           grid-column-end: 1;
       """),format.raw/*28.8*/("""}"""),format.raw/*28.9*/("""

       """),format.raw/*30.8*/(""".same-row """),format.raw/*30.18*/("""{"""),format.raw/*30.19*/("""
           """),format.raw/*31.12*/("""display: inline-block;
       """),format.raw/*32.8*/("""}"""),format.raw/*32.9*/("""

    """),format.raw/*34.5*/("""</style>
<script>
   function showDiv() """),format.raw/*36.23*/("""{"""),format.raw/*36.24*/("""
     """),format.raw/*37.6*/("""document.getElementById('loadingGif').style.display = "inline-block";
     setTimeout(function() """),format.raw/*38.28*/("""{"""),format.raw/*38.29*/("""
       """),format.raw/*39.8*/("""document.getElementById('loadingGif').style.display = "none";
       document.getElementById('showme').style.display = "inline-block";
     """),format.raw/*41.6*/("""}"""),format.raw/*41.7*/(""",120000);
   """),format.raw/*42.4*/("""}"""),format.raw/*42.5*/("""
"""),format.raw/*43.1*/("""</script>
""")))}/*44.2*/{_display_(Seq[Any](format.raw/*44.3*/("""
"""),format.raw/*45.1*/("""</br>
<div align="center">
    <h3>"""),_display_(/*47.10*/title),format.raw/*47.15*/(""" """),format.raw/*47.16*/("""Visualization
    </h3>
</div>
<div class="grid-container">
    <div class="parameters" align="left">
        """),_display_(/*52.10*/parameters),format.raw/*52.20*/("""
    """),format.raw/*53.5*/("""</div>
    <div class="map"> <div id='map'><!--<pre id='info'></pre>--></div></div>
</div>
"""),_display_(/*56.2*/calculateMap()),format.raw/*56.16*/("""

""")))}),format.raw/*58.2*/("""




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
                  DATE: Sat May 25 19:10:53 IDT 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/app/views/visualizations/layouts/calculateDataLayout.scala.html
                  HASH: c8ba3ce8d183248d31cf5700d1adf612600e64de
                  MATRIX: 995->1|1142->53|1172->58|1191->69|1229->70|1257->72|1333->122|1347->128|1406->167|1436->172|1450->179|1479->188|1507->190|1555->211|1583->212|1611->213|1680->255|1708->256|1745->267|1788->283|1816->284|1857->297|2069->482|2097->483|2135->494|2286->617|2315->618|2356->631|2557->805|2585->806|2621->815|2661->827|2690->828|2731->841|2820->903|2848->904|2886->915|2924->925|2953->926|2994->939|3052->970|3080->971|3115->979|3185->1021|3214->1022|3248->1029|3374->1127|3403->1128|3439->1137|3608->1279|3636->1280|3677->1294|3705->1295|3734->1297|3764->1309|3802->1310|3831->1312|3896->1350|3922->1355|3951->1356|4094->1472|4125->1482|4158->1488|4279->1583|4314->1597|4349->1602
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|36->4|36->4|36->4|37->5|37->5|37->5|38->6|39->7|39->7|39->7|39->7|39->7|41->9|41->9|41->9|42->10|47->15|47->15|49->17|50->18|50->18|51->19|56->24|56->24|57->25|57->25|57->25|58->26|60->28|60->28|62->30|62->30|62->30|63->31|64->32|64->32|66->34|68->36|68->36|69->37|70->38|70->38|71->39|73->41|73->41|74->42|74->42|75->43|76->44|76->44|77->45|79->47|79->47|79->47|84->52|84->52|85->53|88->56|88->56|90->58
                  -- GENERATED --
              */
          