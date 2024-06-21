# Riddles You Know - A Spring Boot Project

Riddles You Know is a Spring Boot web application designed to test your riddle-solving skills!

## Features:
* Presents a randomly chosen riddle for you to solve.
* Allows you to guess the answer letter by letter.
* Provides feedback on your guesses, indicating if they're correct or incorrect.
* Tracks your remaining guesses and displays a message when you reach the limit.
* Reveals the completed riddle or congratulates you upon successful completion.

## Technologies Used:
* Spring Boot
* Thymeleaf (for templating)
* H2 Database (in-memory database for development)
* Spring Data JPA

## Running the application:
* Ensure you have Java 17 and Maven installed on your system.
* Clone or download the project.
* Open a terminal and navigate to the project directory.
* Run ``` mvn clean install```.
* The application will start on port 8080 by default. Access it at http://localhost:8080 in your web browser.

## Project Structure:
* ```pom.xml```: Defines project dependencies and build configuration.
* ```app.properties```: Configures application properties like datasource and H2 console.
* ```src/main/java/com.sitemapdev.riddles_you_know```: Contains Java source code for the application.
* ```controller```: Contains the GameController class handling user interaction.
* ```entity```: May contain classes representing Riddles (if implemented).
* ```service```: May contain the GameService class handling riddle logic (if implemented).
* ```src/main/resources/templates```: Contains Thymeleaf templates for the user interface (assuming this structure based on controller usage).

## Dependencies:
The project leverages the following Spring Boot starter dependencies:

* ```spring-boot-starter-actuator```: Provides health and monitoring endpoints.
* ```spring-boot-starter-thymeleaf```: Enables Thymeleaf templating engine.
* ```spring-boot-starter-web```: Provides web application functionalities.
* ```spring-boot-devtools```: Improves development experience with hot reloading. (Optional)
* ```lombok```: Provides code generation annotations. (Optional)
* ```h2```: In-memory database for development.
* ```spring-boot-starter-data-jpa```: Enables JPA data access.
* ```spring-boot-starter-tomcat```: Embeds Tomcat server for deployment. (Provided by default)
* ```spring-boot-starter-test```: Provides testing utilities. (For unit tests)

