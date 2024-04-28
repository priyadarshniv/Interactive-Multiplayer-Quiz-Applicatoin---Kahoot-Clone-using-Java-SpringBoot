package com.example.JavaProject.Model;

public class QuizAnswer {
    private String button; // or you can use 'selectedAnswer' instead of 'button'
    private String selectedAnswer;

    // Constructors, getters, and setters

    public QuizAnswer() {
        // Default constructor
    }

    public QuizAnswer(String button, String selectedAnswer) {
        this.button = button;
        this.selectedAnswer = selectedAnswer;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}
