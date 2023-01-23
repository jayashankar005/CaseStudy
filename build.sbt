ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "CaseStudy"
  )

libraryDependencies += "com.lihaoyi" %% "requests" % "0.8.0"

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.3"
// https://mvnrepository.com/artifact/org.json/json
libraryDependencies += "org.json" % "json" % "20220924"


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.2.2",
  "org.apache.spark" %% "spark-sql" % "3.2.2",
  "org.apache.spark" %% "spark-mllib" % "3.2.2",
  "org.apache.spark" %% "spark-streaming" % "3.2.2"
)
