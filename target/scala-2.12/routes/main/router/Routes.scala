// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/conf/routes
// @DATE:Tue May 21 20:43:39 IDT 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:8
  VisualizationController_1: controllers.VisualizationController,
  // @LINE:14
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:8
    VisualizationController_1: controllers.VisualizationController,
    // @LINE:14
    Assets_2: controllers.Assets
  ) = this(errorHandler, HomeController_0, VisualizationController_1, Assets_2, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, VisualizationController_1, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """PassengersCount""", """controllers.HomeController.passengersCount"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """PassengersCount/Result""", """controllers.VisualizationController.calculatePassengersCount"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """DevSched""", """controllers.HomeController.deviationSched"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """DevSched/Result""", """controllers.VisualizationController.calculateDevSched"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """Instructions""", """controllers.HomeController.instructions"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_passengersCount1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("PassengersCount")))
  )
  private[this] lazy val controllers_HomeController_passengersCount1_invoker = createInvoker(
    HomeController_0.passengersCount,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "passengersCount",
      Nil,
      "GET",
      this.prefix + """PassengersCount""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_VisualizationController_calculatePassengersCount2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("PassengersCount/Result")))
  )
  private[this] lazy val controllers_VisualizationController_calculatePassengersCount2_invoker = createInvoker(
    VisualizationController_1.calculatePassengersCount,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VisualizationController",
      "calculatePassengersCount",
      Nil,
      "GET",
      this.prefix + """PassengersCount/Result""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_deviationSched3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("DevSched")))
  )
  private[this] lazy val controllers_HomeController_deviationSched3_invoker = createInvoker(
    HomeController_0.deviationSched,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "deviationSched",
      Nil,
      "GET",
      this.prefix + """DevSched""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_VisualizationController_calculateDevSched4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("DevSched/Result")))
  )
  private[this] lazy val controllers_VisualizationController_calculateDevSched4_invoker = createInvoker(
    VisualizationController_1.calculateDevSched,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VisualizationController",
      "calculateDevSched",
      Nil,
      "GET",
      this.prefix + """DevSched/Result""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_instructions5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("Instructions")))
  )
  private[this] lazy val controllers_HomeController_instructions5_invoker = createInvoker(
    HomeController_0.instructions,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "instructions",
      Nil,
      "GET",
      this.prefix + """Instructions""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:7
    case controllers_HomeController_passengersCount1_route(params@_) =>
      call { 
        controllers_HomeController_passengersCount1_invoker.call(HomeController_0.passengersCount)
      }
  
    // @LINE:8
    case controllers_VisualizationController_calculatePassengersCount2_route(params@_) =>
      call { 
        controllers_VisualizationController_calculatePassengersCount2_invoker.call(VisualizationController_1.calculatePassengersCount)
      }
  
    // @LINE:9
    case controllers_HomeController_deviationSched3_route(params@_) =>
      call { 
        controllers_HomeController_deviationSched3_invoker.call(HomeController_0.deviationSched)
      }
  
    // @LINE:10
    case controllers_VisualizationController_calculateDevSched4_route(params@_) =>
      call { 
        controllers_VisualizationController_calculateDevSched4_invoker.call(VisualizationController_1.calculateDevSched)
      }
  
    // @LINE:11
    case controllers_HomeController_instructions5_route(params@_) =>
      call { 
        controllers_HomeController_instructions5_invoker.call(HomeController_0.instructions)
      }
  
    // @LINE:14
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_2.versioned(path, file))
      }
  }
}