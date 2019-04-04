
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

object passengersCountResult extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[PassengersCountForm,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(result: PassengersCountForm):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.31*/("""

"""),_display_(/*3.2*/resultLayout("Passengers count result")/*3.41*/{_display_(Seq[Any](format.raw/*3.42*/("""
"""),format.raw/*4.1*/("""<style>
        div.l1 """),format.raw/*5.16*/("""{"""),format.raw/*5.17*/("""
            """),format.raw/*6.13*/("""background-color: #ed6498;
            opacity: 0.1;
            filter: alpha(opacity=10); /* For IE8 and earlier */
        """),format.raw/*9.9*/("""}"""),format.raw/*9.10*/("""

        """),format.raw/*11.9*/("""div.l2 """),format.raw/*11.16*/("""{"""),format.raw/*11.17*/("""
            """),format.raw/*12.13*/("""background-color: #ed6498;
            opacity: 0.2;
            filter: alpha(opacity=20); /* For IE8 and earlier */
        """),format.raw/*15.9*/("""}"""),format.raw/*15.10*/("""

        """),format.raw/*17.9*/("""div.l3 """),format.raw/*17.16*/("""{"""),format.raw/*17.17*/("""
            """),format.raw/*18.13*/("""background-color: #ed6498;
            opacity: 0.3;
            filter: alpha(opacity=30); /* For IE8 and earlier */
        """),format.raw/*21.9*/("""}"""),format.raw/*21.10*/("""
        """),format.raw/*22.9*/("""div.l4 """),format.raw/*22.16*/("""{"""),format.raw/*22.17*/("""
            """),format.raw/*23.13*/("""background-color: #ed6498;
            opacity: 0.4;
            filter: alpha(opacity=40); /* For IE8 and earlier */
        """),format.raw/*26.9*/("""}"""),format.raw/*26.10*/("""
        """),format.raw/*27.9*/("""div.l5 """),format.raw/*27.16*/("""{"""),format.raw/*27.17*/("""
            """),format.raw/*28.13*/("""background-color: #ed6498;
            opacity: 0.5;
            filter: alpha(opacity=50); /* For IE8 and earlier */
        """),format.raw/*31.9*/("""}"""),format.raw/*31.10*/("""
        """),format.raw/*32.9*/("""div.l6 """),format.raw/*32.16*/("""{"""),format.raw/*32.17*/("""
            """),format.raw/*33.13*/("""background-color: #ed6498;
            opacity: 0.6;
            filter: alpha(opacity=60); /* For IE8 and earlier */
        """),format.raw/*36.9*/("""}"""),format.raw/*36.10*/("""
        """),format.raw/*37.9*/("""div.l7 """),format.raw/*37.16*/("""{"""),format.raw/*37.17*/("""
            """),format.raw/*38.13*/("""background-color: #ed6498;
            opacity: 0.7;
            filter: alpha(opacity=70); /* For IE8 and earlier */
        """),format.raw/*41.9*/("""}"""),format.raw/*41.10*/("""
        """),format.raw/*42.9*/("""div.l8 """),format.raw/*42.16*/("""{"""),format.raw/*42.17*/("""
            """),format.raw/*43.13*/("""background-color: #ed6498;
            opacity: 0.8;
            filter: alpha(opacity=80); /* For IE8 and earlier */
        """),format.raw/*46.9*/("""}"""),format.raw/*46.10*/("""
        """),format.raw/*47.9*/("""div.l9 """),format.raw/*47.16*/("""{"""),format.raw/*47.17*/("""
            """),format.raw/*48.13*/("""background-color: #ed6498;
            opacity: 0.9;
            filter: alpha(opacity=90); /* For IE8 and earlier */
        """),format.raw/*51.9*/("""}"""),format.raw/*51.10*/("""
        """),format.raw/*52.9*/("""div.l10 """),format.raw/*52.17*/("""{"""),format.raw/*52.18*/("""
            """),format.raw/*53.13*/("""background-color: #ed6498;
            opacity: 1;
            filter: alpha(opacity=100); /* For IE8 and earlier */
        """),format.raw/*56.9*/("""}"""),format.raw/*56.10*/("""
    """),format.raw/*57.5*/("""</style>
""")))}/*58.2*/{_display_(Seq[Any](format.raw/*58.3*/("""
"""),_display_(/*59.2*/result/*59.8*/.getParametersList()),format.raw/*59.28*/(""";
""")))}/*60.2*/{_display_(Seq[Any](format.raw/*60.3*/("""
    """),format.raw/*61.5*/("""mapboxgl.accessToken = 'pk.eyJ1IjoiYWh1dmlsIiwiYSI6ImNqcHdjdmN1bDA1bjY0OXVqb2pucWo5b2oifQ.DlCUMxPJ6c3TD2eLq3OCEQ';
    var map = new mapboxgl.Map("""),format.raw/*62.32*/("""{"""),format.raw/*62.33*/("""
    """),format.raw/*63.5*/("""container: 'map',
    style: 'mapbox://styles/mapbox/light-v9',
    center: [34.798256,31.260114],
    zoom: 14,
    maxZoom:15,
    minZoom:13,
    // maxBounds: bounds
    """),format.raw/*70.5*/("""}"""),format.raw/*70.6*/(""");

    map.on('load', function () """),format.raw/*72.32*/("""{"""),format.raw/*72.33*/("""
        """),format.raw/*73.9*/("""addLoadLayer();
    """),format.raw/*74.5*/("""}"""),format.raw/*74.6*/(""");
    var json = """),format.raw/*75.16*/("""{"""),format.raw/*75.17*/(""""type":"FeatureCollection","features":["""),format.raw/*75.56*/("""{"""),format.raw/*75.57*/(""""type":"Feature","properties":"""),format.raw/*75.87*/("""{"""),format.raw/*75.88*/(""""load":1"""),format.raw/*75.96*/("""}"""),format.raw/*75.97*/(""","geometry":"""),format.raw/*75.109*/("""{"""),format.raw/*75.110*/(""""type":"LineString","coordinates":[[34.798108,31.23819],[34.808931,31.226122]]"""),format.raw/*75.188*/("""}"""),format.raw/*75.189*/("""}"""),format.raw/*75.190*/("""]"""),format.raw/*75.191*/("""}"""),format.raw/*75.192*/("""
    """),format.raw/*76.5*/("""<!--var json = Json.parse("""),_display_(/*76.32*/result/*76.38*/.resultString),format.raw/*76.51*/(""");-->
    function addLoadLayer() """),format.raw/*77.29*/("""{"""),format.raw/*77.30*/("""
        """),format.raw/*78.9*/("""map.addLayer("""),format.raw/*78.22*/("""{"""),format.raw/*78.23*/("""
            """),format.raw/*79.13*/("""'id': 'loadLater',
            'type': 'line',
            'source': """),format.raw/*81.23*/("""{"""),format.raw/*81.24*/("""
            """),format.raw/*82.13*/("""'type': 'geojson',
            'data': json
            """),format.raw/*84.13*/("""}"""),format.raw/*84.14*/(""",
            'layout': """),format.raw/*85.23*/("""{"""),format.raw/*85.24*/("""
            """),format.raw/*86.13*/("""'line-cap': 'round',
            'line-join': 'round'
            """),format.raw/*88.13*/("""}"""),format.raw/*88.14*/(""",
            'paint': """),format.raw/*89.22*/("""{"""),format.raw/*89.23*/("""
            """),format.raw/*90.13*/("""'line-color': '#ed6498',
            'line-width': 5,
            'line-opacity': ['get', 'load']
            """),format.raw/*93.13*/("""}"""),format.raw/*93.14*/(""",
        """),format.raw/*94.9*/("""}"""),format.raw/*94.10*/(""");
    """),format.raw/*95.5*/("""}"""),format.raw/*95.6*/("""

    """),format.raw/*97.5*/("""map.on('click','stationsLayer',function(e)"""),format.raw/*97.47*/("""{"""),format.raw/*97.48*/("""
        """),format.raw/*98.9*/("""var coordinates = e.features[0].geometry.coordinates.slice();
        var description  = e.features[0].properties.id+": "+e.features[0].properties.name;
        while (Math.abs(e.lngLat.lng - coordinates[0]) > 180) """),format.raw/*100.63*/("""{"""),format.raw/*100.64*/("""
        """),format.raw/*101.9*/("""coordinates[0] += e.lngLat.lng > coordinates[0] ? 360 : -360;
    """),format.raw/*102.5*/("""}"""),format.raw/*102.6*/("""

    """),format.raw/*104.5*/("""new mapboxgl.Popup()
        .setLngLat(coordinates)
        .setHTML(description)
        .addTo(map);
    """),format.raw/*108.5*/("""}"""),format.raw/*108.6*/(""");

    map.on('mousemove', function (e) """),format.raw/*110.38*/("""{"""),format.raw/*110.39*/("""
        """),format.raw/*111.9*/("""document.getElementById('info').innerHTML =
        // e.point is the x, y coordinates of the mousemove event relative
        // to the top-left corner of the map
        JSON.stringify(e.point) + '<br />' +
        // e.lngLat is the longitude, latitude geographical position of the event
        JSON.stringify(e.lngLat);
    """),format.raw/*117.5*/("""}"""),format.raw/*117.6*/(""");

""")))}/*119.2*/{_display_(Seq[Any](format.raw/*119.3*/("""
"""),format.raw/*120.1*/("""<div class="parameters">
    <div class="l1"> <10 passengers </div>
    <div class="l2"> 20 passengers </div>
    <div class="l3"> 30 passengers </div>
    <div class="l4"> 40 passengers </div>
    <div class="l5"> 50 passengers </div>
    <div class="l6"> 60 passengers </div>
    <div class="l7"> 70 passengers </div>
    <div class="l8"> 80 passengers </div>
    <div class="l9"> 90 passengers </div>
    <div class="l10"> >100 passengers </div>

</div>
""")))}),format.raw/*133.2*/("""

"""))
      }
    }
  }

  def render(result:PassengersCountForm): play.twirl.api.HtmlFormat.Appendable = apply(result)

  def f:((PassengersCountForm) => play.twirl.api.HtmlFormat.Appendable) = (result) => apply(result)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Apr 03 16:33:34 IDT 2019
                  SOURCE: C:/Users/user/workspace/final project/FastLane/app/views/Visualizations/passengersCountResult.scala.html
                  HASH: e03de2f516fb4772d76ff9b8066b680559bcd1a8
                  MATRIX: 992->1|1116->30|1146->35|1193->74|1231->75|1259->77|1310->101|1338->102|1379->116|1534->245|1562->246|1601->258|1636->265|1665->266|1707->280|1863->409|1892->410|1931->422|1966->429|1995->430|2037->444|2193->573|2222->574|2259->584|2294->591|2323->592|2365->606|2521->735|2550->736|2587->746|2622->753|2651->754|2693->768|2849->897|2878->898|2915->908|2950->915|2979->916|3021->930|3177->1059|3206->1060|3243->1070|3278->1077|3307->1078|3349->1092|3505->1221|3534->1222|3571->1232|3606->1239|3635->1240|3677->1254|3833->1383|3862->1384|3899->1394|3934->1401|3963->1402|4005->1416|4161->1545|4190->1546|4227->1556|4263->1564|4292->1565|4334->1579|4489->1707|4518->1708|4551->1714|4580->1725|4618->1726|4647->1729|4661->1735|4702->1755|4724->1759|4762->1760|4795->1766|4970->1913|4999->1914|5032->1920|5240->2101|5268->2102|5333->2139|5362->2140|5399->2150|5447->2171|5475->2172|5522->2191|5551->2192|5618->2231|5647->2232|5705->2262|5734->2263|5770->2271|5799->2272|5840->2284|5870->2285|5977->2363|6007->2364|6037->2365|6067->2366|6097->2367|6130->2373|6184->2400|6199->2406|6233->2419|6296->2454|6325->2455|6362->2465|6403->2478|6432->2479|6474->2493|6573->2564|6602->2565|6644->2579|6730->2637|6759->2638|6812->2663|6841->2664|6883->2678|6979->2746|7008->2747|7060->2771|7089->2772|7131->2786|7272->2899|7301->2900|7339->2911|7368->2912|7403->2920|7431->2921|7466->2929|7536->2971|7565->2972|7602->2982|7848->3199|7878->3200|7916->3210|8011->3277|8040->3278|8076->3286|8216->3398|8245->3399|8317->3442|8347->3443|8385->3453|8748->3788|8777->3789|8803->3796|8842->3797|8872->3799|9374->4270
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|37->5|37->5|38->6|41->9|41->9|43->11|43->11|43->11|44->12|47->15|47->15|49->17|49->17|49->17|50->18|53->21|53->21|54->22|54->22|54->22|55->23|58->26|58->26|59->27|59->27|59->27|60->28|63->31|63->31|64->32|64->32|64->32|65->33|68->36|68->36|69->37|69->37|69->37|70->38|73->41|73->41|74->42|74->42|74->42|75->43|78->46|78->46|79->47|79->47|79->47|80->48|83->51|83->51|84->52|84->52|84->52|85->53|88->56|88->56|89->57|90->58|90->58|91->59|91->59|91->59|92->60|92->60|93->61|94->62|94->62|95->63|102->70|102->70|104->72|104->72|105->73|106->74|106->74|107->75|107->75|107->75|107->75|107->75|107->75|107->75|107->75|107->75|107->75|107->75|107->75|107->75|107->75|107->75|108->76|108->76|108->76|108->76|109->77|109->77|110->78|110->78|110->78|111->79|113->81|113->81|114->82|116->84|116->84|117->85|117->85|118->86|120->88|120->88|121->89|121->89|122->90|125->93|125->93|126->94|126->94|127->95|127->95|129->97|129->97|129->97|130->98|132->100|132->100|133->101|134->102|134->102|136->104|140->108|140->108|142->110|142->110|143->111|149->117|149->117|151->119|151->119|152->120|165->133
                  -- GENERATED --
              */
          