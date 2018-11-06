name := """play-java-jpa-tests-example"""

organization := "com.cranberrysoft"

organizationHomepage := Some(url("http://cranberrysoft.com"))

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.6"

crossScalaVersions := Seq("2.11.12", "2.12.6")

libraryDependencies += guice
libraryDependencies += javaJpa
libraryDependencies += evolutions
libraryDependencies += "com.h2database" % "h2" % "1.4.197"
libraryDependencies += "org.hibernate" % "hibernate-core" % "5.2.17.Final"

testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-a", "-v")
