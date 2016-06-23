package pl.lizardproject.qe2016.itemlist

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pl.lizardproject.qe2016.MyApplication
import pl.lizardproject.qe2016.R
import pl.lizardproject.qe2016.databinding.ActivityItemListBinding

class ItemListActivity : AppCompatActivity() {

    private val viewModel by lazy { ItemListViewModel((application as MyApplication).databaseFacade) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityItemListBinding>(this, R.layout.activity_item_list).viewModel = viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.dispose()
    }
}