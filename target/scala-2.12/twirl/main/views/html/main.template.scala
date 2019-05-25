
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
    """),format.raw/*12.58*/("""
    """),format.raw/*13.5*/("""<title>"""),_display_(/*13.13*/title),format.raw/*13.18*/("""</title>
    """),_display_(/*14.6*/imports/*14.13*/.design()),format.raw/*14.22*/("""
    """),_display_(/*15.6*/headers),format.raw/*15.13*/("""
"""),format.raw/*16.1*/("""</head>
<body>
"""),_display_(/*18.2*/navigationbar()),format.raw/*18.17*/("""
"""),format.raw/*19.1*/("""</br>
"""),format.raw/*21.23*/("""
"""),_display_(/*22.2*/content),format.raw/*22.9*/("""


"""),format.raw/*25.1*/("""</body>
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
                  DATE: Tue May 21 20:43:39 IDT 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/app/views/main.scala.html
                  HASH: 15ada997574507297ef8e53a5c2fbe6ffaf4fa01
                  MATRIX: 1211->261|1351->306|1381->310|1456->410|1489->416|1524->424|1550->429|1591->444|1607->451|1637->460|1670->467|1698->474|1727->476|1771->494|1807->509|1836->511|1871->600|1900->603|1927->610|1960->616
                  LINES: 33->7|38->7|40->9|43->12|44->13|44->13|44->13|45->14|45->14|45->14|46->15|46->15|47->16|49->18|49->18|50->19|51->21|52->22|52->22|55->25
                  -- GENERATED --
              */
          