package com.example.demobackend.service;
import com.example.demobackend.model.Student;
import com.example.demobackend.repository.StudentRepository;
import com.example.demobackend.repository.StudentRepositoryResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOptions;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private StudentRepositoryResource studentRepositoryResource;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Object findAll(Integer limit){

        Instant start = Instant.now();
        List<Student> students = studentRepository.getStudentData(limit);
        Instant stop = Instant.now();
        Duration anotate = Duration.between(start,stop);


        HashMap<String,Object> data = new HashMap<>();
        data.put("by_anotate",this.structTime(anotate));
        data.put("size", students.size());

        return data;
    }

    public Object findAllByResource(Integer limit){
        Query query = new Query().limit(limit);
        Instant start = Instant.now();
        List<Student> students = studentRepositoryResource.findAll(query);
        Instant stop = Instant.now();
        Duration anotate = Duration.between(start,stop);


        HashMap<String,Object> data = new HashMap<>();
        data.put("by_resource",this.structTime(anotate));
        data.put("size", students.size());

        return data;
    }

    public HashMap<String, Object> getFilteredStudents(int limit){
        Instant start = Instant.now();
        LimitOperation limitOperation = Aggregation.limit(limit);
        AggregationOptions options = AggregationOptions.builder().allowDiskUse(true).build();

        Aggregation aggregation = Aggregation.newAggregation(limitOperation).withOptions(options);

        List<Student> students = mongoTemplate.aggregate(aggregation, "students", Student.class).getMappedResults();

        Instant stop = Instant.now();
        Duration anotate = Duration.between(start,stop);


        HashMap<String,Object> data = new HashMap<>();
        data.put("by_mongotemplate",this.structTime(anotate));
        data.put("size", students.size());

        return data;

    }

    public String structTime(Duration d){
        int hours = d.toHoursPart();
        int minutes = d.toMinutesPart();
        int second = d.toSecondsPart();
        int ms = d.toMillisPart();

        String exTime = hours+" jam "+minutes+" menit "+second+" detik "+ms+" milidetik";
        return exTime;
    }
}
