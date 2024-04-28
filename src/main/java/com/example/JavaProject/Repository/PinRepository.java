package com.example.JavaProject.Repository;

import com.example.JavaProject.Document.PinDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PinRepository extends MongoRepository<PinDocument, Integer> {
}
