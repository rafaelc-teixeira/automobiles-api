# Automobiles-api

This is a sample Spring Boot application built using Gradle that connects to a PostgreSQL database. You can use Docker and Docker Compose to easily run this application and its dependencies.

## Prerequisites
Before you can run this application, you'll need to have the following installed on your machine:

* Docker

## Running the Docker image
1. Clone this repository and navigate to the project directory in your terminal.
2. Build the Docker image with the following command:

   `docker build -t automobiles-api .`

3. Run the Docker container fir the PostgreSQL database with the following command:

   `docker run --name automobiles-db -p 5433:5432 -e POSTGRES_DB=automobiles-db -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123456 postgres`

4. Run the Docker container for the application with the following command:

   `docker run --name automobiles-api -p 3333:3333 --link automobiles-db:automobiles-db -e SPRING_DATASOURCE_URL=jdbc:postgresql://automobiles-db:5432/automobiles-db -d automobiles-api`

5. Access the application

The application will be accessible at http://localhost:3333.

## Running the application using Docker Compose

Alternatively, you can use Docker Compose to start the application and its dependencies with a single command.

1. Start the application and its dependencies using Docker Compose

    `docker-compose up`
   
This will start the PostgreSQL container and the Spring Boot container, and link them together automatically.

2. Access the application

   You can now access the Spring Boot application by going to http://localhost:3333 in your web browser.