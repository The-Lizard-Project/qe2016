package pl.lizardproject.qe2016.model

class Item(val name: String, val category: Category, val priority: Priority, val isChecked: Boolean = false, val id: Int? = null) {

    fun checkItem(check: Boolean) = Item(name, category, priority, check, id)
}