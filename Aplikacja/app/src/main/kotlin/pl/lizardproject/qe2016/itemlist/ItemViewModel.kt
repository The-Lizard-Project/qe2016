package pl.lizardproject.qe2016.itemlist

import android.content.Context
import android.databinding.ObservableField
import android.view.View
import android.widget.CompoundButton
import pl.lizardproject.database.qe2016.DatabaseFacade
import pl.lizardproject.qe2016.edititem.Henson
import pl.lizardproject.qe2016.model.Item


class ItemViewModel(item: Item, private val context: Context, private val databaseFacade: DatabaseFacade) {

    val item = ObservableField(item)

    fun onCheckChangedCommand(view: CompoundButton, isChecked: Boolean) {
        if (item.get().isChecked != isChecked) {
            databaseFacade.saveItem(item.get().checkItem(isChecked))
        }
    }

    fun onDeleteClickCommand(view: View) {
        databaseFacade.deleteItem(item.get())
    }

    fun onClickCommand(view: View) {
        val intent = Henson.with(context)
                .gotoEditItemActivity()
                .itemId(item.get().id!!)
                .build()

        context.startActivity(intent)
    }
}