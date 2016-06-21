package pl.lizardproject.qe2016.itemlist

import android.databinding.ObservableArrayList
import android.util.Log
import android.view.View
import pl.lizardproject.qe2016.database.DatabaseFacade
import pl.lizardproject.qe2016.edititem.Henson
import pl.lizardproject.qe2016.model.Item

class ItemListViewModel(private val databaseFacade: DatabaseFacade) {

    val items = ObservableArrayList<Item>()

    private var subscription = databaseFacade.loadItems()
            .subscribe ({ values ->
                items.clear()
                items.addAll(values)
            }, { ex -> Log.e("TAG", ex.message, ex) })

    fun addItemCommand(view: View) {
        view.context.startActivity(
                Henson.with(view.context)
                        .gotoEditItemActivity()
                        .build())
    }

    fun dispose() {
        subscription.unsubscribe()
    }
}