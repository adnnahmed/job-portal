
# Job Portal

## Introduction

Welcome to the Job Portal project! This application serves as a backend solution for a basic job portal system. It is built using the Spring framework and Java, with PostgreSQL as the database managed through Docker.

## Features

-   **Job Listings:** Create, update, and delete job listings.
-   **User Authentication:** Secure user authentication to manage job listings & reviews. [To be implemented]
-   **Company Authentication:** Secure authentication for companies to post job listings and receive reviews.
-   **Reviews:** Users can provide reviews for companies.
-   **Database Management:** PostgreSQL database used for storing job, user, company, and review data.

## Tech Stack

-   **Java:** The primary programming language for the application logic.
-   **Spring Framework:** Utilizing the power of Spring for building a robust backend.
-   **PostgreSQL:** A powerful, open-source relational database management system.
-   **Docker:** Containerization for easy deployment and management.

## Prerequisites

Before you begin, ensure you have the following installed:

-   Java JDK
-   Spring Boot
-   [Docker](https://www.docker.com/)
-   Code editor of your choice (e.g., IntelliJ IDEA)

## Getting Started

1.  Clone the repository:
    
    
    `git clone https://github.com/your-username/job-portal.git` 
    
2.  Navigate to the project directory:
	   
    `cd job-portal`
    
3.  Build and run the application:
    
    `./mvnw spring-boot:run` 
    
4.  Access the API at http://localhost:8080.
    

## API Endpoints

-   **Job Listings:**
    
    -   **GET /jobs:** Retrieve all job listings.
    -   **GET /jobs/{id}:** Retrieve a specific job listing by ID.
    -   **POST /jobs:** Create a new job listing.
    -   **PUT /jobs/{id}:** Update a job listing.
    -   **DELETE /jobs/{id}:** Delete a job listing.
-   **Companies:**

    -   **GET /companies/{companyId}:** Retrieve all companies.    
    -   **GET /companies/{companyId}:** Retrieve a specific company by ID.
    -   **POST /companies:** Create a new company.
    -   **PUT /companies/{companyId}:** Update a company's information.
    -   **DELETE /companies/{companyId}:** Delete a company.
-   **Reviews:**
    
    -   **GET /companies/{companyId}/reviews** Retrieve all reviews for a specific company.
    -   **GET /companies/{companyId}/reviews/{reviewId}** Retrieve a specific review by ID for a specific company.
    -   **POST /companies/{companyId}/reviews** Submit a review for a company.
    -   **PUT /companies/{companyId}/reviews/{reviewId}:** Update a review.
    -   **DELETE /companies/{companyId}/reviews/{reviewId}:** Delete a review.

## Configuration

Ensure that your PostgreSQL database is properly configured in the `application.properties` file.


`spring.datasource.url=jdbc:postgresql://localhost:5432/jobportal`

`spring.datasource.username=your_username`

`spring.datasource.password=your_password` 
