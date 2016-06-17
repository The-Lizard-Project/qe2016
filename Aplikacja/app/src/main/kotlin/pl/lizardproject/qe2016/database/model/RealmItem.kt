package pl.lizardproject.qe2016.database.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RealmItem() : RealmObject() {

    @PrimaryKey var id: String = ""
    var name: String? = null
    var isChecked: Boolean? = null
    var category: String? = null
    var priority: String? = null

    override fun toString(): String {
        return "RealmItem(id='$id', name=$name, isChecked=$isChecked, category=$category, priority=$priority)"
    }
}