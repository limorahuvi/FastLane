
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

object resultLayout extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,Html,Html,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(styles: Html)(description: Html)(map: Html)(index: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.74*/("""
"""),_display_(/*2.2*/main(title)/*2.13*/{_display_(Seq[Any](format.raw/*2.14*/("""
    """),format.raw/*3.5*/("""<meta name='viewport' content='initial-scale=1,maximum-scale=1,user-scalable=no' />
    """),_display_(/*4.6*/imports/*4.13*/.mapbox()),format.raw/*4.22*/("""
    """),format.raw/*5.5*/("""<style>
            /*body """),format.raw/*6.20*/("""{"""),format.raw/*6.21*/(""" """),format.raw/*6.22*/("""margin:50%; padding:10%; """),format.raw/*6.47*/("""}"""),format.raw/*6.48*/("""*/
            #map """),format.raw/*7.18*/("""{"""),format.raw/*7.19*/(""" """),format.raw/*7.20*/("""position:absolute; width:70%; height: 80%"""),format.raw/*7.61*/("""}"""),format.raw/*7.62*/("""
            """),format.raw/*8.13*/(""".grid-container """),format.raw/*8.29*/("""{"""),format.raw/*8.30*/("""
                """),format.raw/*9.17*/("""display: grid;
                grid-column-gap: 10%;
                grid-template-columns: auto auto auto;
                /*background-color: #2196F3;*/
                padding: 10px;
            """),format.raw/*14.13*/("""}"""),format.raw/*14.14*/("""

            """),format.raw/*16.13*/("""/*https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Grid_Layout/Basic_Concepts_of_Grid_Layout#Grid_lines*/
            .map """),format.raw/*17.18*/("""{"""),format.raw/*17.19*/("""
                """),format.raw/*18.17*/("""grid-column-start: 1;
                grid-column-end: 2;
                grid-row-start: 1;
                grid-row-end: 4;
            """),format.raw/*22.13*/("""}"""),format.raw/*22.14*/("""
            """),format.raw/*23.13*/(""".parameters """),format.raw/*23.25*/("""{"""),format.raw/*23.26*/("""
                """),format.raw/*24.17*/("""grid-column-start: 4;
                grid-column-end: 5;
                grid-row-start: 1;
                grid-row-end: 4;
            """),format.raw/*28.13*/("""}"""),format.raw/*28.14*/("""
            """),format.raw/*29.13*/(""".btn """),format.raw/*29.18*/("""{"""),format.raw/*29.19*/("""
              """),format.raw/*30.15*/("""background-color: gray;
              border: none;
              color: white;
              padding: 12px 30px;
              cursor: pointer;
              font-size: 20px;
            """),format.raw/*36.13*/("""}"""),format.raw/*36.14*/("""


        """),format.raw/*39.9*/("""</style>
    <style type='text/css'>
            #info """),format.raw/*41.19*/("""{"""),format.raw/*41.20*/("""
                """),format.raw/*42.17*/("""display: block;
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
            """),format.raw/*53.13*/("""}"""),format.raw/*53.14*/("""
        """),format.raw/*54.9*/("""</style>

    <!--<script src = "node_modules/clientside-require/dist/bundle.js"></script>-->
    <!--<script type="text/javascript" src="DemoData.js"></script>-->
    <!--<link rel="stylesheet" href="https://js.arcgis.com/3.27/dijit/themes/claro/claro.css">-->
    <!--<link rel="stylesheet" href="https://js.arcgis.com/3.27/esri/css/esri.css" />-->
    <!--<script src="https://js.arcgis.com/3.27/"></script>-->
    """),_display_(/*61.6*/styles),format.raw/*61.12*/("""
""")))}/*62.2*/{_display_(Seq[Any](format.raw/*62.3*/("""
    """),_display_(/*63.6*/description),format.raw/*63.17*/("""
    """),format.raw/*64.5*/("""<div class="grid-container" id="grid">
        <div class="map"> <div id='map'><!--<pre id='info'></pre>--></div></div>
        <div class="parameters" id="parameters">
            """),_display_(/*67.14*/index),format.raw/*67.19*/("""
            """),format.raw/*68.13*/("""</br>
            <a href='#' onclick='downloadCSV("""),format.raw/*69.46*/("""{"""),format.raw/*69.47*/(""" """),format.raw/*69.48*/("""filename: "data.csv" """),format.raw/*69.69*/("""}"""),format.raw/*69.70*/(""");'>
                <button>
                    Download data as CSV
                </button>
            </a>
        </div>


    </div>

    <script>
        """),_display_(/*80.10*/map),format.raw/*80.13*/("""

        """),format.raw/*82.9*/("""<!--EXPORT TO CSV-->
        function convertArrayOfObjectsToCSV(args) """),format.raw/*83.51*/("""{"""),format.raw/*83.52*/("""
            """),format.raw/*84.13*/("""var result, ctr, keys, columnDelimiter, lineDelimiter, data;

            data = args.data || null;
            if (data == null || !data.length) """),format.raw/*87.47*/("""{"""),format.raw/*87.48*/("""
                """),format.raw/*88.17*/("""return null;
            """),format.raw/*89.13*/("""}"""),format.raw/*89.14*/("""

            """),format.raw/*91.13*/("""columnDelimiter = args.columnDelimiter || ',';
            lineDelimiter = args.lineDelimiter || '\n';

            keys = Object.keys(data[0]);

            result = '';
            result += keys.join(columnDelimiter);

            result += lineDelimiter;

            data.forEach(function(item) """),format.raw/*101.41*/("""{"""),format.raw/*101.42*/("""
                """),format.raw/*102.17*/("""ctr = 0;
                keys.forEach(function(key) """),format.raw/*103.44*/("""{"""),format.raw/*103.45*/("""
                    """),format.raw/*104.21*/("""if (ctr > 0) result += columnDelimiter;

                    result += item[key];
                    ctr++;
                """),format.raw/*108.17*/("""}"""),format.raw/*108.18*/(""");
                result += lineDelimiter;
            """),format.raw/*110.13*/("""}"""),format.raw/*110.14*/(""");

            return result;
        """),format.raw/*113.9*/("""}"""),format.raw/*113.10*/("""
        """),format.raw/*114.9*/("""function flatten(data) """),format.raw/*114.32*/("""{"""),format.raw/*114.33*/("""
        """),format.raw/*115.9*/("""var result = """),format.raw/*115.22*/("""{"""),format.raw/*115.23*/("""}"""),format.raw/*115.24*/(""";

        function recurse(cur, prop) """),format.raw/*117.37*/("""{"""),format.raw/*117.38*/("""
            """),format.raw/*118.13*/("""if (Object(cur) !== cur) """),format.raw/*118.38*/("""{"""),format.raw/*118.39*/("""
                """),format.raw/*119.17*/("""result[prop] = cur;
            """),format.raw/*120.13*/("""}"""),format.raw/*120.14*/(""" """),format.raw/*120.15*/("""else if (Array.isArray(cur)) """),format.raw/*120.44*/("""{"""),format.raw/*120.45*/("""
                """),format.raw/*121.17*/("""for (var i = 0, l = cur.length; i < l; i++)
                recurse(cur[i], prop + "[" + i + "]");
                if (l == 0) result[prop] = [];
            """),format.raw/*124.13*/("""}"""),format.raw/*124.14*/(""" """),format.raw/*124.15*/("""else """),format.raw/*124.20*/("""{"""),format.raw/*124.21*/("""
                """),format.raw/*125.17*/("""var isEmpty = true;
                for (var p in cur) """),format.raw/*126.36*/("""{"""),format.raw/*126.37*/("""
                    """),format.raw/*127.21*/("""isEmpty = false;
                    recurse(cur[p], prop ? prop + "." + p : p);
                """),format.raw/*129.17*/("""}"""),format.raw/*129.18*/("""
                """),format.raw/*130.17*/("""if (isEmpty && prop) result[prop] = """),format.raw/*130.53*/("""{"""),format.raw/*130.54*/("""}"""),format.raw/*130.55*/(""";
            """),format.raw/*131.13*/("""}"""),format.raw/*131.14*/("""
            """),format.raw/*132.13*/("""<!--ELSE END-->
        """),format.raw/*133.9*/("""}"""),format.raw/*133.10*/("""
        """),format.raw/*134.9*/("""<!--RECURSE END-->
        recurse(data, "");
        return result;
    """),format.raw/*137.5*/("""}"""),format.raw/*137.6*/(""";
    </script>
""")))}),format.raw/*139.2*/("""
"""))
      }
    }
  }

  def render(title:String,styles:Html,description:Html,map:Html,index:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(styles)(description)(map)(index)

  def f:((String) => (Html) => (Html) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (styles) => (description) => (map) => (index) => apply(title)(styles)(description)(map)(index)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue May 21 20:43:40 IDT 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/app/views/visualizations/layouts/resultLayout.scala.html
                  HASH: f333b9fb67a67977db04524e9ca025dec341a9ed
                  MATRIX: 998->1|1165->73|1193->76|1212->87|1250->88|1282->94|1397->184|1412->191|1441->200|1473->206|1528->234|1556->235|1584->236|1636->261|1664->262|1712->283|1740->284|1768->285|1836->326|1864->327|1905->341|1948->357|1976->358|2021->376|2252->579|2281->580|2325->596|2481->724|2510->725|2556->743|2726->885|2755->886|2797->900|2837->912|2866->913|2912->931|3082->1073|3111->1074|3153->1088|3186->1093|3215->1094|3259->1110|3481->1304|3510->1305|3551->1319|3636->1376|3665->1377|3711->1395|4105->1761|4134->1762|4171->1772|4623->2198|4650->2204|4671->2207|4709->2208|4742->2215|4774->2226|4807->2232|5019->2417|5045->2422|5087->2436|5167->2488|5196->2489|5225->2490|5274->2511|5303->2512|5506->2688|5530->2691|5569->2703|5669->2775|5698->2776|5740->2790|5917->2939|5946->2940|5992->2958|6046->2984|6075->2985|6119->3001|6458->3311|6488->3312|6535->3330|6617->3383|6647->3384|6698->3406|6856->3535|6886->3536|6973->3594|7003->3595|7073->3637|7103->3638|7141->3648|7193->3671|7223->3672|7261->3682|7303->3695|7333->3696|7363->3697|7433->3738|7463->3739|7506->3753|7560->3778|7590->3779|7637->3797|7699->3830|7729->3831|7759->3832|7817->3861|7847->3862|7894->3880|8084->4041|8114->4042|8144->4043|8178->4048|8208->4049|8255->4067|8340->4123|8370->4124|8421->4146|8549->4245|8579->4246|8626->4264|8691->4300|8721->4301|8751->4302|8795->4317|8825->4318|8868->4332|8921->4357|8951->4358|8989->4368|9093->4444|9122->4445|9172->4464
                  LINES: 28->1|33->1|34->2|34->2|34->2|35->3|36->4|36->4|36->4|37->5|38->6|38->6|38->6|38->6|38->6|39->7|39->7|39->7|39->7|39->7|40->8|40->8|40->8|41->9|46->14|46->14|48->16|49->17|49->17|50->18|54->22|54->22|55->23|55->23|55->23|56->24|60->28|60->28|61->29|61->29|61->29|62->30|68->36|68->36|71->39|73->41|73->41|74->42|85->53|85->53|86->54|93->61|93->61|94->62|94->62|95->63|95->63|96->64|99->67|99->67|100->68|101->69|101->69|101->69|101->69|101->69|112->80|112->80|114->82|115->83|115->83|116->84|119->87|119->87|120->88|121->89|121->89|123->91|133->101|133->101|134->102|135->103|135->103|136->104|140->108|140->108|142->110|142->110|145->113|145->113|146->114|146->114|146->114|147->115|147->115|147->115|147->115|149->117|149->117|150->118|150->118|150->118|151->119|152->120|152->120|152->120|152->120|152->120|153->121|156->124|156->124|156->124|156->124|156->124|157->125|158->126|158->126|159->127|161->129|161->129|162->130|162->130|162->130|162->130|163->131|163->131|164->132|165->133|165->133|166->134|169->137|169->137|171->139
                  -- GENERATED --
              */
          