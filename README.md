# triangle-and-CRUDblog-restful-api-with-spring 
[Examples for the API](#examples)
- [Triangle types](#triangle-type):
- [Posts](#post)
- [Comments](#comment)

This is a simple api to check a triangle type and also a blog api. The blog api handles CRUD for making post and comments for posts.

Before starting you should add spring boot, mysql and jpa dependencies. This is because we will connect to an mysql database locally and use jpa to read and make changes to the database.

When you have run the application once, you'll have to put some data in your database.

## Dependencies you will need in your pom.xml file:
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.0</version>
        </dependency>
        <!-- JPA Data (We are going to use Repositories, Entities, Hibernate, etc...) -->

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <!-- Use MySQL Connector-J -->

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <dependency>
            <groupId>javax.persistence</groupId>
            <artifactId>javax.persistence-api</artifactId>
            <version>2.2</version>
        </dependency>
    </dependencies>

### Create a file: "application.properties" in a /src/resources folder that you'll also need to create.
This is what will connect you with the database
### In the file you have to write:
    spring.jpa.hibernate.ddl-auto=create //after running the application once, you should change it to "update"
    spring.datasource.url=jdbc:mysql://localhost:3306/<schema>?serverTimezone=UTC&ssl=False //your local database - in this case a mysql database
    spring.datasource.username=<username>
    spring.datasource.password=<password>
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
    
# Examples:
## Triangle type:
- ### Scalene: All sides are different.
`http://localhost:8080/api/triangle?a=11&b=12&c=13`
- ### Equilateral: All sides are equal.
`http://localhost:8080/api/triangle?a=12&b=12&c=12`
- ### Isosceles: Two sides are equal.
`http://localhost:8080/api/triangle?a=12&b=11&c=12`
- ### Incorrect: Not a triangle.
`http://localhost:8080/api/triangle?a=11&b=12`
## Post:
- ### Creating a post:
`http://localhost:8080/api/post/create?data={data}&author={author}`
- ### Reading a post:
`http://localhost:8080/api/post/{id}`
- ### Deleting a post: 
`http://localhost:8080/api/post/delete/{id}`
- ### Updating a post:
`http://localhost:8080/api/post/update/{id}?data={data}&author={author}`
## Comment:
- ### Creating a comment:
`localhost:8080/api/comment/create/{post_id}?name={name}&data={data}`
- ### Reading a comment:
`localhost:8080/api/comment/{id}`
- ### Deleting a comment:
`localhost:8080/api/comment/delete/{id}`
- ### Updating a comment:
`localhost:8080/api/comment/update/{post_id}?name={name}&data={data}`
