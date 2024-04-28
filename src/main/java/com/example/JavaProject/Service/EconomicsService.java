package com.example.JavaProject.Service;

import com.example.JavaProject.Document.*;
import com.example.JavaProject.Document.Economics;
import com.example.JavaProject.Model.BasicScienceModel;
import com.example.JavaProject.Model.EconomicsModel;
import com.example.JavaProject.Model.*;
import com.example.JavaProject.Repository.BasicScienceRepository;
import com.example.JavaProject.Repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EconomicsService {

    private final EconomicsRepository economicsRepository;

    public EconomicsService(EconomicsRepository economicsRepository) {
        this.economicsRepository = economicsRepository;
    }

    public List<EconomicsModel> getList() {
        return economicsRepository.findAll().stream()
                .map(e -> new EconomicsModel(
                        e.getID(),
                        e.getGenereID(),
                        e.getQuestion(),
                        e.getOptions(),
                        e.getCorrectAnswer()
                ))
                .toList();
    }

    public String getDataForButton(int ID) {
        Economics data = economicsRepository.findById(ID).orElse(null);
        if (data != null) {
            StringBuilder result = new StringBuilder("Question: " + data.getQuestion() + "<br>Options:<br>");
            List<String> options = data.getOptions();

            for (int i = 0; i < options.size(); i++) {
                result.append(i+1).append(". ").append(options.get(i)).append("<br>");
            }

            result.append("Correct Answer: ").append(data.getCorrectAnswer());
            return result.toString();
        } else {
            return "No data found for ID: " + ID;
        }
    }


    public List<Economics> getQuestionsByIds(List<Integer> questionIds) {
        return economicsRepository.findByIdIn(questionIds);
    }

}
