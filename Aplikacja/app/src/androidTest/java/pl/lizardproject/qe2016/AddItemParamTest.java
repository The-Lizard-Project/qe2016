package pl.lizardproject.qe2016;

import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import pl.lizardproject.qe2016.itemlist.ItemListActivity;
import pl.lizardproject.qe2016.pages.AddItemPage;
import pl.lizardproject.qe2016.pages.ItemListPage;

/**
 * Created by PS on 2016-06-12.
 */
@RunWith(Parameterized.class)
@SmallTest
public class AddItemParamTest {

    @Parameterized.Parameters( name = "{index}: {0}" )
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"ziemniaki"},
                {"buraki"},
                {"crash"},
                {"pieczarki"},
                {"kasztany"},
        });
    }

    private final String mOperand;

    public AddItemParamTest(String operand) {
        mOperand = operand;
    }
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

            addItemPage = itemListPage.goToAddItemPage();
            itemListPage = addItemPage.addItem(mOperand);

    }
}
