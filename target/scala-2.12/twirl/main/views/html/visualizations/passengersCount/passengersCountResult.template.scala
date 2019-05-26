
package views.html.visualizations.passengersCount

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

"""),_display_(/*3.2*/visualizations/*3.16*/.layouts.resultLayout("Passengers count result")/*3.64*/{_display_(Seq[Any](format.raw/*3.65*/("""
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
"""),_display_(/*59.2*/result/*59.8*/.getParametersList()),format.raw/*59.28*/("""
""")))}/*60.2*/{_display_(Seq[Any](format.raw/*60.3*/("""
    """),format.raw/*61.5*/("""mapboxgl.accessToken = 'pk.eyJ1IjoiYWh1dmlsIiwiYSI6ImNqcHdjdmN1bDA1bjY0OXVqb2pucWo5b2oifQ.DlCUMxPJ6c3TD2eLq3OCEQ';
    var map = new mapboxgl.Map("""),format.raw/*62.32*/("""{"""),format.raw/*62.33*/("""
    """),format.raw/*63.5*/("""container: 'map',
    style: 'mapbox://styles/mapbox/light-v9',
    center: [34.798256,31.260114],
    zoom: 14,
    //maxZoom:15,
    //minZoom:13,
    // maxBounds: bounds
    """),format.raw/*70.5*/("""}"""),format.raw/*70.6*/(""");

    map.on('load', function () """),format.raw/*72.32*/("""{"""),format.raw/*72.33*/("""
        """),format.raw/*73.9*/("""addLoadLayer();
        addStations();
    """),format.raw/*75.5*/("""}"""),format.raw/*75.6*/(""");
    function addLoadLayer() """),format.raw/*76.29*/("""{"""),format.raw/*76.30*/("""
        """),format.raw/*77.9*/("""map.addLayer("""),format.raw/*77.22*/("""{"""),format.raw/*77.23*/("""
            """),format.raw/*78.13*/("""'id': 'loadLater',
            'type': 'line',
            'source': """),format.raw/*80.23*/("""{"""),format.raw/*80.24*/("""
            """),format.raw/*81.13*/("""'type': 'geojson',
            'data': JSON.parse('"""),_display_(/*82.34*/result/*82.40*/.getResultString()),format.raw/*82.58*/("""'.replace(/&quot;/g,'"'))
            """),format.raw/*83.13*/("""}"""),format.raw/*83.14*/(""",
            'layout': """),format.raw/*84.23*/("""{"""),format.raw/*84.24*/("""
            """),format.raw/*85.13*/("""'line-cap': 'round',
            'line-join': 'round'
            """),format.raw/*87.13*/("""}"""),format.raw/*87.14*/(""",
            'paint': """),format.raw/*88.22*/("""{"""),format.raw/*88.23*/("""
            """),format.raw/*89.13*/("""'line-color': '#ed6498',
            'line-width': 5,
            'line-opacity': ['get', 'load']
            """),format.raw/*92.13*/("""}"""),format.raw/*92.14*/(""",
        """),format.raw/*93.9*/("""}"""),format.raw/*93.10*/(""");
    """),format.raw/*94.5*/("""}"""),format.raw/*94.6*/("""

    """),format.raw/*96.5*/("""map.on('click','stationsLayer',function(e)"""),format.raw/*96.47*/("""{"""),format.raw/*96.48*/("""
        """),format.raw/*97.9*/("""var coordinates = e.features[0].geometry.coordinates.slice();
        var description  = e.features[0].properties.id+": "+e.features[0].properties.name;
        while (Math.abs(e.lngLat.lng - coordinates[0]) > 180) """),format.raw/*99.63*/("""{"""),format.raw/*99.64*/("""
        """),format.raw/*100.9*/("""coordinates[0] += e.lngLat.lng > coordinates[0] ? 360 : -360;
    """),format.raw/*101.5*/("""}"""),format.raw/*101.6*/("""

    """),format.raw/*103.5*/("""new mapboxgl.Popup()
        .setLngLat(coordinates)
        .setHTML(description)
        .addTo(map);
    """),format.raw/*107.5*/("""}"""),format.raw/*107.6*/(""");

    function addStations() """),format.raw/*109.28*/("""{"""),format.raw/*109.29*/("""
        """),format.raw/*110.9*/("""map.addLayer("""),format.raw/*110.22*/("""{"""),format.raw/*110.23*/("""
            """),format.raw/*111.13*/(""""id": "stationsLayer",
            "type": "symbol",
            "source": """),format.raw/*113.23*/("""{"""),format.raw/*113.24*/("""
                """),format.raw/*114.17*/(""""type": "geojson",
                "data": JSON.parse(localStorage.getItem('stations').replace(/&quot;/g,'"'))
            """),format.raw/*116.13*/("""}"""),format.raw/*116.14*/(""",
            "layout": """),format.raw/*117.23*/("""{"""),format.raw/*117.24*/("""
            """),format.raw/*118.13*/(""""icon-image": "bus-15",
        """),format.raw/*119.9*/("""}"""),format.raw/*119.10*/("""
        """),format.raw/*120.9*/("""}"""),format.raw/*120.10*/(""")
    """),format.raw/*121.5*/("""}"""),format.raw/*121.6*/(""";



""")))}/*125.2*/{_display_(Seq[Any](format.raw/*125.3*/("""
    """),format.raw/*126.5*/("""<div class="parameters" id="loadIndex">
    </div>

    <script type="text/javascript">
        addToLoadIndex();

        function addToLoadIndex()"""),format.raw/*132.34*/("""{"""),format.raw/*132.35*/("""
            """),format.raw/*133.13*/("""var myElement = document.getElementById("loadIndex");
            for (var i=1; i<=10; i++)"""),format.raw/*134.38*/("""{"""),format.raw/*134.39*/("""
                """),format.raw/*135.17*/("""var iDiv = document.createElement('div');
                iDiv.className = 'l'+i;
                iDiv.innerHTML += parseInt("""),_display_(/*137.45*/result/*137.51*/.getMinPassengersForPublicLane()),format.raw/*137.83*/("""/10*i) +" passengers";
                myElement.appendChild(iDiv);
            """),format.raw/*139.13*/("""}"""),format.raw/*139.14*/("""
        """),format.raw/*140.9*/("""}"""),format.raw/*140.10*/("""

        """),format.raw/*142.9*/("""function downloadCSV(args) """),format.raw/*142.36*/("""{"""),format.raw/*142.37*/("""
            """),format.raw/*143.13*/("""var data, filename, link;
            var newJson = [];
            var json = JSON.parse('"""),_display_(/*145.37*/result/*145.43*/.getResultString()),format.raw/*145.61*/("""'.replace(/&quot;/g,'"'));
            json["features"].forEach(line=>newJson.push(flatten(line)));

            var csv = convertArrayOfObjectsToCSV("""),format.raw/*148.50*/("""{"""),format.raw/*148.51*/("""
                """),format.raw/*149.17*/("""data: newJson
            """),format.raw/*150.13*/("""}"""),format.raw/*150.14*/(""");
            if (csv == null) return;

            filename = args.filename || 'export.csv';

            if (!csv.match(/^data:text\/csv/i)) """),format.raw/*155.49*/("""{"""),format.raw/*155.50*/("""
                """),format.raw/*156.17*/("""csv = 'data:text/csv;charset=utf-8,' + csv;
            """),format.raw/*157.13*/("""}"""),format.raw/*157.14*/("""
            """),format.raw/*158.13*/("""data = encodeURI(csv);

            link = document.createElement('a');
            link.setAttribute('href', data);
            link.setAttribute('download', filename);
            link.click();
        """),format.raw/*164.9*/("""}"""),format.raw/*164.10*/("""

    """),format.raw/*166.5*/("""</script>
""")))}),format.raw/*167.2*/("""

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
                  DATE: Sat May 25 19:10:53 IDT 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/app/views/visualizations/passengersCount/passengersCountResult.scala.html
                  HASH: 2db102dfdb19020a9a0ae9bdf5e13c5b19d13dec
                  MATRIX: 1008->1|1132->30|1162->35|1184->49|1240->97|1278->98|1306->100|1357->124|1385->125|1426->139|1581->268|1609->269|1648->281|1683->288|1712->289|1754->303|1910->432|1939->433|1978->445|2013->452|2042->453|2084->467|2240->596|2269->597|2306->607|2341->614|2370->615|2412->629|2568->758|2597->759|2634->769|2669->776|2698->777|2740->791|2896->920|2925->921|2962->931|2997->938|3026->939|3068->953|3224->1082|3253->1083|3290->1093|3325->1100|3354->1101|3396->1115|3552->1244|3581->1245|3618->1255|3653->1262|3682->1263|3724->1277|3880->1406|3909->1407|3946->1417|3981->1424|4010->1425|4052->1439|4208->1568|4237->1569|4274->1579|4310->1587|4339->1588|4381->1602|4536->1730|4565->1731|4598->1737|4627->1748|4665->1749|4694->1752|4708->1758|4749->1778|4770->1781|4808->1782|4841->1788|5016->1935|5045->1936|5078->1942|5290->2127|5318->2128|5383->2165|5412->2166|5449->2176|5521->2221|5549->2222|5609->2254|5638->2255|5675->2265|5716->2278|5745->2279|5787->2293|5886->2364|5915->2365|5957->2379|6037->2432|6052->2438|6091->2456|6158->2495|6187->2496|6240->2521|6269->2522|6311->2536|6407->2604|6436->2605|6488->2629|6517->2630|6559->2644|6700->2757|6729->2758|6767->2769|6796->2770|6831->2778|6859->2779|6894->2787|6964->2829|6993->2830|7030->2840|7275->3057|7304->3058|7342->3068|7437->3135|7466->3136|7502->3144|7642->3256|7671->3257|7733->3290|7763->3291|7801->3301|7843->3314|7873->3315|7916->3329|8022->3406|8052->3407|8099->3425|8253->3550|8283->3551|8337->3576|8367->3577|8410->3591|8471->3624|8501->3625|8539->3635|8569->3636|8604->3643|8633->3644|8662->3654|8701->3655|8735->3661|8918->3815|8948->3816|8991->3830|9112->3922|9142->3923|9189->3941|9345->4069|9361->4075|9415->4107|9526->4189|9556->4190|9594->4200|9624->4201|9664->4213|9720->4240|9750->4241|9793->4255|9915->4349|9931->4355|9971->4373|10153->4526|10183->4527|10230->4545|10286->4572|10316->4573|10494->4722|10524->4723|10571->4741|10657->4798|10687->4799|10730->4813|10968->5023|10998->5024|11034->5032|11077->5044
                  LINES: 28->1|33->1|35->3|35->3|35->3|35->3|36->4|37->5|37->5|38->6|41->9|41->9|43->11|43->11|43->11|44->12|47->15|47->15|49->17|49->17|49->17|50->18|53->21|53->21|54->22|54->22|54->22|55->23|58->26|58->26|59->27|59->27|59->27|60->28|63->31|63->31|64->32|64->32|64->32|65->33|68->36|68->36|69->37|69->37|69->37|70->38|73->41|73->41|74->42|74->42|74->42|75->43|78->46|78->46|79->47|79->47|79->47|80->48|83->51|83->51|84->52|84->52|84->52|85->53|88->56|88->56|89->57|90->58|90->58|91->59|91->59|91->59|92->60|92->60|93->61|94->62|94->62|95->63|102->70|102->70|104->72|104->72|105->73|107->75|107->75|108->76|108->76|109->77|109->77|109->77|110->78|112->80|112->80|113->81|114->82|114->82|114->82|115->83|115->83|116->84|116->84|117->85|119->87|119->87|120->88|120->88|121->89|124->92|124->92|125->93|125->93|126->94|126->94|128->96|128->96|128->96|129->97|131->99|131->99|132->100|133->101|133->101|135->103|139->107|139->107|141->109|141->109|142->110|142->110|142->110|143->111|145->113|145->113|146->114|148->116|148->116|149->117|149->117|150->118|151->119|151->119|152->120|152->120|153->121|153->121|157->125|157->125|158->126|164->132|164->132|165->133|166->134|166->134|167->135|169->137|169->137|169->137|171->139|171->139|172->140|172->140|174->142|174->142|174->142|175->143|177->145|177->145|177->145|180->148|180->148|181->149|182->150|182->150|187->155|187->155|188->156|189->157|189->157|190->158|196->164|196->164|198->166|199->167
                  -- GENERATED --
              */
          