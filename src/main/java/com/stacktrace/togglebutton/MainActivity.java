package com.stacktrace.togglebutton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

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
        mToggleButton.setToogleState(ToggleButton.ToggleState.Close);
        mToggleButton.setOnToggleStateChangeListener(new ToggleButton.onToggleStateChangeListener() {
            @Override
            public void onToggleStateChange(ToggleButton.ToggleState state) {
                Toast.makeText(MainActivity.this, state == ToggleButton.ToggleState.Open ? "Open" : "Close", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
