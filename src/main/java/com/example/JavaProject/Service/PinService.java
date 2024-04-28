package com.example.JavaProject.Service;

import com.example.JavaProject.Document.BasicScience;
import com.example.JavaProject.Document.PinDocument;
import com.example.JavaProject.Repository.BasicScienceRepository;
import com.example.JavaProject.Repository.PinRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinService {

    @Autowired
    private PinRepository pinRepository;

    public void savePin(PinDocument pinDocument) {
        pinRepository.save(pinDocument);
    }
    public Optional<PinDocument> getPinById(int pinId) {
        return pinRepository.findById(pinId);
    }


}
