# Student-JPA-Application

Spring Boot application with Data JPA and MVC design pattern for the implementation of services to create, read, update, and delete student data stored in a MySQL database.  

**Features:**
* UI with JSP and JSTL
* Read/Write student information in database
* IO Streams --> save data to an external .txt file
* **Spring Boot Security:**
  - Uses jdbc authentication for the login and registration of students
  - Access to certain features based on roles:
    - Student:
      - read privileges only (can't add, update, or delete a student from DB)
    - Admin
      - read/write privileges
      - username/password --> "admin"/"admin"

**Execution:**
 * run as Java application
 * connect to localhost:8080 in browser
 * login as admin, add some students, try out the other features
 * logout and log back in as one of the users you created
    --> you will find that some features/information is now blocked!
   
