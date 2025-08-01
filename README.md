# USCIS Case Tracker App

A full-stack web application for tracking USCIS (U.S. Citizenship and Immigration Services) case statuses.  
Built with **Spring Boot**, **PostgreSQL**, **Spring Security**, and **Thymeleaf**, this project enables users to securely monitor their immigration case progress with features like multi-case tracking, public lookups, OAuth2 integration, and scheduled updates.

> ⚠️ _Note: This application is currently under active development and will be released as a public-facing web app in the near future._

---

## Features

- **JWT Authentication** – Secure user registration and login flow with token-based access  
- **Role-Based Access Control (RBAC)** – Admin/user-level permissions using `enum` roles and `@PreAuthorize` annotations  
- **USCIS API Integration** – Real-time case updates from the official **USCIS Case Status API** using **OAuth 2.0**  
- **Scheduled Tasks** – Daily background job to auto-refresh case statuses for all users  
- **Public Lookup** – Thymeleaf frontend that allows status check without login  
- **Deployment** – Hosted on **AWS EC2** with `.env` and `application.properties`-based configuration  
- **API Documentation** – Swagger/OpenAPI integration for all REST endpoints  
- **Clean Architecture** – Layered structure using Controller → Service → Repository pattern and DTOs  

---

## Tech Stack

**Backend**  
- Java 21  
- Spring Boot (Web, Security, JPA, Scheduler)  
- PostgreSQL  
- OAuth 2.0 (Client Credentials Grant)  
- JWT + Spring Security  
- Swagger / OpenAPI  
- Maven

**Frontend**  
- Thymeleaf (for public status lookup)

**Deployment & DevOps**  
- AWS EC2 (Ubuntu)  
- Environment-based configuration with `.env` and `application.properties`  
- CI/CD awareness with GitHub Actions (basic setup)

---

## Authentication & Authorization

- User registration and login with password encryption and JWT
- Secure endpoints via Spring Security + token-based auth
- Admin-only routes protected by `@PreAuthorize("hasRole('ADMIN')")`

---

## USCIS API Integration

- Real-time case status is fetched from the USCIS Case Status API
- Authentication is handled via **OAuth 2.0 Client Credentials**
- Token is cached and refreshed automatically as needed

---

## Future Plans

This project is still under active development. Upcoming enhancements include:

- Email notifications for case status changes  
- Unit and integration testing with JUnit  
- CI/CD pipeline improvements  
- Responsive frontend interface  
- Live deployment with custom domain and HTTPS  
- Multi-language support  

---

## Author

**Selim Kamuran Sensoy**  
Washington DC – Baltimore Area  
- [LinkedIn](https://linkedin.com/in/selimkamuransensoy/)  
- [GitHub](https://github.com/kamuransensoy)
