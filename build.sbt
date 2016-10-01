val spark_streaming_kafka = "org.apache.spark" % "spark-streaming-kafka-0-8_2.11" % "2.0.0"
val spark_core = "org.apache.spark" %% "spark-core" % "2.0.0"

lazy val commonSettings = Seq(
  organization := "com.yangcun",
  version := "0.1.0",
  scalaVersion := "2.11.8"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "user_behavior_server",
    libraryDependencies += spark_streaming_kafka,
    libraryDependencies += spark_core
  )
