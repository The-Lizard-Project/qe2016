package pl.lizardproject.qe2016.database.converter

import pl.lizardproject.qe2016.database.model.DbItemEntity
import pl.lizardproject.qe2016.model.Item

fun DbItemEntity.toAppModel() = Item(name, isChecked, id)

fun Item.toDbModel(dbItem: DbItemEntity? = null): DbItemEntity {
    val dbModel = dbItem ?: DbItemEntity()
    dbModel.name = name
    dbModel.isChecked = isChecked
    return dbModel
}