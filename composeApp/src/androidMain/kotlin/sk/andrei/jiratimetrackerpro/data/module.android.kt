package sk.andrei.jiratimetrackerpro.data

import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.koin.dsl.module
import sk.andrei.jiratimetrackerpro.data.database.JttpDatabase

actual val platformDataModule = module {
    single<SqlDriver> {
        AndroidSqliteDriver(
            schema = JttpDatabase.Schema.synchronous(),
            context = get<Context>(),
            name = "test.db"
        )
    }
}