package pl.lizardproject.qe2016

import android.app.Application
import pl.lizardproject.qe2016.database.DatabaseFacade

class MyApplication : Application() {
    val databaseFacade = DatabaseFacade(this)
}