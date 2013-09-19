import sbt._
import sbt.Keys._

import aether.WagonWrapper
import aether.Aether._
import sbtrelease.ReleasePlugin._

import Dependencies._

object Publishing {

	lazy val allAetherSettings = aetherPublishSettings ++ aetherPublishLocalSettings

	lazy val publishingSettings = allAetherSettings ++ releaseSettings ++ Seq(
		crossPaths           := false,
		pomExtra             := scm ++ developersXml(developers),
		pomIncludeRepository := { _ => false },
		wagons := {
			if(isSnapshot.value) 
				Seq(WagonWrapper("davs", "org.apache.maven.wagon.providers.webdav.WebDavWagon"))
			else
				Seq.empty
		},
		publishTo := { 
			if(isSnapshot.value)
				Some(cloudbeesSnapshots)
			else
				Some(excilysReleases)
		},
		credentials += {
			if(isSnapshot.value)
				Credentials(file("/private/gatling/.credentials"))
			else
				Credentials(Path.userHome / ".sbt" / ".credentials")
		}
	)

	/************************/
	/** POM extra metadata **/
	/************************/

	private val scm = {
		<scm>
			<connection>scm:git:git@github.com:excilys/gatling-highcharts.git</connection>
			<developerConnection>scm:git:git@github.com:excilys/gatling-highcharts.git</developerConnection>
			<url>https://github.com/excilys/gatling-highcharts</url>
			<tag>HEAD</tag>
		</scm>
	}

	private case class GatlingDeveloper(emailAddress: String, name: String, isEbiz: Boolean)

	private val developers = Seq(
		GatlingDeveloper("slandelle@excilys.com", "Stephane Landelle", true),
		GatlingDeveloper("rsertelon@excilys.com", "Romain Sertelon", true)
	)

	private def developersXml(devs: Seq[GatlingDeveloper]) = {
		<developers>
		{
			for(dev <- devs)
			yield {
				<developer>
					<id>{dev.emailAddress}</id>
					<name>{dev.name}</name>
					{ if (dev.isEbiz) <organization>eBusiness Information, Excilys Group</organization> }
				</developer>
			}
		}
		</developers>
	}
}