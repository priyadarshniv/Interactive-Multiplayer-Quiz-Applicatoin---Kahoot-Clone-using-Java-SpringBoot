package com.example.JavaProject.Repository;


import com.example.JavaProject.Document.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeographyRepository extends MongoRepository<Geography,Integer> {
    List<Geography> findByIdIn(List<Integer> ids);
}
