package sk.andrei.jiratimetrackerpro.infrastructure

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.koin.dsl.module
import sk.andrei.jiratimetrackerpro.data.database.JttpDatabase
import java.util.Properties

actual val platformInfrastructureModule = module {
    single<SqlDriver> {
        JdbcSqliteDriver(
            "jdbc:sqlite:test.db",
            Properties(),
            JttpDatabase.Schema
        )
    }
}