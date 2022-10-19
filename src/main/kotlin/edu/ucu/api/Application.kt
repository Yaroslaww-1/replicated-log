package edu.ucu.api

import io.micronaut.runtime.Micronaut

object ApplicationKt {
	@JvmStatic
	fun main(args: Array<String>) {
		Micronaut.build()
			.packages("edu.ucu")
			.mainClass(ApplicationKt.javaClass)
			.start()
	}
}

