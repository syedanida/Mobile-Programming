package com.example.a2_activitiesandintents;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private TextView answerTextView;
    private SharedPreferences sharedPreferences;
    private static final String FLASHCARD_INDEX_KEY = "flashcard_index";

    private final String[] flashcards = {
            "1. What is a sorting algorithm?\n\nA sorting algorithm is a step-by-step procedure used for arranging elements in a specific order.",
            "2. What is the time complexity of a sorting algorithm?\n\nTime complexity measures the amount of time an algorithm takes to complete based on the size of the input data. Sorting algorithms can have different time complexities, such as O(n log n) for efficient ones like merge sort and quicksort.",
            "3. What is the difference between comparison and non-comparison sorting algorithms?\n\nComparison sorting algorithms determine the order of elements by comparing them, while non-comparison algorithms, like counting sort, use properties of the data to achieve sorting without explicit comparisons.",
            "4. Explain the concept of stability in sorting algorithms.\n\nStability in sorting means that the relative order of equal elements remains unchanged after sorting. Stable sorting algorithms maintain the original order of equal elements in the sorted output.",
            "5. Give an example of an in-place sorting algorithm.\n\nAn example of an in-place sorting algorithm is the in-place version of quicksort, where the partitioning is done in situ."
    };

    private int currentCardIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        answerTextView = findViewById(R.id.answerTextView);
        Button nextButton = findViewById(R.id.nextButton);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        currentCardIndex = sharedPreferences.getInt(FLASHCARD_INDEX_KEY, 0);
        displayCard();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextCard();
            }
        });

        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
    }

    private void showNextCard() {
        currentCardIndex = (currentCardIndex + 1) % flashcards.length;
        displayCard();
        saveCurrentCardIndex();
    }

    private void displayCard() {
        String[] parts = flashcards[currentCardIndex].split("\n\n");
        questionTextView.setText(parts[0]);
        answerTextView.setText(parts[1]);
    }

    private void saveCurrentCardIndex() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(FLASHCARD_INDEX_KEY, currentCardIndex);
        editor.apply();
    }
}
