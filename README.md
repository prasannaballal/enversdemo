
# Envers Demo

This is a Spring Boot project demonstrating the use of Hibernate Envers for auditing entity changes in a PostgreSQL database.

## Features

- Create, update, and delete `Person` entities.
- Audit changes to `Person` entities using Hibernate Envers.
- Store audit logs in a separate table (`person_aud`).

## Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for building the application.
- **Hibernate Envers**: For auditing entity changes.
- **PostgreSQL**: Database for storing data and audit logs.
- **Maven**: Build and dependency management tool.

## Prerequisites

- Java 21
- Maven 3.8 or higher
- PostgreSQL database
- IDE (e.g., IntelliJ IDEA)

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd enversdemo
   ```

2. Configure the database:
    - Use docker compose file in `src/main/resources/docker-compose.yml` to start PostgreSQL:
      ```bash
      docker-compose up -d
      ```
    - create table using SQL Script file in `src/main/resources/db.migration/V1__create_tables.sql`:

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

5. Access the database to view the `person` and `person_aud` tables:
   ```sql
   SELECT * FROM person;
   SELECT * FROM person_aud;
   ```

## Endpoints

### Create a Person
- **URL**: `/create`
- **Method**: POST
- **Payload**:
  ```json
  {
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com"
  }
  ```

### Update a Person
- **URL**: `/update`
- **Method**: PUT
- **Payload**:
  ```json
  {
    "id": 1,
    "firstName": "Jane",
    "lastName": "Doe",
    "email": "jane.doe@example.com"
  }
  ```

### Delete a Person
- **URL**: `/delete/{id}`
- **Method**: DELETE

## Database Schema

- **Table**: `person`
- **Audit Table**: `person_aud`

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.
```
