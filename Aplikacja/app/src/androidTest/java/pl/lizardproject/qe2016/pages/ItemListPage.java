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
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

public class ItemListPage {
    public ItemListPage() {
        Log.i("Activity: ", ActivityHelper.getActivityName());
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