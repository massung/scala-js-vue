package vue

import scala.scalajs.js
import js.annotation._
import org.scalajs.dom

@js.native
@JSGlobal
class Vue(config: js.Dictionary[js.Any]) extends js.Object {
  val $data: js.Dynamic = js.native

  // read only members
  val $el: dom.Element = js.native
  val $options: js.Dynamic = js.native
  val $parent: Vue = js.native
  val $root: Vue = js.native
  val $refs: js.Dictionary[js.Any] = js.native
  val $slots: js.Dictionary[js.Any] = js.native
  val $scopedSlots: js.Dynamic = js.native
  val $isServer: Boolean = js.native
  val $ssrContext: js.Any = js.native
  val $props: js.Any = js.native
  val $vnode: VNode = js.native
  val $attrs: js.Dictionary[String] = js.native
  val $listeners: js.Dictionary[js.Any] = js.native

  def $mount(elementOrSelector: js.Any): Vue = js.native
  def $forceUpdate(): Unit = js.native
  def $destroy(): Unit = js.native
  def $set: js.Function = js.native
  def $delete: js.Function = js.native
  def $watch(expOrFn: js.ThisFunction, callback: js.Function, options: WatchOptions): js.Function = js.native
  def $on(event: String, callback: js.Function): Vue = js.native
  def $on(event: js.Array[String], callback: js.Function): Vue = js.native
  def $once(event: String, callback: js.Function): Vue = js.native
  def $once(event: js.Array[String], callback: js.Function): Vue = js.native
  def $off(event: String, callback: js.Function): Vue = js.native
  def $off(event: js.Array[String], callback: js.Function): Vue = js.native
  def $emit(event: String, args: String*): Vue = js.native
  def $nextTick(callback: js.ThisFunction): Unit = js.native
  def $nextTick(): js.Promise[Unit] = js.native
  def $createElement(tag: String, data: VNodeData, children: String): VNode = js.native
  def $createElement(tag: String, data: VNodeData, children: js.Array[js.Any]): VNode = js.native
  def $createElement(tag: js.Object, data: VNodeData, children: String): VNode = js.native
  def $createElement(tag: js.Object, data: VNodeData, children: js.Array[js.Any]): VNode = js.native
  def $createElement(tag: js.Function, data: VNodeData, children: String): VNode = js.native
  def $createElement(tag: js.Function, data: VNodeData, children: js.Array[js.Any]): VNode = js.native
}

@js.native
@JSGlobal
object Vue extends js.Object {
  @js.native
  trait Constructor extends js.Object {
    def `new`(args: js.Any*): js.Any = js.native
  }

  def extend(options: js.Any): Vue = js.native
  def nextTick(callback: js.Function, context: js.Array[js.Any]): Unit = js.native
  def nextTick(): js.Promise[Unit] = js.native
  def set[T](obj: js.Object, key: String, value: T): T = js.native
  def set[T](array: js.Array[T], key: Int, value: T): T = js.native
  def delete(obj: js.Object, key: String): Unit = js.native
  def delete[T](array: js.Array[T], key: Int): Unit = js.native
  
  @js.native
  object Config extends js.Object {
    var silent: Boolean = js.native
    var optionMergeStrategies: js.Any = js.native
    var devtools: Boolean = js.native
    var productionTip: Boolean = js.native
    var performance: Boolean = js.native
    var errorHandler: js.Function = js.native
    var warnHandler: js.Function = js.native
    var ignoredElements: js.Array[String] = js.native
    var keyCodes: js.Dictionary[Int] = js.native
  }

  def directive(id: String, definition: js.Any): DirectiveOptions = js.native
  def filter(id: String, definition: js.Any): js.Function = js.native
  def component(id: String, definition: js.Function): js.Function = js.native
  def use[T](plugin: PluginObject[T], options: T): Unit = js.native
  def use[T](plugin: js.Function2[Vue, T, Unit], options: T): Unit = js.native
  def mixin(mixin: Vue): Unit = js.native
  def mixin(mixin: ComponentOptions[Vue]): Unit = js.native
  def compile(template: String): js.Object = js.native
}