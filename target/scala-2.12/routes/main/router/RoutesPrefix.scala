// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/hshidlov/Desktop/private/Project/FastLane/conf/routes
// @DATE:Tue Mar 12 14:16:44 IST 2019


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
