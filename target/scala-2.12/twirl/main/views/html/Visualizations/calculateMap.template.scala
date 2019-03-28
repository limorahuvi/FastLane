
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

object calculateMap extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<script type="text/javascript" src=""""),_display_(/*2.38*/routes/*2.44*/.Assets.versioned("demo-data/DemoData.js")),format.raw/*2.86*/(""""></script>
<script>
<!--TODO make map larger-->
    mapboxgl.accessToken = 'pk.eyJ1IjoiYWh1dmlsIiwiYSI6ImNqcHdjdmN1bDA1bjY0OXVqb2pucWo5b2oifQ.DlCUMxPJ6c3TD2eLq3OCEQ';
    var map = new mapboxgl.Map("""),format.raw/*6.32*/("""{"""),format.raw/*6.33*/("""
        """),format.raw/*7.9*/("""container: 'map',
        style: 'mapbox://styles/mapbox/streets-v9',
        center: [34.798256,31.260114],
        zoom: 13,
        trackResize: true
    """),format.raw/*12.5*/("""}"""),format.raw/*12.6*/(""");

    map.on('load', function()"""),format.raw/*14.30*/("""{"""),format.raw/*14.31*/("""
        """),format.raw/*15.9*/("""addStations();
    """),format.raw/*16.5*/("""}"""),format.raw/*16.6*/(""");
<!--TODO recieve stations from server-->
<!--TODO print stations id???-->
    //add all stations to map
    function addStations() """),format.raw/*20.28*/("""{"""),format.raw/*20.29*/("""
        """),format.raw/*21.9*/("""map.addLayer("""),format.raw/*21.22*/("""{"""),format.raw/*21.23*/("""
            """),format.raw/*22.13*/(""""id": "stationsLayer",
            "type": "symbol",
            "source": """),format.raw/*24.23*/("""{"""),format.raw/*24.24*/("""
                """),format.raw/*25.17*/(""""type": "geojson",
                "data": stations
            """),format.raw/*27.13*/("""}"""),format.raw/*27.14*/(""",
            "layout": """),format.raw/*28.23*/("""{"""),format.raw/*28.24*/("""
                """),format.raw/*29.17*/(""""icon-image": "bus-15",
            """),format.raw/*30.13*/("""}"""),format.raw/*30.14*/("""
        """),format.raw/*31.9*/("""}"""),format.raw/*31.10*/(""")
    """),format.raw/*32.5*/("""}"""),format.raw/*32.6*/(""";

    //handle selection of area
    var points = [];
    map.on('click',function(e)"""),format.raw/*36.31*/("""{"""),format.raw/*36.32*/("""
        """),format.raw/*37.9*/("""if (points.length < 2) """),format.raw/*37.32*/("""{"""),format.raw/*37.33*/("""
            """),format.raw/*38.13*/("""var coordinates = [e.lngLat.lng,e.lngLat.lat];
            // var description = e.features[0].properties.name;
            //
            points.push(coordinates);
            var marker = new mapboxgl.Marker()
                .setLngLat(coordinates)
                .addTo(map);


        """),format.raw/*47.9*/("""}"""),format.raw/*47.10*/("""
        """),format.raw/*48.9*/("""else alert("You have already choose 2 points");
    """),format.raw/*49.5*/("""}"""),format.raw/*49.6*/(""");

    function addNewLayerWithSelectedPoint(coordinates)"""),format.raw/*51.55*/("""{"""),format.raw/*51.56*/("""
        """),format.raw/*52.9*/("""map.addLayer("""),format.raw/*52.22*/("""{"""),format.raw/*52.23*/("""
            """),format.raw/*53.13*/(""""id": "point"+points.length,
            "type": "symbol",
            "source": """),format.raw/*55.23*/("""{"""),format.raw/*55.24*/("""
                """),format.raw/*56.17*/(""""type": "geojson",
                "data": """),format.raw/*57.25*/("""{"""),format.raw/*57.26*/("""
                    """),format.raw/*58.21*/(""""type": "FeatureCollection",
                    "features": ["""),format.raw/*59.34*/("""{"""),format.raw/*59.35*/("""
                        """),format.raw/*60.25*/(""""type": "Feature",
                        "geometry": """),format.raw/*61.37*/("""{"""),format.raw/*61.38*/("""
                            """),format.raw/*62.29*/(""""type": "Point",
                            "coordinates":coordinates
                        """),format.raw/*64.25*/("""}"""),format.raw/*64.26*/("""
                    """),format.raw/*65.21*/("""}"""),format.raw/*65.22*/("""]
                """),format.raw/*66.17*/("""}"""),format.raw/*66.18*/("""
            """),format.raw/*67.13*/("""}"""),format.raw/*67.14*/(""",
            "layout": """),format.raw/*68.23*/("""{"""),format.raw/*68.24*/("""
                """),format.raw/*69.17*/(""""icon-image": "monument",
                "icon-size": 0.25
            """),format.raw/*71.13*/("""}"""),format.raw/*71.14*/("""
        """),format.raw/*72.9*/("""}"""),format.raw/*72.10*/(""");
    """),format.raw/*73.5*/("""}"""),format.raw/*73.6*/("""

    """),format.raw/*75.5*/("""function addPopupOfSelectesPoint(coordinates)"""),format.raw/*75.50*/("""{"""),format.raw/*75.51*/("""
        """),format.raw/*76.9*/("""while (Math.abs(e.lngLat.lng - coordinates[0]) > 180) """),format.raw/*76.63*/("""{"""),format.raw/*76.64*/("""
            """),format.raw/*77.13*/("""coordinates[0] += e.lngLat.lng > coordinates[0] ? 360 : -360;
        """),format.raw/*78.9*/("""}"""),format.raw/*78.10*/("""

        """),format.raw/*80.9*/("""new mapboxgl.Popup()
            .setLngLat(coordinates)
            .setHTML(description)
            .addTo(map);
    """),format.raw/*84.5*/("""}"""),format.raw/*84.6*/("""

    """),format.raw/*86.5*/("""</script>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Mar 28 13:16:39 IST 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/FastLane/app/views/Visualizations/calculateMap.scala.html
                  HASH: bd203efc1000369653f50a6deff0e76a7b392005
                  MATRIX: 1052->2|1115->39|1129->45|1191->87|1421->290|1449->291|1485->301|1674->463|1702->464|1765->499|1794->500|1831->510|1878->530|1906->531|2072->669|2101->670|2138->680|2179->693|2208->694|2250->708|2355->785|2384->786|2430->804|2524->870|2553->871|2606->896|2635->897|2681->915|2746->952|2775->953|2812->963|2841->964|2875->971|2903->972|3020->1061|3049->1062|3086->1072|3137->1095|3166->1096|3208->1110|3534->1409|3563->1410|3600->1420|3680->1473|3708->1474|3796->1534|3825->1535|3862->1545|3903->1558|3932->1559|3974->1573|4085->1656|4114->1657|4160->1675|4232->1719|4261->1720|4311->1742|4402->1805|4431->1806|4485->1832|4569->1888|4598->1889|4656->1919|4781->2016|4810->2017|4860->2039|4889->2040|4936->2059|4965->2060|5007->2074|5036->2075|5089->2100|5118->2101|5164->2119|5266->2193|5295->2194|5332->2204|5361->2205|5396->2213|5424->2214|5459->2222|5532->2267|5561->2268|5598->2278|5680->2332|5709->2333|5751->2347|5849->2418|5878->2419|5917->2431|6068->2555|6096->2556|6131->2564
                  LINES: 33->2|33->2|33->2|33->2|37->6|37->6|38->7|43->12|43->12|45->14|45->14|46->15|47->16|47->16|51->20|51->20|52->21|52->21|52->21|53->22|55->24|55->24|56->25|58->27|58->27|59->28|59->28|60->29|61->30|61->30|62->31|62->31|63->32|63->32|67->36|67->36|68->37|68->37|68->37|69->38|78->47|78->47|79->48|80->49|80->49|82->51|82->51|83->52|83->52|83->52|84->53|86->55|86->55|87->56|88->57|88->57|89->58|90->59|90->59|91->60|92->61|92->61|93->62|95->64|95->64|96->65|96->65|97->66|97->66|98->67|98->67|99->68|99->68|100->69|102->71|102->71|103->72|103->72|104->73|104->73|106->75|106->75|106->75|107->76|107->76|107->76|108->77|109->78|109->78|111->80|115->84|115->84|117->86
                  -- GENERATED --
              */
          