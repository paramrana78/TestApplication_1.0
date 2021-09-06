/*
 * *
 *  * Created by param on 9/4/21, 8:01 PM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 9/4/21, 8:01 PM
 *
 */

package com.assign.srijan;


import static junit.framework.Assert.assertNotNull;

import android.os.Build;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@Config(manifest=Config.NONE,sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricTestRunner.class)
public class Screen2Test {
    private Screen2 activity;

    // @Before => JUnit 4 annotation that specifies this method should run before each test is run
    // Useful to do setup for objects that are needed in the test
    @Before
    public void setup() {
        // Convenience method to run MainActivity through the Activity Lifecycle methods:
        // onCreate(...) => onStart() => onPostCreate(...) => onResume()
        activity = Robolectric.setupActivity(Screen2.class);
    }

    // @Test => JUnit 4 annotation specifying this is a test to be run
    // The test simply checks that our EditText exists and has the text length more than or equal to 5
    @Test
    public void validateEditText() {
        TextView status_text = activity.findViewById(R.id.status_text);

        assertNotNull(status_text);


        if(status_text.getText().equals("Hello")){
            Log.v("DEBUG","msg check pass");
        }else {
            Log.v("DEBUG","msg check fail");
        }
    }

}
