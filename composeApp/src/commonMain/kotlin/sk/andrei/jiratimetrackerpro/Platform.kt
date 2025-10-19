package sk.andrei.jiratimetrackerpro

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform