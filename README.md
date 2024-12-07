# Ebankingapp - Backend

## Overview

The **Ebankingapp** project is the backend of an e-banking application developed using **Spring Boot**. This project provides robust and secure backend services for handling user operations such as registration, login, and role management. It communicates effectively with the frontend, built with **React.js**, to create a comprehensive, full-stack banking solution.

The backend is designed to manage user data, perform role-based access control, and facilitate various banking functionalities. This includes managing both customer and admin interactions for a seamless user experience.

## Project Highlights

- **Scalable and Secure**: Built using Spring Boot, ensuring scalability and secure handling of user data.
- **RESTful API**: Exposes REST endpoints for smooth communication between the backend and frontend.
- **Database Management**: Uses SQL for storing and managing user and banking data.
- **Role-Based Access Control**: Differentiates between Admin and Customer roles to enable tailored functionality and access.

## Features

- **User Registration and Login**:
  - New users can create accounts.
  - Existing users can log in with their credentials.
- **Role-Based Access Control**:
  - Two distinct user roles: Admin and Customer.
- **Admin Functionalities**:
  - View and edit own profile.
  - Manage customer profiles (add, edit, delete).
  - View detailed customer information.
- **Customer Functionalities**:
  - View and update profile information.
  - Add and manage beneficiaries.
  - Access support contact details.
  - Manage subscribed services.

## Technologies Used

- **Spring Boot**: Framework for building the REST API.
- **Java**: Main programming language for the backend logic.
- **SQL**: For database management.

## Getting Started

### Prerequisites

- JDK 11 or higher
- Maven or Gradle
- A configured database (e.g., MySQL, PostgreSQL)

### Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/ashserrao/Ebankingapp.git
2. Navigate to the project directory:
   ```bash
   cd Ebankingapp
3. Configure the database connection in `application.properties`.
4. Navigate to the project directory:
   ```bash
   mvn clean install
5. mvn clean install
    ```bash
   mvn spring-boot:run
    
### Documentation

For further understanding of the frontend, check out the [React-Ebanking README](https://github.com/ashserrao/React-Ebanking).

## Screenshots

![Ebankingflow chart drawio](https://github.com/user-attachments/assets/49cc7e9a-7150-4fe6-97e8-e03caef9723a)


## Author
Anush Serrao
