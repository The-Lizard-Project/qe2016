package pl.lizardproject.qe2016.database.converter

import pl.lizardproject.qe2016.database.model.RealmItem
import pl.lizardproject.qe2016.model.Category
import pl.lizardproject.qe2016.model.Item
import pl.lizardproject.qe2016.model.Priority

fun RealmItem.toAppModel() = Item(id, name!!, Category.valueOf(category!!), Priority.valueOf(priority!!), isChecked!!)