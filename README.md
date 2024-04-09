# MausamUpdate

## Purpose
MausamUpdate is a weather update application designed to provide users with real-time weather information after registration and login.

## Tech Stack
- Java
- MySQL
- Spring Boot
- Spring Security
- Swagger UI

## Functionality
1. **Registration**
   - Users can sign up for an account by providing necessary details.
   - Registration includes fields such as username, email, and password.

2. **Login**
   - Registered users can securely log in to their accounts.
   - Authentication is handled using Spring Security.

3. **Weather Updates**
   - Upon successful login, users can access weather updates.
   - Weather information is fetched from external sources or APIs.
   - Users can view the weather forecast for their desired location.

## Hosting
- The application is hosted on Railway.app.
- Access the application through the provided host link: [MausamUpdate Host Link](https://dice1-production.up.railway.app/swagger-ui/index.html)
## Instruction to use Swagger API Documentation
 - First of all register their self as a user(role must be "user" or "admin")
 - After thet login by login api.
 - After that in response body there is a bearer token copy that and paste that token in in place of bearer token(right cornere there is is a symbol of lock after 
   clicking on this a input box will come for fill the bearer token and authorize that and closed).
 - After that access the weather api.
 
## Additional Notes
- Ensure MySQL is properly configured for the application to function correctly.
- Continuous monitoring and updating of weather data sources may be required for accurate updates.
- Consider implementing additional features such as location-based weather updates or personalized notifications based on user preferences for future iterations.
