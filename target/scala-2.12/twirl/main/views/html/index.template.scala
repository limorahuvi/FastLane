
package views.html

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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(stations: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.20*/("""

"""),_display_(/*3.2*/main("Fast Lane")/*3.19*/ {_display_(Seq[Any](format.raw/*3.21*/("""
""")))}/*4.2*/{_display_(Seq[Any](format.raw/*4.3*/("""

"""),format.raw/*6.1*/("""<!-- Header -->
  <br></br>
<h1 align="center" style="color:#404040;"	><b>Welcome to Fast Lane!</b>
    <span align="right"><i class="fa fa-bus" style="font-size:50px;" ></i></span></h1>
<h2 align="center" style="color:#404040;"><b>Visualizing MOT Data</b></h2>
<p style="text-align:center; font-size:50px;"><img src=""""),_display_(/*11.58*/routes/*11.64*/.Assets.versioned("images/main.jpg")),format.raw/*11.100*/("""" ></p>
<script type="text/javascript">
    localStorage.setItem('stations','"""),_display_(/*13.39*/stations),format.raw/*13.47*/("""');
</script>
""")))}),format.raw/*15.2*/("""
"""))
      }
    }
  }

  def render(stations:String): play.twirl.api.HtmlFormat.Appendable = apply(stations)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (stations) => apply(stations)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat May 25 19:10:53 IDT 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/app/views/index.scala.html
                  HASH: 64e6141a981f359cba02c34ee41dab90148b4cfc
                  MATRIX: 948->1|1061->19|1091->24|1116->41|1155->43|1175->46|1212->47|1242->51|1593->375|1608->381|1666->417|1773->497|1802->505|1849->522
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|36->4|38->6|43->11|43->11|43->11|45->13|45->13|47->15
                  -- GENERATED --
              */
          