package ru.shtyrev.searchservice.controllers;


import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shtyrev.searchservice.documents.ESProject;
import ru.shtyrev.searchservice.dtos.ProjectDTO;
import ru.shtyrev.searchservice.exceptions.ESProjectException;
import ru.shtyrev.searchservice.exceptions.ESProjectNotFound;
import ru.shtyrev.searchservice.services.ESProjectService;
import ru.shtyrev.searchservice.services.search.SearchService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
@Tag(name = "Elasticsearch")
public class ESProjectController {
    private final ESProjectService projectService;
    private final SearchService searchService;

    @Autowired
    public ESProjectController(ESProjectService projectService, SearchService searchService) {
        this.projectService = projectService;
        this.searchService = searchService;
    }

        @Operation(
            description = "Создание нового проекта в индексе Elasticsearch, в теле запроса передается ProjectDTO.",
            summary = "Создание проекта.",
            responses = {
                    @ApiResponse(
                            description = "CREATED",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "BAD REQUEST",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ESProjectException.class),
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\n" +
                                                            "  \"message\": \"JSON parse error: Unexpected character ('d' (code 100)): was expecting comma to separate Object entries\",\n" +
                                                            "  \"httpStatus\": \"BAD_REQUEST\",\n" +
                                                            "  \"zonedDateTime\": \"2023-10-15T14:50:27.876228Z\"\n" +
                                                            "}"
                                            )
                                    }
                            )
                    )
            }
    )
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/projects/create")
    public ResponseEntity<ESProject> createESProject(@RequestBody ProjectDTO projectDTO)
            throws ESProjectNotFound {
        System.out.println(projectDTO);
        ESProject esProject = projectService.createESProject(projectDTO);
        return new ResponseEntity<>(esProject, HttpStatus.CREATED);
    }

    @Hidden
    @GetMapping("/esProjects/{esProjectId}")
    ESProject getESProjectById(@PathVariable String esProjectId) throws ESProjectNotFound {
        return projectService.getESProjectById(esProjectId);
    }

    @Operation(
            description = "Получение ESProject по id ProjectDTO, который хранится внутри.",
            summary = "Получение ESProject по id проекта.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "NOT FOUND",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ESProjectException.class),
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\n" +
                                                            "  \"message\": \"ESProject not found\",\n" +
                                                            "  \"httpStatus\": \"NOT_FOUND\",\n" +
                                                            "  \"zonedDateTime\": \"2023-10-15T16:43:09.1118292Z\"\n" +
                                                            "}"
                                            )
                                    }
                            )
                    )
            }
    )
    @GetMapping("/projects/{projectId}")
    ResponseEntity<ESProject> getESProjectByProjectId(@PathVariable Long projectId) throws ESProjectNotFound {
        ESProject esProject = projectService.getESProjectByProjectId(projectId);
        return new ResponseEntity<>(esProject, HttpStatus.OK);
    }

    @Hidden
    @PutMapping("/esProjects/update/{esProjectId}")
    ESProject updateESProjectById(@PathVariable String esProjectId, @RequestBody ProjectDTO projectDTO)
            throws ESProjectNotFound {
        return projectService.updateESProjectById(esProjectId, projectDTO);
    }

    @Operation(
            description = "Обновление ESProject по id ProjectDTO, который хранится внутри.",
            summary = "Обновление ESProject по id проекта.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "NOT FOUND",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ESProjectException.class),
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\n" +
                                                            "  \"message\": \"ESProject not found\",\n" +
                                                            "  \"httpStatus\": \"NOT_FOUND\",\n" +
                                                            "  \"zonedDateTime\": \"2023-10-15T16:43:09.1118292Z\"\n" +
                                                            "}"
                                            )
                                    }
                            )
                    )
            }
    )
    @PutMapping("/projects/update/{projectId}")
    ESProject updateESProjectByProjectId(@PathVariable Long projectId, @RequestBody ProjectDTO projectDTO)
            throws ESProjectNotFound {
        return projectService.updateESProjectByProjectId(projectId, projectDTO);
    }

    @Hidden
    @DeleteMapping("/esProjects/delete/{esProjectId}")
    void deleteESProjectById(@PathVariable String esProjectId) throws ESProjectNotFound {
        projectService.deleteESProjectById(esProjectId);
    }


    @Operation(
            description = "Удаление ESProject по id ProjectDTO, который хранится внутри.",
            summary = "Удаление ESProject по id проекта.",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "NOT FOUND",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ESProjectException.class),
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\n" +
                                                            "  \"message\": \"ESProject not found\",\n" +
                                                            "  \"httpStatus\": \"NOT_FOUND\",\n" +
                                                            "  \"zonedDateTime\": \"2023-10-15T16:43:09.1118292Z\"\n" +
                                                            "}"
                                            )
                                    }
                            )
                    )
            }
    )
    @DeleteMapping("/projects/delete/{projectId}")
    void deleteESProjectByProjectId(@PathVariable Long projectId) throws ESProjectNotFound {
        projectService.deleteESProjectByProjectId(projectId);
    }

    @GetMapping("/projects")
    ResponseEntity<List<ProjectDTO>> findAllProjects() {
        List<ProjectDTO> projects = projectService.findAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @Hidden
    @GetMapping("/esProjects")
    Iterable<ESProject> findAllESProjects() {
        return projectService.findAllESProjects();
    }

    @Operation(
            description = "Метод возвращает массив проектов найденных по поисковому запросу.",
            summary = "Метод поиска.",
            responses = @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            value = "[\n" +
                                                    "  {\n" +
                                                    "    \"id\": 0,\n" +
                                                    "    \"name\": \"Простая верстка ничо сложного\",\n" +
                                                    "    \"description\": \"Всего лишь ищу senior React developer'a\",\n" +
                                                    "    \"category\": \"жесть\",\n" +
                                                    "    \"budget\": 50000,\n" +
                                                    "    \"projectStatus\": \"ACTIVE\",\n" +
                                                    "    \"timeframe\": 100,\n" +
                                                    "    \"creationDate\": null,\n" +
                                                    "    \"startedDate\": null,\n" +
                                                    "    \"endDate\": null,\n" +
                                                    "    \"customerId\": 0,\n" +
                                                    "    \"producerId\": 0\n" +
                                                    "  },\n" +
                                                    "  {\n" +
                                                    "    \"id\": 1,\n" +
                                                    "    \"name\": \"Простая верстка ничо сложного\",\n" +
                                                    "    \"description\": \"Всего лишь ищу senior React developer'a\",\n" +
                                                    "    \"category\": \"жесть\",\n" +
                                                    "    \"budget\": 50000,\n" +
                                                    "    \"projectStatus\": \"ACTIVE\",\n" +
                                                    "    \"timeframe\": 100,\n" +
                                                    "    \"creationDate\": null,\n" +
                                                    "    \"startedDate\": null,\n" +
                                                    "    \"endDate\": null,\n" +
                                                    "    \"customerId\": 0,\n" +
                                                    "    \"producerId\": 0\n" +
                                                    "  }\n" +
                                                    "]"
                                    )
                            }
                    )
            )
    )
    @GetMapping("/search/{searchText}")
    public ResponseEntity<List<ProjectDTO>> search(@PathVariable String searchText)
            throws IOException {
        return ResponseEntity.ok(searchService.search(searchText));
    }

    @Operation(
            description = "Метод возвращает массив проектов заданой длины, найденных по поисковому запросу.",
            summary = "Метод поиска с пагинацией.",
            responses = @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            value = "[\n" +
                                                    "  {\n" +
                                                    "    \"id\": 0,\n" +
                                                    "    \"name\": \"Простая верстка ничо сложного\",\n" +
                                                    "    \"description\": \"Всего лишь ищу senior React developer'a\",\n" +
                                                    "    \"category\": \"жесть\",\n" +
                                                    "    \"budget\": 50000,\n" +
                                                    "    \"projectStatus\": \"ACTIVE\",\n" +
                                                    "    \"timeframe\": 100,\n" +
                                                    "    \"creationDate\": null,\n" +
                                                    "    \"startedDate\": null,\n" +
                                                    "    \"endDate\": null,\n" +
                                                    "    \"customerId\": 0,\n" +
                                                    "    \"producerId\": 0\n" +
                                                    "  },\n" +
                                                    "  {\n" +
                                                    "    \"id\": 1,\n" +
                                                    "    \"name\": \"Простая верстка ничо сложного\",\n" +
                                                    "    \"description\": \"Всего лишь ищу senior React developer'a\",\n" +
                                                    "    \"category\": \"жесть\",\n" +
                                                    "    \"budget\": 50000,\n" +
                                                    "    \"projectStatus\": \"ACTIVE\",\n" +
                                                    "    \"timeframe\": 100,\n" +
                                                    "    \"creationDate\": null,\n" +
                                                    "    \"startedDate\": null,\n" +
                                                    "    \"endDate\": null,\n" +
                                                    "    \"customerId\": 0,\n" +
                                                    "    \"producerId\": 0\n" +
                                                    "  }\n" +
                                                    "]"
                                    )
                            }
                    )
            )
    )
    @GetMapping("/search/{searchText}/{page}/{size}")
    public ResponseEntity<List<ProjectDTO>> search(@PathVariable String searchText,
                                                   @PathVariable int page,
                                                   @PathVariable int size) {
        return ResponseEntity.ok(projectService.search(searchText, page, size));
    }
}
