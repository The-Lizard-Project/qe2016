package pl.lizardproject.qe2016.itemlist

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.lizardproject.qe2016.MyApplication
import pl.lizardproject.qe2016.R
import pl.lizardproject.qe2016.databinding.ItemItemListBinding
import pl.lizardproject.qe2016.model.Item

class ItemRecyclerViewAdapter(private val list: ObservableArrayList<Item>, private val context: Context) : RecyclerView.Adapter<ItemRecyclerViewAdapter.BindingViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    private val databaseFacade = (context.applicationContext as MyApplication).databaseFacade

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BindingViewHolder(layoutInflater.inflate(R.layout.item_item_list, parent, false))

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        holder.binder.viewModel = ItemViewModel(list[position], context, databaseFacade)
        holder.binder.executePendingBindings()
    }

    override fun getItemCount() = list.count()

    class BindingViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var binder: ItemItemListBinding = DataBindingUtil.bind(view)
    }
}