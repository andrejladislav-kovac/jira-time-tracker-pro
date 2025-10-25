package sk.andrei.jiratimetrackerpro

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import sk.andrei.jiratimetrackerpro.data.dataModule
import sk.andrei.jiratimetrackerpro.domain.domainModule
import sk.andrei.jiratimetrackerpro.infrastructure.infrastructureModule
import sk.andrei.jiratimetrackerpro.infrastructure.platformInfrastructureModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                dataModule,
                platformInfrastructureModule,
                infrastructureModule,
                domainModule
            )
        }
    }
}