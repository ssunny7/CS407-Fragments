package com.ssunny.cs407.quizapp.ui;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ssunny.cs407.quizapp.questions.TextQuestion;

public class TextQuestionFragment extends Fragment {

    private TextQuestion curQuestion;
    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_question_text, container, false);

        questionTextView = (TextView)view.findViewById(R.id.questionText);
        optionsRadioGroup = (RadioGroup)view.findViewById(R.id.optionGroup);
        optionsRadioGroup.check(0);

        return view;
    }

    @Override
    public void onResume() {
        questionTextView.setText(curQuestion.getQuestionText());

        for(int optionIndex = 0; optionIndex < curQuestion.getOptions().length; optionIndex++) {
            String curOption = curQuestion.getOptions()[optionIndex];
            RadioButton curRadio = (RadioButton)(optionsRadioGroup.getChildAt(optionIndex));
            curRadio.setText(curOption);
        }

        super.onResume();
    }

    public void updateQuestion(TextQuestion question) {
        curQuestion = question;
    }

    public boolean isAnswerCorrect() {
        int selectedIndex = optionsRadioGroup.getCheckedRadioButtonId();

        switch(selectedIndex) {
            case R.id.option0: return curQuestion.getAnswerIndex() == 0;
            case R.id.option1: return curQuestion.getAnswerIndex() == 1;
            case R.id.option2: return curQuestion.getAnswerIndex() == 2;
            case R.id.option3: return curQuestion.getAnswerIndex() == 3;
            default: return false;
        }
    }
}