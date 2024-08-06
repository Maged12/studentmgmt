package edu.miu.cs.cs425.studentmgmt.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Course {
    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseCode=" + courseCode + ", courseName=" + courseName
                + ", students=" + students + "]";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @NotNull(message = "Course Code cannot be null")
    @NotEmpty(message = "Course Code cannot be empty string")
    @NotBlank(message = "Course Code cannot be blank space(s)")
    private String courseCode;

    @NotNull(message = "Course Name cannot be null")
    @NotEmpty(message = "Course Name cannot be empty string")
    @NotBlank(message = "Course Name cannot be blank space(s)")
    private String courseName;

    @ManyToMany
    @JoinTable(name = "student_courses", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;
}
