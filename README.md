# Project README

This project is a Java application that demonstrates the usage of Spring Boot and JPA for managing orders and products.

## Prerequisites

- Java 8 or higher
- Maven
- MySQL database

## Getting Started

1. Clone the repository:
  git clone https://github.com/wisann/workshop-springboot3-jpa.git

2. Change into the project directory
  

3. Build the project using Maven:
```shell
  mvn clean install 
```
4. Configure the database connection in the `application.properties` file:
```shell
  spring.datasource.url=jdbc:mysql://localhost:3306/your-database
  spring.datasource.username=your-username
  spring.datasource.password=your-password
```
5. Run the application:
```shell
  mvn spring-boot:run
```

## API Endpoints

The following API endpoints are available:

- GET /categories: Get all categories
- GET /products: Get all products
- GET /products/{id}: Get a product by ID
- POST /products: Create a new product
- PUT /products/{id}: Update a product
- DELETE /products/{id}: Delete a product
- GET /orders: Get all orders
- GET /orders/{id}: Get an order by ID
- POST /orders: Create a new order
- PUT /orders/{id}: Update an order
- DELETE /orders/{id}: Delete an order

## Data Model

The application uses the following entities:

- Category: Represents a category of products
- Product: Represents a product
- User: Represents a user or client
- Order: Represents an order placed by a user
- OrderItem: Represents an item in an order
- Payment: Represents a payment made for an order
