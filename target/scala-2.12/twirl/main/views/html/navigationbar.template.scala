
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

object navigationbar extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href=""""),_display_(/*2.36*/routes/*2.42*/.HomeController.index),format.raw/*2.63*/("""">Fast Lane</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <!--<li class="nav-item active">-->
                <!--<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>-->
            <!--</li>-->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Calculate Data
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href=""""),_display_(/*17.53*/routes/*17.59*/.HomeController.passengersCount),format.raw/*17.90*/("""">Passengers count</a>
                    <a class="dropdown-item" href="#">Historical real-time</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Old</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Upload new file</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Formulas</a>
            </li>
            <!--<li class="nav-item">-->
                <!--<a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>-->
            <!--</li>-->
        </ul>
        <!--<form class="form-inline my-2 my-lg-0">-->
            <!--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">-->
            <!--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>-->
        <!--</form>-->
    </div>
</nav>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Jan 04 16:17:51 IST 2019
                  SOURCE: C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/play-java-seed/app/views/navigationbar.scala.html
                  HASH: 54d98d95c8378dc8d787e02769edf4e6147882a9
                  MATRIX: 1038->0|1160->96|1174->102|1215->123|2215->1096|2230->1102|2282->1133
                  LINES: 33->1|34->2|34->2|34->2|49->17|49->17|49->17
                  -- GENERATED --
              */
          