name := "carmanagerapp"

version := "2.5.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

organization := "be.objectify"

libraryDependencies ++= Seq(
  javaJdbc,
  evolutions,
  "be.objectify" %% "deadbolt-java" % "2.5.0",
  "mysql" % "mysql-connector-java" % "5.1.38"
)

routesGenerator := InjectedRoutesGenerator
