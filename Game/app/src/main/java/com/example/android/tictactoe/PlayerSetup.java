package com.example.android.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlayerSetup extends AppCompatActivity {
    private EditText player1;
    private EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_setup);

        player1 = findViewById(R.id.editTextText);
        player2 = findViewById(R.id.editTextText2);
        Button submitButton = findViewById(R.id.button2);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitButtonClick();
            }
        });
    }

    private void submitButtonClick() {
        String player1Name = player1.getText().toString();
        String player2Name = player2.getText().toString();

        Intent intent = new Intent(this, GameDisplay.class);
        intent.putExtra("playerNames", new String[]{player1Name, player2Name});
        startActivity(intent);
    }
}
