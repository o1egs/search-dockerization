package ru.shtyrev.searchservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private String category;
    private Double budget;
    private String status;
    private Integer timeframe;
    private LocalDateTime creationDate;
    private LocalDateTime startedDate;
    private LocalDateTime endDate;
    private Long customerId;
    private Long producerId;
}
