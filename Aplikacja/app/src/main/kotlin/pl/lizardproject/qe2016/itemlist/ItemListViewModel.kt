package pl.lizardproject.qe2016.itemlist

import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.view.View
import pl.lizardproject.database.qe2016.DatabaseFacade
import pl.lizardproject.qe2016.model.Item

class ItemListViewModel(val databaseFacade: DatabaseFacade) {

    private var subscription = databaseFacade.loadItems().subscribe {
        values ->
        items.clear()
        items.addAll(values)
    }

    val items = ObservableArrayList<Item>()
    val newItemName = ObservableField<String>("")

    fun addItemCommand(view: View) {
        databaseFacade.saveItem(Item(newItemName.get()))
        newItemName.set("")
    }

    fun dispose() {
        subscription.unsubscribe()
    }
}