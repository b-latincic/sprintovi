# Sprintovi (Sprints)

This repository contains a web application developed using Spring Boot, React, and Bootstrap frameworks for tracking music performances.

## Features

### Entities:

- **Sprint**: id (Unique identifier), ime (textual value), ukupnoBodova (positive number), zadaci (@OneToMany relationship with Zadatak class)
- **Stanje**: id (Unique identifier), ime (textual value), zadaci (@OneToMany relationship with Zadatak class)
- **Zadatak**: id (Unique identifier), ime (textual value), zaduzeni (textual value, required, max length = 40), bodovi (numerical value, positive, max value = 40), sprint (@ManyToOne relationship to Spring class), stanje (@ManyToOne relationship to Stanje class)

### Implemented REST API:

- `GET /api/zadaci` - Fetch all Zadatak entities
- `GET /api/stanja` - Fetch all Stanje entities
- `GET /api/sprintovi` - Fetch all Sprint entities
- `GET /api/zadaci/{id}` - Fetch one Zadatak entity
- `PUT /api/zadaci/{id}` - Modify an existing Zadatak entity (for admins and users)
- `POST /api/zadaci` - Add a new Zadatak (for admins and users)
- `DELETE /api/zadaci/{id}` - Delete an existing Zadatak entity (for admins)

### API Validation:

- **bodovi** must be a positive number
- **ime** must be provided

## Installation

1. Clone this repository to your local machine.
2. Navigate to the backend directory and run the Spring Boot application.
3. Navigate to the frontend directory and run the React application.

## Usage

- **Admins** have access to all functionalities. (TODO)
- **Users** can add new Zadatak. (TODO)
- Only logged-in users have access to the application. Users log in via the login page.

### Admin Credentials:

- **Username**: miroslav
- **Password**: miroslav

### User Credentials:

- **Username**: petar
- **Password**: petar

## Additional Notes

- Ensure that the backend and frontend are both running to access the full functionality of the application.
- Test data for the database is provided along with the solution.
- HTTPS configuration is not required for this project.
