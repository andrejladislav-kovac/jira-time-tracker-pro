package sk.andrei.jiratimetrackerpro.data

import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.koin.dsl.module
import sk.andrei.jiratimetrackerpro.data.database.JttpDatabase
import java.util.Properties

actual val platformDataModule = module {
    single<SqlDriver> {
        JdbcSqliteDriver(
            "jdbc:sqlite:test.db",
            Properties(),
            JttpDatabase.Schema.synchronous()
        )
    }
}