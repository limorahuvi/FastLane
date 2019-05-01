
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

object calculateMap extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!--TODO print stations id???-->
<script type="text/javascript" src=""""),_display_(/*2.38*/routes/*2.44*/.Assets.versioned("demo-data/DemoData.js")),format.raw/*2.86*/(""""></script>
<script>

     var markers="""),format.raw/*5.18*/("""{"""),format.raw/*5.19*/("""}"""),format.raw/*5.20*/(""";
    mapboxgl.accessToken = 'pk.eyJ1IjoiYWh1dmlsIiwiYSI6ImNqcHdjdmN1bDA1bjY0OXVqb2pucWo5b2oifQ.DlCUMxPJ6c3TD2eLq3OCEQ';
    var map = new mapboxgl.Map("""),format.raw/*7.32*/("""{"""),format.raw/*7.33*/("""
        """),format.raw/*8.9*/("""container: 'map',
        style: 'mapbox://styles/mapbox/streets-v9',
        center: [34.798256,31.260114],
        zoom: 13,
        trackResize: true
    """),format.raw/*13.5*/("""}"""),format.raw/*13.6*/(""");

    map.on('load', function()"""),format.raw/*15.30*/("""{"""),format.raw/*15.31*/("""
        """),format.raw/*16.9*/("""update_label();
         addStations();
    """),format.raw/*18.5*/("""}"""),format.raw/*18.6*/(""");

    //add all stations to map
    function addStations() """),format.raw/*21.28*/("""{"""),format.raw/*21.29*/("""
        """),format.raw/*22.9*/("""map.addLayer("""),format.raw/*22.22*/("""{"""),format.raw/*22.23*/("""
            """),format.raw/*23.13*/(""""id": "stationsLayer",
            "type": "symbol",
            "source": """),format.raw/*25.23*/("""{"""),format.raw/*25.24*/("""
                """),format.raw/*26.17*/(""""type": "geojson",
                "data": JSON.parse(localStorage.getItem('stations').replace(/&quot;/g,'"'))
            """),format.raw/*28.13*/("""}"""),format.raw/*28.14*/(""",
            "layout": """),format.raw/*29.23*/("""{"""),format.raw/*29.24*/("""
                """),format.raw/*30.17*/(""""icon-image": "bus-15",
            """),format.raw/*31.13*/("""}"""),format.raw/*31.14*/("""
        """),format.raw/*32.9*/("""}"""),format.raw/*32.10*/(""")
    """),format.raw/*33.5*/("""}"""),format.raw/*33.6*/(""";

    //handle selection of area
    map.on('click',function(e)"""),format.raw/*36.31*/("""{"""),format.raw/*36.32*/("""
        """),format.raw/*37.9*/("""var coordinates = [e.lngLat.lng,e.lngLat.lat];
        if(!addCoordinate(coordinates,"coor1") && !addCoordinate(coordinates,"coor2"))"""),format.raw/*38.87*/("""{"""),format.raw/*38.88*/("""
            """),format.raw/*39.13*/("""alert("You have already choose 2 points");
            """),format.raw/*40.13*/("""}"""),format.raw/*40.14*/("""
    """),format.raw/*41.5*/("""}"""),format.raw/*41.6*/(""");

 function addCoordinate(coordinates,label)"""),format.raw/*43.43*/("""{"""),format.raw/*43.44*/("""
        """),format.raw/*44.9*/("""if(document.getElementById(label).value=="")"""),format.raw/*44.53*/("""{"""),format.raw/*44.54*/("""
            """),format.raw/*45.13*/("""document.getElementById(label).value = coordinates;
            var marker = new mapboxgl.Marker()
                .setLngLat(coordinates)
                .addTo(map);
            markers[label]=marker;
            return true;
        """),format.raw/*51.9*/("""}"""),format.raw/*51.10*/("""
        """),format.raw/*52.9*/("""else"""),format.raw/*52.13*/("""{"""),format.raw/*52.14*/("""
            """),format.raw/*53.13*/("""return false;
        """),format.raw/*54.9*/("""}"""),format.raw/*54.10*/("""
    """),format.raw/*55.5*/("""}"""),format.raw/*55.6*/("""

     """),format.raw/*57.6*/("""function removeCoordinates()"""),format.raw/*57.34*/("""{"""),format.raw/*57.35*/("""
        """),format.raw/*58.9*/("""document.getElementById("coor1").value = "";
        document.getElementById("coor2").value = "";
        if(markers["coor1"]!=undefined)"""),format.raw/*60.40*/("""{"""),format.raw/*60.41*/("""
            """),format.raw/*61.13*/("""markers["coor1"].remove();
            delete markers["coor1"];
        """),format.raw/*63.9*/("""}"""),format.raw/*63.10*/("""
        """),format.raw/*64.9*/("""if(markers["coor2"]!=undefined)"""),format.raw/*64.40*/("""{"""),format.raw/*64.41*/("""
            """),format.raw/*65.13*/("""markers["coor2"].remove();
            delete markers["coor2"];
        """),format.raw/*67.9*/("""}"""),format.raw/*67.10*/("""
    """),format.raw/*68.5*/("""}"""),format.raw/*68.6*/("""

    """),format.raw/*70.5*/("""function update_label()"""),format.raw/*70.28*/("""{"""),format.raw/*70.29*/("""
         """),format.raw/*71.10*/("""if(document.getElementById("coor1").value=="" && markers["coor1"]!=undefined)"""),format.raw/*71.87*/("""{"""),format.raw/*71.88*/("""
            """),format.raw/*72.13*/("""markers["coor1"].remove();
            delete markers["coor1"];
         """),format.raw/*74.10*/("""}"""),format.raw/*74.11*/("""
          """),format.raw/*75.11*/("""if(document.getElementById("coor2").value=="" && markers["coor2"]!=undefined)"""),format.raw/*75.88*/("""{"""),format.raw/*75.89*/("""
             """),format.raw/*76.14*/("""markers["coor2"].remove();
            delete markers["coor2"];
         """),format.raw/*78.10*/("""}"""),format.raw/*78.11*/("""
          """),format.raw/*79.11*/("""if(document.getElementById("coor1").value!="" )"""),format.raw/*79.58*/("""{"""),format.raw/*79.59*/("""

             """),format.raw/*81.14*/("""if(markers["coor1"]!=undefined)"""),format.raw/*81.45*/("""{"""),format.raw/*81.46*/("""
                """),format.raw/*82.17*/("""markers["coor1"].remove();
                delete markers["coor1"];
            """),format.raw/*84.13*/("""}"""),format.raw/*84.14*/("""

            """),format.raw/*86.13*/("""var coor_value=document.getElementById("coor1").value;
            var coor_arr=coor_value.split(",");
            var coor=new Array();
            coor[0]=coor_arr[0];
            coor[1]=coor_arr[1];
             var marker = new mapboxgl.Marker()
                .setLngLat(coor)
                .addTo(map);
            markers["coor1"]=marker;
         """),format.raw/*95.10*/("""}"""),format.raw/*95.11*/("""
          """),format.raw/*96.11*/("""if(document.getElementById("coor2").value!="")"""),format.raw/*96.57*/("""{"""),format.raw/*96.58*/("""
            """),format.raw/*97.13*/("""if(markers["coor2"]!=undefined)"""),format.raw/*97.44*/("""{"""),format.raw/*97.45*/("""
                """),format.raw/*98.17*/("""markers["coor2"].remove();
                delete markers["coor2"];
            """),format.raw/*100.13*/("""}"""),format.raw/*100.14*/("""

            """),format.raw/*102.13*/("""var coor_value=document.getElementById("coor2").value;
            var coor_arr=coor_value.split(",");
            var coor=new Array();
            coor[0]=coor_arr[0];
            coor[1]=coor_arr[1];
              var marker = new mapboxgl.Marker()
                .setLngLat(coor)
                .addTo(map);
             markers["coor2"]=marker;

         """),format.raw/*112.10*/("""}"""),format.raw/*112.11*/("""
    """),format.raw/*113.5*/("""}"""),format.raw/*113.6*/("""

    """),format.raw/*115.5*/("""function addNewLayerWithSelectedPoint(coordinates)"""),format.raw/*115.55*/("""{"""),format.raw/*115.56*/("""
        """),format.raw/*116.9*/("""map.addLayer("""),format.raw/*116.22*/("""{"""),format.raw/*116.23*/("""
            """),format.raw/*117.13*/(""""id": "point"+points.length,
            "type": "symbol",
            "source": """),format.raw/*119.23*/("""{"""),format.raw/*119.24*/("""
                """),format.raw/*120.17*/(""""type": "geojson",
                "data": """),format.raw/*121.25*/("""{"""),format.raw/*121.26*/("""
                    """),format.raw/*122.21*/(""""type": "FeatureCollection",
                    "features": ["""),format.raw/*123.34*/("""{"""),format.raw/*123.35*/("""
                        """),format.raw/*124.25*/(""""type": "Feature",
                        "geometry": """),format.raw/*125.37*/("""{"""),format.raw/*125.38*/("""
                            """),format.raw/*126.29*/(""""type": "Point",
                            "coordinates":coordinates
                        """),format.raw/*128.25*/("""}"""),format.raw/*128.26*/("""
                    """),format.raw/*129.21*/("""}"""),format.raw/*129.22*/("""]
                """),format.raw/*130.17*/("""}"""),format.raw/*130.18*/("""
            """),format.raw/*131.13*/("""}"""),format.raw/*131.14*/(""",
            "layout": """),format.raw/*132.23*/("""{"""),format.raw/*132.24*/("""
                """),format.raw/*133.17*/(""""icon-image": "monument",
                "icon-size": 0.25
            """),format.raw/*135.13*/("""}"""),format.raw/*135.14*/("""
        """),format.raw/*136.9*/("""}"""),format.raw/*136.10*/(""");
    """),format.raw/*137.5*/("""}"""),format.raw/*137.6*/("""

    """),format.raw/*139.5*/("""function addPopupOfSelectesPoint(coordinates)"""),format.raw/*139.50*/("""{"""),format.raw/*139.51*/("""
        """),format.raw/*140.9*/("""while (Math.abs(e.lngLat.lng - coordinates[0]) > 180) """),format.raw/*140.63*/("""{"""),format.raw/*140.64*/("""
            """),format.raw/*141.13*/("""coordinates[0] += e.lngLat.lng > coordinates[0] ? 360 : -360;
        """),format.raw/*142.9*/("""}"""),format.raw/*142.10*/("""

        """),format.raw/*144.9*/("""new mapboxgl.Popup()
            .setLngLat(coordinates)
            .setHTML(description)
            .addTo(map);
    """),format.raw/*148.5*/("""}"""),format.raw/*148.6*/("""

    """),format.raw/*150.5*/("""</script>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Apr 30 19:36:04 IDT 2019
                  SOURCE: C:/Users/user/workspace/final project/FastLane/app/views/visualizations/layouts/calculateMap.scala.html
                  HASH: 7a73bb4a90db60cc5e8d32bc04007df02c1ad78a
                  MATRIX: 1060->0|1157->71|1171->77|1233->119|1302->161|1330->162|1358->163|1539->317|1567->318|1603->328|1792->490|1820->491|1883->526|1912->527|1949->537|2022->583|2050->584|2142->648|2171->649|2208->659|2249->672|2278->673|2320->687|2425->764|2454->765|2500->783|2653->908|2682->909|2735->934|2764->935|2810->953|2875->990|2904->991|2941->1001|2970->1002|3004->1009|3032->1010|3127->1077|3156->1078|3193->1088|3355->1222|3384->1223|3426->1237|3510->1293|3539->1294|3572->1300|3600->1301|3676->1349|3705->1350|3742->1360|3814->1404|3843->1405|3885->1419|4154->1661|4183->1662|4220->1672|4252->1676|4281->1677|4323->1691|4373->1714|4402->1715|4435->1721|4463->1722|4499->1731|4555->1759|4584->1760|4621->1770|4788->1909|4817->1910|4859->1924|4960->1998|4989->1999|5026->2009|5085->2040|5114->2041|5156->2055|5257->2129|5286->2130|5319->2136|5347->2137|5382->2145|5433->2168|5462->2169|5501->2180|5606->2257|5635->2258|5677->2272|5780->2347|5809->2348|5849->2360|5954->2437|5983->2438|6026->2453|6129->2528|6158->2529|6198->2541|6273->2588|6302->2589|6347->2606|6406->2637|6435->2638|6481->2656|6591->2738|6620->2739|6664->2755|7060->3123|7089->3124|7129->3136|7203->3182|7232->3183|7274->3197|7333->3228|7362->3229|7408->3247|7519->3329|7549->3330|7594->3346|7995->3718|8025->3719|8059->3725|8088->3726|8124->3734|8203->3784|8233->3785|8271->3795|8313->3808|8343->3809|8386->3823|8498->3906|8528->3907|8575->3925|8648->3969|8678->3970|8729->3992|8821->4055|8851->4056|8906->4082|8991->4138|9021->4139|9080->4169|9206->4266|9236->4267|9287->4289|9317->4290|9365->4309|9395->4310|9438->4324|9468->4325|9522->4350|9552->4351|9599->4369|9702->4443|9732->4444|9770->4454|9800->4455|9836->4463|9865->4464|9901->4472|9975->4517|10005->4518|10043->4528|10126->4582|10156->4583|10199->4597|10298->4668|10328->4669|10368->4681|10520->4805|10549->4806|10585->4814
                  LINES: 33->1|34->2|34->2|34->2|37->5|37->5|37->5|39->7|39->7|40->8|45->13|45->13|47->15|47->15|48->16|50->18|50->18|53->21|53->21|54->22|54->22|54->22|55->23|57->25|57->25|58->26|60->28|60->28|61->29|61->29|62->30|63->31|63->31|64->32|64->32|65->33|65->33|68->36|68->36|69->37|70->38|70->38|71->39|72->40|72->40|73->41|73->41|75->43|75->43|76->44|76->44|76->44|77->45|83->51|83->51|84->52|84->52|84->52|85->53|86->54|86->54|87->55|87->55|89->57|89->57|89->57|90->58|92->60|92->60|93->61|95->63|95->63|96->64|96->64|96->64|97->65|99->67|99->67|100->68|100->68|102->70|102->70|102->70|103->71|103->71|103->71|104->72|106->74|106->74|107->75|107->75|107->75|108->76|110->78|110->78|111->79|111->79|111->79|113->81|113->81|113->81|114->82|116->84|116->84|118->86|127->95|127->95|128->96|128->96|128->96|129->97|129->97|129->97|130->98|132->100|132->100|134->102|144->112|144->112|145->113|145->113|147->115|147->115|147->115|148->116|148->116|148->116|149->117|151->119|151->119|152->120|153->121|153->121|154->122|155->123|155->123|156->124|157->125|157->125|158->126|160->128|160->128|161->129|161->129|162->130|162->130|163->131|163->131|164->132|164->132|165->133|167->135|167->135|168->136|168->136|169->137|169->137|171->139|171->139|171->139|172->140|172->140|172->140|173->141|174->142|174->142|176->144|180->148|180->148|182->150
                  -- GENERATED --
              */
          