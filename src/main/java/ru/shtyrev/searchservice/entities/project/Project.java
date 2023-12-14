package ru.shtyrev.searchservice.entities.project;

import lombok.Builder;
import lombok.Data;
import ru.shtyrev.searchservice.entities.user.User;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Project {
        private Long id;
        private String name;
        private String description;
        private String category;
        private Double budget;
        private Status status;
        private Integer timeframe;
        private LocalDateTime creationDate;
        private LocalDateTime startedDate;
        private User customer;
        private User producer;
        private List<User> users;
}
