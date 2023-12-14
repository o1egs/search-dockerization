package ru.shtyrev.searchservice.kafka;

import lombok.Data;
import ru.shtyrev.searchservice.dtos.ProjectDTO;

@Data
public class ProjectMessage {
    private ProjectDTO projectDTO;
    private String method;

    public ProjectMessage(ProjectDTO projectDTO, String method) {
        this.projectDTO = projectDTO;
        this.method = method;
    }
}
