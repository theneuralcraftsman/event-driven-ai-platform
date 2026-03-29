package in.quiktrack.erp.router;

import in.quiktrack.erp.model.EventMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventRouter {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public EventRouter(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "eventflow.input", groupId = "router-group")
    public void route(EventMessage event) {

        switch (event.getType()) {

            case "resume":
                kafkaTemplate.send("eventflow.agent.resume", event);
                break;

            case "invoice":
                kafkaTemplate.send("eventflow.agent.invoice", event);
                break;

            default:
                System.out.println("No agent found for: " + event.getType());
        }
    }
}