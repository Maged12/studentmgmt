package edu.miu.cs.cs425.studentmgmt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs425.studentmgmt.dto.StudentResponse;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{param}")
    public StudentResponse getStudentById(@PathVariable String param) {
        return studentService.getStudentById(Long.parseLong(param));
    }

    @PutMapping("/{id}")
    public StudentResponse updateStudentBuildingName(@PathVariable String id,
            @RequestParam String newStudentBuildingName) {
        return studentService.updateStudentBuildingName(newStudentBuildingName, Long.parseLong(id));
    }

    @PostMapping("")
    public StudentResponse createStudent(@RequestBody Student entity) {
        var student = studentService.saveStudent(entity);
        return student;
    }

}
