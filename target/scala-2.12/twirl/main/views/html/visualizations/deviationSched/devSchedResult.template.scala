
package views.html.visualizations.deviationSched

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

object devSchedResult extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[DevSchedForm,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(result: DevSchedForm):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.24*/("""

"""),_display_(/*3.2*/visualizations/*3.16*/.layouts.resultLayout("Deviation in schedule visualization result")/*3.83*/{_display_(Seq[Any](format.raw/*3.84*/("""
"""),format.raw/*4.1*/("""<style>
        .marker """),format.raw/*5.17*/("""{"""),format.raw/*5.18*/("""
            """),format.raw/*6.13*/("""background-size: cover;
            cursor: pointer;
            width: 0;
            height: 0;
            border-top: 20px solid red;
            border-left: 20px solid transparent;

        """),format.raw/*13.9*/("""}"""),format.raw/*13.10*/("""
        """),format.raw/*14.9*/(""".mapboxgl-popup """),format.raw/*14.25*/("""{"""),format.raw/*14.26*/("""
            """),format.raw/*15.13*/("""max-width: 600px;
        """),format.raw/*16.9*/("""}"""),format.raw/*16.10*/("""
        """),format.raw/*17.9*/(""".mapboxgl-popup-content """),format.raw/*17.33*/("""{"""),format.raw/*17.34*/("""
            """),format.raw/*18.13*/("""text-align: center;
            font-family: 'Open Sans', sans-serif;

        """),format.raw/*21.9*/("""}"""),format.raw/*21.10*/("""
        """),format.raw/*22.9*/(""".marker2 """),format.raw/*22.18*/("""{"""),format.raw/*22.19*/("""
            """),format.raw/*23.13*/("""background-size: cover;
            cursor: pointer;
            width: 0;
            height: 0;
            border-bottom: 30px solid green;
            border-right: 30px solid transparent;

        """),format.raw/*30.9*/("""}"""),format.raw/*30.10*/("""







    """),format.raw/*38.5*/("""</style>
""")))}/*39.2*/{_display_(Seq[Any](format.raw/*39.3*/("""
"""),_display_(/*40.2*/result/*40.8*/.getParametersList()),format.raw/*40.28*/("""
""")))}/*41.2*/{_display_(Seq[Any](format.raw/*41.3*/("""
"""),format.raw/*42.1*/("""mapboxgl.accessToken = 'pk.eyJ1IjoiYWh1dmlsIiwiYSI6ImNqcHdjdmN1bDA1bjY0OXVqb2pucWo5b2oifQ.DlCUMxPJ6c3TD2eLq3OCEQ';
var map = new mapboxgl.Map("""),format.raw/*43.28*/("""{"""),format.raw/*43.29*/("""
"""),format.raw/*44.1*/("""container: 'map',
style: 'mapbox://styles/mapbox/streets-v9',
center: [34.798256,31.260114],
zoom: 13
"""),format.raw/*48.1*/("""}"""),format.raw/*48.2*/(""");



var geojson = JSON.parse('"""),_display_(/*52.28*/result/*52.34*/.getResultString()),format.raw/*52.52*/("""'.replace(/&quot;/g,'"'));


geojson.features.forEach(function(marker) """),format.raw/*55.43*/("""{"""),format.raw/*55.44*/("""


"""),format.raw/*58.1*/("""// create a HTML element for each feature
var el = document.createElement('div');
el.className = 'marker';

if(marker.properties[1].average >=20)"""),format.raw/*62.38*/("""{"""),format.raw/*62.39*/("""
"""),format.raw/*63.1*/("""var radius= 50;
"""),format.raw/*64.1*/("""}"""),format.raw/*64.2*/("""
"""),format.raw/*65.1*/("""else var radius=(marker.properties[1].average * 2.5);

el.style.borderTop= radius+'px solid red';
el.style.borderLeft=radius+'px solid transparent';

// make a marker for each feature and add to the map
new mapboxgl.Marker(el)
.setLngLat(marker.geometry.coordinates)
.setPopup(new mapboxgl.Popup("""),format.raw/*73.30*/("""{"""),format.raw/*73.31*/(""" """),format.raw/*73.32*/("""offset: 0"""),format.raw/*73.41*/("""}"""),format.raw/*73.42*/(""") // add popups
.setHTML('<h6> ' + 'Average preliminaries:' + marker.properties[0].average + '</h6><p>' +  marker.properties[0].description + '</p>'+
'<h6>' + 'Average lateness:' + marker.properties[1].average + '</h6><p>' + marker.properties[1].description + '</p>'
))
.addTo(map);



// create a HTML element for each feature
var el = document.createElement('div');
el.className = 'marker2';

if(marker.properties[0].average >=20)"""),format.raw/*85.38*/("""{"""),format.raw/*85.39*/("""
"""),format.raw/*86.1*/("""var radius= 50;
"""),format.raw/*87.1*/("""}"""),format.raw/*87.2*/("""
"""),format.raw/*88.1*/("""else var radius=(marker.properties[0].average * 2.5);

el.style.borderBottom= radius+'px solid green';
el.style.borderRight=radius+'px solid transparent';


// make a marker for each feature and add to the map
new mapboxgl.Marker(el)
.setLngLat(marker.geometry.coordinates)
.setPopup(new mapboxgl.Popup("""),format.raw/*97.30*/("""{"""),format.raw/*97.31*/(""" """),format.raw/*97.32*/("""offset: 0"""),format.raw/*97.41*/("""}"""),format.raw/*97.42*/(""") // add popups
.setHTML('<h6> ' + 'Average preliminaries: ' + marker.properties[0].average + '</h6><p>' +  marker.properties[0].description + '</p>'+
'<h6>' + 'Average lateness: ' + marker.properties[1].average + '</h6><p>' + marker.properties[1].description + '</p>'
))
.addTo(map);


"""),format.raw/*104.1*/("""}"""),format.raw/*104.2*/(""");

""")))}/*106.2*/{_display_(Seq[Any](format.raw/*106.3*/("""
"""),format.raw/*107.1*/("""<div class="parameters">
    <div class="l1"> Red triangular-</div>
    <div class="l1"> Average lateness </div>
    <div class="l1"> Green triangular- </div>
    <div class="l1"> Average preliminaries </div>
</div>




<!--TODO add index-->
<!--TODO adjust excel-->
<script type="text/javascript">

       function downloadCSV(args) """),format.raw/*121.35*/("""{"""),format.raw/*121.36*/("""
            """),format.raw/*122.13*/("""var data, filename, link;
            var newJson = [];
            var json = JSON.parse('"""),_display_(/*124.37*/result/*124.43*/.getResultString()),format.raw/*124.61*/("""'.replace(/&quot;/g,'"'));
            json["features"].forEach(line=>newJson.push(flatten(line)));

            var csv = convertArrayOfObjectsToCSV("""),format.raw/*127.50*/("""{"""),format.raw/*127.51*/("""
                """),format.raw/*128.17*/("""data: newJson
            """),format.raw/*129.13*/("""}"""),format.raw/*129.14*/(""");
            if (csv == null) return;

            filename = args.filename || 'export.csv';

            if (!csv.match(/^data:text\/csv/i)) """),format.raw/*134.49*/("""{"""),format.raw/*134.50*/("""
                """),format.raw/*135.17*/("""csv = 'data:text/csv;charset=utf-8,' + csv;
            """),format.raw/*136.13*/("""}"""),format.raw/*136.14*/("""
            """),format.raw/*137.13*/("""data = encodeURI(csv);

            link = document.createElement('a');
            link.setAttribute('href', data);
            link.setAttribute('download', filename);
            link.click();
        """),format.raw/*143.9*/("""}"""),format.raw/*143.10*/("""


    """),format.raw/*146.5*/("""</script>



""")))}),format.raw/*150.2*/("""


"""))
      }
    }
  }

  def render(result:DevSchedForm): play.twirl.api.HtmlFormat.Appendable = apply(result)

  def f:((DevSchedForm) => play.twirl.api.HtmlFormat.Appendable) = (result) => apply(result)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue May 21 20:43:40 IDT 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/app/views/visualizations/deviationSched/devSchedResult.scala.html
                  HASH: ee14244717d92943a94509cadfcbb50f4737b7ff
                  MATRIX: 993->1|1110->23|1140->28|1162->42|1237->109|1275->110|1303->112|1355->137|1383->138|1424->152|1654->355|1683->356|1720->366|1764->382|1793->383|1835->397|1889->424|1918->425|1955->435|2007->459|2036->460|2078->474|2187->556|2216->557|2253->567|2290->576|2319->577|2361->591|2597->800|2626->801|2673->821|2702->832|2740->833|2769->836|2783->842|2824->862|2845->865|2883->866|2912->868|3083->1011|3112->1012|3141->1014|3274->1120|3302->1121|3366->1158|3381->1164|3420->1182|3522->1256|3551->1257|3584->1263|3761->1412|3790->1413|3819->1415|3863->1432|3891->1433|3920->1435|4252->1739|4281->1740|4310->1741|4347->1750|4376->1751|4848->2195|4877->2196|4906->2198|4950->2215|4978->2216|5007->2218|5347->2530|5376->2531|5405->2532|5442->2541|5471->2542|5793->2836|5822->2837|5848->2844|5887->2845|5917->2847|6294->3195|6324->3196|6367->3210|6489->3304|6505->3310|6545->3328|6727->3481|6757->3482|6804->3500|6860->3527|6890->3528|7068->3677|7098->3678|7145->3696|7231->3753|7261->3754|7304->3768|7542->3978|7572->3979|7610->3989|7659->4007
                  LINES: 28->1|33->1|35->3|35->3|35->3|35->3|36->4|37->5|37->5|38->6|45->13|45->13|46->14|46->14|46->14|47->15|48->16|48->16|49->17|49->17|49->17|50->18|53->21|53->21|54->22|54->22|54->22|55->23|62->30|62->30|70->38|71->39|71->39|72->40|72->40|72->40|73->41|73->41|74->42|75->43|75->43|76->44|80->48|80->48|84->52|84->52|84->52|87->55|87->55|90->58|94->62|94->62|95->63|96->64|96->64|97->65|105->73|105->73|105->73|105->73|105->73|117->85|117->85|118->86|119->87|119->87|120->88|129->97|129->97|129->97|129->97|129->97|136->104|136->104|138->106|138->106|139->107|153->121|153->121|154->122|156->124|156->124|156->124|159->127|159->127|160->128|161->129|161->129|166->134|166->134|167->135|168->136|168->136|169->137|175->143|175->143|178->146|182->150
                  -- GENERATED --
              */
          