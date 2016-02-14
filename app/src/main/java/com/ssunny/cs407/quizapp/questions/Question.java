package com.ssunny.cs407.quizapp.questions;

/**
 * Created by ssunny7 on 11/02/2016.
 */
public class Question {
    public static enum Type {
        Text,
        Image
    };

    private String questionText;
    private Type questionType;

    public Question(String _questionText, Type _questionType) {
        questionText = _questionText;
        questionType = _questionType;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Type getQuestionType() {
        return questionType;
    }

}
