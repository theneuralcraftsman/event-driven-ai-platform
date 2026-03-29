package in.quiktrack.erp.controller;

import in.quiktrack.erp.model.EventMessage;
import in.quiktrack.erp.producer.EventProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingest")
public class IngestionController {

    private final EventProducer producer;

    public IngestionController(EventProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String ingest(@RequestBody EventMessage event) {
        producer.send(event);
        return "Event sent";
    }
}