
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


Seq[Any](format.raw/*1.1*/("""<script type="text/javascript" src=""""),_display_(/*1.38*/routes/*1.44*/.Assets.versioned("demo-data/DemoData.js")),format.raw/*1.86*/(""""></script>
<script>

     var markers="""),format.raw/*4.18*/("""{"""),format.raw/*4.19*/("""}"""),format.raw/*4.20*/(""";
    mapboxgl.accessToken = 'pk.eyJ1IjoiYWh1dmlsIiwiYSI6ImNqcHdjdmN1bDA1bjY0OXVqb2pucWo5b2oifQ.DlCUMxPJ6c3TD2eLq3OCEQ';
    var map = new mapboxgl.Map("""),format.raw/*6.32*/("""{"""),format.raw/*6.33*/("""
        """),format.raw/*7.9*/("""container: 'map',
        style: 'mapbox://styles/mapbox/streets-v9',
        center: [34.798256,31.260114],
        zoom: 13,
        trackResize: true
    """),format.raw/*12.5*/("""}"""),format.raw/*12.6*/(""");

    map.on('load', function()"""),format.raw/*14.30*/("""{"""),format.raw/*14.31*/("""
        """),format.raw/*15.9*/("""update_label();
         addStations();
    """),format.raw/*17.5*/("""}"""),format.raw/*17.6*/(""");

    //add all stations to map
    function addStations() """),format.raw/*20.28*/("""{"""),format.raw/*20.29*/("""
        """),format.raw/*21.9*/("""map.addLayer("""),format.raw/*21.22*/("""{"""),format.raw/*21.23*/("""
            """),format.raw/*22.13*/(""""id": "stationsLayer",
            "type": "symbol",
            "source": """),format.raw/*24.23*/("""{"""),format.raw/*24.24*/("""
                """),format.raw/*25.17*/(""""type": "geojson",
                "data": JSON.parse(localStorage.getItem('stations').replace(/&quot;/g,'"'))
            """),format.raw/*27.13*/("""}"""),format.raw/*27.14*/(""",
            "layout": """),format.raw/*28.23*/("""{"""),format.raw/*28.24*/("""
                """),format.raw/*29.17*/(""""icon-image": "bus-15",
            """),format.raw/*30.13*/("""}"""),format.raw/*30.14*/("""
        """),format.raw/*31.9*/("""}"""),format.raw/*31.10*/(""")
    """),format.raw/*32.5*/("""}"""),format.raw/*32.6*/(""";

    //handle selection of area
    map.on('click',function(e)"""),format.raw/*35.31*/("""{"""),format.raw/*35.32*/("""
        """),format.raw/*36.9*/("""var coordinates = [e.lngLat.lng,e.lngLat.lat];
        if(!addCoordinate(coordinates,"coor1") && !addCoordinate(coordinates,"coor2"))"""),format.raw/*37.87*/("""{"""),format.raw/*37.88*/("""
            """),format.raw/*38.13*/("""alert("You have already choose 2 points");
            """),format.raw/*39.13*/("""}"""),format.raw/*39.14*/("""
    """),format.raw/*40.5*/("""}"""),format.raw/*40.6*/(""");

 function addCoordinate(coordinates,label)"""),format.raw/*42.43*/("""{"""),format.raw/*42.44*/("""
        """),format.raw/*43.9*/("""if(document.getElementById(label).value=="")"""),format.raw/*43.53*/("""{"""),format.raw/*43.54*/("""
            """),format.raw/*44.13*/("""document.getElementById(label).value = coordinates;
            var marker = new mapboxgl.Marker()
                .setLngLat(coordinates)
                .addTo(map);
            markers[label]=marker;
            return true;
        """),format.raw/*50.9*/("""}"""),format.raw/*50.10*/("""
        """),format.raw/*51.9*/("""else"""),format.raw/*51.13*/("""{"""),format.raw/*51.14*/("""
            """),format.raw/*52.13*/("""return false;
        """),format.raw/*53.9*/("""}"""),format.raw/*53.10*/("""
    """),format.raw/*54.5*/("""}"""),format.raw/*54.6*/("""

     """),format.raw/*56.6*/("""function removeCoordinates()"""),format.raw/*56.34*/("""{"""),format.raw/*56.35*/("""
        """),format.raw/*57.9*/("""document.getElementById("coor1").value = "";
        document.getElementById("coor2").value = "";
        if(markers["coor1"]!=undefined)"""),format.raw/*59.40*/("""{"""),format.raw/*59.41*/("""
            """),format.raw/*60.13*/("""markers["coor1"].remove();
            delete markers["coor1"];
        """),format.raw/*62.9*/("""}"""),format.raw/*62.10*/("""
        """),format.raw/*63.9*/("""if(markers["coor2"]!=undefined)"""),format.raw/*63.40*/("""{"""),format.raw/*63.41*/("""
            """),format.raw/*64.13*/("""markers["coor2"].remove();
            delete markers["coor2"];
        """),format.raw/*66.9*/("""}"""),format.raw/*66.10*/("""
    """),format.raw/*67.5*/("""}"""),format.raw/*67.6*/("""

    """),format.raw/*69.5*/("""function update_label()"""),format.raw/*69.28*/("""{"""),format.raw/*69.29*/("""
         """),format.raw/*70.10*/("""if(document.getElementById("coor1").value=="" && markers["coor1"]!=undefined)"""),format.raw/*70.87*/("""{"""),format.raw/*70.88*/("""
            """),format.raw/*71.13*/("""markers["coor1"].remove();
            delete markers["coor1"];
         """),format.raw/*73.10*/("""}"""),format.raw/*73.11*/("""
          """),format.raw/*74.11*/("""if(document.getElementById("coor2").value=="" && markers["coor2"]!=undefined)"""),format.raw/*74.88*/("""{"""),format.raw/*74.89*/("""
             """),format.raw/*75.14*/("""markers["coor2"].remove();
            delete markers["coor2"];
         """),format.raw/*77.10*/("""}"""),format.raw/*77.11*/("""
          """),format.raw/*78.11*/("""if(document.getElementById("coor1").value!="" )"""),format.raw/*78.58*/("""{"""),format.raw/*78.59*/("""

             """),format.raw/*80.14*/("""if(markers["coor1"]!=undefined)"""),format.raw/*80.45*/("""{"""),format.raw/*80.46*/("""
                """),format.raw/*81.17*/("""markers["coor1"].remove();
                delete markers["coor1"];
            """),format.raw/*83.13*/("""}"""),format.raw/*83.14*/("""

            """),format.raw/*85.13*/("""var coor_value=document.getElementById("coor1").value;
            var coor_arr=coor_value.split(",");
            var coor=new Array();
            coor[0]=coor_arr[0];
            coor[1]=coor_arr[1];
             var marker = new mapboxgl.Marker()
                .setLngLat(coor)
                .addTo(map);
            markers["coor1"]=marker;
         """),format.raw/*94.10*/("""}"""),format.raw/*94.11*/("""
          """),format.raw/*95.11*/("""if(document.getElementById("coor2").value!="")"""),format.raw/*95.57*/("""{"""),format.raw/*95.58*/("""
            """),format.raw/*96.13*/("""if(markers["coor2"]!=undefined)"""),format.raw/*96.44*/("""{"""),format.raw/*96.45*/("""
                """),format.raw/*97.17*/("""markers["coor2"].remove();
                delete markers["coor2"];
            """),format.raw/*99.13*/("""}"""),format.raw/*99.14*/("""

            """),format.raw/*101.13*/("""var coor_value=document.getElementById("coor2").value;
            var coor_arr=coor_value.split(",");
            var coor=new Array();
            coor[0]=coor_arr[0];
            coor[1]=coor_arr[1];
              var marker = new mapboxgl.Marker()
                .setLngLat(coor)
                .addTo(map);
             markers["coor2"]=marker;

         """),format.raw/*111.10*/("""}"""),format.raw/*111.11*/("""
    """),format.raw/*112.5*/("""}"""),format.raw/*112.6*/("""

    """),format.raw/*114.5*/("""function addNewLayerWithSelectedPoint(coordinates)"""),format.raw/*114.55*/("""{"""),format.raw/*114.56*/("""
        """),format.raw/*115.9*/("""map.addLayer("""),format.raw/*115.22*/("""{"""),format.raw/*115.23*/("""
            """),format.raw/*116.13*/(""""id": "point"+points.length,
            "type": "symbol",
            "source": """),format.raw/*118.23*/("""{"""),format.raw/*118.24*/("""
                """),format.raw/*119.17*/(""""type": "geojson",
                "data": """),format.raw/*120.25*/("""{"""),format.raw/*120.26*/("""
                    """),format.raw/*121.21*/(""""type": "FeatureCollection",
                    "features": ["""),format.raw/*122.34*/("""{"""),format.raw/*122.35*/("""
                        """),format.raw/*123.25*/(""""type": "Feature",
                        "geometry": """),format.raw/*124.37*/("""{"""),format.raw/*124.38*/("""
                            """),format.raw/*125.29*/(""""type": "Point",
                            "coordinates":coordinates
                        """),format.raw/*127.25*/("""}"""),format.raw/*127.26*/("""
                    """),format.raw/*128.21*/("""}"""),format.raw/*128.22*/("""]
                """),format.raw/*129.17*/("""}"""),format.raw/*129.18*/("""
            """),format.raw/*130.13*/("""}"""),format.raw/*130.14*/(""",
            "layout": """),format.raw/*131.23*/("""{"""),format.raw/*131.24*/("""
                """),format.raw/*132.17*/(""""icon-image": "monument",
                "icon-size": 0.25
            """),format.raw/*134.13*/("""}"""),format.raw/*134.14*/("""
        """),format.raw/*135.9*/("""}"""),format.raw/*135.10*/(""");
    """),format.raw/*136.5*/("""}"""),format.raw/*136.6*/("""

    """),format.raw/*138.5*/("""function addPopupOfSelectesPoint(coordinates)"""),format.raw/*138.50*/("""{"""),format.raw/*138.51*/("""
        """),format.raw/*139.9*/("""while (Math.abs(e.lngLat.lng - coordinates[0]) > 180) """),format.raw/*139.63*/("""{"""),format.raw/*139.64*/("""
            """),format.raw/*140.13*/("""coordinates[0] += e.lngLat.lng > coordinates[0] ? 360 : -360;
        """),format.raw/*141.9*/("""}"""),format.raw/*141.10*/("""

        """),format.raw/*143.9*/("""new mapboxgl.Popup()
            .setLngLat(coordinates)
            .setHTML(description)
            .addTo(map);
    """),format.raw/*147.5*/("""}"""),format.raw/*147.6*/("""
    """),format.raw/*148.5*/("""</script>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat May 25 19:10:53 IDT 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/app/views/visualizations/layouts/calculateMap.scala.html
                  HASH: 22cd9399777ac2817d2e460e2176967a4b747ab4
                  MATRIX: 1060->0|1123->37|1137->43|1199->85|1268->127|1296->128|1324->129|1505->283|1533->284|1569->294|1758->456|1786->457|1849->492|1878->493|1915->503|1988->549|2016->550|2108->614|2137->615|2174->625|2215->638|2244->639|2286->653|2391->730|2420->731|2466->749|2619->874|2648->875|2701->900|2730->901|2776->919|2841->956|2870->957|2907->967|2936->968|2970->975|2998->976|3093->1043|3122->1044|3159->1054|3321->1188|3350->1189|3392->1203|3476->1259|3505->1260|3538->1266|3566->1267|3642->1315|3671->1316|3708->1326|3780->1370|3809->1371|3851->1385|4120->1627|4149->1628|4186->1638|4218->1642|4247->1643|4289->1657|4339->1680|4368->1681|4401->1687|4429->1688|4465->1697|4521->1725|4550->1726|4587->1736|4754->1875|4783->1876|4825->1890|4926->1964|4955->1965|4992->1975|5051->2006|5080->2007|5122->2021|5223->2095|5252->2096|5285->2102|5313->2103|5348->2111|5399->2134|5428->2135|5467->2146|5572->2223|5601->2224|5643->2238|5746->2313|5775->2314|5815->2326|5920->2403|5949->2404|5992->2419|6095->2494|6124->2495|6164->2507|6239->2554|6268->2555|6313->2572|6372->2603|6401->2604|6447->2622|6557->2704|6586->2705|6630->2721|7026->3089|7055->3090|7095->3102|7169->3148|7198->3149|7240->3163|7299->3194|7328->3195|7374->3213|7484->3295|7513->3296|7558->3312|7959->3684|7989->3685|8023->3691|8052->3692|8088->3700|8167->3750|8197->3751|8235->3761|8277->3774|8307->3775|8350->3789|8462->3872|8492->3873|8539->3891|8612->3935|8642->3936|8693->3958|8785->4021|8815->4022|8870->4048|8955->4104|8985->4105|9044->4135|9170->4232|9200->4233|9251->4255|9281->4256|9329->4275|9359->4276|9402->4290|9432->4291|9486->4316|9516->4317|9563->4335|9666->4409|9696->4410|9734->4420|9764->4421|9800->4429|9829->4430|9865->4438|9939->4483|9969->4484|10007->4494|10090->4548|10120->4549|10163->4563|10262->4634|10292->4635|10332->4647|10484->4771|10513->4772|10547->4778
                  LINES: 33->1|33->1|33->1|33->1|36->4|36->4|36->4|38->6|38->6|39->7|44->12|44->12|46->14|46->14|47->15|49->17|49->17|52->20|52->20|53->21|53->21|53->21|54->22|56->24|56->24|57->25|59->27|59->27|60->28|60->28|61->29|62->30|62->30|63->31|63->31|64->32|64->32|67->35|67->35|68->36|69->37|69->37|70->38|71->39|71->39|72->40|72->40|74->42|74->42|75->43|75->43|75->43|76->44|82->50|82->50|83->51|83->51|83->51|84->52|85->53|85->53|86->54|86->54|88->56|88->56|88->56|89->57|91->59|91->59|92->60|94->62|94->62|95->63|95->63|95->63|96->64|98->66|98->66|99->67|99->67|101->69|101->69|101->69|102->70|102->70|102->70|103->71|105->73|105->73|106->74|106->74|106->74|107->75|109->77|109->77|110->78|110->78|110->78|112->80|112->80|112->80|113->81|115->83|115->83|117->85|126->94|126->94|127->95|127->95|127->95|128->96|128->96|128->96|129->97|131->99|131->99|133->101|143->111|143->111|144->112|144->112|146->114|146->114|146->114|147->115|147->115|147->115|148->116|150->118|150->118|151->119|152->120|152->120|153->121|154->122|154->122|155->123|156->124|156->124|157->125|159->127|159->127|160->128|160->128|161->129|161->129|162->130|162->130|163->131|163->131|164->132|166->134|166->134|167->135|167->135|168->136|168->136|170->138|170->138|170->138|171->139|171->139|171->139|172->140|173->141|173->141|175->143|179->147|179->147|180->148
                  -- GENERATED --
              */
          