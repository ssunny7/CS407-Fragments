package com.ssunny.cs407.quizapp.questions;

/**
 * Created by Cygnus on 11/02/2016.
 */
public class ImageQuestion extends Question {
    private String imageUrl;
    private String answer;

    public ImageQuestion(String questionText, Type questionType) {
        super(questionText, questionType);

        answer = imageUrl = null;
    }

    public void setImageUrl(String _imageUrl) {
        imageUrl = _imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setAnswer(String _answer) {
        answer = _answer;
    }

    public String getAnswer() {
        return answer;
    }
}
