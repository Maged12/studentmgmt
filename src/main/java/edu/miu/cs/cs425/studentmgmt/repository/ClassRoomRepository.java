package edu.miu.cs.cs425.studentmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;

public interface ClassRoomRepository extends JpaRepository<Classroom, Long> {

}
