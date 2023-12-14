package ru.shtyrev.searchservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.shtyrev.searchservice.documents.ESProject;
import ru.shtyrev.searchservice.exceptions.ESProjectAlreadyExist;
import ru.shtyrev.searchservice.exceptions.ESProjectNotFound;
import ru.shtyrev.searchservice.repositories.ESProjectRepository;
import ru.shtyrev.searchservice.services.ESProjectService;
import ru.tasktrade.monolithservice.project.dtos.ProjectDTO;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ESProjectServiceImpl implements ESProjectService {
    private final ESProjectRepository projectRepository;
    @Override
    public ESProject createESProject(ProjectDTO projectDTO) throws ESProjectNotFound {
        Optional<ESProject> existingESProject = projectRepository
                .findByProject_Id(projectDTO.getId());
        if (existingESProject.isEmpty()) {
            ESProject esProject = ESProject.builder()
                    .project(projectDTO)
                    .build();
            return projectRepository.save(esProject);
        } else {
            return updateESProjectByProjectId(projectDTO.getId(), projectDTO);
        }
    }

    @Override
    public ESProject getESProjectById(String id) throws ESProjectNotFound {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ESProjectNotFound("ESProject not found"));
    }

    @Override
    public ESProject updateESProjectById(String id, ProjectDTO projectDTO) throws ESProjectNotFound {
        Optional<ESProject> existingESProject = projectRepository.findById(id);
        if (existingESProject.isPresent()) {
            ESProject esProjectDB = existingESProject.get();
            ProjectDTO projectDB = esProjectDB.getProject();
//
            String name = projectDTO.getName();
            String description = projectDTO.getDescription();
            String category = projectDTO.getCategory();
            Double budget = projectDTO.getBudget();
            String projectStatus = projectDTO.getProjectStatus();
            Integer timeframe = projectDTO.getTimeframe();
            LocalDateTime creationDate = projectDTO.getCreationDate();
            LocalDateTime startedDate = projectDTO.getStartedDate();
            LocalDateTime endDate = projectDTO.getEndDate();
            Long customerId = projectDTO.getCustomerId();
            Long producerId = projectDTO.getProducerId();
//
            if (Objects.nonNull(name) && !"".equalsIgnoreCase(name)) {
                projectDB.setName(name);
            }
            if (Objects.nonNull(description) && !"".equalsIgnoreCase(description)) {
                projectDB.setDescription(description);
            }
            if (Objects.nonNull(category) && !"".equalsIgnoreCase(category)) {
                projectDB.setCategory(category);
            }
            if (Objects.nonNull(budget)) {
                projectDB.setBudget(budget);
            }
            if (Objects.nonNull(projectStatus) && !"".equalsIgnoreCase(projectStatus)) {
                projectDB.setProjectStatus(projectStatus);
            }
            if (Objects.nonNull(timeframe)) {
                projectDB.setTimeframe(timeframe);
            }
            if (Objects.nonNull(creationDate)) {
                projectDB.setCreationDate(creationDate);
            }
            if (Objects.nonNull(startedDate)) {
                projectDB.setStartedDate(startedDate);
            }
            if (Objects.nonNull(endDate)) {
                projectDB.setEndDate(endDate);
            }
            if (Objects.nonNull(customerId)) {
                projectDB.setCustomerId(customerId);
            }
            if (Objects.nonNull(producerId)) {
                projectDB.setProducerId(producerId);
            }
            esProjectDB.setProject(projectDB);
            return projectRepository.save(esProjectDB);
        } else {
            throw new ESProjectNotFound("ESProject not found");
        }
    }

    @Override
    public ESProject updateESProjectByProjectId(Long id, ProjectDTO projectDTO) throws ESProjectNotFound {
        Optional<ESProject> existingESProject = projectRepository.findByProject_Id(id);
        if (existingESProject.isPresent()) {
            ESProject esProjectDB = existingESProject.get();
            ProjectDTO projectDB = esProjectDB.getProject();
//
            String name = projectDTO.getName();
            String description = projectDTO.getDescription();
            String category = projectDTO.getCategory();
            Double budget = projectDTO.getBudget();
            String projectStatus = projectDTO.getProjectStatus();
            Integer timeframe = projectDTO.getTimeframe();
            LocalDateTime creationDate = projectDTO.getCreationDate();
            LocalDateTime startedDate = projectDTO.getStartedDate();
            LocalDateTime endDate = projectDTO.getEndDate();
            Long customerId = projectDTO.getCustomerId();
            Long producerId = projectDTO.getProducerId();
//
            if (Objects.nonNull(name) && !"".equalsIgnoreCase(name)) {
                projectDB.setName(name);
            }
            if (Objects.nonNull(description) && !"".equalsIgnoreCase(description)) {
                projectDB.setDescription(description);
            }
            if (Objects.nonNull(category) && !"".equalsIgnoreCase(category)) {
                projectDB.setCategory(category);
            }
            if (Objects.nonNull(budget)) {
                projectDB.setBudget(budget);
            }
            if (Objects.nonNull(projectStatus) && !"".equalsIgnoreCase(projectStatus)) {
                projectDB.setProjectStatus(projectStatus);
            }
            if (Objects.nonNull(timeframe)) {
                projectDB.setTimeframe(timeframe);
            }
            if (Objects.nonNull(creationDate)) {
                projectDB.setCreationDate(creationDate);
            }
            if (Objects.nonNull(startedDate)) {
                projectDB.setStartedDate(startedDate);
            }
            if (Objects.nonNull(endDate)) {
                projectDB.setEndDate(endDate);
            }
            if (Objects.nonNull(customerId)) {
                projectDB.setCustomerId(customerId);
            }
            if (Objects.nonNull(producerId)) {
                projectDB.setProducerId(producerId);
            }
            esProjectDB.setProject(projectDB);
            return projectRepository.save(esProjectDB);
        } else {
            throw new ESProjectNotFound("ESProject not found");
        }
    }

    @Override
    public void deleteESProjectById(String id) throws ESProjectNotFound {
        ESProject existingESProject = projectRepository.findById(id)
                .orElseThrow(() -> new ESProjectNotFound("ESProject not found"));
        projectRepository.deleteById(existingESProject.getId());
    }

    @Override
    public void deleteESProjectByProjectId(Long projectId) throws ESProjectNotFound {
        ESProject existingESProject = projectRepository.findByProject_Id(projectId)
                .orElseThrow(() -> new ESProjectNotFound("ESProject not found"));
        projectRepository.deleteById(existingESProject.getId());
    }

    @Override
    public List<ProjectDTO> findAllProjects() {
        List<ProjectDTO> projects = new ArrayList<>();
        projectRepository.findAll().forEach(p -> projects.add(p.getProject()));
        return projects;
    }

    @Override
    public Iterable<ESProject> findAllESProjects() {
        return projectRepository.findAll();
    }

    @Override
    public List<ProjectDTO> search(String searchText, int page, int size) {
        return projectRepository
                .search(searchText, PageRequest.of(page, size))
                .stream()
                .map(ESProject::getProject)
                .collect(Collectors.toList());
    }
}
