package pl.lizardproject.qe2016.helpers;

import android.content.res.Resources;
import android.support.test.espresso.NoMatchingViewException;

import junit.framework.AssertionFailedError;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class WaitFor {

    private static int exceptionTries = 10;
    private static int sleepTime = 1000;

    public static void text(String str) {

        for (int i = 1; i < exceptionTries; i++) {
            try {
                onView(withText(str)).check(matches(isDisplayed()));
                continue;
            } catch (AssertionFailedError ignored) {
                doLoop();
            } catch (NoMatchingViewException ignored) {
                doLoop();
            } catch (Resources.NotFoundException ignored) {
                doLoop();
            }
        }
        onView(withText(str)).check(matches(isDisplayed()));
    }

    public static void id(int id) {

        for (int i = 1; i < exceptionTries; i++) {
            try {
                onView(withId(id)).check(matches(isDisplayed()));
                continue;
            } catch (AssertionFailedError ignored) {
                doLoop();
            } catch (NoMatchingViewException ignored) {
                doLoop();
            } catch (Resources.NotFoundException ignored) {
                doLoop();
            }
        }
        onView(withId(id)).check(matches(isDisplayed()));
    }

    private static void doLoop() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
