package vue

import scala.scalajs.js
import js.annotation._

@js.native
trait PluginObject[T] extends js.Object {
  var install: js.Function2[Vue, T, Unit] = js.native

  // dictionary lookup
  def apply(key: String): js.Any = js.native
}
