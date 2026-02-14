package sk.andrei.jiratimetrackerpro.infrastructure

import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.koin.dsl.module
import sk.andrei.jiratimetrackerpro.data.database.JttpDatabase

actual val databaseModule = module {

    single<SqlDriver> {
        NativeSqliteDriver(
            schema = JttpDatabase.Schema.synchronous(),
            name = "test.db"
        )
    }

}