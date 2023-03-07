# Student Management System

A robust and user-friendly web application designed for managing student records, offering comprehensive CRUD (Create, Read, Update, Delete) operations, advanced search capabilities, pagination for efficient data browsing, and integrated grade tracking. Built with modern Java and Spring Boot technologies, it provides a responsive and intuitive interface for educational institutions or personal use.

## Table of Contents

*   [Features](#features)
*   [Tech Stack](#tech-stack)
*   [Getting Started](#getting-started)
    *   [Prerequisites](#prerequisites)
    *   [Cloning the Repository](#cloning-the-repository)
    *   [Running the Application](#running-the-application)
*   [Usage](#usage)
*   [Project Structure](#project-structure)
*   [Database](#database)
*   [Future Enhancements](#future-enhancements)
*   [License](#license)

## Features

*   **Student Management:**
    *   **Add New Students:** Create new student records with details like name, email, and major.
    *   **View All Students:** Display a paginated list of all registered students.
    *   **Search Students:** Efficiently find students by name or email using a dynamic search bar.
    *   **Update Student Details:** Modify existing student information.
    *   **Delete Students:** Remove student records from the system.
*   **Grade Tracking:**
    *   **Add Grades:** Assign grades to specific students for various subjects/courses.
    *   **View Grades:** See a list of all grades associated with a student on their details page.
    *   **Update/Delete Grades:** (Planned for future, currently basic add/view)
*   **User Interface:**
    *   **Responsive Design:** A clean and intuitive user interface built with Thymeleaf and custom CSS, ensuring usability across different devices.
    *   **Pagination:** Navigate through large lists of students effortlessly.

## Tech Stack

*   **Backend:**
    *   Java 17+
    *   Spring Boot 3.x
    *   Spring Data JPA
*   **Frontend:**
    *   Thymeleaf (Templating Engine)
    *   HTML5
    *   CSS3 (Custom styling)
*   **Database:**
    *   H2 Database (In-memory for development and testing)
*   **Build Tool:**
    *   Maven 3.x

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Before you begin, ensure you have the following installed:

*   **Java Development Kit (JDK) 17 or higher:**
    *   [Download JDK](https://www.oracle.com/java/technologies/downloads/)
*   **Maven 3.6 or higher:**
    *   [Download Maven](https://maven.apache.org/download.cgi)
*   **Git:**
    *   [Download Git](https://git-scm.com/downloads)

### Cloning the Repository

1.  Open your terminal or command prompt.
2.  Navigate to the directory where you want to store the project.
3.  Clone the repository:
    ```bash
    git clone https://github.com/your-username/student-management-system.git
    ```
4.  Change into the project directory:
    ```bash
    cd student-management-system
    ```

### Running the Application

1.  Build the project using Maven:
    ```bash
    mvn clean install
    ```
2.  Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```
    Alternatively, you can run the JAR file after building:
    ```bash
    java -jar target/student-management-system-0.0.1-SNAPSHOT.jar
    ```
3.  Once the application starts successfully, open your web browser and navigate to:
    ```
    http://localhost:8080
    ```

## Usage

Upon launching the application and navigating to `http://localhost:8080`, you will be presented with the main student listing page.

*   **View Students:** The home page displays a paginated list of all students.
*   **Add Student:** Click the "Add New Student" button to open a form for creating a new student record.
*   **Search:** Use the search bar to filter students by their name or email.
*   **Edit Student:** Click the "Edit" button next to a student's entry to modify their details.
*   **Delete Student:** Click the "Delete" button to remove a student record.
*   **Student Details & Grades:** Click the "Details" button to view a student's full profile and manage their grades. On this page, you can add new grades for the student.

## Project Structure

The project follows a standard Spring Boot application structure:

```
student-management-system/
├── .gitignore
├── pom.xml                                 # Maven build file
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/example/sms/
    │   │       ├── StudentManagementSystemApplication.java # Main Spring Boot entry point
    │   │       ├── controller/             # Handles web requests and returns responses
    │   │       │   └── StudentController.java
    │   │       ├── model/                  # Defines data structures (entities)
    │   │       │   ├── Student.java
    │   │       │   └── Grade.java
    │   │       ├── repository/             # Data access layer (Spring Data JPA repositories)
    │   │       │   ├── StudentRepository.java
    │   │       │   └── GradeRepository.java
    │   │       └── service/                # Business logic layer
    │   │           └── StudentService.java
    │   └── resources/
    │       ├── application.properties      # Application configuration (e.g., database settings)
    │       ├── static/                     # Static resources (CSS, JS, images)
    │       │   └── css/
    │       │       └── style.css
    │       └── templates/                  # Thymeleaf HTML templates
    │           ├── students.html           # Main student listing page
    │           ├── student-form.html       # Form for adding/editing students
    │           └── student-details.html    # Student details and grade management page
    └── test/                               # Unit and integration tests
```

## Database

This project uses an **H2 in-memory database** for simplicity and ease of setup during development.

*   **Configuration:** The database settings are defined in `src/main/resources/application.properties`.
*   **Data Persistence:** As an in-memory database, all data will be lost when the application is restarted. This is ideal for development and testing but not for production environments requiring persistent data.
*   **H2 Console:** You can access the H2 console to view the database schema and data by navigating to `http://localhost:8080/h2-console` after the application starts.
    *   **JDBC URL:** `jdbc:h2:mem:smsdb` (as configured in `application.properties`)
    *   **Username:** `sa`
    *   **Password:** (leave blank)

## Future Enhancements

*   **User Authentication & Authorization:** Implement Spring Security for user login, roles (e.g., Admin, Teacher), and access control.
*   **Persistent Database:** Migrate from H2 to a production-ready database like PostgreSQL or MySQL.
*   **Advanced Grade Management:**
    *   Ability to edit and delete individual grades.
    *   Calculate average grades for students.
    *   Filter grades by subject or semester.
*   **Error Handling:** More robust and user-friendly error pages and messages.
*   **Export Functionality:** Allow exporting student data to CSV or PDF formats.
*   **REST API:** Expose a RESTful API for external applications to interact with student data.
*   **Testing:** Comprehensive unit and integration tests for all layers of the application.
*   **Frontend Framework:** Consider integrating a modern JavaScript framework (e.g., React, Vue) for a more dynamic frontend experience, while still leveraging Spring Boot for the backend.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.