package com.example.demobackend.repository;

import com.example.demobackend.model.Student;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

    @Aggregation("{'$limit': ?0}")
    List<Student> getStudentData(int limit);

}
