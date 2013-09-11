/**
 * Copyright 2011-2013 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 *
 * Licensed under the Gatling Highcharts License
 */
package io.gatling.highcharts.series

import io.gatling.core.result.PieSlice

class StackedColumnSeries(name: String, data: Seq[PieSlice], color: String) extends ColumnSeries(name, data, List(color)) {

	def elements: Seq[String] = data.map(_.value.toString)
}