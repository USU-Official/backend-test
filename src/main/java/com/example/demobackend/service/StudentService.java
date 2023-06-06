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

    private List<String> entryYears = List.of("2004/2005", "2005/2006", "2019/2020", "2020/2021", "2021/2022");
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private StudentRepositoryResource studentRepositoryResource;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Object findAll(){

        Instant start = Instant.now();
        List<Student> students = studentRepository.getStudentData(entryYears);
        Instant stop = Instant.now();
        Duration anotate = Duration.between(start,stop);


        HashMap<String,Object> data = new HashMap<>();
        data.put("by_anotate",this.structTime(anotate));
        data.put("size", students.size());

        return data;
    }

    public Object findAll3(){

        Instant start = Instant.now();
        List<Student> students = studentRepository.getStudentData2(entryYears);
        Instant stop = Instant.now();
        Duration anotate = Duration.between(start,stop);


        HashMap<String,Object> data = new HashMap<>();
        data.put("by_anotate3",this.structTime(anotate));
        data.put("size", students.size());

        return data;
    }

    public Object findAllIn(){

        Instant start = Instant.now();
        List<Student> students = studentRepository.findByEntryYearIn(entryYears);
        Instant stop = Instant.now();
        Duration anotate = Duration.between(start,stop);


        HashMap<String,Object> data = new HashMap<>();
        data.put("by_anotate_in",this.structTime(anotate));
        data.put("size", students.size());

        return data;
    }

    public Object findAll2(){

        Instant start = Instant.now();
        List<Student> students = studentRepository.findAllByEntryYear(entryYears);
        Instant stop = Instant.now();
        Duration anotate = Duration.between(start,stop);


        HashMap<String,Object> data = new HashMap<>();
        data.put("by_anotate2",this.structTime(anotate));
        data.put("size", students.size());

        return data;
    }

    public Object findAllByResource(Integer limit){
        Instant start = Instant.now();
        Query query = new Query();
        query.addCriteria(Criteria.where("entry_year").in(entryYears));

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
        MatchOperation match = Aggregation.match(Criteria.where("entry_year").in(entryYears));
//        LimitOperation limitOperation = Aggregation.limit(limit);
        AggregationOptions options = AggregationOptions.builder().allowDiskUse(true).build();

        Aggregation aggregation = Aggregation.newAggregation(match).withOptions(options);

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
