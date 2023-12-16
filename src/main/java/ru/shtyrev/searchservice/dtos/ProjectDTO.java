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
    private String creationDate;
    private String startedDate;
    private String endDate;
    private Long customerId;
    private Long producerId;
}
