## Handling databases

In a Java application, developers generally use the concept of utility class to create, open, and close database connections. It is a pretty sound, smart, and reusable way for connection management, but still, the application is tightly coupled with the utility class. Any change in either the database or its connectivity, such as URL, username, password, or schema, needs to be changed in the class. This needs to be followed by recompilation and redeployment of the code. We cannot externalize the Connection object, which has to be managed by the developer, and so do the exceptions while handling it. Spring has an elegant and loosely coupled way to manage the connection using **DataSource** at the center.

### DataSource

**DataSource** is the factory for data source connections similar to DriverManager in JDBC, which helps in connection management

>**With the help of the JDBC driver**: One can use the following class to configure the simplest way to get an object of **DataSource**:

> **SingleConnectionDataSource**: As we already discussed, this returns a single connection

> **DriverManagerDataSource**: This returns a new connection object on request

```java
        <bean id="dataSource" 
            class="org.springframework.jdbc.datasource
           .DriverManagerDataSource"> 
          <property name="driverClassName" 
            value="org.hsqldb.jdbcDriver"/> 
          <property name="url" 
            value="jdbc:hsqldb:hsql://locahost/name_of_schama"/> 
          <property name="username" 
            value="credential_for_username"/> 
          <property name="password" 
            value="credential_for_password"/> 
        </bean> 
```

>**SingleConnectionDataSource** is suitable for small, single-threaded applications. **DriverManagerDataSource** supports multithreaded applications. The **DriverManagerDataSource** is not a pooled **DataSource**, and it needs to be managed carefully for handling multiple connections. It ultimately hampers the application performance. It's recommended to use a pooled data source for better performance.

The **DataSource** facilitates handling of connection with the database, so it needs to be injected in the module.

- Case 1 - Using XML configuration of DriverManagerDataSource
- Case 2 - Using annotations for DriverManagerDataSource

[Using DataSource](https://github.com/oceannguyen/spring-framework-note/tree/master/03-Accelerate-with-SpringDAO/ch03-01-DataSourceConfiguration)

### Using template classes to perform JDBC operations

Template classes provide an abstract way to define operations by getting rid of common issues, such as opening and maintaining the connection, and the boiler plate code

#### JdbcTemplate

**JdbcTemplate** helps the developers to concentrate on the core business logic of the application without getting involved in how to open or manage the Connection

### NamedParameterJdbcTemplate

**NamedParamterJdbcTemplate**, which facilitates the use of named parameters to specify the parameters in SQL. Each parameter will have a named prefixed with a colon(:)

[Using JdbcTemplate and NamedParameterJdbcTemplate](https://github.com/oceannguyen/spring-framework-note/tree/master/03-Accelerate-with-SpringDAO/ch03-02-JdbcTemplate)


