package ru.shtyrev.searchservice.kafka;


import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.shtyrev.searchservice.exceptions.ESProjectAlreadyExist;
import ru.shtyrev.searchservice.exceptions.ESProjectNotFound;
import ru.shtyrev.searchservice.services.ESProjectService;

@Service
@RequiredArgsConstructor
public class KafkaMessageListener {
    private final ESProjectService projectService;

//    @KafkaListener(topics = "project-topic", groupId = "project-topic-listener-1")
//    public void consumeMessage(ProjectMessage projectMessage) throws ESProjectAlreadyExist, ESProjectNotFound {
//        ProjectDTO projectDTO = projectMessage.getProjectDTO();
//        switch (projectMessage.getMethod().toLowerCase()) {
//            case "create" -> projectService.createESProject(projectDTO);
//            case "update" -> projectService.updateESProjectByProjectId(projectDTO.getId(), projectDTO);
//            case "delete", "finish", "start" -> projectService.deleteESProjectByProjectId(projectDTO.getId());
//            default -> {
//            }
//        }
//    }
}
