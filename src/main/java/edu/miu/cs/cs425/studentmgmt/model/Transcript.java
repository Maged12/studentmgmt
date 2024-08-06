package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "transcripts")
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transcriptId;

    @NotNull(message = "Degree Title cannot be null")
    @NotEmpty(message = "Degree Title cannot be empty string")
    @NotBlank(message = "Degree Title cannot be blank space(s)")
    private String degreeTitle;

    @Override
    public String toString() {
        return "Transcript [transcriptId=" + transcriptId + ", degreeTitle=" + degreeTitle + "]";
    }

}
