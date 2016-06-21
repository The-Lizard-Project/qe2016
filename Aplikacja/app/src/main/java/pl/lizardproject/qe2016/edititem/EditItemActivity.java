package pl.lizardproject.qe2016.edititem;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.InjectExtra;

import pl.lizardproject.qe2016.MyApplication;
import pl.lizardproject.qe2016.R;
import pl.lizardproject.qe2016.databinding.ActivityEditItemBinding;

public class EditItemActivity extends AppCompatActivity {

    private EditItemViewModel viewModel;

    @InjectExtra
    @Nullable
    Integer itemId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dart.inject(this);

        viewModel = new EditItemViewModel(itemId, this, ((MyApplication) getApplication()).getDatabaseFacade());
        ((ActivityEditItemBinding) DataBindingUtil.setContentView(this, R.layout.activity_edit_item)).setViewModel(viewModel);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.dispose();
    }
}