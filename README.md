# ScalaJS Vue Facade

[![Release](https://jitpack.io/v/blog.codeninja/scala-js-vue.svg)]
(https://jitpack.io/#blog.codeninja/scala-js-vue)

This is a [ScalaJS][scalajs] facade for [Vue.js][vue].

## Installing

**Step 1.** Add [JitPack][jitpack] to your repositories in [SBT][sbt]:

```scala
resolvers += "jitpack" at "https://jitpack.io"
```

**Step 2.** Add this repo as a dependency:

```scala
libraryDependencies += "blog.codeninja" % "scala-js-vue" % "2.2.4"
```

If you'd like the latest-and-greatest version, use "master-SNAPSHOT".

## Example Usage

Here's a basic "TODO" app skeleton.

```scala
import scala.scalajs.js
import js.annotation._
import blog.codeninja.scalajs.vue._

/* First create a trait that will be the $data member of our Vue
 * instance. Vue is a subclass js.Object, so when we create methods
 * that take Data as an argument, they can be called from the Vue
 * core.
 */

@js.native
trait Data extends Vue {
    var task: String = js.native
    var list: js.Array[Task] = js.native
}

/* Next, we define a Task object, inherited from js.Object.
 */

class Task(val text: String val done: Boolean = false) extends js.Object

/* Finally, let's create our application.
 */

object TodoApp {
    val vue = new Vue(
        "el" -> "#app",

        // This is our js.Object instance of Data.
        "data" -> js.Dynamic.literal(
            task = "",
            list = js.Array[Task](
                new Task("Learn Vue.js"),
                new Task("Create reactive Scala.js app"),
                new Task("Profit!")
            )
        ),

        // Reactive methods that Vue can call.
        "methods" -> js.Dynamic.literal(
            addTask = addTask: js.ThisFunction0[Data, _],
            finishTask = finishTask: js.ThisFunction1[Data, Int, _]
        )
    )

    // This is called from JS through methods when the ENTER key is
    // pressed while focused on the input text field.
    def addTask(data: Data): Unit =
        if (data.task.length > 0) {
            data.list.push(new Task(data.task))
            data.task = ""
        }
    
    // This is called from JS through the "remove" button.
    def delTask(data: Data, index: Int): Unit =
        data.list.splice(index, 1)
}
```

There, the [ScalaJS][scalajs] side of things is done. Now, let's make our HTML body (*this is not intended to be styled or pretty, just to get the idea across and show how to use the various Vue tags*):

```html
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
    <button v-on:click="delTask(index)">Remove</button>
</div>
```

That's it. Launch the application and start completing tasks!

## That's It

If you find a bug or have suggestions on how to improve the facade (specifically adding some more type safety where possible), please open an issue and tell me about it.

Hope you find this helpful!

[scalajs]:      http://www.scala-js.org
[sbt]:          http://www.scala-sbt.org
[vue]:          https://vuejs.org
[jitpack]:      https://jitpack.io
