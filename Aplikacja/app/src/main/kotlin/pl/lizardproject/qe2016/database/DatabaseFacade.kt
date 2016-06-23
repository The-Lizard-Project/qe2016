package pl.lizardproject.qe2016.database

import android.content.Context
import io.requery.Persistable
import io.requery.android.sqlitex.SqlitexDatabaseSource
import io.requery.rx.RxSupport
import io.requery.sql.EntityDataStore
import io.requery.sql.TableCreationMode
import pl.lizardproject.qe2016.BuildConfig
import pl.lizardproject.qe2016.database.converter.toAppModel
import pl.lizardproject.qe2016.database.converter.toDbModel
import pl.lizardproject.qe2016.database.model.DbItemEntity
import pl.lizardproject.qe2016.database.model.Models
import pl.lizardproject.qe2016.model.Item
import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.Executors

class DatabaseFacade(private val context: Context) {

    private val scheduler = Schedulers.from(Executors.newSingleThreadExecutor())

    val storage by lazy {
        // override onUpgrade to handle migrating to a new version
        val source = SqlitexDatabaseSource(context, Models.DEFAULT, 1)
        source.setLoggingEnabled(true)

        if (BuildConfig.DEBUG) {
            // use this in development mode to drop and recreate the tables on every upgrade
            source.setTableCreationMode(TableCreationMode.DROP_CREATE)
        }

        RxSupport.toReactiveStore(EntityDataStore<Persistable>(source.configuration))
    }

    fun saveItem(item: Item) {
        storage.findByKey(DbItemEntity::class.java, item.id)
                .subscribeOn(scheduler)
                .flatMap { dbItem ->
                    if (dbItem != null) {
                        storage.update(item.toDbModel(dbItem))
                    } else {
                        storage.insert(item.toDbModel())
                    }
                }
                .subscribe { }
    }

    fun loadItems() = storage.select(DbItemEntity::class.java)
            .orderBy(DbItemEntity.CHECKED.asc())
            .get()
            .toSelfObservable()
            .subscribeOn(scheduler)
            .map { it.map { it.toAppModel() } }
            .observeOn(AndroidSchedulers.mainThread())

    fun deleteItem(item: Item) {
        storage.findByKey(DbItemEntity::class.java, item.id)
                .subscribeOn(scheduler)
                .flatMap { dbItem ->
                    if (dbItem != null) {
                        storage.delete(item.toDbModel(dbItem))
                    } else {
                        Single.just(dbItem)
                    }
                }
                .subscribe { }
    }

    fun loadItem(itemId: Int?) = storage.select(DbItemEntity::class.java)
            .get()
            .toSelfObservable()
            .subscribeOn(scheduler)
            .map { it.first { it.id == itemId } }
            .map { it.toAppModel() }
}