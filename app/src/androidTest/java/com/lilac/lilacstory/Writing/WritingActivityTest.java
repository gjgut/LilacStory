package com.lilac.lilacstory.Writing;

import android.view.View;
import android.widget.EditText;

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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

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
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(RobolectricTestRunner.class)
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
        WritingActivity activity = Robolectric.setupActivity(WritingActivity.class);
        EditText text = activity.findViewById(R.id.edt_writing);
        Assert.assertThat(text.getText().toString(),CoreMatchers.equalTo(""));

    }

    @Ignore
    public void FontSizeButtonTest()
    {

    }

    @Ignore
    public void AlignButtonTest()
    {
    }

}
