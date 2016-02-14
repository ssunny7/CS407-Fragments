package com.ssunny.cs407.quizapp.ui;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ssunny.cs407.quizapp.questions.ImageQuestion;

public class ImageQuestionFragment extends Fragment {

    private ImageView questionImageView;
    private TextView questionImageTextView;
    private EditText answerEditText;
    private ImageQuestion curQuestion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_question_image, container, false);

        questionImageView = (ImageView)view.findViewById(R.id.questionImage);
        questionImageTextView = (TextView)view.findViewById(R.id.questionImageText);
        answerEditText = (EditText)view.findViewById(R.id.answerText);

        return view;
    }

    @Override
    public void onResume() {
        questionImageTextView.setText(curQuestion.getQuestionText());
        questionImageView.setImageResource(curQuestion.getImageId());

        super.onResume();
    }

    public void updateQuestion(ImageQuestion question) {
        curQuestion = question;
    }

    public boolean isAnswerCorrect() {
        String curAnswer = answerEditText.getText().toString();

        return curAnswer.equalsIgnoreCase(curQuestion.getAnswer());
    }
}