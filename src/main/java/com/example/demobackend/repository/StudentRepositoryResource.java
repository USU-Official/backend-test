package com.example.demobackend.repository;

import com.example.demobackend.model.Student;
import com.example.demobackend.repository.mongo.ResourceRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryResource extends ResourceRepository<Student, String> {
}
