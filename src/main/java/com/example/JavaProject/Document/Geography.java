package com.example.JavaProject.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Geography")
public class Geography {

    @Id
    private int id;
    private int GenereID;
    private String Question;
    private List<String> Options;
    private String CorrectAnswer;

    // Add getters and setters here



    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public int getGenereID() {
        return GenereID;
    }

    public void setGenereID(int GenereID) {
        this.GenereID = GenereID;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public List<String> getOptions() {
        return Options;
    }

    public void setOptions(List<String> Options) {
        this.Options = Options;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String CorrectAnswer) {
        this.CorrectAnswer = CorrectAnswer;
    }
}
