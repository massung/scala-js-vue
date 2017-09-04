# ScalaJS Vue Facade

This is a [ScalaJS][scalajs] facade for [Vue.js][vue].

## Installing

**Step 1.** Add [JitPack][jitpack] to your repositories in [SBT][sbt]:

```scala
resolvers += "jitpack" at "https://jitpack.io"
```

**Step 2.** Add this repo as a dependency:

```scala
libraryDependencies += "blog.codeninja" % "scala-js-vue" % "2.4.2"
```

If you'd like the latest-and-greatest version, use "master-SNAPSHOT".

## Example Usage

Here's a basic "TODO" app skeleton.

```scala
import scala.scalajs.js
import blog.codeninja.scalajs.vue._

/* First create a trait that will be the $data member of our Vue
 * instance. It doesn't need to be @js.native since we don't
 * intend to expose it to any JavaScript code. Instead, it's just
 * a trait of data members that we can use in templating our
 * Vue methods of type js.ThisFunctionN[..].
 */

trait Data extends js.Object {
    var task: String
    var list: js.Array[Task]
}

/* Next, we define a Task object. It needs to be derived from
 * js.Object, because the Vue object will access it from HTML.
 */

class Task(var text: String var done: Boolean = false) extends js.Object

/* Finally, let's create our application.
 */

object TodoApp {
    var vue: Vue = _

    // Create the application entry point.
    def main(args: Array[String]) = {
        vue = new Vue(
            js.Dynamic.literal(
                el = "#app",

                // This is our js.Object instance of Data.
                data = js.Dynamic.literal(
                    task = "",
                    list = js.Array[Task](
                        new Task("Learn Vue.js"),
                        new Task("Create reactive Scala.js app"),
                        new Task("Profit!")
                    )
                ),

                // Reactive methods that Vue can call.
                methods = js.Dynamic.literal(
                    addTask = addTask: js.ThisFunction0[Data, _],
                    rmTask = rmTask: js.ThisFunction1[Data, Int, _],
                    toggleTask = toggleTask: js.ThisFunction1[Data, Int, _]
                )
            )
        )
    }

    // This is called from JS through methods when the ENTER key is
    // pressed while focused on the input text field.
    def addTask(data: Data): Unit =
        if (data.task.length > 0) {
            data.list.push(new Task(data.task))
            data.task = ""
        }
    
    // This is called from JS through the "remove" button.
    def rmTask(data: Data, index: Int): Unit =
        data.list.splice(index, 1)
}
```

There, the [ScalaJS][scalajs] side of things is done. Now, let's make our HTML body (*this is intentionally not styled or pretty as opposed to slim to be readable, showing how to use various Vue tags*):

```html
<div id="app">
    <div>
        <input v-on:keyup.enter="addTask" v-model="task">
    </div>

    <!-- special text if there are no todo items -->
    <div v-if="list.length == 0">
        <em>Nothing to do! Add items above.</em>
    </div>

    <!-- loop and create a div for each task -->
    <div v-for="(task, index) in list">
        <input type="checkbox" v-model="task.done" />
        <span v-bind:class="{done: task.done}">
            {{ task.text }}
        </span>
        <button v-on:click="rmTask(index)">Remove</button>
    </div>
</div>
```

That's it. Launch the application and start completing tasks!

## How To Use A Vue.js Plugin

Here's an example of how to install and use a [Vue][vue] plugin. In this example, we'll use the [vue-async-computed][async] plugin.

**Step 1.** Add the JavaScript dependency:

```scala
jsDependencies += "org.webjars.npm" % "vue-async-computed" % "3.3.0" / "dist/vue-async-computed.js" commonJSName "AsyncComputed"
```

**Step 2. (Option A)** If you need a facade for the plugin, derive from `PluginObject[T]` using the `commonJSName` used for the `jsDependency`:

```scala
@js.native
@JSGlobal
object AsyncComputed extends PluginObject[js.Any] {
    // TOOD: facade members and methods here...
}
```

**Step 2. (Option B)** If you don't need a facade, then you can just find the plugin in the global scope use the `commonJSName`:

```scala
val AsyncComputed = g.selectDynamic("AsyncComputed").asInstanceOf[PluginObject[js.Any]]
```

**Step 3.** Call `Vue.use` with your plugin:

```scala
val options = js.Dynamic.literal(
    // TODO: put any plugin install options here...
)

Vue.use(AsyncComputed, options)
```

You should be ready to roll...

## That's It

If you find a bug or have suggestions on how to improve the facade (specifically adding some more type safety where possible), please open an issue and tell me about it.

Hope you find this helpful!

[scalajs]:      http://www.scala-js.org
[sbt]:          http://www.scala-sbt.org
[vue]:          https://vuejs.org
[jitpack]:      https://jitpack.io
[async]:        https://github.com/foxbenjaminfox/vue-async-computed
