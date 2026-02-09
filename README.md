# Bakery Microservices Application

A **Bakery Management System** built using **Spring Boot microservices architecture**.  
This project comprises several independently deployable services to handle different parts of a bakery e‑commerce platform.

## 🧱 Services Included

| Service | Responsibility |
|---------|----------------|
| `User-Service` | Manages user registration and profiles |
| `Order-Service` | Handles customer orders |
| `Cart-Service` | Manages shopping cart operations |
| `Catalog-Service` | Stores product catalog (bakery items) |
| `Delivery-Service` | Tracks delivery status of orders |
| `Payment-Service` | Handles payments and transactions |
| `ProjectConfig` | Common configuration for all services |

## 🚀 Features

- Spring Boot based **REST APIs**
- Modular microservices architecture
- Independent service deployment
- Inter‑service communication (REST)
- Basic CRUD operations

## 🛠 Tech Stack

- Java 21+
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- PgAdmin (per service database)
- Docker (optional for containerization)
- Eureka / Config Server (optional for service registry/config)

## 🧩 How to Run Locally

1. Clone the repository: git clone https://github.com/Mahinder7953/Bakery.git
