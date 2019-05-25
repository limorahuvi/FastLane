
package views.html.imports

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

object design extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<link rel="stylesheet" href=""""),_display_(/*1.31*/routes/*1.37*/.Assets.versioned("outsiders/bootstrap-4.2.1-dist/css/bootstrap.min.css")),format.raw/*1.110*/(""""  crossorigin="anonymous">
<script src=""""),_display_(/*2.15*/routes/*2.21*/.Assets.versioned("javascripts/main.js")),format.raw/*2.61*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*3.15*/routes/*3.21*/.Assets.versioned("outsiders/jquery-3.3.1.slim.min.js")),format.raw/*3.76*/(""""></script>
<script src=""""),_display_(/*4.15*/routes/*4.21*/.Assets.versioned("outsiders/bootstrap-4.2.1-dist/js/bootstrap.min.js")),format.raw/*4.92*/("""" crossorigin="anonymous"></script>
<link rel="stylesheet" media="screen" href=""""),_display_(/*5.46*/routes/*5.52*/.Assets.versioned("stylesheets/main.css")),format.raw/*5.93*/("""">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue May 21 20:43:39 IDT 2019
                  SOURCE: C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/app/views/imports/design.scala.html
                  HASH: 3b569f6a25b055a4963c7ec40a21b73839ea9175
                  MATRIX: 1039->0|1095->30|1109->36|1203->109|1272->152|1286->158|1346->198|1422->248|1436->254|1511->309|1564->336|1578->342|1669->413|1777->495|1791->501|1852->542
                  LINES: 33->1|33->1|33->1|33->1|34->2|34->2|34->2|35->3|35->3|35->3|36->4|36->4|36->4|37->5|37->5|37->5
                  -- GENERATED --
              */
          