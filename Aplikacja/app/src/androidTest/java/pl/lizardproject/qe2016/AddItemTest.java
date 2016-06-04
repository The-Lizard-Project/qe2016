package pl.lizardproject.qe2016;

import android.support.test.espresso.PerformException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.lizardproject.qe2016.helpers.ActivityHelper;
import pl.lizardproject.qe2016.itemlist.ItemListActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AddItemTest{

    @Rule
    public ActivityTestRule<ItemListActivity> itemListActivityActivityTestRule = new ActivityTestRule<ItemListActivity>(ItemListActivity.class);

    @Test
    public void addItem(){
        Matcher editText = withId(R.id.newItemEditText);
        Matcher addButton = withId(R.id.addButton);
        Matcher recyclerViewList = withId(R.id.recyclerViewList);
        int elements = 0;
        for (int i = 0 ; i<100;i++ ) {
            onView(editText).perform(typeText(String.valueOf(i)));
            onView(addButton).perform(click());
        }
        onView(editText).perform(closeSoftKeyboard());
        for(int i = 0 ; i<30;i++){
            onView(recyclerViewList).perform(scrollToPosition(100));
                elements++;
                Log.i("Numer: ", Integer.toString(elements-1));
            onView(recyclerViewList).perform(scrollToPosition(0));
        }
        for (int i = 0 ; i<10;i++ ) {
            onView(recyclerViewList).perform(RecyclerViewActions.actionOnItemAtPosition(0, new ClickDeleteButton()));
        }
    }

    @Test
    public void checkActivity(){
        Log.i("Aktywnosc:", ActivityHelper.getActivityName());
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