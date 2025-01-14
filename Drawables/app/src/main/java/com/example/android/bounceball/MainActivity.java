package com.example.android.bounceball;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private BouncingCircleView bouncingCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bouncingCircleView = new BouncingCircleView(this, null);
        setContentView(bouncingCircleView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bouncingCircleView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        bouncingCircleView.pause();
    }
}
