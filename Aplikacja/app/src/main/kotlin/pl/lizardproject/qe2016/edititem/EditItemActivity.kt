package pl.lizardproject.qe2016.edititem

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pl.lizardproject.qe2016.MyApplication
import pl.lizardproject.qe2016.R
import pl.lizardproject.qe2016.databinding.ActivityEditItemBinding

class EditItemActivity : AppCompatActivity() {

    private val viewModel by lazy { EditItemViewModel(this, (application as MyApplication).databaseFacade) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityEditItemBinding>(this, R.layout.activity_edit_item).viewModel = viewModel
    }
}