package ru.shtyrev.searchservice.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private String category;
    private Double budget;
    private String projectStatus;
    private Integer timeframe;
    private LocalDateTime creationDate;
    private LocalDateTime startedDate;
    private LocalDateTime endDate;
    private Long customerId;
    private Long producerId;
}
