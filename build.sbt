name := """play-java-seed"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava , PlayEbean)

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "42.1.4",
  guice,
  javaJdbc,
  evolutions, 
  jdbc,
  "io.ebean" % "ebean" % "11.37.1",
  "javax.persistence" % "persistence-api" % "1.0.2" ,
  "io.ebean" % "ebean-postgis" % "11.1.1",
  "io.ebean" % "ebean-querybean" % "11.37.1",
  "io.ebean" % "querybean-generator" % "11.37.1",
  "org.apache.poi" % "poi" % "3.10-FINAL",
  "org.apache.poi" % "poi-ooxml" % "3.10-FINAL",
  "org.apache.poi" % "poi-scratchpad" % "3.2-FINAL"
)