package com.lilac.lilacstory.Writing;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.lilac.lilacstory.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class WritingActivityTest {

    private String stringTobeTyped="";

    @Rule
    public ActivityTestRule<WritingActivity> activityTestRule = new ActivityTestRule<>(WritingActivity.class);

    @Before
    public void initValidString()
    {
        stringTobeTyped="Hello";
    }

    @Test
    public void changeText()
    {

        Espresso.onView(ViewMatchers.withId(R.id.edt_writing))
                .perform(ViewActions.typeText("Hello World!"),ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.edt_writing))
                .check(ViewAssertions.matches(ViewMatchers.withText("Hello World!")));
    }


}
