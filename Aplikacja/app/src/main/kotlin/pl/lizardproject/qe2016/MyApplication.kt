package pl.lizardproject.qe2016

import android.app.Application
import pl.lizardproject.database.qe2016.DatabaseFacade

class MyApplication : Application() {
    val databaseFacade = DatabaseFacade(this)
}