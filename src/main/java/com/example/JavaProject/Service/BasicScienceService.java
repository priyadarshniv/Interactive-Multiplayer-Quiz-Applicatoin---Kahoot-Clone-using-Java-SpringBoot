package com.example.JavaProject.Service;

import com.example.JavaProject.Document.BasicScience;
import com.example.JavaProject.Model.BasicScienceModel;
import com.example.JavaProject.Model.GeographyModel;
import com.example.JavaProject.Repository.BasicScienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicScienceService {

    private final BasicScienceRepository basicScienceRepository;

    public BasicScienceService(BasicScienceRepository basicScienceRepository) {
        this.basicScienceRepository = basicScienceRepository;
    }

    public List<BasicScienceModel> getList() {
        return basicScienceRepository.findAll().stream()
                .map(bs -> new BasicScienceModel(
                        bs.getID(),
                        bs.getGenereID(),
                        bs.getQuestion(),
                        bs.getOptions(),
                        bs.getCorrectAnswer()
                ))
                .toList();
    }

    public String getDataForButton(int ID) {
        BasicScience data = basicScienceRepository.findById(ID).orElse(null);
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


    public List<BasicScience> getQuestionsByIds(List<Integer> questionIds) {
        return basicScienceRepository.findByIdIn(questionIds);
    }

}
