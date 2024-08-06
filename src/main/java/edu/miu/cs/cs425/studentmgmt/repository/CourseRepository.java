package edu.miu.cs.cs425.studentmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs.cs425.studentmgmt.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
