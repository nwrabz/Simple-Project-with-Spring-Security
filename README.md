# Spring Boot Security Demo Project

This is a simple Spring Boot project demonstrating **Spring Security** integration with **Thymeleaf** and **Spring Data JPA**. It uses **MySQL** as the database and includes basic authentication and authorization features.

This project is based on concepts from *Spring Security in Action* and enhanced with modern practices.

---

## Features

* User authentication using Spring Security
* Role-based authorization (basic setup)
* Thymeleaf integration for secure web pages
* CRUD operations with Spring Data JPA
* MySQL database connection
* Lombok for boilerplate code reduction

---

## Technologies Used

* Java 17+
* Spring Boot 3.x
* Spring Security 6
* Spring Data JPA
* Thymeleaf 3.x
* MySQL 8.x
* Lombok

---

## Getting Started

### Prerequisites

* Java 17 or higher installed
* MySQL server running
* Maven installed (or use Spring Boot Wrapper)

### Setup Instructions

1. Clone the repository:

```bash
git clone https://github.com/your-username/your-project.git
cd your-project
```

2. Configure your MySQL database connection in `application.properties` or `application.yml`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. Build and run the project:

```bash
mvn clean install
mvn spring-boot:run
```

4. Open your browser at `http://localhost:8080`

## Project Structure

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/527ae525-1e4c-4d1a-822d-0e199fa19495" />

## Usage

* Register new users or use default users (if configured)
* Access restricted pages based on user roles
* Explore CRUD operations on entities via web interface

## Notes

* This is a **learning/demo project**. Not production-ready.
* Some features are simplified for educational purposes.
* Modern Spring Security practices are applied, but older examples from books may differ slightly.

## Contributing

1. Fork the project
2. Create a feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Open a pull request

