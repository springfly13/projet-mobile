package com.ioweb.concertplace;

import android.support.test.rule.ActivityTestRule;

import com.ioweb.concertplace.*;
import com.ioweb.concertplace.R;
import org.junit.Rule;
import org.junit.Test;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ArtistesSearcheProtocolActivityTest{
    @Rule
    public final ActivityTestRule<ArtistesSearcheProtocolActivity> main = new ActivityTestRule<ArtistesSearcheProtocolActivity>(ArtistesSearcheProtocolActivity.class);

    @Test
    public void testShouldFindSpinner1() {
        onView(withId(R.id.spinner))
                .perform(click());
    }

}


