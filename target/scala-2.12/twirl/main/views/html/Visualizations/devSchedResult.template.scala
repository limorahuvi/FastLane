
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

object devSchedResult extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[DevSchedForm,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(result: DevSchedForm):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.24*/("""

"""),_display_(/*3.2*/resultLayout("Deviation in schedule visualization result")/*3.60*/{_display_(Seq[Any](format.raw/*3.61*/("""
"""),format.raw/*4.1*/("""<style>

        .marker """),format.raw/*6.17*/("""{"""),format.raw/*6.18*/("""
            """),format.raw/*7.13*/("""background-size: cover;
            cursor: pointer;
            width: 0;
            height: 0;
            border-top: 20px solid red;
            border-left: 20px solid transparent;

        """),format.raw/*14.9*/("""}"""),format.raw/*14.10*/("""
        """),format.raw/*15.9*/(""".mapboxgl-popup """),format.raw/*15.25*/("""{"""),format.raw/*15.26*/("""
            """),format.raw/*16.13*/("""max-width: 200px;
        """),format.raw/*17.9*/("""}"""),format.raw/*17.10*/("""
        """),format.raw/*18.9*/(""".mapboxgl-popup-content """),format.raw/*18.33*/("""{"""),format.raw/*18.34*/("""
            """),format.raw/*19.13*/("""text-align: center;
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
    """),format.raw/*31.5*/("""</style>
""")))}/*32.2*/{_display_(Seq[Any](format.raw/*32.3*/("""
"""),_display_(/*33.2*/result/*33.8*/.getParametersList()),format.raw/*33.28*/(""";
""")))}/*34.2*/{_display_(Seq[Any](format.raw/*34.3*/("""
"""),format.raw/*35.1*/("""mapboxgl.accessToken = 'pk.eyJ1IjoiYWh1dmlsIiwiYSI6ImNqcHdjdmN1bDA1bjY0OXVqb2pucWo5b2oifQ.DlCUMxPJ6c3TD2eLq3OCEQ';
var map = new mapboxgl.Map("""),format.raw/*36.28*/("""{"""),format.raw/*36.29*/("""
"""),format.raw/*37.1*/("""container: 'map',
style: 'mapbox://styles/mapbox/streets-v9',
center: [34.798256,31.260114],
zoom: 13
"""),format.raw/*41.1*/("""}"""),format.raw/*41.2*/(""");

var index=0;
// add markers to map
geojson.features.forEach(function(marker) """),format.raw/*45.43*/("""{"""),format.raw/*45.44*/("""

"""),format.raw/*47.1*/("""// create a HTML element for each feature
var el = document.createElement('div');
el.className = 'marker';

var radius=(marker.properties.average * 10);
el.style.borderTop= radius+'px solid red';
el.style.borderLeft=radius+'px solid transparent';

// make a marker for each feature and add to the map
new mapboxgl.Marker(el)
.setLngLat(marker.geometry.coordinates)
.setPopup(new mapboxgl.Popup("""),format.raw/*58.30*/("""{"""),format.raw/*58.31*/(""" """),format.raw/*58.32*/("""offset: 0"""),format.raw/*58.41*/("""}"""),format.raw/*58.42*/(""") // add popups
.setHTML('<h3> ' + 'Average preliminaries:' + geojson2.features[index].properties.average + '</h3><p>' + geojson2.features[index].properties.description + '</p>'+
'<h3>' + 'Average lateness:' + marker.properties.average + '</h3><p>' + marker.properties.description + '</p>'
))
.addTo(map);
index++;
"""),format.raw/*64.1*/("""}"""),format.raw/*64.2*/(""");

var index=0;
geojson2.features.forEach(function(marker2) """),format.raw/*67.45*/("""{"""),format.raw/*67.46*/("""


"""),format.raw/*70.1*/("""// create a HTML element for each feature
var el = document.createElement('div');
el.className = 'marker2';

var radius=(marker2.properties.average * 10);
el.style.borderBottom= radius+'px solid green';
el.style.borderRight=radius+'px solid transparent';


// make a marker for each feature and add to the map
new mapboxgl.Marker(el)
.setLngLat(marker2.geometry.coordinates)
.setPopup(new mapboxgl.Popup("""),format.raw/*82.30*/("""{"""),format.raw/*82.31*/(""" """),format.raw/*82.32*/("""offset: 0"""),format.raw/*82.41*/("""}"""),format.raw/*82.42*/(""") // add popups
.setHTML('<h3> ' + 'Average preliminaries:' + marker2.properties.average + '</h3><p>' + marker2.properties.description + '</p>'+
'<h3>' + 'Average lateness:' + geojson.features[index].properties.average + '</h3><p>' + geojson.features[index].properties.description + '</p>'
))
.addTo(map);
index++;
"""),format.raw/*88.1*/("""}"""),format.raw/*88.2*/(""");

""")))}/*90.2*/{_display_(Seq[Any](format.raw/*90.3*/("""

""")))}),format.raw/*92.2*/("""

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
                  DATE: Thu Mar 07 21:40:42 IST 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/FastLane/app/views/Visualizations/devSchedResult.scala.html
                  HASH: 00e9294080bf04f2c5b77aa797bc9440dd54f93b
                  MATRIX: 978->1|1095->23|1125->28|1191->86|1229->87|1257->89|1311->116|1339->117|1380->131|1610->334|1639->335|1676->345|1720->361|1749->362|1791->376|1845->403|1874->404|1911->414|1963->438|1992->439|2034->453|2141->533|2170->534|2207->544|2244->553|2273->554|2315->568|2551->777|2580->778|2613->784|2642->795|2680->796|2709->799|2723->805|2764->825|2786->829|2824->830|2853->832|3024->975|3053->976|3082->978|3215->1084|3243->1085|3356->1170|3385->1171|3416->1175|3849->1580|3878->1581|3907->1582|3944->1591|3973->1592|4321->1913|4349->1914|4441->1978|4470->1979|4503->1985|4947->2401|4976->2402|5005->2403|5042->2412|5071->2413|5419->2734|5447->2735|5472->2742|5510->2743|5545->2748
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|38->6|38->6|39->7|46->14|46->14|47->15|47->15|47->15|48->16|49->17|49->17|50->18|50->18|50->18|51->19|53->21|53->21|54->22|54->22|54->22|55->23|62->30|62->30|63->31|64->32|64->32|65->33|65->33|65->33|66->34|66->34|67->35|68->36|68->36|69->37|73->41|73->41|77->45|77->45|79->47|90->58|90->58|90->58|90->58|90->58|96->64|96->64|99->67|99->67|102->70|114->82|114->82|114->82|114->82|114->82|120->88|120->88|122->90|122->90|124->92
                  -- GENERATED --
              */
          