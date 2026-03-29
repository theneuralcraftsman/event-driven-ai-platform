package in.quiktrack.erp.agent.resume;

import in.quiktrack.erp.model.EventMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ResumeAgent {

    @KafkaListener(topics = "eventflow.agent.resume", groupId = "resume-agent")
    public void process(EventMessage event) {

        System.out.println("Resume agent processing:");
        System.out.println(event.getPayload());
    }
}