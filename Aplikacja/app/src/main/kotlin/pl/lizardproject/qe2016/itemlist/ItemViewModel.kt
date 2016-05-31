package pl.lizardproject.qe2016.itemlist

import android.databinding.ObservableField
import android.view.View
import android.widget.CompoundButton
import pl.lizardproject.database.qe2016.DatabaseFacade
import pl.lizardproject.qe2016.model.Item


class ItemViewModel(item: Item, val databaseFacade: DatabaseFacade) {

    val item = ObservableField<Item>(item)

    fun onCheckChangedCommand(view: CompoundButton, isChecked: Boolean) {
        databaseFacade.saveItem(item.get().checkItem(isChecked))
    }

    fun onDeleteCommand(view: View) {
        databaseFacade.deleteItem(item.get())
    }
}