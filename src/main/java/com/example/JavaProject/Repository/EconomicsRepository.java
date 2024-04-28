package com.example.JavaProject.Repository;


import com.example.JavaProject.Document.BasicScience;
import com.example.JavaProject.Document.Economics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EconomicsRepository extends MongoRepository<Economics,Integer> {
    List<Economics> findByIdIn(List<Integer> ids);
}
