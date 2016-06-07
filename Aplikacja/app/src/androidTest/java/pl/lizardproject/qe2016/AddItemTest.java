package pl.lizardproject.qe2016;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.lizardproject.qe2016.itemlist.ItemListActivity;
import pl.lizardproject.qe2016.pages.AddItemPage;
import pl.lizardproject.qe2016.pages.ItemListPage;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AddItemTest {
    private ItemListPage itemListPage;

    @Rule
    public ActivityTestRule<ItemListActivity> itemListActivityActivityTestRule = new ActivityTestRule<ItemListActivity>(ItemListActivity.class);

    @Before
    public void before(){
        itemListPage = new ItemListPage();
    }

    @Test
    public void addItem() {
        AddItemPage addItemPage;

        for (int i = 0; i < 10; i++) {
            addItemPage = itemListPage.goToAddItemPage();
            itemListPage = addItemPage.addItem("1");
        }
        for (int i = 0; i < 10; i++) {
            itemListPage = itemListPage.removeNthItem(0);
        }
    }
}