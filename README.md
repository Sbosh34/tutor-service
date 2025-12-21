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

Update task title

    curl -i http://localhost:8080/tasks/1 \
    -H "Content-Type: application/json" \
    -d '{"title":"Write new title brev"}'

Delete task
  
    curl -i -X DELETE .../tasks/id  

## Notes for Windows + WSL

## Pagination, Sorting, and Filtering

The `GET /tasks` endpoint supports **pagination** and **sorting** via Spring-style query parameters, and can optionally **filter** by completion status.

### Query parameters
- `page` (number, default `0`): zero-based page index  
- `size` (number, default `20`): page size  
- `sort` (string, optional): sorting in the form `field,direction` (for example `createdAt,desc`)  
- `completed` (boolean, optional): filter tasks by completion status (`true` or `false`)

### Examples
List tasks (defaults apply):
```bash
curl -i "http://localhost:8080/tasks"

Fetch the first 5 tasks, newest first:

    curl -i .../tasks?page=0&size=5&sort=createdAt,desc

Fetch only the finished tasks

    curl -i .../tasks?completed=true&page=0&size=10

If you run the service in WSL, you can still call it from Windows or WSL using:
  \<LocalHost\>

