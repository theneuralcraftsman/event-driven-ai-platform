package in.quiktrack.erp.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic documentTopic() {
        return new NewTopic("documents", 1, (short) 1);
    }
}