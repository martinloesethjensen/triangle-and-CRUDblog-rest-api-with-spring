# triangle-and-CRUDblog-restful-api-with-spring 

### Create a file: "application.properties" in the resources folder.
### In the file you have to write:
    spring.jpa.hibernate.ddl-auto=create //after running the application once, you should change it to "update"
    spring.datasource.url=jdbc:mysql://localhost:3306/<schema>?serverTimezone=UTC&ssl=False //your local database - in this case a mysql database
    spring.datasource.username=<username>
    spring.datasource.password=<password>
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect