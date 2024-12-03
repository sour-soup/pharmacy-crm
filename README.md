# Web Application Development. Study Project: PHARMACY-CRM

This repository contains a study project created during the "Web Application Development" course. The goal of the project is to explore the basics of building multi-layer applications, integrating microservices, and using asynchronous message processing.

## Features

- **CRUD Operations**: Implemented for entities `Customer`, `Order`, `Medicine`, `Pharmacist`, and `OrderItem`.
- **Asynchronous Communication**: Integration with RabbitMQ for handling messages.
- **Service Integration**: Interaction between services via REST API and message queues.
- **Data Mapping**: Automated DTO-entity conversion using MapStruct.
- **Layered Architecture**: Controllers, services, mappers, and repositories organized in separate layers.

## Technologies Used

- **Java 17**
- **Spring Boot**
- **RabbitMQ**
- **MapStruct**
- **RestTemplate**
- **Lombok**

## Project Objectives

1. Learn to design and develop web applications with modern technologies.
2. Master asynchronous messaging with RabbitMQ.
3. Understand the separation of concerns in application architecture.
4. Deepen knowledge of REST API and data mapping.

## Getting Started

### Prerequisites

- Java 17 or later.
- RabbitMQ installed and running.

### Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```  

2. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```  

### API Endpoints

- **Customers**: `/api/customers`
- **Orders**: `/api/orders`
- **Medicines**: `/api/medicines`
- **Pharmacists**: `/api/pharmacists`
- **Order Items**: `/api/order-items`

