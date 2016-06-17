package pl.lizardproject.qe2016.model

class Item(val id: String, val name: String, val category: Category, val priority: Priority, val isChecked: Boolean =
false) {

    fun checkItem(check: Boolean) = Item(id, name, category, priority, check)

    override fun toString(): String {
        return "Item(id='$id', name='$name', category=$category, priority=$priority, isChecked=$isChecked)"
    }
}