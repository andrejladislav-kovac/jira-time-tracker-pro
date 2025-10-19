package sk.andrei.jiratimetrackerpro

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import sk.andrei.jiratimetrackerpro.domain.domainModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                dataModule,
                infrastructureModule,
                domainModule
            )
        }
    }
}