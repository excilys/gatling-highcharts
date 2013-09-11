/**
 * Copyright 2011-2013 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 *
 * Licensed under the Gatling Highcharts License
 */
package io.gatling.highcharts.component

import io.gatling.charts.component.Component
import io.gatling.highcharts.template.Template

class HighchartsComponent(template: Template) extends Component {

	def html = template.html

	def js = template.js

	val jsFiles: Seq[String] = List("highstock.js", "highcharts-more.js", "theme.js")
}