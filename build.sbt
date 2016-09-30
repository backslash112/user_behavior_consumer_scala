// val derby = "org.apache.derby" % "derby" % "10.4.1.3"
val kafka_clients = "org.apache.kafka" % "kafka-clients" % "0.10.0.0"

lazy val commonSettings = Seq(
  organization := "com.yangcun",
  version := "0.1.0",
  scalaVersion := "2.11.8"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "user_behavior_server",
    // libraryDependencies += derby,
    libraryDependencies += kafka_clients
  )
