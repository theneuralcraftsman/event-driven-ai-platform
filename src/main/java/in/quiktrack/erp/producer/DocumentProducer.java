package in.quiktrack.erp.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DocumentProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public DocumentProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendDocument(String message) {
        kafkaTemplate.send("documents", message);
    }
}