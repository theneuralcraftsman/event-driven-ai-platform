package in.quiktrack.erp.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic inputTopic() {
        return new NewTopic("eventflow.input", 1, (short) 1);
    }

    @Bean
    public NewTopic resumeTopic() {
        return new NewTopic("eventflow.agent.resume", 1, (short) 1);
    }

    @Bean
    public NewTopic invoiceTopic() {
        return new NewTopic("eventflow.agent.invoice", 1, (short) 1);
    }
}