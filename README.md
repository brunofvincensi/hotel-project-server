# hotel-project-server

- System for hotel management
- Server application
- Client application: https://github.com/brunofvincensi/hotel-project-client
- Cloud API URL: https://aw-hotel-api.herokuapp.com
- API Swagger: https://aw-hotel-api.herokuapp.com/swagger-ui/index.html#

## Technologies Used
- Java 11
- Maven
- Spring Boot
- Postgresql
- H2 Database

## Dependencies
- Spring Data JPA
- Spring Validation
- Spring Web
- Spring Devtools
- PostgreSQL | H2
- Lombok
- Springfox Swagger

## Features

CRUD for guest registration
- Create  {baseUrl}/api/hospede (POST) </br>
- Read  {baseUrl}/api/hospede (GET) </br>
- Update  {baseUrl}/api/hospede:{} (PUT) </br>

Check-in and Check-out management
- Check in  {baseUrl}/api/hospedagem (POST) 
- Check out  {baseUrl}/api/hospedagem (PATCH) </br>

View former guests
- {baseUrl}/api/hospede/ex_hospedes (GET)</br>

Payment processing
- {baseUrl}/api/hospedagem/pay (PATCH)</br>


## MER Diagram

![UML](https://github.com/brunofvincensi/hotel-project-server/blob/main/database/MER_hotel_project.JPG)


## How to Run Locally
Pré-requisitos: 
- Java 11
- Intellij IDE (or other)
- Postgresql (optional) </br></br>

```bash
# Download or clone this repository:
https://github.com/Bruno-ferrariv/hotel-project-server

# Open the project in IntelliJ

# Download the dependencies listed in pom.xml

# Go to application.properties and set the active profile to 'development' or 'homologation'
# Use 'development' for local PostgreSQL
# Use 'homologation' for in-memory H2 database
```
![UML](https://github.com/brunofvincensi/hotel-project-server/blob/main/images/application.properties-image.JPG)

```bash
# If you choose the 'development' profile, use the script below and update the password in the properties file:
```
## [SCRIPT-DB](https://github.com/Bruno-ferrariv/hotel-project-server/blob/main/database/DDL_Hotel_Project)
![UML](https://github.com/brunofvincensi/hotel-project-server/blob/main/images/development-image.JPG)

```bash
# Finally, run the project using the HotelProjectApplication class
# Or run it from the terminal with the following command:
 ./mvnw spring-boot:run
```
