package com.example.android.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   public void playButtonClick(View view){
        Intent intent = new Intent(this, PlayerSetup.class);
        startActivity(intent);

    }
}