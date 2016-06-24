package pl.lizardproject.qe2016.pages;

import android.util.Log;

import pl.lizardproject.qe2016.R;
import pl.lizardproject.qe2016.helpers.ActionHelper;
import pl.lizardproject.qe2016.helpers.ActivityHelper;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class AddItemPage {

    protected AddItemPage() {
        Log.i("Activity: ", ActivityHelper.getActivityName());
    }

    public ItemListPage addItem(String item) {
        onView(withId(R.id.newItemEditText)).perform(typeText(item), closeSoftKeyboard());
        ActionHelper.clickOnId(R.id.fabSave);
        return new ItemListPage();
    }

    public ItemListPage addItem(String item, String category, String priority) {

        onView(withId(R.id.newItemEditText)).perform(typeText(item), closeSoftKeyboard());

        if (category != null) {
            onView(withId(R.id.category_spinner)).perform(click());
            onView(withText(category)).perform(click());
        }

        if (priority != null) {
            onView(withId(R.id.priority_spinner)).perform(click());
            onView(withText(priority)).perform(click());
        }

        ActionHelper.clickOnId(R.id.fabSave);
        return new ItemListPage();
    }


    public void assertPageIsOpened() {
        onView(withId(R.id.fabSave)).check(matches(isDisplayed()));
    }
}
