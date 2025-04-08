# Basic API Test Project

## 📋 Overview
This project is a basic API testing setup using:
- Java
- Maven
- TestNG
- RestAssured

## 🧪 Goal
To implement a simple GET request with temporary validation and document tech debt and improvements.

## 🛠 How to Run
1. Make sure you have Java and Maven installed.
2. Run from terminal: mvn test

3. Or run `testng.xml` directly from your IDE.

## 📂 Structure
- `src/test/java/com/example/api/ApiTest.java` – test logic
- `pom.xml` – project dependencies
- `testng.xml` – test suite
- `docs/documentation.md` – project notes and plan

## ✅ Temporary Solution
- Only checking HTTP 200 response status for now

## 🚧 Future Plans
- Add validations for response content (e.g., title, userId)
- Implement parameterized testing
- Add failure scenario handling

## ✅ Features Implemented

- Enhanced GET request with validations (status code, body fields, userId)
- Negative test case for non-existent post ID (returns empty JSON)
- Data-driven testing with TestNG DataProvider for multiple IDs
- Basic error handling and logging added

