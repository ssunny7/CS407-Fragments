package com.ssunny.cs407.quizapp.questions;

import java.util.ArrayList;

/**
 * Created by ssunny7 on 11/02/2016.
 */
public class QuestionFactory {
    public static ArrayList<Question> questionBank = null;

    public static ArrayList<Question> buildQuestionBank() {
        questionBank = new ArrayList<Question>();

        ImageQuestion question1 = new ImageQuestion("Question 1 Text", Question.Type.Text);
        questionBank.add(question1);

        TextQuestion question2 = new TextQuestion("Question 2 Text", Question.Type.Image);
        questionBank.add(question2);

        return questionBank;
    }

    public static ArrayList<Question> getQuestionBank() {
        if(questionBank == null)
            questionBank = buildQuestionBank();

        return questionBank;
    }
}
