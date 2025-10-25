package sk.andrei.jiratimetrackerpro.infrastructure

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.koin.dsl.module
import sk.andrei.jiratimetrackerpro.data.database.JttpDatabase

actual val platformInfrastructureModule = module {

    single<SqlDriver> {
        NativeSqliteDriver(
            schema = JttpDatabase.Schema,
            name = "test.db"
        )
    }

}