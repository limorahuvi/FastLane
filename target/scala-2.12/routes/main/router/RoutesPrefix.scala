// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/limor/OneDrive/Documents/uni/Final Project/play-java-seed/play-java-seed/conf/routes
// @DATE:Fri Jan 04 18:08:04 IST 2019


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
