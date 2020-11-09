package com.lilac.lilacstory.Register;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.lilac.lilacstory.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RegisterAcitivityTest2 {

    @Rule
    public ActivityTestRule<RegisterAcitivity> mActivityTestRule = new ActivityTestRule<>(RegisterAcitivity.class);

    @Test
    public void registerAcitivityTest2() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.edt_Nickname),
                        childAtPosition(
                                allOf(withId(R.id.Email),
                                        childAtPosition(
                                                withId(R.id.Content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("Hello"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.edt_Email),
                        childAtPosition(
                                allOf(withId(R.id.Nickname),
                                        childAtPosition(
                                                withId(R.id.Content),
                                                2)),
                                2),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("Iknowyou"), closeSoftKeyboard());


        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn_register_submit), withText("회원가입 하기"),
                        childAtPosition(
                                allOf(withId(R.id.Content),
                                        childAtPosition(
                                                withId(R.id.Contents),
                                                1)),
                                8),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction button = onView(
                allOf(withId(R.id.btn_login),
                        childAtPosition(
                                allOf(withId(R.id.Buttons),
                                        childAtPosition(
                                                withId(R.id.ButtonInputs),
                                                0)),
                                0),
                        isDisplayed()));
        button.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
