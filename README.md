# Cloud Infrastructure Monitoring Platform

A distributed event-driven cloud infrastructure monitoring platform built with **Spring Boot**, **Apache Kafka**, and **Docker**. The platform asynchronously ingests telemetry metrics from distributed servers, routes events through Kafka topics, and processes them using independent storage and alert pipelines.

This project demonstrates production-oriented backend concepts including asynchronous messaging, event-driven architecture, loose coupling, and scalable microservice communication.

---

## Features

- REST API for telemetry ingestion
- Event-driven architecture using Apache Kafka
- Asynchronous telemetry processing
- Intelligent event routing
- Independent storage and alert processing pipelines
- Threshold-based alert generation
- Production-style logging with SLF4J
- Dockerized Kafka environment
- Extensible microservice architecture

---

## Technology Stack

- Java 17
- Spring Boot
- Spring Kafka
- Apache Kafka
- Docker & Docker Compose
- Maven
- SLF4J Logging

---

## Event Flow

1. Cloud servers publish telemetry metrics.
2. The REST API accepts telemetry requests.
3. `TelemetryProducer` publishes events to the `telemetry.raw` Kafka topic.
4. `TelemetryRouter` consumes events from `telemetry.raw`.
5. Every event is forwarded to `telemetry.storage`.
6. Critical telemetry events (CPU/Memory threshold exceeded) are additionally published to `telemetry.alert`.
7. `TelemetryStorageConsumer` processes all telemetry events.
8. `AlertConsumer` forwards alert events to `AlertService` for alert generation.

---

## Current Project Structure

```text
src
└── main
    └── java
        └── io.cloudmonitor.platform
            ├── config
            ├── consumer
            ├── controller
            ├── model
            ├── producer
            ├── router
            ├── service
            └── CloudMonitoringApplication.java
```

---

## Running the Project

### Prerequisites

- Java 17+
- Maven
- Docker Desktop

### Start Kafka

```bash
docker compose up -d
```

### Run Spring Boot

```bash
mvn spring-boot:run
```

or run `CloudMonitoringApplication` directly from your IDE.

---

## Sample API Request

**POST**

```
http://localhost:8080/api/v1/telemetry
```

**Request Body**

```json
{
  "eventId": "evt-1001",
  "hostName": "server-1",
  "region": "ap-south-1",
  "instanceType": "t3.medium",
  "cpuUsage": 95,
  "memoryUsage": 71,
  "diskUsage": 62,
  "networkThroughput": 125,
  "timestamp": "2026-06-30T09:00:00"
}
```

---

## Sample Processing Flow

```
REST API
      │
      ▼
TelemetryProducer
      │
      ▼
telemetry.raw
      │
      ▼
TelemetryRouter
      │
      ├────────► telemetry.storage
      │                 │
      │                 ▼
      │       TelemetryStorageConsumer
      │
      └────────► telemetry.alert
                        │
                        ▼
                 AlertConsumer
                        │
                        ▼
                  AlertService
```

---

## Why Event-Driven Architecture?

Instead of processing telemetry synchronously during an HTTP request, events are published to Kafka and processed asynchronously by independent services.

### Benefits

- Loose coupling between services
- High throughput
- Improved scalability
- Independent deployment of consumers
- Fault-tolerant processing
- Easy addition of new downstream services

---

