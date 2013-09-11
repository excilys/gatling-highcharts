// Show deprecation and features warnings in SBT build file
scalacOptions ++= Seq("-deprecation", "-feature", "-language:postfixOps")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")

addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.1.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "0.6.2")

addSbtPlugin("no.arktekk.sbt" % "aether-deploy" % "0.10")

// Dependency needed for the WebDAV wagon
libraryDependencies += "org.apache.maven.wagon" % "wagon-webdav-jackrabbit" % "2.4"