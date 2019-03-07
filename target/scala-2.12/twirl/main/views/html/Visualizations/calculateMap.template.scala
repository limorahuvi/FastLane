
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


Seq[Any](format.raw/*1.1*/("""<!--TODO receive stations from server-->
<!--TODO print stations id???-->
<script type="text/javascript" src=""""),_display_(/*3.38*/routes/*3.44*/.Assets.versioned("demo-data/DemoData.js")),format.raw/*3.86*/(""""></script>
<script>
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

    //add all stations to map
    function addStations() """),format.raw/*19.28*/("""{"""),format.raw/*19.29*/("""
        """),format.raw/*20.9*/("""map.addLayer("""),format.raw/*20.22*/("""{"""),format.raw/*20.23*/("""
            """),format.raw/*21.13*/(""""id": "stationsLayer",
            "type": "symbol",
            "source": """),format.raw/*23.23*/("""{"""),format.raw/*23.24*/("""
                """),format.raw/*24.17*/(""""type": "geojson",
                "data": stations
            """),format.raw/*26.13*/("""}"""),format.raw/*26.14*/(""",
            "layout": """),format.raw/*27.23*/("""{"""),format.raw/*27.24*/("""
                """),format.raw/*28.17*/(""""icon-image": "bus-15",
            """),format.raw/*29.13*/("""}"""),format.raw/*29.14*/("""
        """),format.raw/*30.9*/("""}"""),format.raw/*30.10*/(""")
    """),format.raw/*31.5*/("""}"""),format.raw/*31.6*/(""";

    //handle selection of area
    var points = [];
    map.on('click',function(e)"""),format.raw/*35.31*/("""{"""),format.raw/*35.32*/("""
        """),format.raw/*36.9*/("""if (points.length < 2) """),format.raw/*36.32*/("""{"""),format.raw/*36.33*/("""
            """),format.raw/*37.13*/("""var coordinates = [e.lngLat.lng,e.lngLat.lat];
            // var description = e.features[0].properties.name;
            //
            points.push(coordinates);
            var marker = new mapboxgl.Marker()
                .setLngLat(coordinates)
                .addTo(map);


        """),format.raw/*46.9*/("""}"""),format.raw/*46.10*/("""
        """),format.raw/*47.9*/("""else alert("You have already choose 2 points");
    """),format.raw/*48.5*/("""}"""),format.raw/*48.6*/(""");

    function addNewLayerWithSelectedPoint(coordinates)"""),format.raw/*50.55*/("""{"""),format.raw/*50.56*/("""
        """),format.raw/*51.9*/("""map.addLayer("""),format.raw/*51.22*/("""{"""),format.raw/*51.23*/("""
            """),format.raw/*52.13*/(""""id": "point"+points.length,
            "type": "symbol",
            "source": """),format.raw/*54.23*/("""{"""),format.raw/*54.24*/("""
                """),format.raw/*55.17*/(""""type": "geojson",
                "data": """),format.raw/*56.25*/("""{"""),format.raw/*56.26*/("""
                    """),format.raw/*57.21*/(""""type": "FeatureCollection",
                    "features": ["""),format.raw/*58.34*/("""{"""),format.raw/*58.35*/("""
                        """),format.raw/*59.25*/(""""type": "Feature",
                        "geometry": """),format.raw/*60.37*/("""{"""),format.raw/*60.38*/("""
                            """),format.raw/*61.29*/(""""type": "Point",
                            "coordinates":coordinates
                        """),format.raw/*63.25*/("""}"""),format.raw/*63.26*/("""
                    """),format.raw/*64.21*/("""}"""),format.raw/*64.22*/("""]
                """),format.raw/*65.17*/("""}"""),format.raw/*65.18*/("""
            """),format.raw/*66.13*/("""}"""),format.raw/*66.14*/(""",
            "layout": """),format.raw/*67.23*/("""{"""),format.raw/*67.24*/("""
                """),format.raw/*68.17*/(""""icon-image": "monument",
                "icon-size": 0.25
            """),format.raw/*70.13*/("""}"""),format.raw/*70.14*/("""
        """),format.raw/*71.9*/("""}"""),format.raw/*71.10*/(""");
    """),format.raw/*72.5*/("""}"""),format.raw/*72.6*/("""

    """),format.raw/*74.5*/("""function addPopupOfSelectesPoint(coordinates)"""),format.raw/*74.50*/("""{"""),format.raw/*74.51*/("""
        """),format.raw/*75.9*/("""while (Math.abs(e.lngLat.lng - coordinates[0]) > 180) """),format.raw/*75.63*/("""{"""),format.raw/*75.64*/("""
            """),format.raw/*76.13*/("""coordinates[0] += e.lngLat.lng > coordinates[0] ? 360 : -360;
        """),format.raw/*77.9*/("""}"""),format.raw/*77.10*/("""

        """),format.raw/*79.9*/("""new mapboxgl.Popup()
            .setLngLat(coordinates)
            .setHTML(description)
            .addTo(map);
    """),format.raw/*83.5*/("""}"""),format.raw/*83.6*/("""

    """),format.raw/*85.5*/("""</script>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Mar 07 13:14:38 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/app/views/Visualizations/calculateMap.scala.html
                  HASH: 7e254ccad39d5ed21d3107e2469102bb33060497
                  MATRIX: 1052->0|1191->113|1205->119|1267->161|1468->335|1496->336|1532->346|1721->508|1749->509|1812->544|1841->545|1878->555|1925->575|1953->576|2045->640|2074->641|2111->651|2152->664|2181->665|2223->679|2328->756|2357->757|2403->775|2497->841|2526->842|2579->867|2608->868|2654->886|2719->923|2748->924|2785->934|2814->935|2848->942|2876->943|2993->1032|3022->1033|3059->1043|3110->1066|3139->1067|3181->1081|3507->1380|3536->1381|3573->1391|3653->1444|3681->1445|3769->1505|3798->1506|3835->1516|3876->1529|3905->1530|3947->1544|4058->1627|4087->1628|4133->1646|4205->1690|4234->1691|4284->1713|4375->1776|4404->1777|4458->1803|4542->1859|4571->1860|4629->1890|4754->1987|4783->1988|4833->2010|4862->2011|4909->2030|4938->2031|4980->2045|5009->2046|5062->2071|5091->2072|5137->2090|5239->2164|5268->2165|5305->2175|5334->2176|5369->2184|5397->2185|5432->2193|5505->2238|5534->2239|5571->2249|5653->2303|5682->2304|5724->2318|5822->2389|5851->2390|5890->2402|6041->2526|6069->2527|6104->2535
                  LINES: 33->1|35->3|35->3|35->3|38->6|38->6|39->7|44->12|44->12|46->14|46->14|47->15|48->16|48->16|51->19|51->19|52->20|52->20|52->20|53->21|55->23|55->23|56->24|58->26|58->26|59->27|59->27|60->28|61->29|61->29|62->30|62->30|63->31|63->31|67->35|67->35|68->36|68->36|68->36|69->37|78->46|78->46|79->47|80->48|80->48|82->50|82->50|83->51|83->51|83->51|84->52|86->54|86->54|87->55|88->56|88->56|89->57|90->58|90->58|91->59|92->60|92->60|93->61|95->63|95->63|96->64|96->64|97->65|97->65|98->66|98->66|99->67|99->67|100->68|102->70|102->70|103->71|103->71|104->72|104->72|106->74|106->74|106->74|107->75|107->75|107->75|108->76|109->77|109->77|111->79|115->83|115->83|117->85
                  -- GENERATED --
              */
          