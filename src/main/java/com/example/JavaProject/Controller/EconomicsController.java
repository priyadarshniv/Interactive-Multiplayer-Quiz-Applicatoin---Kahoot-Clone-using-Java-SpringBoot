package com.example.JavaProject.Controller;

import com.example.JavaProject.Model.*;
import com.example.JavaProject.Service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EconomicsController {

    private final EconomicsService economicsService;

    public EconomicsController(EconomicsService economicsService) {
        this.economicsService = economicsService;
    }

    @RequestMapping("/e")
    public List<EconomicsModel> getListdetails() {
        return economicsService.getList();
    }

    @GetMapping("fetchData2")
    public String fetchData(@RequestParam int ID) {
        String data = economicsService.getDataForButton(ID);
        return data;
    }

}
