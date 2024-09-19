# Université du Futur

[![GitHub Repo](https://img.shields.io/badge/GitHub-Repo-blue)](https://github.com/firasabdelaziz/future-university)
[![Java](https://img.shields.io/badge/Java-11%2B-orange)](https://www.java.com/)
[![Node.js](https://img.shields.io/badge/Node.js-14%2B-green)](https://nodejs.org/)
[![Docker](https://img.shields.io/badge/Docker-available-blue)](https://www.docker.com/)

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
  - [For Professors](#for-professors)
  - [For Students](#for-students)
  - [Common Features](#common-features)
- [Technology Stack](#technology-stack)
- [Installation](#installation)
  - [Prerequisites](#prerequisites)
  - [Steps](#steps)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction
"Université du Futur" is a web application designed to transform the academic experience for students and professors. It offers robust course and task management functionalities, real-time notifications, and comprehensive dashboards.

## Features

### For Professors
- **Course Management** 📝
  - Manage course details easily.
- **View and Export Tasks** 📊
  - Track and export tasks in Excel format.
- **Real-Time Notifications** 🔔
  - Get updates on task statuses and deadlines.
- **Dashboard Overview** 📈
  - Monitor courses and tasks with metrics and burndown charts.

### For Students
- **Task Management** 🗂️
  - Create, update, and delete tasks.
- **Export Tasks as PDF** 📄
  - Download tasks for offline access.
- **Real-Time Notifications** 🔔
  - Receive updates on task changes and deadlines.
- **Dashboard Overview** 📊
  - Visualize progress with a dashboard and burndown charts.

### Common Features
- **User Registration and Login** 🔐
  - Secure authentication for all users.

## Technology Stack
- **Backend:** [Spring Boot](https://spring.io/projects/spring-boot)
- **Frontend:** [Angular](https://angular.io/)
- **Database:** [MySQL](https://www.mysql.com/)
- **Containerization:** [Docker](https://www.docker.com/)
- **Real-Time Communication:** [WebSockets](https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API)

## Installation

### Prerequisites
- [Java 11+](https://www.java.com/)
- [Node.js 14+](https://nodejs.org/)
- [MySQL 8.x](https://www.mysql.com/)
- [Docker](https://www.docker.com/)
- [Maven](https://maven.apache.org/)

### Steps
1. **Clone the repository:**
   ```bash
   git clone https://github.com/firasabdelaziz/future-university.git
   cd future-university
   ```

2. **Backend Setup:**
   - Navigate to the backend directory:
     ```bash
     cd backend
     ```
   - Build the project using Maven:
     ```bash
     mvn clean install
     ```
   - Run the Spring Boot application:
     ```bash
     mvn spring-boot:run
     ```

3. **Frontend Setup:**
   - Navigate to the frontend directory:
     ```bash
     cd frontend
     ```
   - Install dependencies:
     ```bash
     npm install
     ```
   - Start the Angular development server:
     ```bash
     ng serve
     ```

4. **Docker Setup (Optional):**
   - Build and run the application using Docker:
     ```bash
     docker-compose up --build
     ```

## Usage
- Access the application in your web browser at [http://localhost:4200](http://localhost:4200).
- Professors and students can log in to manage courses and tasks.

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

