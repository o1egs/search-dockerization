package ru.shtyrev.searchservice.documents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import ru.tasktrade.monolithservice.project.dtos.ProjectDTO;

@Document(indexName = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ESProject {
    @Id
    @JsonProperty("id")
    private String id;
    @Field(type = FieldType.Object, name = "project")
    @JsonProperty("project")
    private ProjectDTO project;
}
