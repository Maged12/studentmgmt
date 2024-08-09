package edu.miu.cs.cs425.studentmgmt.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotNull(message = "Student Number cannot be null")
    @NotEmpty(message = "Student Number cannot be empty string")
    @NotBlank(message = "Student Number cannot be blank space(s)")
    private String studentNumber;

    @NotNull(message = "Student First Name cannot be null")
    @NotEmpty(message = "Student First Name cannot be empty string")
    @NotBlank(message = "Student First Name cannot be blank space(s)")
    private String firstName;

    private String middleName;

    @NotNull(message = "Student Last Name cannot be null")
    @NotEmpty(message = "Student Last Name cannot be empty string")
    @NotBlank(message = "Student Last Name cannot be blank space(s)")
    private String lastName;

    private double cgpa;

    @Temporal(TemporalType.DATE)
    private Date dateOfEnrollment;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "transcript_id", unique = false)
    private Transcript transcript;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToMany
    @JoinTable(name = "student_courses", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;
}
