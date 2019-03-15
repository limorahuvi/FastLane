// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/hshidlov/Desktop/private/Project/FastLane/conf/routes
// @DATE:Tue Mar 12 14:16:44 IST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:8
  class ReverseVisualizationController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def calculatePassengersCount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VisualizationController.calculatePassengersCount",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "PassengersCount/Result"})
        }
      """
    )
  
    // @LINE:10
    def calculateDevSched: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VisualizationController.calculateDevSched",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "DevSched/Result"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def passengersCount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.passengersCount",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "PassengersCount"})
        }
      """
    )
  
    // @LINE:9
    def deviationSched: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.deviationSched",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "DevSched"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
