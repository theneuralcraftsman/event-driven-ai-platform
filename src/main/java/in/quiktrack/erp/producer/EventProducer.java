package in.quiktrack.erp.producer;

import in.quiktrack.erp.model.EventMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public EventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(EventMessage event) {
        kafkaTemplate.send("eventflow.input", event);
    }
}