package com.example.adapterandview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Flashcard> flashcards;
    private int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        Button btnPrevious = findViewById(R.id.btnPrevious);
        Button btnNext = findViewById(R.id.btnNext);

        flashcards = new ArrayList<>();
        flashcards.add(new Flashcard("What is the time complexity of the Quick Sort algorithm?", "O (n log n"));
        flashcards.add(new Flashcard("Which sorting algorithm has the best average-case time complexity?", "Merge Sort"));
        flashcards.add(new Flashcard("Which sorting algorithm is based in the principle of divide and conquer?", "Merge Sort"));
        flashcards.add(new Flashcard("Which sorting algorithm is commonly used for sorting small arrays or as a subroutine in more advanced sorting algorithms?", "Insertion Sort"));
        flashcards.add(new Flashcard("Which sorting algorithm works by repeatedly stepping through the list to be sorted?", "Bubble Sort"));
        flashcards.add(new Flashcard("Which sorting algorithm is not suitable for large datasets due to its quadratic time complexity?", "Bubble Sort"));

        FlashcardAdapter flashcardAdapter = new FlashcardAdapter(flashcards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(flashcardAdapter);

        btnPrevious.setOnClickListener(v -> showPreviousQuestion());
        btnNext.setOnClickListener(v -> showNextQuestion());
    }

    private void showPreviousQuestion() {
        if (currentPosition > 0) {
            currentPosition--;
            recyclerView.scrollToPosition(currentPosition);
        }
    }

    private void showNextQuestion() {
        if (currentPosition < flashcards.size() - 1) {
            currentPosition++;
            recyclerView.scrollToPosition(currentPosition);
        }
    }
}
