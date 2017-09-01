package vue

import scala.scalajs.js
import js.annotation._
import org.scalajs.dom

@js.native
@JSGlobal
class VNode extends js.Object {
  var tag: String = js.native
  var data: VNodeData = js.native
  var children: js.Any = js.native
  var text: String = js.native
  var elm: dom.Node = js.native
  var ns: String = js.native
  var context: Vue = js.native
  var key: String = js.native
  var componentOptions: js.Object = js.native
  var componentInstance: Vue = js.native
  var parent: VNode = js.native
  var raw: Boolean = js.native
  var isStatic: Boolean = js.native
  var propsData: js.Object = js.native
  var listeners: js.Object = js.native
}

@js.native
@JSGlobal
class VNodeComponentOptions extends js.Object {
  var Ctor: Vue = js.native
  var propsData: js.Object = js.native
  var listeners: js.Object = js.native
  var children: js.Any = js.native
  var tag: String = js.native
}

@js.native
@JSGlobal
class VNodeData extends js.Object {
  var key: js.Any = js.native
  var slot: String = js.native
  var scopedSlots: js.Object = js.native
  var ref: String = js.native
  var tag: String = js.native
  var staticClass: String = js.native
  var `class`: js.Any = js.native
  var staticStyle: js.Object = js.native
  var style: js.Dynamic = js.native
  var props: js.Object = js.native
  var attrs: js.Object = js.native
  var domProps: js.Object = js.native
  var hook: js.Dynamic = js.native
  var on: js.Dynamic = js.native
  var nativeOn: js.Dynamic = js.native
  var transition: js.Object = js.native
  var show: Boolean = js.native
  var inlineTemplate: js.Object = js.native
  var directives: js.Array[VNodeDirective] = js.native
  var keepAlive: Boolean = js.native
}

@js.native
@JSGlobal
class VNodeDirective extends js.Object {
  var name: String = js.native
  var value: js.Any = js.native
  var oldValue: js.Any = js.native
  var expression: js.Any = js.native
  var arg: String = js.native
  var modifiers: js.Object = js.native
}