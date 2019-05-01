// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/user/workspace/final project/FastLane/conf/routes
// @DATE:Tue Apr 30 19:36:03 IDT 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:8
  class ReverseVisualizationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def calculatePassengersCount(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "PassengersCount/Result")
    }
  
    // @LINE:10
    def calculateDevSched(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "DevSched/Result")
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def passengersCount(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "PassengersCount")
    }
  
    // @LINE:11
    def instructions(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "Instructions")
    }
  
    // @LINE:9
    def deviationSched(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "DevSched")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:14
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
