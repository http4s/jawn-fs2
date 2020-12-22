ThisBuild / organization := "org.typelevel"
ThisBuild / organizationName := "Typelevel"

ThisBuild / crossScalaVersions := Seq("2.12.12", "2.13.3", "3.0.0-M2", "3.0.0-M3")
ThisBuild / scalaVersion := crossScalaVersions.value.filter(_.startsWith("2.")).last
ThisBuild / baseVersion := "2.0"
ThisBuild / publishGithubUser := "rossabaker"
ThisBuild / publishFullName := "Ross A. Baker"
ThisBuild / githubWorkflowPublishTargetBranches := Seq.empty

val JawnVersion   = "1.0.3"
val Fs2Version    = "3.0.0-M7"
val Specs2Version = "4.10.5"

libraryDependencies ++= Seq(
  "org.typelevel"  %% "jawn-parser" % JawnVersion,
  "co.fs2"         %% "fs2-core"    % Fs2Version,
  "org.typelevel"  %% "jawn-ast"    % JawnVersion   % Test,
  "co.fs2"         %% "fs2-io"      % Fs2Version    % Test,
  "org.specs2"     %% "specs2-core" % Specs2Version % Test withDottyCompat scalaVersion.value,
)

publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

versionIntroduced := Map("3.0.0-M1" -> "1.1.0")
