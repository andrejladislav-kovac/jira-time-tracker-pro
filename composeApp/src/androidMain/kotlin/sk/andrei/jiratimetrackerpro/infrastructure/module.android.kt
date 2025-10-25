package sk.andrei.jiratimetrackerpro.infrastructure

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.koin.dsl.module
import sk.andrei.jiratimetrackerpro.data.database.JttpDatabase

actual val platformInfrastructureModule = module {
    single<SqlDriver> {
        AndroidSqliteDriver(
            schema = JttpDatabase.Schema,
            context = get(),
            name = "test.db"
        )
    }
}