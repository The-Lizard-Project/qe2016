package pl.lizardproject.qe2016.pages;

import android.util.Log;

import pl.lizardproject.qe2016.R;
import pl.lizardproject.qe2016.helpers.ActionHelper;
import pl.lizardproject.qe2016.helpers.ActivityHelper;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by PS on 2016-06-07.
 */

public class AddItemPage {

    protected AddItemPage() {
        Log.i("Activity: ", ActivityHelper.getActivityName());
    }

    public ItemListPage addItem(String item) {
        onView(withId(R.id.newItemEditText)).perform(typeText(item), closeSoftKeyboard());
        ActionHelper.clickOnId(R.id.fabSave);
        return new ItemListPage();
    }
}
