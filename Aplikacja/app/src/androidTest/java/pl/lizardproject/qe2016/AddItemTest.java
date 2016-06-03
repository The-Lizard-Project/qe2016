package pl.lizardproject.qe2016;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.lizardproject.qe2016.itemlist.ItemListActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AddItemTest {

    @Rule
    public ActivityTestRule<ItemListActivity> itemListActivityActivityTestRule = new ActivityTestRule<ItemListActivity>(ItemListActivity.class);

    @Test
    public void addItem(){
        for (int i = 0 ; i<10;i++ ) {
            onView(withId(R.id.newItemEditText)).perform(typeText("1"), closeSoftKeyboard());
            onView(withId(R.id.addButton)).perform(click());
        }
        for (int i = 0 ; i<10;i++ ) {
            onView(withId(R.id.recyclerViewList)).perform(RecyclerViewActions.actionOnItemAtPosition(0, new ClickDeleteButton()));
        }
    }

    public class ClickDeleteButton implements ViewAction {
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