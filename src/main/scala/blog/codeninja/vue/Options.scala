package vue

import scala.scalajs.js
import js.annotation._

@js.native
@JSGlobal
class Model extends js.Object {
  var prop: String = js.native
  var event: String = js.native
}

@js.native
trait ComponentOptions[V <: Vue] extends js.Object {
  var data: js.Any = js.native
  var props: js.Any = js.native
  var propsData: js.Object = js.native
  var computed: js.Dictionary[js.Any] = js.native
  var methods: js.Dictionary[js.Function] = js.native
  var watch: js.Dictionary[js.Any] = js.native
  var el: js.Any = js.native
  var template: String = js.native
  var render: js.Function2[V, js.Function, VNode] = js.native
  var renderError: js.Function2[js.Function1[Unit, VNode], js.Any, VNode] = js.native
  var staticRenderFns: js.Function1[js.Function, VNode] = js.native
  var beforeCreate: js.Function1[V, Unit] = js.native
  var created: js.Function1[V, Unit] = js.native
  var beforeDestroy: js.Function1[V, Unit] = js.native
  var destroyed: js.Function1[V, Unit] = js.native
  var beforeMount: js.Function1[V, Unit] = js.native
  var mounted: js.Function1[V, Unit] = js.native
  var beforeUpdate: js.Function1[V, Unit] = js.native
  var updated: js.Function1[V, Unit] = js.native
  var activated: js.Function1[V, Unit] = js.native
  var deactivated: js.Function1[V, Unit] = js.native
  var directives: js.Dictionary[js.Any] = js.native
  var components: js.Dictionary[js.Function] = js.native
  var transitions: js.Dictionary[js.Object] = js.native
  var filters: js.Dictionary[js.Function] = js.native
  var provide: js.Any = js.native
  var inject: js.Any = js.native
  var model: Model = js.native
  var parent: Vue = js.native
  var mixins: js.Any = js.native
  var name: String = js.native
  var `extends`: js.Any = js.native
  var delimiters: (String, String) = js.native
  var comments: Boolean = js.native
  var inheritAttrs: Boolean = js.native
}

@js.native
trait FunctionalComponentOptions extends js.Object {
  var name: String = js.native
  var props: js.Any = js.native
  var functional: Boolean = js.native

  def render(me: js.Any, createElement: js.Function, context: RenderContext): VNode = js.native
}

@js.native
trait RenderContext extends js.Object {
  var props: js.Any = js.native
  var children: js.Array[VNode] = js.native
  var data: VNodeData = js.native
  var parent: Vue = js.native
  var injections: js.Any = js.native

  def slots(): js.Any = js.native
}

@js.native
trait PropOptions extends js.Object {
  var `type`: js.Function = js.native
  var required: Boolean = js.native
  var default: js.Any = js.native

  def validator(value: js.Any): Boolean = js.native
}

@js.native
trait ComputedOptions[V <: Vue] extends js.Object {
  var cache: Boolean = js.native

  def get(me: V): js.Any = js.native
  def set(me: V, value: js.Any): Unit = js.native
}

@js.native
trait WatchOptions extends js.Object {
  var deep: Boolean = js.native
  var immediate: Boolean = js.native
}

@js.native
trait DirectiveOptions extends js.Object {
  var bind: js.Function = js.native
  var inserted: js.Function = js.native
  var update: js.Function = js.native
  var componentUpdated: js.Function = js.native
  var unbind: js.Function = js.native
}
