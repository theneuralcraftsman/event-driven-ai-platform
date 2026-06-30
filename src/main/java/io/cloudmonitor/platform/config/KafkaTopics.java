package io.cloudmonitor.platform.config;

public final class KafkaTopics {

    private KafkaTopics() {
    }

    public static final String RAW = "telemetry.raw";

    public static final String STORAGE = "telemetry.storage";

    public static final String ALERT = "telemetry.alert";
}