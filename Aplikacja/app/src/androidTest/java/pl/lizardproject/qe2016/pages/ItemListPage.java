package pl.lizardproject.qe2016.pages;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.util.Log;
import android.view.View;

import org.hamcrest.Matcher;

import pl.lizardproject.qe2016.R;
import pl.lizardproject.qe2016.helpers.ActionHelper;
import pl.lizardproject.qe2016.helpers.ActivityHelper;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by PS on 2016-06-07.
 */

public class ItemListPage {
    public ItemListPage() {
        Log.i("Activity: ", ActivityHelper.getActivityName());
    }

    public AddItemPage goToAddItemPage() {
        ActionHelper.clickOnId(R.id.fabAdd);
        return new AddItemPage();
    }

    public int ClearWholeList() {
        int i = 0;
        while (true) {
            try {
                removeNthItem(0);
            } catch (Exception e) {
                break;
            }
            i++;
        }
        return i;
    }

    public ItemListPage removeNthItem(int item) {
        onView(withId(R.id.recyclerViewList)).perform(
            RecyclerViewActions.actionOnItemAtPosition(item, new ClickDeleteButton()));
        return new ItemListPage();
    }

    private class ClickDeleteButton implements ViewAction {
        ViewAction click = click();

        @Override
        public Matcher<View> getConstraints() {
            return click.getConstraints();
        }

        @Override
        public String getDescription() {
            return " Click Delete Button";
        }

        @Override
        public void perform(UiController uiController, View view) {
            click.perform(uiController, view.findViewById(R.id.deleteButton));
        }
    }
}
