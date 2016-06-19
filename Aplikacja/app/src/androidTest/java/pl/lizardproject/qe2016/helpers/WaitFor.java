package pl.lizardproject.qe2016.helpers;

import android.content.res.Resources;
import android.support.test.espresso.NoMatchingViewException;

import junit.framework.AssertionFailedError;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by PS on 2016-06-19.
 */

public class WaitFor {

    private static int exceptionTries = 1000;
    private static int waitTries = 1000;

    public static void Text(String str) {

        for (int i = 1; i < exceptionTries; i++) {
            try {
                onView(withText(str)).check(matches(isDisplayed()));
                continue;
            } catch (AssertionFailedError pEx) {
                doLoop();
            } catch (NoMatchingViewException nmWEx) {
                doLoop();
            } catch (Resources.NotFoundException nfEx) {
                doLoop();
            }
        }
        onView(withText(str)).check(matches(isDisplayed()));
    }

    public static void Id(int id) {

        for (int i = 1; i < exceptionTries; i++) {
            try {
                onView(withId(id)).check(matches(isDisplayed()));
                continue;
            } catch (AssertionFailedError pEx) {
                doLoop();
            } catch (NoMatchingViewException nmWEx) {
                doLoop();
            } catch (Resources.NotFoundException nfEx) {
                doLoop();
            }
        }
        onView(withId(id)).check(matches(isDisplayed()));
    }

    private static void doLoop() {
        for (int j = 0; j < waitTries; ) {
            j = j + 1;
        }
    }
}
