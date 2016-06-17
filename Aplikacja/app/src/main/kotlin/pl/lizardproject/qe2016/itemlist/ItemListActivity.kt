package pl.lizardproject.qe2016.itemlist

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pl.lizardproject.qe2016.MyApplication
import pl.lizardproject.qe2016.R
import pl.lizardproject.qe2016.databinding.ActivityItemListBinding

class ItemListActivity : AppCompatActivity() {

    private var viewModel: ItemListViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ItemListViewModel((application as MyApplication).databaseFacade)
        DataBindingUtil.setContentView<ActivityItemListBinding>(this, R.layout.activity_item_list).viewModel = viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel!!.dispose()
    }
}