package pl.lizardproject.qe2016;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.lizardproject.qe2016.itemlist.ItemListActivity;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class Exercise1 {

    @Rule
    public ActivityTestRule<ItemListActivity> itemListActivityActivityTestRule = new ActivityTestRule<>(ItemListActivity.class);

    /* TODO TASK 1
     * Use methods available via Espresso: onView(), withId(), perform(), click()
     *
     * 1. Find button that adds item
     * 2. Click on it
     *
     * 3. Move to the previous screen(hint: use pressBack())
    */
    @Test
    public void openAddItemScreen() {
        //TODO: Fill this
    }

    /* TODO TASK 2
     * Use selected methods from task 1 and new ones: typeText(), closeSoftKeyboard(), check(), matches(), isDisplayed()
     *
     * 1. Find button that adds item
     * 2. Click on it
     * 3. Verify if user is on the right activity
     *
     * 4. Find edit text item
     * 5. Type text there and close keyboard
     * 6. Save added item
     *
     * 7. Verify if user was moved to the right activity
     * 8. Verify if proper item was added
     *
     */
    @Test
    public void addItem() {
        //TODO: Fill this
    }

    /* TODO TASK 3
     * Use knowledge and selected methods from previous tasks and new ones: allOf(), withText()
     *
     * Add more than one item and verify
     *
     */
    @Test
    public void addMoreThanOneItem() {
        //TODO: Fill this
    }

    /* TODO task 4 for volunteers
     * Using chosen methods from previous tasks and Google :)
     *
     * Add more than one item with the same name but with different type or priority, then verify
     */
    @Test
    public void addTheSameItemNameMoreThanOnce() {
        //TODO: Fill this
    }

    // TODO Task 5
    // Find and extract common parts of tests 1-4 so that your code has minimal possible amount of duplication.
}
