# QuizWhiz - Interactive Coding Quiz Platform

QuizWhiz is a full-stack web application that provides interactive coding quizzes across multiple programming languages including Java, Python, JavaScript, and .NET.

## Features

- 🎯 Multiple programming language quizzes
- 📱 Responsive design for all devices
- 🔄 Randomized questions
- ⏱️ Real-time scoring
- 📊 Results tracking
- 🏆 Top performers showcase
- 📚 Study resources and notes section

## Tech Stack

### Frontend
- HTML5
- CSS3
- JavaScript (Vanilla)
- Responsive Design

### Backend
- Java Spring Boot
- MySQL Database
- JPA/Hibernate
- RESTful APIs

## Project Structure

```
QuizWhiz/
├── Frontend/
│   ├── images/
│   ├── index.html
│   ├── style.css
│   ├── index.js
│   ├── java-quiz.html
│   ├── java-quiz.js
│   └── [other quiz pages]
│
└── Backend/
    ├── src/
    │   ├── main/
    │   │   ├── java/com/my/quiz/
    │   │   │   ├── config/
    │   │   │   ├── controller/
    │   │   │   ├── entity/
    │   │   │   ├── service/
    │   │   │   └── QuizApplication.java
    │   │   └── resources/
    │   │       └── application.properties
    └── pom.xml
```

## Setup and Installation

### Prerequisites
- Java JDK 21
- MySQL
- Maven
- Web browser

### Backend Setup
1. Clone the repository
   ```bash
   git clone [repository-url]
   ```

2. Navigate to Backend directory
   ```bash
   cd Backend
   ```

3. Configure MySQL database in `application.properties`
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/quiz_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. Build and run the Spring Boot application
   ```bash
   mvn spring-boot:run
   ```

### Frontend Setup
1. Navigate to Frontend directory
   ```bash
   cd Frontend
   ```

2. Open `index.html` in a web browser or serve using a local server
   ```bash
   # Using Python's built-in server
   python -m http.server 3000
   ```

## API Endpoints

- `GET /quiz/questions` - Fetch all quiz questions
- `POST /quiz/login` - User authentication
- `POST /quiz/save` - Save a single question
- `POST /quiz/save-all` - Save multiple questions

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE.md file for details

## Acknowledgments

- Special thanks to all contributors
- Inspired by modern learning platforms
- Built with ❤️ by [Your Name]


This README provides:
1. A clear project overview
2. Detailed setup instructions
3. Tech stack information
4. Project structure
5. API documentation
6. Contributing guidelines
7. Contact information

You should customize:
- Repository URLs
- Database configuration details
- Your personal information and social links
- Any specific setup requirements for your environment
- Additional features or endpoints you've implemented

