# Event-Driven AI Data Processing Platform

A distributed, event-driven platform for asynchronous ingestion and AI-based processing of documents using Kafka and Spring Boot. The system is designed to simulate scalable AI infrastructure used in production-grade platforms.

## Overview

This platform enables ingestion of unstructured data through REST APIs, processes it asynchronously using Kafka, and exposes processed results through retrieval services. The architecture follows microservices and event-driven design principles for scalability and reliability.

## Architecture

```
Client
  ↓
API Gateway (future)
  ↓
Ingestion Service (Kafka Producer)
  ↓
Kafka Topic
  ↓
Processing Service (Kafka Consumer)
  ↓
AI Processing (Embedding / NLP - planned)
  ↓
Database (planned)
  ↓
Retrieval Service (planned)
```

## Features

- Event-driven architecture using Apache Kafka
- Stateless ingestion microservice
- Asynchronous document processing
- Kafka producer and consumer services
- REST-based ingestion API
- Scalable microservices design
- Extensible AI processing pipeline (planned)
- Docker-based local deployment (planned)

## Tech Stack

- Java
- Spring Boot
- Spring Kafka
- Apache Kafka
- Docker (planned)
- MySQL / MongoDB (planned)
- REST APIs

## Services

### Ingestion Service
- Accepts documents via REST API
- Publishes messages to Kafka topic

### Processing Service
- Consumes Kafka messages
- Performs AI processing (planned)
- Stores processed results (planned)

### Retrieval Service (Planned)
- Query processed data
- Provide search and retrieval APIs

## Getting Started

### Prerequisites

- Java 17+
- Maven
- Docker (for Kafka)

### Run Kafka

```
docker-compose up -d
```

### Run Application

```
mvn spring-boot:run
```

### Test Ingestion

```
curl -X POST http://localhost:8080/ingest \
-H "Content-Type: text/plain" \
-d "Sample document for AI processing"
```

You should see the consumer service processing the document.

## Project Structure

```
event-driven-ai-platform
│
├── ingestion-service
├── processing-service
├── retrieval-service (planned)
├── docker-compose.yml
└── README.md
```

## Future Improvements

- AI embedding generation
- Vector database integration
- Multiple Kafka consumers
- Retry & dead-letter queue
- API gateway
- Observability (metrics + logging)
- Kubernetes deployment

## Use Case

This platform simulates AI data ingestion pipelines used in production systems, where large volumes of documents must be processed asynchronously and made searchable using AI techniques.

## Status

🚧 Work in Progress — Initial Kafka ingestion and processing services implemented.
