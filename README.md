# DBS-Labor
This Project is for the Distributed System Labor
What does it contain:
 - A full Website for managing own banking accounts and theire contracts
 - Docker Container for Front and Backend

Overview: NOTE: Each of them is in an own Docker container
1. Backend Database
2. Backend API
3. Frontend React


1. Backend Database
For the Project i used a mysql database for simple sql usage. The advantage here is, that mysql provides a docker container. So the installation si really simple made by the docker-compose.yml. So at all the  Database dont need any more steps for the installation. The logic inside the DB is simple. It contains 3 Tables for the main functionality. The first one is the User Table which holds the base data for user like name or email and password. The other two tables are for the main purpose of use. We have a Account table for the banking accounts and a transaction table. There is no more functionality.

2. Backend API
The Spring application holds the main functionality. It contains the connection to the Database and the processing of the data. Its builded like an typicall Rest Api with jpa. We have a Rest Class where we can access urls with functionality and classes for handle the Database table. This classes divided into Entity class for only holding data, repository class as interface for the table functionality and the controller / service class, which holds the interface functions.
This structure is visible by packages in the backend folder
For the database config, you can have a look into the ressource folder. Here is the main file the application.config

3. Frontend React
The Frontend is created with the React Framework.


