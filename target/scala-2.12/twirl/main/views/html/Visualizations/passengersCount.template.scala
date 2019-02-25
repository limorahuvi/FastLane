
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

object passengersCount extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/calculateDataLayout("Passengers Count")/*3.41*/{_display_(Seq[Any](format.raw/*3.42*/("""
    """),format.raw/*4.5*/("""<h4>Passengers count visualization description</h4>
""")))}/*5.2*/{_display_(Seq[Any](format.raw/*5.3*/("""
"""),format.raw/*6.1*/("""Day of the week:</br>
<select id="days">
    <option value="Sunday">Sunday</option>
    <option value="Monday">Monday</option>
    <option value="Tuesday">Tuesday</option>
    <option value="Wednesday">Wednesday</option>
    <option value="Thursday">Thursday</option>
    <option value="Friday">Friday</option>
    <option value="Saturday">Saturday</option>
</select>
</br></br>
Hour of the day:</br>
<select id="hours">
    <option value="h0">00:00-00:59</option>
    <option value="h1">01:00-01:59</option>
    <option value="h2">02:00-02:59</option>
    <option value="h3">03:00-03:59</option>
    <option value="h4">04:00-04:59</option>
    <option value="h5">05:00-05:59</option>
    <option value="h6">06:00-06:59</option>
    <option value="h7">07:00-07:59</option>
    <option value="h8">08:00-08:59</option>
    <option value="h9">09:00-09:59</option>
    <option value="h10">10:00-10:59</option>
    <option value="h11">11:00-11:59</option>
    <option value="h12">12:00-12:59</option>
    <option value="h13">13:00-13:59</option>
    <option value="h14">14:00-14:59</option>
    <option value="h15">15:00-15:59</option>
    <option value="h16">16:00-16:59</option>
    <option value="h17">17:00-17:59</option>
    <option value="h18">18:00-18:59</option>
    <option value="h19">19:00-19:59</option>
    <option value="h20">20:00-20:59</option>
    <option value="h21">21:00-21:59</option>
    <option value="h22">22:00-22:59</option>
    <option value="h23">23:00-23:59</option>
</select>
</br></br>
Minimum for public lane:</br>
<input type="number" name="min" value="100">
</br>
</br>
</br>
<button type="button" onclick=calculate()>Calculate</button>

<script>
    var d, h, m;
    document.getElementById("days").onchange = function() """),format.raw/*54.59*/("""{"""),format.raw/*54.60*/("""
        """),format.raw/*55.9*/("""if (this.selectedIndex!==0) """),format.raw/*55.37*/("""{"""),format.raw/*55.38*/("""
            """),format.raw/*56.13*/("""d = this.value;
        """),format.raw/*57.9*/("""}"""),format.raw/*57.10*/("""
    """),format.raw/*58.5*/("""}"""),format.raw/*58.6*/(""";
    function calculate()"""),format.raw/*59.25*/("""{"""),format.raw/*59.26*/("""
        """),format.raw/*60.9*/("""window.location.href="""),_display_(/*60.31*/routes/*60.37*/.VisualizationController.calculatePassengersCount(d)),format.raw/*60.89*/(""";
    """),format.raw/*61.5*/("""}"""),format.raw/*61.6*/("""
"""),format.raw/*62.1*/("""</script>
""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Feb 25 12:55:35 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/app/views/Visualizations/passengersCount.scala.html
                  HASH: 81ff132e3da64ddcdb946df794c82d19a08614ae
                  MATRIX: 966->1|1062->3|1092->8|1139->47|1177->48|1209->54|1280->108|1317->109|1345->111|3172->1910|3201->1911|3238->1921|3294->1949|3323->1950|3365->1964|3417->1989|3446->1990|3479->1996|3507->1997|3562->2024|3591->2025|3628->2035|3677->2057|3692->2063|3765->2115|3799->2122|3827->2123|3856->2125
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|37->5|37->5|38->6|86->54|86->54|87->55|87->55|87->55|88->56|89->57|89->57|90->58|90->58|91->59|91->59|92->60|92->60|92->60|92->60|93->61|93->61|94->62
                  -- GENERATED --
              */
          