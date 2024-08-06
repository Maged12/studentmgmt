package edu.miu.cs.cs425.studentmgmt.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "classrooms")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Classroom {
    // classroomId: primaryKey, buildingName, roomNumber
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classroomId;
    @NotNull(message = "Building Name cannot be null")
    @NotEmpty(message = "Building Name cannot be empty string")
    @NotBlank(message = "Building Name cannot be blank space(s)")
    private String buildingName;

    @NotNull(message = "Room Number cannot be null")
    @NotEmpty(message = "Room Number cannot be empty string")
    @NotBlank(message = "Room Number cannot be blank space(s)")
    private String roomNumber;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> students;

    @Override
    public String toString() {
        return "Classroom [classroomId=" + classroomId + ", buildingName=" + buildingName + ", roomNumber=" + roomNumber
                + ", students=" + students + "]";
    }

}
