package com.ssunny.cs407.quizapp.questions;

import java.util.ArrayList;

/**
 * Created by Cygnus on 11/02/2016.
 */
public class TextQuestion extends Question {
    ArrayList<String> options;
    int answerIndex;

    public TextQuestion(String _questionText, Type _questionType) {
        super(_questionText, _questionType);

        options = null;
        answerIndex = -1;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(int _answerIndex) {
        answerIndex = _answerIndex;
    }

    public String[] getOptions() {
        return (String[])options.toArray();
    }

    public void addOption(String option) {
        if(options == null)
            options = new ArrayList<String>();

        options.add(option);
    }
}
