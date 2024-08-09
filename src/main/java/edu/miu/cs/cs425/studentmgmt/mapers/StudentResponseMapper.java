package edu.miu.cs.cs425.studentmgmt.mapers;

import edu.miu.cs.cs425.studentmgmt.dto.StudentResponse;
import edu.miu.cs.cs425.studentmgmt.model.Student;

public class StudentResponseMapper {

    public static StudentResponse mapToStudentResponse(Student t) {
        return new StudentResponse(t.getStudentId(), "" + t.getFirstName() + " " + t.getLastName(),
                t.getStudentNumber(), t.getDateOfEnrollment(), t.getCgpa(), t.getTranscript().getDegreeTitle(),
                t.getClassroom().getBuildingName(),
                t.getClassroom().getRoomNumber());
    }
}
