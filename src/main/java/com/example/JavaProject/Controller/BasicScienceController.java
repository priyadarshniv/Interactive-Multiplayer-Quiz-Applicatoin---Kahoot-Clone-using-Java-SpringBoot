package com.example.JavaProject.Controller;

import com.example.JavaProject.Document.BasicScience;
import com.example.JavaProject.Model.BasicScienceModel;
import com.example.JavaProject.Model.GeographyModel;
import com.example.JavaProject.Service.BasicScienceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BasicScienceController {

    private final BasicScienceService basicScienceService;

    public BasicScienceController(BasicScienceService basicScienceService) {
        this.basicScienceService = basicScienceService;
    }

    @RequestMapping("/bs")
    public List<BasicScienceModel> getListdetails() {
        return basicScienceService.getList();
    }

    @GetMapping("fetchData")
    public String fetchData(@RequestParam int ID) {
        String data = basicScienceService.getDataForButton(ID);
        return data;
    }

}
