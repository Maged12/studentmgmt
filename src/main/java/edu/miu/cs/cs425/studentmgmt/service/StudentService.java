package edu.miu.cs.cs425.studentmgmt.service;

import java.util.List;

import edu.miu.cs.cs425.studentmgmt.dto.StudentResponse;
import edu.miu.cs.cs425.studentmgmt.model.Student;

public interface StudentService {
    StudentResponse saveStudent(Student newStudent);

    StudentResponse getStudentById(Long id);

    StudentResponse updateStudentBuildingName(String buildingName, Long id);

    List<StudentResponse> getAllStudent();

    List<Student> getAllStudents();

}
