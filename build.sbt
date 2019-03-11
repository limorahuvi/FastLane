name := """play-java-seed"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava , PlayEbean)

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "42.1.4",
  guice,
  javaJdbc,
  "org.avaje" % "ebean" % "2.7.3",
   "javax.persistence" % "persistence-api" % "1.0.2"
)

//Problem1
libraryDependencies ++= Seq(
  "io.ebean" % "ebean" % "11.26.1",
  "io.ebean" % "ebean-agent" % "11.26.1",
  "io.ebean" % "ebean-migration" % "11.11.1"
)