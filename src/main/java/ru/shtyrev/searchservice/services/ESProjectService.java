package ru.shtyrev.searchservice.services;

import ru.shtyrev.searchservice.documents.ESProject;
import ru.shtyrev.searchservice.dtos.ProjectDTO;
import ru.shtyrev.searchservice.exceptions.ESProjectAlreadyExist;
import ru.shtyrev.searchservice.exceptions.ESProjectNotFound;

import java.util.List;

public interface ESProjectService {
    ESProject createESProject(ProjectDTO projectDTO) throws ESProjectNotFound;

    ESProject getESProjectById(String id) throws ESProjectNotFound;
    ESProject getESProjectByProjectId(Long id) throws ESProjectNotFound;

    ESProject updateESProjectById(String id, ProjectDTO projectDTO) throws ESProjectNotFound;

    ESProject updateESProjectByProjectId(Long id, ProjectDTO projectDTO) throws ESProjectNotFound;

    void deleteESProjectById(String id) throws ESProjectNotFound;

    void deleteESProjectByProjectId(Long projectId) throws ESProjectNotFound;

    List<ProjectDTO> findAllProjects();

    Iterable<ESProject> findAllESProjects();

    List<ProjectDTO> search(String searchText, int page, int size);

}
