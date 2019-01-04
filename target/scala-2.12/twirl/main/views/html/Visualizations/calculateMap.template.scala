
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
        zoom: 13
    """),format.raw/*10.5*/("""}"""),format.raw/*10.6*/(""");

    map.on('load', function()"""),format.raw/*12.30*/("""{"""),format.raw/*12.31*/("""
        """),format.raw/*13.9*/("""addStations();
    """),format.raw/*14.5*/("""}"""),format.raw/*14.6*/(""");

    //add all stations to map
    function addStations() """),format.raw/*17.28*/("""{"""),format.raw/*17.29*/("""
        """),format.raw/*18.9*/("""map.addLayer("""),format.raw/*18.22*/("""{"""),format.raw/*18.23*/("""
            """),format.raw/*19.13*/(""""id": "stationsLayer",
            "type": "symbol",
            "source": """),format.raw/*21.23*/("""{"""),format.raw/*21.24*/("""
                """),format.raw/*22.17*/(""""type": "geojson",
                "data": stations
            """),format.raw/*24.13*/("""}"""),format.raw/*24.14*/(""",
            "layout": """),format.raw/*25.23*/("""{"""),format.raw/*25.24*/("""
                """),format.raw/*26.17*/(""""icon-image": "bus-15",
            """),format.raw/*27.13*/("""}"""),format.raw/*27.14*/("""
        """),format.raw/*28.9*/("""}"""),format.raw/*28.10*/(""")
    """),format.raw/*29.5*/("""}"""),format.raw/*29.6*/(""";

    //handle selection of area
    var points = [];
    map.on('click',function(e)"""),format.raw/*33.31*/("""{"""),format.raw/*33.32*/("""
        """),format.raw/*34.9*/("""if (points.length < 2) """),format.raw/*34.32*/("""{"""),format.raw/*34.33*/("""
            """),format.raw/*35.13*/("""var coordinates = [e.lngLat.lng,e.lngLat.lat];
            // var description = e.features[0].properties.name;
            //
            points.push(coordinates);
            var marker = new mapboxgl.Marker()
                .setLngLat(coordinates)
                .addTo(map);


        """),format.raw/*44.9*/("""}"""),format.raw/*44.10*/("""
        """),format.raw/*45.9*/("""else alert("You have already choose 2 points");
    """),format.raw/*46.5*/("""}"""),format.raw/*46.6*/(""");

    function addNewLayerWithSelectedPoint(coordinates)"""),format.raw/*48.55*/("""{"""),format.raw/*48.56*/("""
        """),format.raw/*49.9*/("""map.addLayer("""),format.raw/*49.22*/("""{"""),format.raw/*49.23*/("""
            """),format.raw/*50.13*/(""""id": "point"+points.length,
            "type": "symbol",
            "source": """),format.raw/*52.23*/("""{"""),format.raw/*52.24*/("""
                """),format.raw/*53.17*/(""""type": "geojson",
                "data": """),format.raw/*54.25*/("""{"""),format.raw/*54.26*/("""
                    """),format.raw/*55.21*/(""""type": "FeatureCollection",
                    "features": ["""),format.raw/*56.34*/("""{"""),format.raw/*56.35*/("""
                        """),format.raw/*57.25*/(""""type": "Feature",
                        "geometry": """),format.raw/*58.37*/("""{"""),format.raw/*58.38*/("""
                            """),format.raw/*59.29*/(""""type": "Point",
                            "coordinates":coordinates
                        """),format.raw/*61.25*/("""}"""),format.raw/*61.26*/("""
                    """),format.raw/*62.21*/("""}"""),format.raw/*62.22*/("""]
                """),format.raw/*63.17*/("""}"""),format.raw/*63.18*/("""
            """),format.raw/*64.13*/("""}"""),format.raw/*64.14*/(""",
            "layout": """),format.raw/*65.23*/("""{"""),format.raw/*65.24*/("""
                """),format.raw/*66.17*/(""""icon-image": "monument",
                "icon-size": 0.25
            """),format.raw/*68.13*/("""}"""),format.raw/*68.14*/("""
        """),format.raw/*69.9*/("""}"""),format.raw/*69.10*/(""");
    """),format.raw/*70.5*/("""}"""),format.raw/*70.6*/("""

    """),format.raw/*72.5*/("""function addPopupOfSelectesPoint(coordinates)"""),format.raw/*72.50*/("""{"""),format.raw/*72.51*/("""
        """),format.raw/*73.9*/("""while (Math.abs(e.lngLat.lng - coordinates[0]) > 180) """),format.raw/*73.63*/("""{"""),format.raw/*73.64*/("""
            """),format.raw/*74.13*/("""coordinates[0] += e.lngLat.lng > coordinates[0] ? 360 : -360;
        """),format.raw/*75.9*/("""}"""),format.raw/*75.10*/("""

        """),format.raw/*77.9*/("""new mapboxgl.Popup()
            .setLngLat(coordinates)
            .setHTML(description)
            .addTo(map);
    """),format.raw/*81.5*/("""}"""),format.raw/*81.6*/("""

    """),format.raw/*83.5*/("""</script>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Jan 04 18:14:29 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/play-java-seed/app/views/Visualizations/calculateMap.scala.html
                  HASH: d5123533a8bbeb15f3e51c675c268fa551ab8cf3
                  MATRIX: 1052->2|1115->39|1129->45|1191->87|1392->261|1420->262|1456->272|1617->406|1645->407|1708->442|1737->443|1774->453|1821->473|1849->474|1941->538|1970->539|2007->549|2048->562|2077->563|2119->577|2224->654|2253->655|2299->673|2393->739|2422->740|2475->765|2504->766|2550->784|2615->821|2644->822|2681->832|2710->833|2744->840|2772->841|2889->930|2918->931|2955->941|3006->964|3035->965|3077->979|3403->1278|3432->1279|3469->1289|3549->1342|3577->1343|3665->1403|3694->1404|3731->1414|3772->1427|3801->1428|3843->1442|3954->1525|3983->1526|4029->1544|4101->1588|4130->1589|4180->1611|4271->1674|4300->1675|4354->1701|4438->1757|4467->1758|4525->1788|4650->1885|4679->1886|4729->1908|4758->1909|4805->1928|4834->1929|4876->1943|4905->1944|4958->1969|4987->1970|5033->1988|5135->2062|5164->2063|5201->2073|5230->2074|5265->2082|5293->2083|5328->2091|5401->2136|5430->2137|5467->2147|5549->2201|5578->2202|5620->2216|5718->2287|5747->2288|5786->2300|5937->2424|5965->2425|6000->2433
                  LINES: 33->2|33->2|33->2|33->2|36->5|36->5|37->6|41->10|41->10|43->12|43->12|44->13|45->14|45->14|48->17|48->17|49->18|49->18|49->18|50->19|52->21|52->21|53->22|55->24|55->24|56->25|56->25|57->26|58->27|58->27|59->28|59->28|60->29|60->29|64->33|64->33|65->34|65->34|65->34|66->35|75->44|75->44|76->45|77->46|77->46|79->48|79->48|80->49|80->49|80->49|81->50|83->52|83->52|84->53|85->54|85->54|86->55|87->56|87->56|88->57|89->58|89->58|90->59|92->61|92->61|93->62|93->62|94->63|94->63|95->64|95->64|96->65|96->65|97->66|99->68|99->68|100->69|100->69|101->70|101->70|103->72|103->72|103->72|104->73|104->73|104->73|105->74|106->75|106->75|108->77|112->81|112->81|114->83
                  -- GENERATED --
              */
          