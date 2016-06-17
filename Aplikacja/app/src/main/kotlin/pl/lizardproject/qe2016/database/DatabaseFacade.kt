package pl.lizardproject.database.qe2016

import android.content.Context
import android.text.TextUtils
import io.realm.Realm
import io.realm.RealmConfiguration
import pl.lizardproject.qe2016.database.converter.toAppModel
import pl.lizardproject.qe2016.database.model.RealmItem
import pl.lizardproject.qe2016.model.Item
import rx.Observable
import java.util.*

class DatabaseFacade(private val context: Context) {

    val realm by lazy {
        val realmConfig: RealmConfiguration = RealmConfiguration.Builder(context).build()
        Realm.setDefaultConfiguration(realmConfig)
        Realm.getDefaultInstance()
    }

    fun saveItem(item: Item) {
        realm.beginTransaction()
        try {
            val realmItem = getRealmItem(item)
            if (realmItem == null) {
                realm.cancelTransaction()
                return
            }
            realmItem.category = item.category.toString()
            realmItem.priority = item.priority.toString()
            realmItem.id = UUID.randomUUID().toString()
            realmItem.isChecked = item.isChecked
            realmItem.name = item.name
            realm.commitTransaction()
        } catch (e: Exception) {
            realm.cancelTransaction()
        }
    }

    private fun getRealmItem(item: Item): RealmItem? {
        return if (TextUtils.isEmpty(item.id)) realm.createObject(RealmItem::class.java) else realm
                .where(RealmItem::class.java)
                .equalTo("id", item.id)
                .findFirst()
    }

    fun loadItems() = Observable.defer {
        realm.where(RealmItem::class.java)
                .findAll()
                .asObservable()
                .flatMap {
                    Observable.from(it.toTypedArray())
                            .map { it -> it.toAppModel() }
                            .toList()
                }
    }

    fun deleteItem(itemId: String) {
        try {
            realm.beginTransaction()
            realm.where(RealmItem::class.java)
                    .equalTo("id", itemId)
                    .findFirst()
                    .deleteFromRealm()
            realm.commitTransaction()
        } catch (ex: Exception) {
            realm.cancelTransaction()
        }
    }

    fun loadItem(itemId: String) = Observable.defer {
        Observable.just(realm.where(RealmItem::class.java)
                .equalTo("id", itemId)
                .findFirst())
                .map { it -> it.toAppModel() }
    }
}