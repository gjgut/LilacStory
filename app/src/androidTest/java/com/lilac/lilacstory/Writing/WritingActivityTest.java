package com.lilac.lilacstory.Writing;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.Espresso.*;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.action.ViewActions.*;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.lilac.lilacstory.R;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Objects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasBackground;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

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
    public void FontStyleButtonTest()
    {
        onView(ViewMatchers.withId(R.id.img_btn_font_style))
                .perform(click());
        onView(ViewMatchers.withId(R.id.writing_bar_font_style))
                .check(matches(isDisplayed()));
        onView(withId(R.id.writing_bar_font_size))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }

    @Test
    public void FontSizeButtonTest()
    {
        onView(withId(R.id.img_btn_font_size))
                .perform(click());
        onView(withId(R.id.writing_bar_font_size))
                .check(matches(isDisplayed()));
        onView(withId(R.id.writing_bar_font_style))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }

    @Test
    public void AlignButtonTest()
    {
        onView(withId(R.id.img_btn_align))
                .perform(click());
        onView(withId(R.id.img_btn_align))
                .check(matches(not(withTagValue(CoreMatchers.<Object>equalTo(R.drawable.icon_text_align_center)))));
    }

}
