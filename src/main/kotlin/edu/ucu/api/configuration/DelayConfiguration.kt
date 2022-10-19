package edu.ucu.api.configuration

import io.micronaut.context.annotation.ConfigurationProperties
import java.time.Duration

//@ConfigurationProperties("delay")
//class DelayConfiguration {
//    var enabled: Boolean = false
////    var min: Duration = Duration.ZERO
////    var max: Duration = Duration.ZERO
//}

//@ConfigurationProperties("delay")
//class DelayConfiguration {
//    private var enabled: Boolean = false
//    private var min: Duration = Duration.ZERO
//    private var max: Duration = Duration.ZERO
//
//    fun enabled(): Boolean {
//        return enabled
//    }
//
//    fun setEnabled(enabled: Boolean?) {
//        this.enabled = enabled ?: false
//    }
//
//    fun min(): Duration {
//        return min
//    }
//
//    fun setMin(min: Duration?) {
//        this.min = min ?: Duration.ZERO
////        this.min = Duration.parse(min ?: "0s")
//    }
//
//    fun max(): Duration {
//        return max
//    }
//
//    fun setMax(max: String?) {
//        this.max = Duration.parse(max ?: "0s")
//    }
//}

@ConfigurationProperties("delay")
class DelayConfiguration {
    var enabled: Boolean = false
    var min: Duration = Duration.ZERO
    var max: Duration = Duration.ZERO
}

//class Delay private constructor(
//    val enabled: Boolean,
//    val min: Duration,
//    val max: Duration
//) {
//    data class Builder(
//        var enabled: Boolean?,
//        var min: Duration?,
//        var max: Duration?
//    ) {
//        fun withEnabled(enabled: Boolean?) = apply { this.enabled = enabled }
//        fun withMin(min: Duration?) = apply { this.min = min }
//        fun withMax(max: Duration?) = apply { this.max = max }
//
//        fun build() = Delay(
//            enabled ?: false,
//            min ?: Duration.ZERO,
//            max ?: Duration.ZERO)
//    }
//}
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import io.micronaut.context.annotation.ConfigurationBuilder
//import io.micronaut.context.annotation.ConfigurationProperties
//import io.micronaut.serde.annotation.Serdeable
//
//@Serdeable
//@JsonIgnoreProperties("builder")
//@ConfigurationProperties("team")
//class TeamConfiguration  {
//    var name: String? = null
//    var color: String? = null
//    var playerNames: List<String>? = null
//    @ConfigurationBuilder(prefixes = ["with"], configurationPrefix = "team-admin")
//    var builder = Delay.Builder()
//}

