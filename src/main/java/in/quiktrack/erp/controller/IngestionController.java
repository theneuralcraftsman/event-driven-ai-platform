package in.quiktrack.erp.controller;

import in.quiktrack.erp.producer.DocumentProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingest")
public class IngestionController {

    private final DocumentProducer producer;

    public IngestionController(DocumentProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String ingest(@RequestBody String document) {
        producer.sendDocument(document);
        return "Document sent to Kafka";
    }
}