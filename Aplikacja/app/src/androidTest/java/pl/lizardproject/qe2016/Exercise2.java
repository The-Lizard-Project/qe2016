package pl.lizardproject.qe2016;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import pl.lizardproject.qe2016.itemlist.ItemListActivity;

public class Exercise2 {

    @Rule
    public ActivityTestRule<ItemListActivity> itemListActivityActivityTestRule = new ActivityTestRule<>(ItemListActivity.class);

    /* TODO Task1
    Using knowledge and code from Task5 in Exercise1 create simple PageObject of following Activities:
    AddItemPage and ItemListPage

    and using them implement 3 (4th is optional) tests that are below:
    */

    @Test
    public void openAddItemScreen() {

    }

    @Test
    public void addItem() {

    }

    @Test
    public void addMoreThanOneItem() {

    }

    @Test
    public void addTheSameItemMoreThanOnce() {

    }

    /* TODO Task2
    Add Possibility to remove chosen Item from the list into created PageObjects
    */

    @Test
    public void addAndRemoveItem() {

    }

    /* TODO Task3
    Create PageObject for EditItem Activity with needed functionality to change the parameters, then write following test:
    1. Clear whole list
    2. Create single item
    3. Edit item
    4. Validate if item's data has been changed
    */
}