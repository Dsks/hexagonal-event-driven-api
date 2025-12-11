# Hexagonal Event-Driven API

A scalable, enterprise-grade microservice designed to demonstrate modern software architecture patterns. This project implements **Hexagonal Architecture (Ports and Adapters)** to isolate business logic from infrastructure and utilizes **Event-Driven Architecture (EDA)** for asynchronous communication.



## 🚀 Tech Stack

* **Language:** Java 21
* **Framework:** Spring Boot 4.0.0
* **Architecture:** Hexagonal (Ports & Adapters)
* **Messaging:** Apache Kafka (Confluent Cloud)
* **Database:** PostgreSQL (AWS RDS)
* **Containerization:** Docker & Docker Compose
* **Testing:** JUnit 5, Mockito

## 🏗️ Architecture & Design

This repository strictly follows the **Dependency Rule**: source code dependencies only point inward.

1.  **Domain Layer (Core):** Contains pure business logic and entities. No framework dependencies.
2.  **Application Layer (Ports):** Interfaces defining *incoming* (Use Cases) and *outgoing* (Repositories/Event Publishers) interactions.
3.  **Infrastructure Layer (Adapters):** Implementations of the ports (REST Controllers, JPA Repositories, Kafka Producers).

## ⚙️ Configuration (12-Factor App)

Sensitive configuration is externalized via Environment Variables to ensure security across environments (Dev/Stage/Prod).

**Required Environment Variables:**

| Variable | Description |
| :--- | :--- |
| `DB_URL` | JDBC URL for PostgreSQL (AWS RDS) |
| `DB_USER` | Database Username |
| `DB_PASSWORD` | Database Password |
| `KAFKA_BOOTSTRAP_SERVER` | Confluent Cloud / Kafka Broker URL |
| `KAFKA_KEY` | SASL API Key |
| `KAFKA_SECRET` | SASL API Secret |

## 🧪 How to Run

1.  Clone the repository.
2.  Set up the environment variables in your IDE or `.env` file.
3.  Run `mvn spring-boot:run`.