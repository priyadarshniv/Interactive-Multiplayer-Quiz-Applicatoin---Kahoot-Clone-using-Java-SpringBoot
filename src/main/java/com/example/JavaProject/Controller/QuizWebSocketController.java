package com.example.JavaProject.Controller;

import com.example.JavaProject.Model.QuizAnswer;
import com.example.JavaProject.Model.QuizUpdate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class QuizWebSocketController {

    @MessageMapping("/answer")
    @SendTo("/quiz/update")
    public QuizUpdate updateQuiz(QuizAnswer answer) {
        // Log the received question number for debugging
        System.out.println("Received answer for Question ");

        // Process the user's answer and return the updated state
        // For example, disable the answered question for all users
        String updateMessage = "Question " + " is answered!"+answer.getButton();
        return new QuizUpdate(updateMessage,answer.getButton());
    }
}
