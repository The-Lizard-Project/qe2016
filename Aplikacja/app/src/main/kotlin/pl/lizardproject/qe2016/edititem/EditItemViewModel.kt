package pl.lizardproject.qe2016.edititem

import android.app.Activity
import android.databinding.ObservableField
import android.support.design.widget.Snackbar
import android.text.TextUtils
import android.view.View
import pl.lizardproject.database.qe2016.DatabaseFacade
import pl.lizardproject.qe2016.R
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
    val newItemCategoryPosition = ObservableField(Category.FRUITS.ordinal)
    val newItemPriorityPosition = ObservableField(Priority.NORMAL.ordinal)

    val categories = Category.values().map { it.toString().toLowerCase() }
    val priorities = Priority.values().map { it.toString().toLowerCase() }

    fun saveItemCommand(view: View) {
        if (!TextUtils.isEmpty(newItemName.get())) {
            databaseFacade.saveItem(Item(itemId, newItemName.get(), Category.values()[newItemCategoryPosition.get()], Priority.values()[newItemPriorityPosition.get()]))
            activity.finish()
        } else {
            Snackbar.make(view, activity.getString(R.string.snackbarText), Snackbar.LENGTH_SHORT).show()
        }
    }

    fun dispose() {
        subscription.unsubscribe()
    }
}