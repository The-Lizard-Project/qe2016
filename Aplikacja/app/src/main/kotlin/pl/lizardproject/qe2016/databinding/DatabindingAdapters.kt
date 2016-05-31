package pl.lizardproject.qe2016.databinding

import android.databinding.BindingAdapter
import android.databinding.ObservableArrayList
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import pl.lizardproject.qe2016.itemlist.ItemRecyclerViewAdapter
import pl.lizardproject.qe2016.model.Item

@BindingAdapter("items")
fun bindList(view: RecyclerView, list: ObservableArrayList<Item>) {
    if (view.adapter == null) {
        view.layoutManager = LinearLayoutManager(view.context)
        view.adapter = ItemRecyclerViewAdapter(list, view.context)
    } else {
        view.adapter.notifyDataSetChanged()
    }
}