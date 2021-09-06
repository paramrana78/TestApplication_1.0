/*
 * *
 *  * Created by param on 9/4/21, 8:01 PM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 9/4/21, 8:01 PM
 *
 */

package com.assign.srijan;


import static junit.framework.Assert.assertNotNull;

import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@Config(manifest=Config.NONE,sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricTestRunner.class)
public class Screen1Test {
    private Screen1 activity;

    // @Before => JUnit 4 annotation that specifies this method should run before each test is run
    // Useful to do setup for objects that are needed in the test
    @Before
    public void setup() {
        // Convenience method to run MainActivity through the Activity Lifecycle methods:
        // onCreate(...) => onStart() => onPostCreate(...) => onResume()
        activity = Robolectric.setupActivity(Screen1.class);
    }

    // @Test => JUnit 4 annotation specifying this is a test to be run
    // The test simply checks that our EditText exists and has the text length more than or equal to 5
    @Test
    public void validateEditText() {
        EditText edit_text_username = activity.findViewById(R.id.edit_text_username);
        EditText edit_text_password = activity.findViewById(R.id.edit_text_password);
        assertNotNull(edit_text_username);
        assertNotNull(edit_text_password);

        if(edit_text_username.getText().length()>5&&edit_text_password.getText().length()>5){
            Log.v("DEBUG","Length check pass");
        }else {
            Log.v("DEBUG","Length check fail");
        }
    }



    @Test
    public void clickButton() {
        Button button_confirm = activity.findViewById(R.id.button_confirm);
        Assert.assertNotNull("button could not be found", button_confirm);
        assertEquals("button does not contain text 'Confirm!'", "Confirm", button_confirm.getText());
    }
}
