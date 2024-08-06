package edu.miu.cs.cs425.studentmgmt.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "transcript_id", referencedColumnName = "transcriptId")
    private Transcript transcript;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToMany
    @JoinTable(name = "student_courses", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", studentNumber=" + studentNumber + ", firstName=" + firstName
                + ", middleName=" + middleName + ", lastName=" + lastName + ", cgpa=" + cgpa + ", dateOfEnrollment="
                + dateOfEnrollment + ", transcript=" + transcript + ", classroom=" + classroom + ", courses=" + courses
                + "]";
    }

}
