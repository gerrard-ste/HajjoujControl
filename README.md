# Microservices Project README

This project consists of several microservices designed to provide functionality related to client management, API gateway, car management, and service discovery.

## Microservices Overview

### 1. clientservice
- Description: Microservice responsible for managing client information.

### 2. apigateway
- Description: API Gateway serving as a single entry point for external clients.

### 3. carservice
- Description: Microservice handling car-related operations.

### 4. eurekaserver
- Description: Service registry and discovery server using Netflix Eureka.

## Microservices Relationships

- `clientservice` communicates with `carservice` to retrieve car-related information for clients.
- `apigateway` routes external requests to the appropriate microservices (e.g., `clientservice`, `carservice`).
- Both `clientservice` and `carservice` register with `eurekaserver` for service discovery.
