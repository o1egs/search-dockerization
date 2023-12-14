package ru.shtyrev.searchservice.entities.user;

import lombok.Builder;
import lombok.Data;
import ru.shtyrev.searchservice.entities.Attachment;
import ru.shtyrev.searchservice.entities.project.Project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Double balance;
    private Role role;
    private LocalDate dateOfBirth;
    private String skillsDescription;
    private Integer completedProjects;
    private AccountStatus accountStatus;
    private Gender gender;
    private LocalDateTime registrationDate;
    private City city;
    private Attachment attachment;
    private Integer currentRating;
    private List<Project> projects;

}
