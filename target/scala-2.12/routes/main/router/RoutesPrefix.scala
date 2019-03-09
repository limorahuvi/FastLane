// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/user/workspace/final project/FastLane/conf/routes
// @DATE:Thu Mar 07 20:58:30 IST 2019


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
