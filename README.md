Project Description: Microservice Architecture with Multi-Database Integration and OKTA Authentication
This project is a robust microservice-based application designed to demonstrate the integration of multiple databases and secure authentication using OKTA. It includes a variety of services, each responsible for a specific aspect of the application, ensuring scalability, maintainability, and ease of deployment.

Key Components:
Databases:

PostgreSQL: Used for handling the core data storage, ensuring reliable and efficient data management for critical application components.
OracleSQL Developer: Employed for specific enterprise-level database needs, taking advantage of Oracle's powerful data handling and complex query capabilities.
MySQL: Utilized for lighter, more flexible data storage requirements, offering fast and easy-to-use database solutions for less intensive data operations.
Microservices:

API Gateway: Acts as a single entry point for all client requests, routing them to the appropriate services, handling authentication, and aggregating responses from multiple services.
Service Registry: Maintains a dynamic list of available services, enabling service discovery and facilitating communication between services without hardcoding their locations.
HotelService: Manages hotel-related data and operations, including listing hotels, booking management, and hotel information updates.
UserService: Handles user data and operations such as user registration, profile management, and authentication processes.
RatingService: Manages the rating and review system, allowing users to rate hotels and provide feedback, storing and retrieving these ratings efficiently.
Config Server Service: Centralizes configuration management, providing a unified approach to manage configuration across all services, ensuring consistency and ease of updates.
Security:

OKTA Authentication: Implements robust security measures using OKTA for user authentication and authorization, providing secure access control across the microservices. This integration ensures that only authenticated and authorized users can access specific resources and perform actions.
Technical Stack and Tools:
Spring Boot: For building each microservice, leveraging its powerful features to create stand-alone, production-ready applications.
Spring Cloud: For managing the distributed nature of the application, including service discovery, configuration management, and load balancing.
Docker: For containerizing the microservices, ensuring consistent environments across development, testing, and production.
Kubernetes: (optional) For orchestrating and managing the containerized microservices, providing scalability and resilience.
Architecture Overview:
The application is designed following the microservice architecture pattern, where each service is an independently deployable unit, communicating with others via RESTful APIs. The API Gateway serves as the front door to the clients, directing requests to the appropriate microservices, while the Service Registry maintains service availability. The Config Server manages the configuration settings, promoting centralized management and simplified updates.

The use of multiple databases allows the application to leverage the strengths of each database technology, ensuring optimal performance and flexibility. OKTA Authentication provides a secure and scalable approach to managing user identities and access controls.

This microservice project exemplifies a modern, scalable, and secure approach to application development, integrating various technologies to deliver a comprehensive solution.
