// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/conf/routes
// @DATE:Thu Mar 07 12:53:48 IST 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseVisualizationController VisualizationController = new controllers.ReverseVisualizationController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseVisualizationController VisualizationController = new controllers.javascript.ReverseVisualizationController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
