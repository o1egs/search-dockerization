package ru.shtyrev.searchservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shtyrev.searchservice.documents.ESProject;
import ru.shtyrev.searchservice.exceptions.ESProjectAlreadyExist;
import ru.shtyrev.searchservice.exceptions.ESProjectNotFound;
import ru.shtyrev.searchservice.services.ESProjectService;
import ru.shtyrev.searchservice.services.search.SearchService;
import ru.tasktrade.monolithservice.project.dtos.ProjectDTO;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
@RequiredArgsConstructor
public class ESProjectController {
    private final ESProjectService projectService;
    private final SearchService searchService;

    @PostMapping("/projects/create")
    public ResponseEntity<ESProject> createESProject(@RequestBody ProjectDTO projectDTO)
            throws ESProjectAlreadyExist, ESProjectNotFound {
        return ResponseEntity.ok(projectService.createESProject(projectDTO));
    }

    @GetMapping("/esProjects/{esProjectId}")
    ESProject getESProjectById(@PathVariable String esProjectId) throws ESProjectNotFound {
        return projectService.getESProjectById(esProjectId);
    }

    @PutMapping("/esProjects/update/{esProjectId}")
    ESProject updateESProjectById(@PathVariable String esProjectId, @RequestBody ProjectDTO projectDTO) throws ESProjectNotFound {
        return projectService.updateESProjectById(esProjectId, projectDTO);
    }

    @PutMapping("/projects/update/{projectId}")
    ESProject updateESProjectByProjectId(@PathVariable Long projectId, @RequestBody ProjectDTO projectDTO) throws ESProjectNotFound {
        return projectService.updateESProjectByProjectId(projectId, projectDTO);
    }

    @DeleteMapping("/esProjects/delete/{esProjectId}")
    void deleteESProjectById(@PathVariable String esProjectId) throws ESProjectNotFound {
        projectService.deleteESProjectById(esProjectId);
    }

    @DeleteMapping("/projects/delete/{projectId}")
    void deleteESProjectByProjectId(@PathVariable Long projectId) throws ESProjectNotFound {
        projectService.deleteESProjectByProjectId(projectId);
    }

    @GetMapping("/projects")
    List<ProjectDTO> findAllProjects() {
        return projectService.findAllProjects();
    }

    @GetMapping("/esProjects")
    Iterable<ESProject> findAllESProjects() {
        return projectService.findAllESProjects();
    }

    @GetMapping("/search/{searchText}")
    public ResponseEntity<List<ProjectDTO>> search(@PathVariable String searchText)
            throws IOException {
        return ResponseEntity.ok(searchService.search(searchText));
    }

    @GetMapping("/search/{searchText}/{page}/{size}")
    public ResponseEntity<List<ProjectDTO>> search(@PathVariable String searchText,
                                                   @PathVariable int page,
                                                   @PathVariable int size) {
        return ResponseEntity.ok(projectService.search(searchText, page, size));
    }
}
