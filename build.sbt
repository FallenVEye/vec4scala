ThisBuild / name := "vec4scala"

ThisBuild / version := "0.0.5"

ThisBuild / organization := "com.fallenveye"

ThisBuild / scalaVersion := "3.3.5"

ThisBuild / publishMavenStyle := true

ThisBuild / publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))



val scalaTestVersion = "3.2.19"

lazy val root = (project in file("."))
  .settings(
    name := "Vec4Scala",
    libraryDependencies ++= Seq(
        "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
    )
  )
