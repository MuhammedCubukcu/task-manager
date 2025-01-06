# Task Management System

A robust Spring Boot application designed for efficient task and user management with RESTful architecture.

## 🚀 Features

- **User Management**
  - User registration and authentication
  - Profile management
  - Role-based access control
- **Task Management** (Coming soon)
  - Task creation and assignment
  - Status tracking
  - Priority management
  - Deadline monitoring

## 🛠 Tech Stack

- **Backend Framework:** Spring Boot 3.x
- **Java Version:** JDK 21 (LTS)
- **Database:** MySQL 8.0
- **ORM:** Spring Data JPA
- **Build Tool:** Maven
- **API Documentation:** Swagger/OpenAPI

## 📋 Prerequisites

- JDK 21 or higher
- MySQL 8.0+
- Maven 3.x
- Git

## 🔧 Installation & Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/task-management.git
   cd task-management
   ```

2. **Configure MySQL Database**
   ```sql
   CREATE DATABASE task_managementdb;
   ```

3. **Configure Application Properties**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/task_managementdb
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

4. **Build and Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## 🌐 API Endpoints

### User Management
```
GET    /api/users     - Retrieve all users
POST   /api/users     - Create a new user
GET    /api/users/{id} - Get user by ID
PUT    /api/users/{id} - Update user
DELETE /api/users/{id} - Delete user
```

## 🔒 Security

- JWT based authentication
- Role based authorization
- Password encryption using BCrypt

## 🧪 Testing

Run the tests using Maven:
```bash
mvn test
```

## 📚 Documentation

API documentation is available at:
```
http://localhost:8080/swagger-ui.html
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- **Muhammed ÇUBUKCU** - *Initial work*

## 🙏 Acknowledgments

- Spring Boot Documentation
- MySQL Documentation
- Stack Overflow Community
