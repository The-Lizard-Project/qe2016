package pl.lizardproject.qe2016;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.lizardproject.qe2016.itemlist.ItemListActivity;
import pl.lizardproject.qe2016.pages.ItemListPage;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class Exercise1 {

    @Rule
    public ActivityTestRule<ItemListActivity> itemListActivityActivityTestRule = new ActivityTestRule<ItemListActivity>(ItemListActivity.class);

    @Test
    public void addItem() {

        ItemListPage itemListPage = new ItemListPage();
        itemListPage.ClearWholeList();

        // on the Product List click Add Button
        onView(withId(R.id.fabAdd)).perform(click());

        // On New Item screen type product name...
        onView(withId(R.id.newItemEditText)).perform(typeText("ziemniaki"), closeSoftKeyboard());

        // ...and Save
        onView(withId(R.id.fabSave)).perform(click());

        // Verify if Item was added
        onView(withId(R.id.text)).check(matches(withText("ziemniaki")));

        // Add second element
        onView(withId(R.id.fabAdd)).perform(click());
        onView(withId(R.id.newItemEditText)).perform(typeText("buraki"), closeSoftKeyboard());
        onView(withId(R.id.fabSave)).perform(click());

        // Validate if it was added

        // wrong solution
        //onView(withId(R.id.text)).check(matches(withText("buraki")));

        // good solution
        onView(allOf(withId(R.id.text), withText("buraki"))).check(matches(isDisplayed()));
    }

    // Task2 - create more than 20 different elements and verify
    @Test
    public void addIMoreThan20Items() {

    }

}
