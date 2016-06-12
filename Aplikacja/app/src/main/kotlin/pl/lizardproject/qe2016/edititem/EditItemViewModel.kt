package pl.lizardproject.qe2016.edititem

import android.app.Activity
import android.databinding.ObservableField
import android.view.View
import pl.lizardproject.database.qe2016.DatabaseFacade
import pl.lizardproject.qe2016.model.Category
import pl.lizardproject.qe2016.model.Item
import pl.lizardproject.qe2016.model.Priority

class EditItemViewModel(val itemId: Int?, private val activity: Activity, private val databaseFacade: DatabaseFacade) {

    private var subscription = databaseFacade.loadItem(itemId)
            .subscribe({
                newItemName.set(it.name)
                newItemCategoryPosition.set(it.category.ordinal)
                newItemPriorityPosition.set(it.priority.ordinal)
            }, { /*new item*/ })

    val newItemName = ObservableField("")
    val newItemCategoryPosition = ObservableField(0)
    val newItemPriorityPosition = ObservableField(1)

    val categories = Category.values().map { it.toString().toLowerCase() }
    val priorities = Priority.values().map { it.toString().toLowerCase() }

    fun saveItemCommand(view: View) {
        if(newItemName.get() == "crash"){
            newItemName.set(null);
        }
        databaseFacade.saveItem(Item(itemId, newItemName.get(), Category.values()[newItemCategoryPosition.get()], Priority.values()[newItemPriorityPosition.get()]))
        activity.finish()
    }

    fun dispose() {
        subscription.unsubscribe()
    }
}