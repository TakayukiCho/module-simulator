
lazy val projectName = "module-simulator"
lazy val currentVersion = "0.1"

lazy val organizationName = "dev.modulesimulator"

lazy val mainClassPath = s"${organizationName}.Bootstrap"

lazy val root = (project in file(",")).settings(
  inThisBuild(List(
    organization := organizationName,
    scalaVersion := "2.12.8",
    version := currentVersion
  )),
  mainClass in (Compile, run) := Some(mainClassPath),
  name := projectName
)