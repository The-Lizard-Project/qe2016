package pl.lizardproject.qe2016;

import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import pl.lizardproject.qe2016.itemlist.ItemListActivity;
import pl.lizardproject.qe2016.model.Category;
import pl.lizardproject.qe2016.model.Priority;
import pl.lizardproject.qe2016.pages.AddItemPage;
import pl.lizardproject.qe2016.pages.ItemListPage;

public class Exercise2 {
    private ItemListPage itemListPage;
    @Rule
    public ActivityTestRule<ItemListActivity> itemListActivityActivityTestRule = new ActivityTestRule<>(ItemListActivity.class);

    /* TODO Task1
    Using knowledge and code from Task5 in Exercise1 create simple PageObject of following Activities:
    AddItemPage and ItemListPage

    and using them implement 3 (4th is optional) tests that are below:
    */

    @Before
    public void before() {
        itemListPage = new ItemListPage();
        itemListPage.ClearWholeList();
    }

    @Test
    public void openAddItemScreen() {
        AddItemPage addItemPage;
        addItemPage = itemListPage.goToAddItemPage();
        addItemPage.assertPageIsOpened();
    }

    @Test
    public void addItem() {
        AddItemPage addItemPage;
        addItemPage = itemListPage.goToAddItemPage();
        itemListPage = addItemPage.addItem("gruszki");
        itemListPage.assertItemExists("gruszki");
    }

    @Test
    public void addMoreThanOneItem() {
        AddItemPage addItemPage;
        addItemPage = itemListPage.goToAddItemPage();
        itemListPage = addItemPage.addItem("gruszki");

        addItemPage = itemListPage.goToAddItemPage();
        itemListPage = addItemPage.addItem("sliwki");

        itemListPage.assertItemExists("gruszki");
        itemListPage.assertItemExists("sliwki");
    }

    @Test
    public void addTheSameItemNameMoreThanOnce() {
        AddItemPage addItemPage;
        addItemPage = itemListPage.goToAddItemPage();

        addItemPage = itemListPage.goToAddItemPage();
        itemListPage = addItemPage.addItem("gruszki", Category.VEGETABLES.toString().toLowerCase(), null);
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

     /* TODO Task4
    Create list of Items, then using it add end remove each item
    */

}