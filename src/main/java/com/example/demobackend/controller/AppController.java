package com.example.demobackend.controller;

import com.example.demobackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@CrossOrigin(origins = "*")
@RestController
public class AppController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/run-findall")
    public ResponseEntity<?> checkFindAll() {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(studentService.findAll());
    }

    @GetMapping("/run-resource")
    public ResponseEntity<?> checkResource() {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(studentService.findAllByResource(100));
    }

    @GetMapping("/run-mongotemplate")
    public ResponseEntity<?> checkMongoTemplate() {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(studentService.getFilteredStudents(100));
    }

    @GetMapping("/run/{limit}")
    public ResponseEntity<?> runAll(@PathVariable int limit) {
        HashMap<String, Object> data = new HashMap<>();

        data.put("not_count", studentService.findAllByResource(limit));
        data.put("at_resource", studentService.findAllByResource(limit));
        data.put("at_annote", studentService.findAll());
        data.put("at_annote_in", studentService.findAllIn());
        data.put("at_annote2", studentService.findAll2());
        data.put("at_annote3", studentService.findAll3());
        data.put("at_mongoTemplate", studentService.getFilteredStudents(limit));
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(data);
    }
}
