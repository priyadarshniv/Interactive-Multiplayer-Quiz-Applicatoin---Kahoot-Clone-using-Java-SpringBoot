package com.example.JavaProject.Repository;


import com.example.JavaProject.Document.BasicScience;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasicScienceRepository extends MongoRepository<BasicScience,Integer> {
    List<BasicScience> findByIdIn(List<Integer> ids);
}
