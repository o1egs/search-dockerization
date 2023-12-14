package ru.shtyrev.searchservice.kafka;

import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;
import ru.tasktrade.monolithservice.config.kafka.ProjectMessage;

@Component
public class ProjectMessageDeserializer extends JsonDeserializer<ProjectMessage> {
    @Override
    public ProjectMessage deserialize(String topic, byte[] data) {
        return super.deserialize(topic, data);
    }
}
