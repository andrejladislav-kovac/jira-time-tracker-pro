package sk.andrei.jiratimetrackerpro.infrastructure

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import org.koin.dsl.module
import org.w3c.dom.Worker

@OptIn(ExperimentalWasmJsInterop::class)
val scriptUrl: String = js("""new URL("@cashapp/sqldelight-sqljs-worker/sqljs.worker.js", import.meta.url)""")

@OptIn(ExperimentalWasmJsInterop::class)
actual val platformInfrastructureModule = module {

    single<SqlDriver> {
        WebWorkerDriver(
            worker = Worker(scriptUrl),
        )
    }

}