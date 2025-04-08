# Technical Documentation – Assignment 4A

## ✅ Temporary Solution
- We created a GET request test using JSONPlaceholder API.
- Test only checks if HTTP status code is 200.

## ⚠️ Technical Debt
- Response body is not validated.
- Static hardcoded API endpoint.
- No test for negative or invalid inputs.

## 🔧 Future Plan
1. Add validation of title, userId, and body in the response.
2. Create parameterized tests for multiple post IDs.
3. Introduce error handling for bad requests.
4. Move base URL to config file for better flexibility.
