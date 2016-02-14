package com.ssunny.cs407.quizapp.questions;

import com.ssunny.cs407.quizapp.ui.R;

import java.util.ArrayList;

/**
 * Created by ssunny7 on 11/02/2016.
 */
public class QuestionFactory {
    public static ArrayList<Question> questionBank = null;

    private static ArrayList<TextQuestion> textQuestions = null;
    private static ArrayList<ImageQuestion> imageQuestions = null;
    private static int textQuestionIndex = -1;
    private static int imageQuestionIndex = -1;

    public static ArrayList<Question> buildQuestionBank() {
        questionBank = new ArrayList<Question>();

        textQuestions = new ArrayList<TextQuestion>();
        textQuestionIndex = -1;
        imageQuestions = new ArrayList<ImageQuestion>();
        imageQuestionIndex = -1;

        ImageQuestion question1 = new ImageQuestion("What fruit is this?", Question.Type.Image);
        question1.setAnswer("banana");
        question1.setImageId(R.raw.banana);
        questionBank.add(question1);
        imageQuestions.add(question1);
        imageQuestionIndex++;

        TextQuestion question2 = new TextQuestion("Which is the most expensive city in the world?", Question.Type.Text);
        question2.addOption("Geneva");
        question2.addOption("London");
        question2.addOption("New York City");
        question2.addOption("Seoul");
        question2.setAnswerIndex(2);
        questionBank.add(question2);
        textQuestions.add(question2);
        textQuestionIndex++;

        return questionBank;
    }

    public static ArrayList<Question> getQuestionBank() {
        if(questionBank == null)
            questionBank = buildQuestionBank();

        return questionBank;
    }

    public static TextQuestion getNextTextQuestion() {
        if(textQuestionIndex == textQuestions.size())
            return null;

        return textQuestions.get(textQuestionIndex++);
    }

    public static ImageQuestion getNextImageQuestion() {
        if(imageQuestionIndex == imageQuestions.size())
            return null;

        return imageQuestions.get(imageQuestionIndex++);
    }
}
