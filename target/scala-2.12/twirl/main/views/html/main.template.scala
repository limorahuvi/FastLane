
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(headers: Html)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.47*/("""

"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*12.62*/("""
        """),format.raw/*13.9*/("""<title>"""),_display_(/*13.17*/title),format.raw/*13.22*/("""</title>
        """),_display_(/*14.10*/imports/*14.17*/.design()),format.raw/*14.26*/("""
        """),_display_(/*15.10*/headers),format.raw/*15.17*/("""
    """),format.raw/*16.5*/("""</head>
    <body>
        """),_display_(/*18.10*/navigationbar()),format.raw/*18.25*/("""
        """),format.raw/*20.32*/("""
        """),_display_(/*21.10*/content),format.raw/*21.17*/("""


    """),format.raw/*24.5*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,headers:Html,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(headers)(content)

  def f:((String) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (headers) => (content) => apply(title)(headers)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Mar 16 22:13:10 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/app/views/main.scala.html
                  HASH: 76585c04947027ab66017f56dd01e7084c61b53c
                  MATRIX: 1216->266|1356->311|1386->315|1469->423|1506->433|1541->441|1567->446|1613->465|1629->472|1659->481|1697->492|1725->499|1758->505|1815->535|1851->550|1889->651|1927->662|1955->669|1992->679
                  LINES: 33->7|38->7|40->9|43->12|44->13|44->13|44->13|45->14|45->14|45->14|46->15|46->15|47->16|49->18|49->18|50->20|51->21|51->21|54->24
                  -- GENERATED --
              */
          