enablePlugins(ScalaJSPlugin)

// project name/version
name := "scala-js-vue"
version := "2.2.4"

// what version of scala to use
scalaVersion := "2.12.3"

// libraries
libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1"
)

// javascript sources
jsDependencies ++= Seq(
  "org.webjars.npm" % "vue" % "2.4.2" / "dist/vue.js" minified "dist/vue.min.js" commonJSName "Vue"
)
