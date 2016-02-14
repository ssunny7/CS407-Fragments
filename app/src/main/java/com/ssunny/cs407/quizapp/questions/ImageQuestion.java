package com.ssunny.cs407.quizapp.questions;

/**
 * Created by Cygnus on 11/02/2016.
 */
public class ImageQuestion extends Question {
    private int imageId;
    private String answer;

    public ImageQuestion(String questionText, Type questionType) {
        super(questionText, questionType);

        answer = null;
        imageId = -1;
    }

    public void setImageId(int _imageId) {
        imageId = _imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setAnswer(String _answer) {
        answer = _answer;
    }

    public String getAnswer() {
        return answer;
    }
}
