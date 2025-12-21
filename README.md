# TutorHub Service

Backend service for TutorHub, built with Spring Boot and PostgreSQL.

## What this service currently does

- Health endpoint to confirm the service is alive.
- Task API:
  - Create a task
  - List tasks
  - Get a task by identifier
  - Mark a task as complete
  - Validation errors return a clear JSON response
  - Missing tasks return a clear JSON response

## Requirements

- Java 17
- PostgreSQL 16 (or compatible)
- Git
- This repository includes the Maven Wrapper, so you do not need to install Maven separately.

## Database setup

This project expects a PostgreSQL database.

Example setup (run in a terminal):

1) Confirm PostgreSQL is running
   pg_isready

2) Create a database user (role)
   sudo -u postgres createuser -P tutorhub_app

3) Create the database owned by that user
   sudo -u postgres createdb -O tutorhub_app tutorhub

If your PostgreSQL is not running on port 5432, confirm the port in PostgreSQL:
  sudo -u postgres psql -c "SHOW port;"

Make sure your application configuration matches your PostgreSQL host, port, database name, username, and password.

## Run tests

From the project root:

  ./mvnw test

## Run the service

  ./mvnw spring-boot:run

The service will start on your LocalHost

## API quick checks (using curl)

Health:

  curl -i .../health

List tasks:

  curl -i .../tasks

Create a task:

  curl -i -X POST .../tasks \
    -H "Content-Type: application/json" \
    -d '{"title":"First task"}'

Validation example (title is required):

  curl -i -X POST .../tasks \
    -H "Content-Type: application/json" \
    -d '{"title":""}'

Get task by identifier:

  curl -i .../tasks/1

Not found example:

  curl -i .../tasks/999999

Mark task as complete:

  curl -i -X PATCH .../tasks/1/complete

Delete task
  
    curl -i -X DELETE .../tasks/id  
## Notes for Windows + WSL

If you run the service in WSL, you can still call it from Windows or WSL using:
  \<LocalHost\>

