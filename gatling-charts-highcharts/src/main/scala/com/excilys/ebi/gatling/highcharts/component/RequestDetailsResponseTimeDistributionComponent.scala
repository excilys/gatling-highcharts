/**
 * Copyright 2011-2013 eBusiness Information, Groupe Excilys (www.excilys.com)
 *
 * Licensed under the Gatling Highcharts License
 */
package com.excilys.ebi.gatling.highcharts.component

import com.excilys.ebi.gatling.charts.series.Series
import com.excilys.ebi.gatling.highcharts.series.StackedColumnSeries
import com.excilys.ebi.gatling.highcharts.template.RequestDetailsResponseTimeDistributionTemplate

object RequestDetailsResponseTimeDistributionComponent {

	def apply(successDistribution: Series[Int, Int], failuresDistribution: Series[Int, Int]) = {
		val template = new RequestDetailsResponseTimeDistributionTemplate(
			new StackedColumnSeries(successDistribution.name, successDistribution.data.map { case (time, count) => (time.toString -> count) }, successDistribution.colors.head),
			new StackedColumnSeries(failuresDistribution.name, failuresDistribution.data.map { case (time, count) => (time.toString -> count) }, failuresDistribution.colors.head))

		new HighchartsComponent(template)
	}
}