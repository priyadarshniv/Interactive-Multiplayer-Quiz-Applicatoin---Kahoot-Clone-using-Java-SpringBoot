package com.example.JavaProject.Controller;

import com.example.JavaProject.Model.GeographyModel;
import com.example.JavaProject.Service.BasicScienceService;
import com.example.JavaProject.Service.GeographyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeographyController {

    private final GeographyService geographyRepository;

    public GeographyController(GeographyService geographyRepository) {
        this.geographyRepository = geographyRepository;
    }


    @RequestMapping("/g")
    public List<GeographyModel> getListdetails() {
        return geographyRepository.getList();
    }

    @GetMapping("fetchData1")
    public String fetchData(@RequestParam int ID) {
        String data = geographyRepository.getDataForButton(ID);
        return data;
    }

}
