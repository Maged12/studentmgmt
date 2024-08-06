package edu.miu.cs.cs425.studentmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs.cs425.studentmgmt.model.Transcript;

public interface TranscriptRepository extends JpaRepository<Transcript, Long> {

}
