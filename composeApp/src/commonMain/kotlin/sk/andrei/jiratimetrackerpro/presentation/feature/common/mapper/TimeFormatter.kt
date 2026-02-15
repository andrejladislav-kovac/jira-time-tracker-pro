package sk.andrei.jiratimetrackerpro.presentation.feature.common.mapper

private const val MINUTE = 60
private const val HOUR = 60 * MINUTE
private const val MAN_DAY = 8 * HOUR

fun Long.toManDaysHoursMinutes() = buildList {
    val d = this@toManDaysHoursMinutes / MAN_DAY
    if (d > 0) add("${d}d")
    val h = this@toManDaysHoursMinutes % MAN_DAY / HOUR
    if (h > 0) add("${h}h")
    val m = this@toManDaysHoursMinutes % HOUR / MINUTE
    if (m > 0) add("${m}m")
}.joinToString(separator = " ")