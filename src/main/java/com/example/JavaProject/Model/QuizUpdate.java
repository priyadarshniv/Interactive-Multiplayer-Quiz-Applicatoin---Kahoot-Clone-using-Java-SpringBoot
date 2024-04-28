package com.example.JavaProject.Model;

public class QuizUpdate {
    private String message;
    private int questionNumber;
    private String selectedAnswer;
    private String correctAnswer;

    private String button;

    // Constructors, getters, and setters

    public QuizUpdate() {
        // Default constructor
    }

    public QuizUpdate(String message, int questionNumber, String selectedAnswer, String correctAnswer, String button) {
        this.message = message;
        this.questionNumber = questionNumber;
        this.selectedAnswer = selectedAnswer;
        this.correctAnswer = correctAnswer;
        this.button=button;
    }

    public QuizUpdate(String updateMessage,String button)
    {
        this.message=updateMessage;
        this.button=button;
    }

    public String getMessage() {
        return message;
    }

    public String getButton() {
        return button;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }


    public void setButton(String button) {
        this.button=button;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
