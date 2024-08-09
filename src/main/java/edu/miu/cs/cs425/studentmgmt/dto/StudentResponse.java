package edu.miu.cs.cs425.studentmgmt.dto;

public record StudentResponse(
        Long id, String name,
        String studentNumber, java.util.Date enrollmentDate, double GPA, String degreeTitle,
        String classRoomBuildingName, String classRoomNumber) {

}
