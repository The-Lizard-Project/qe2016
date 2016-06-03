package pl.lizardproject.qe2016.itemlist

import android.app.Activity
import android.content.Intent
import android.databinding.ObservableArrayList
import android.view.View
import pl.lizardproject.database.qe2016.DatabaseFacade
import pl.lizardproject.qe2016.edititem.EditItemActivity
import pl.lizardproject.qe2016.model.Item

class ItemListViewModel(private val activity: Activity, private val databaseFacade: DatabaseFacade) {

    private var subscription = databaseFacade.loadItems().subscribe {
        values ->
        items.clear()
        items.addAll(values)
    }

    val items = ObservableArrayList<Item>()

    fun addItemCommand(view: View) {
        activity.startActivity(Intent(activity, EditItemActivity::class.java))
    }

    fun dispose() {
        subscription.unsubscribe()
    }
}