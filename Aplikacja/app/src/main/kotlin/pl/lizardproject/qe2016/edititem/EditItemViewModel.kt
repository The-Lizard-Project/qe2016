package pl.lizardproject.qe2016.edititem

import android.app.Activity
import android.databinding.ObservableField
import android.view.View
import pl.lizardproject.database.qe2016.DatabaseFacade
import pl.lizardproject.qe2016.model.Category
import pl.lizardproject.qe2016.model.Item
import pl.lizardproject.qe2016.model.Priority

class EditItemViewModel(private val activity: Activity, private val databaseFacade: DatabaseFacade) {

    val newItemName = ObservableField("")
    val newItemCategoryPosition = ObservableField(0)
    val newItemPriorityPosition = ObservableField(1)

    val categories = Category.values().map { it.toString().toLowerCase() }
    val priorities = Priority.values().map { it.toString().toLowerCase() }

    fun saveItemCommand(view: View) {
        databaseFacade.saveItem(Item(newItemName.get(), Category.values()[newItemCategoryPosition.get()], Priority.values()[newItemPriorityPosition.get()]))
        activity.finish()
    }
}