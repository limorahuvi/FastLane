// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/hshidlov/Desktop/private/Project/FastLane/conf/routes
// @DATE:Thu Mar 28 13:16:38 IST 2019


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
