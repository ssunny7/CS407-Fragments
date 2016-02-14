package com.ssunny.cs407.quizapp.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.ssunny.cs407.quizapp.questions.Question;
import com.ssunny.cs407.quizapp.questions.QuestionFactory;
import com.ssunny.cs407.quizapp.ui.R;

import java.util.ArrayList;

public class QuizPlayActivity extends FragmentActivity implements ProgressFragment.ProgressNotifier {

    private ArrayList<Question> questionList = null;
    private int questionIndex = -1;
    private int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_play);
    }

    @Override
    protected void onStart() {
        questionList = QuestionFactory.buildQuestionBank();
        questionIndex = 0;
        super.onStart();
    }

    private void loadNextQuestion(FragmentManager fragmentManager, FragmentTransaction fragmentTransaction) {
        Question curQuestion = questionList.get(questionIndex);

        switch(curQuestion.getQuestionType()) {
            case Text:TextQuestionFragment textQuestionFragment = new TextQuestionFragment();
                textQuestionFragment.updateQuestion(QuestionFactory.getNextTextQuestion());
                fragmentTransaction.replace(R.id.questionFragment, textQuestionFragment, TextQuestionFragment.class.getSimpleName());
                break;
            case Image:ImageQuestionFragment imageQuestionFragment = new ImageQuestionFragment();
                imageQuestionFragment.updateQuestion(QuestionFactory.getNextImageQuestion());
                fragmentTransaction.replace(R.id.questionFragment, imageQuestionFragment, ImageQuestionFragment.class.getSimpleName());
                break;
        }

        questionIndex++;
    }

    @Override
    protected void onResume() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        loadNextQuestion(fragmentManager, fragmentTransaction);

        Fragment curProgressFragment = fragmentManager.findFragmentById(R.id.progressFragment);
        if(curProgressFragment == null || !(curProgressFragment instanceof ProgressFragment)) {
            ProgressFragment progressFragment = new ProgressFragment();
            fragmentTransaction.add(R.id.progressFragment, progressFragment, ProgressFragment.class.getSimpleName());
        }

        fragmentTransaction.commit();

        super.onResume();
    }

    public void nextClicked() {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment curFragment = fragmentManager.findFragmentById(R.id.questionFragment);
        if(curFragment instanceof ImageQuestionFragment) {
            ImageQuestionFragment fragment = (ImageQuestionFragment)curFragment;
            if(fragment.isAnswerCorrect())
                score++;
        } else {
            TextQuestionFragment fragment = (TextQuestionFragment)curFragment;
            if(fragment.isAnswerCorrect())
                score++;
        }

        if(questionIndex == questionList.size()) {
            Intent endActivityIntent = new Intent(getBaseContext(), QuizEndActivity.class);

            Bundle bundle = new Bundle();
            bundle.putInt("SCORE", score);
            endActivityIntent.putExtras(bundle);

            startActivity(endActivityIntent);
            finish();
        } else {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            loadNextQuestion(fragmentManager, fragmentTransaction);

            fragmentTransaction.commit();
        }
    }
}
