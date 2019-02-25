
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
    mapboxgl.accessToken = 'pk.eyJ1IjoiYWh1dmlsIiwiYSI6ImNqcHdjdmN1bDA1bjY0OXVqb2pucWo5b2oifQ.DlCUMxPJ6c3TD2eLq3OCEQ';
    var map = new mapboxgl.Map("""),format.raw/*5.32*/("""{"""),format.raw/*5.33*/("""
        """),format.raw/*6.9*/("""container: 'map',
        style: 'mapbox://styles/mapbox/streets-v9',
        center: [34.798256,31.260114],
        zoom: 13,
        trackResize: true
    """),format.raw/*11.5*/("""}"""),format.raw/*11.6*/(""");

    map.on('load', function()"""),format.raw/*13.30*/("""{"""),format.raw/*13.31*/("""
        """),format.raw/*14.9*/("""addStations();
    """),format.raw/*15.5*/("""}"""),format.raw/*15.6*/(""");

    //add all stations to map
    function addStations() """),format.raw/*18.28*/("""{"""),format.raw/*18.29*/("""
        """),format.raw/*19.9*/("""map.addLayer("""),format.raw/*19.22*/("""{"""),format.raw/*19.23*/("""
            """),format.raw/*20.13*/(""""id": "stationsLayer",
            "type": "symbol",
            "source": """),format.raw/*22.23*/("""{"""),format.raw/*22.24*/("""
                """),format.raw/*23.17*/(""""type": "geojson",
                "data": stations
            """),format.raw/*25.13*/("""}"""),format.raw/*25.14*/(""",
            "layout": """),format.raw/*26.23*/("""{"""),format.raw/*26.24*/("""
                """),format.raw/*27.17*/(""""icon-image": "bus-15",
            """),format.raw/*28.13*/("""}"""),format.raw/*28.14*/("""
        """),format.raw/*29.9*/("""}"""),format.raw/*29.10*/(""")
    """),format.raw/*30.5*/("""}"""),format.raw/*30.6*/(""";

    //handle selection of area
    var points = [];
    map.on('click',function(e)"""),format.raw/*34.31*/("""{"""),format.raw/*34.32*/("""
        """),format.raw/*35.9*/("""if (points.length < 2) """),format.raw/*35.32*/("""{"""),format.raw/*35.33*/("""
            """),format.raw/*36.13*/("""var coordinates = [e.lngLat.lng,e.lngLat.lat];
            // var description = e.features[0].properties.name;
            //
            points.push(coordinates);
            var marker = new mapboxgl.Marker()
                .setLngLat(coordinates)
                .addTo(map);


        """),format.raw/*45.9*/("""}"""),format.raw/*45.10*/("""
        """),format.raw/*46.9*/("""else alert("You have already choose 2 points");
    """),format.raw/*47.5*/("""}"""),format.raw/*47.6*/(""");

    function addNewLayerWithSelectedPoint(coordinates)"""),format.raw/*49.55*/("""{"""),format.raw/*49.56*/("""
        """),format.raw/*50.9*/("""map.addLayer("""),format.raw/*50.22*/("""{"""),format.raw/*50.23*/("""
            """),format.raw/*51.13*/(""""id": "point"+points.length,
            "type": "symbol",
            "source": """),format.raw/*53.23*/("""{"""),format.raw/*53.24*/("""
                """),format.raw/*54.17*/(""""type": "geojson",
                "data": """),format.raw/*55.25*/("""{"""),format.raw/*55.26*/("""
                    """),format.raw/*56.21*/(""""type": "FeatureCollection",
                    "features": ["""),format.raw/*57.34*/("""{"""),format.raw/*57.35*/("""
                        """),format.raw/*58.25*/(""""type": "Feature",
                        "geometry": """),format.raw/*59.37*/("""{"""),format.raw/*59.38*/("""
                            """),format.raw/*60.29*/(""""type": "Point",
                            "coordinates":coordinates
                        """),format.raw/*62.25*/("""}"""),format.raw/*62.26*/("""
                    """),format.raw/*63.21*/("""}"""),format.raw/*63.22*/("""]
                """),format.raw/*64.17*/("""}"""),format.raw/*64.18*/("""
            """),format.raw/*65.13*/("""}"""),format.raw/*65.14*/(""",
            "layout": """),format.raw/*66.23*/("""{"""),format.raw/*66.24*/("""
                """),format.raw/*67.17*/(""""icon-image": "monument",
                "icon-size": 0.25
            """),format.raw/*69.13*/("""}"""),format.raw/*69.14*/("""
        """),format.raw/*70.9*/("""}"""),format.raw/*70.10*/(""");
    """),format.raw/*71.5*/("""}"""),format.raw/*71.6*/("""

    """),format.raw/*73.5*/("""function addPopupOfSelectesPoint(coordinates)"""),format.raw/*73.50*/("""{"""),format.raw/*73.51*/("""
        """),format.raw/*74.9*/("""while (Math.abs(e.lngLat.lng - coordinates[0]) > 180) """),format.raw/*74.63*/("""{"""),format.raw/*74.64*/("""
            """),format.raw/*75.13*/("""coordinates[0] += e.lngLat.lng > coordinates[0] ? 360 : -360;
        """),format.raw/*76.9*/("""}"""),format.raw/*76.10*/("""

        """),format.raw/*78.9*/("""new mapboxgl.Popup()
            .setLngLat(coordinates)
            .setHTML(description)
            .addTo(map);
    """),format.raw/*82.5*/("""}"""),format.raw/*82.6*/("""

    """),format.raw/*84.5*/("""</script>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Feb 25 09:35:43 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/app/views/Visualizations/calculateMap.scala.html
                  HASH: 8a60b233ab4490a81b3ba5ff528e1c4fdabdd32f
                  MATRIX: 1052->2|1115->39|1129->45|1191->87|1392->261|1420->262|1456->272|1645->434|1673->435|1736->470|1765->471|1802->481|1849->501|1877->502|1969->566|1998->567|2035->577|2076->590|2105->591|2147->605|2252->682|2281->683|2327->701|2421->767|2450->768|2503->793|2532->794|2578->812|2643->849|2672->850|2709->860|2738->861|2772->868|2800->869|2917->958|2946->959|2983->969|3034->992|3063->993|3105->1007|3431->1306|3460->1307|3497->1317|3577->1370|3605->1371|3693->1431|3722->1432|3759->1442|3800->1455|3829->1456|3871->1470|3982->1553|4011->1554|4057->1572|4129->1616|4158->1617|4208->1639|4299->1702|4328->1703|4382->1729|4466->1785|4495->1786|4553->1816|4678->1913|4707->1914|4757->1936|4786->1937|4833->1956|4862->1957|4904->1971|4933->1972|4986->1997|5015->1998|5061->2016|5163->2090|5192->2091|5229->2101|5258->2102|5293->2110|5321->2111|5356->2119|5429->2164|5458->2165|5495->2175|5577->2229|5606->2230|5648->2244|5746->2315|5775->2316|5814->2328|5965->2452|5993->2453|6028->2461
                  LINES: 33->2|33->2|33->2|33->2|36->5|36->5|37->6|42->11|42->11|44->13|44->13|45->14|46->15|46->15|49->18|49->18|50->19|50->19|50->19|51->20|53->22|53->22|54->23|56->25|56->25|57->26|57->26|58->27|59->28|59->28|60->29|60->29|61->30|61->30|65->34|65->34|66->35|66->35|66->35|67->36|76->45|76->45|77->46|78->47|78->47|80->49|80->49|81->50|81->50|81->50|82->51|84->53|84->53|85->54|86->55|86->55|87->56|88->57|88->57|89->58|90->59|90->59|91->60|93->62|93->62|94->63|94->63|95->64|95->64|96->65|96->65|97->66|97->66|98->67|100->69|100->69|101->70|101->70|102->71|102->71|104->73|104->73|104->73|105->74|105->74|105->74|106->75|107->76|107->76|109->78|113->82|113->82|115->84
                  -- GENERATED --
              */
          