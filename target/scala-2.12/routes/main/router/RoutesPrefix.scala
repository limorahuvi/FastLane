// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/hshidlov/Desktop/private/Project/2904/FastLane/conf/routes
// @DATE:Sat May 25 20:16:59 IDT 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
