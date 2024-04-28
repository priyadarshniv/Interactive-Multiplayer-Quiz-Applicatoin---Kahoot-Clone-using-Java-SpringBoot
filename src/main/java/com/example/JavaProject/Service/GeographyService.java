package com.example.JavaProject.Service;


import com.example.JavaProject.Document.Geography;
import com.example.JavaProject.Model.GeographyModel;
import com.example.JavaProject.Repository.BasicScienceRepository;
import com.example.JavaProject.Repository.GeographyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeographyService {

    private final GeographyRepository geographyRepository;

    public GeographyService(GeographyRepository geographyRepository) {
        this.geographyRepository = geographyRepository;
    }

    public List<GeographyModel> getList() {
        return geographyRepository.findAll().stream()
                .map(g -> new GeographyModel(
                        g.getID(),
                        g.getGenereID(),
                        g.getQuestion(),
                        g.getOptions(),
                        g.getCorrectAnswer()
                ))
                .toList();
    }

    public String getDataForButton(int ID) {
        Geography data = geographyRepository.findById(ID).orElse(null);
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


    public List<Geography> getQuestionsByIds(List<Integer> questionIds) {
        return geographyRepository.findByIdIn(questionIds);
    }

}
