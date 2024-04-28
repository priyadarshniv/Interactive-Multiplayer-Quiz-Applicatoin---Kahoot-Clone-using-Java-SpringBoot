package com.example.JavaProject.Controller;

import com.example.JavaProject.Document.BasicScience;
import com.example.JavaProject.Document.PinDocument;
import com.example.JavaProject.Repository.PinRepository;
import com.example.JavaProject.Service.BasicScienceService;
import com.example.JavaProject.Service.PinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/create/api")
public class PinController {



    @Autowired
    private PinService pinService;

    @Autowired
    private BasicScienceService basicScienceService;

    @Autowired
    private PinRepository pinRepository;

    private final ConcurrentHashMap<Integer, AtomicInteger> pinPlayerCountMap = new ConcurrentHashMap<>();

    @PostMapping("/savePin")
    public String savePin(@RequestBody PinDocument pinDocument) {
        try {
            pinService.savePin(pinDocument);
            return "PIN data saved successfully!";
        } catch (Exception e) {
            return "Error saving PIN data.";
        }
    }

    @GetMapping("/verifyPin")
    @ResponseBody
    public String verifyPin(@RequestParam int enteredPin) {
        try {
            Optional<PinDocument> pinOptional = pinRepository.findById(enteredPin);

            if (pinOptional.isPresent()) {
                int pinId = pinOptional.get().get_id();
                int playerCount = pinPlayerCountMap.computeIfAbsent(pinId, k -> new AtomicInteger(0)).incrementAndGet();

                if (playerCount <= 5) {
                    return "true";
                } else {
                    pinPlayerCountMap.get(pinId).decrementAndGet();
                    return "false";
                }
            } else {
                return "false"; // PIN not found
            }
        } catch (Exception e) {
            return "false";
        }
    }
    @GetMapping("/getQuestionsByPin")
    public List<BasicScience> getQuestionsByPin(@RequestParam int enteredPin) {
        try {
            Optional<PinDocument> pinOptional = pinService.getPinById(enteredPin);

            if (pinOptional.isPresent()) {
                PinDocument pinDocument = pinOptional.get();
                List<Integer> questionIds = pinDocument.getQuestionIds();
                return basicScienceService.getQuestionsByIds(questionIds);
            } else {
                return Collections.emptyList(); // PIN not found
            }
        } catch (Exception e) {
            // Log the exception
            return Collections.emptyList();
        }
    }


}
