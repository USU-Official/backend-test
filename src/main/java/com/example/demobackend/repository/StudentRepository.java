package com.example.demobackend.repository;

import com.example.demobackend.model.Student;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

    @Aggregation("{'$match': {'entry_year' : {'$in': ?0}}}")
    List<Student> getStudentData(Iterable<String> entryYears);

    @Query("{'entry_year' : {'$in': ?0}}")
    List<Student> getStudentData2(Iterable<String> entryYears);

    List<Student> findAllByEntryYear(Iterable<String> entryYears);

    List<Student> findByEntryYearIn(Iterable<String> entryYears);
}
