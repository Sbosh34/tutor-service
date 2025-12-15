# TutorHub Service (Spring Boot + PostgreSQL)

A small REST API built with Spring Boot and PostgreSQL.

## Tech
- Java 17
- Spring Boot
- Maven
- PostgreSQL

## Run locally (WSL)

### 1) Start PostgreSQL on WSL(linux)

Check it's running:
```bash
pg_isready


2. Set Environment vars
export TUTORHUB_DB_URL="jdbc:postgresql://localhost:5433/tutorhub"
export TUTORHUB_DB_USER="tutorhub_app"
export TUTORHUB_DB_PASSWORD="YOUR_PASSWORD"

3. Run tests
./mvnw test

4. Run Service
./mvnw spring-boot:run

API Calls

see health
curl -i -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"First task"}'

create task
curl -i -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"First task"}'

list task
curl -i http://localhost:8080/tasks

get task by id
curl -i http://localhost:8080/tasks/1

mark task as complete
curl -i -X PATCH http://localhost:8080/tasks/1/complete



