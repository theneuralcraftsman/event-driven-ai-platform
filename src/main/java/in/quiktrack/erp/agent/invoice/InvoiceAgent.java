package in.quiktrack.erp.agent.invoice;

import in.quiktrack.erp.model.EventMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InvoiceAgent {

    @KafkaListener(topics = "eventflow.agent.invoice", groupId = "invoice-agent")
    public void process(EventMessage event) {

        System.out.println("Invoice agent processing:");
        System.out.println(event.getPayload());
    }
}