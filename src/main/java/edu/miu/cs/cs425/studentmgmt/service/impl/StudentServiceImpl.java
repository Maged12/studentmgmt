package edu.miu.cs.cs425.studentmgmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.studentmgmt.dto.StudentResponse;
import edu.miu.cs.cs425.studentmgmt.mapers.StudentResponseMapper;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponse saveStudent(Student newStudent) {
        var savedStudent = studentRepository.save(newStudent);
        return StudentResponseMapper.mapToStudentResponse(savedStudent);
    }

    @Override
    public List<StudentResponse> getAllStudent() {
        var allStudents = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
        return allStudents.stream()
                .map(t -> StudentResponseMapper.mapToStudentResponse(t))
                .toList();
    }

    @Override
    public List<Student> getAllStudents() {
        var allStudents = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
        return allStudents;
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        var student = studentRepository.findById(id).orElse(null);
        return StudentResponseMapper.mapToStudentResponse(student);
    }

    @Override
    public StudentResponse updateStudentBuildingName(String buildingName, Long id) {
        var newStudent = studentRepository.findById(id).orElse(null);
        newStudent.getClassroom().setBuildingName(buildingName);
        return StudentResponseMapper.mapToStudentResponse(studentRepository.save(newStudent));
    }

}
