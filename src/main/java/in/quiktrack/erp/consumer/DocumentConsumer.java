package in.quiktrack.erp.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DocumentConsumer {

    @KafkaListener(topics = "documents", groupId = "ai-processing-group")
    public void consume(String message) {
        System.out.println("Processing document: " + message);
    }
}