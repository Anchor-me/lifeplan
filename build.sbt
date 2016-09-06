name := "runner"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.3.4",
  "org.apache.poi" % "poi-ooxml" % "3.10-FINAL",
  "com.anchor" %% "anchor-models" % "1.0"
)