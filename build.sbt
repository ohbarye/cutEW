name := """cutew"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.webjars" %% "webjars-play" % "2.3.0",
  "org.webjars" % "bootstrap" % "3.0.0",
  "org.projectlombok" % "lombok" % "1.14.8",  
  "com.google.guava" % "guava" % "18.0",  
  "net.sf.jett" % "jett-core" % "0.9.0"
)

includeFilter in (Assets, LessKeys.less) := "*.less"