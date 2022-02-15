name := "Euler2"

version := "0.1"

scalaVersion := "2.13.6"

libraryDependencies += "org.scalatestplus" %% "junit-4-13" % "3.2.9.0" % "test"

val AkkaVersion = "2.6.16"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % AkkaVersion