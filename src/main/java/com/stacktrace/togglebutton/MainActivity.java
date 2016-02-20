package com.stacktrace.togglebutton;

import android.app.Activity;
import android.os.Bundle;

import com.stacktrace.togglebutton.view.ToggleButton;

public class MainActivity extends Activity {
    private ToggleButton mToggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToggleButton = (ToggleButton) findViewById(R.id.toggle_button);
        
        mToggleButton.setSlideBackgroundResource(R.drawable.slide_button_background);
        mToggleButton.setSwitchBackgroundResource(R.drawable.switch_background);
        //mToggleButton.setToogleState(ToggleButton.ToggleState.Open);
    }
}
