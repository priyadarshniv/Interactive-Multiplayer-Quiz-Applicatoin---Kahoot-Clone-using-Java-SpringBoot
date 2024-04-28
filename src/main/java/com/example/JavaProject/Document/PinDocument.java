package com.example.JavaProject.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "PIN")
public class PinDocument {
    @Id
    private int _id;
    private List<Integer> questionIds;
    private int genreId;

    public PinDocument() {
    }

    public PinDocument(int _id, List<Integer> questionIds, int genreId) {
        this._id = _id;
        this.questionIds = questionIds;
        this.genreId = genreId;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public List<Integer> getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(List<Integer> questionIds) {
        this.questionIds = questionIds;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}
