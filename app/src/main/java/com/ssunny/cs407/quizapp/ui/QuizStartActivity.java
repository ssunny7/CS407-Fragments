package com.ssunny.cs407.quizapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class QuizStartActivity extends Activity {

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_start);

        startButton = (Button)findViewById(R.id.startButton);
    }
}
