# Understanding Transaction Management

The transaction management helps the developers maintain the consistency and integrity of the database by either making all the operations reflected correctly in the database tables or none of them.

## Isolation

Multiple transactions take place, leading to the problem of data mismanagement. Isolation helps us keep the data in a consistent state by locking the mechanism. Unless one of the transactions that is dealing with data is not complete, it will keep the lock on it

> Dirty read
> Non-repeatable read
> Phantom read
> Repeatable read

# Life cycle of transaction management


The following are the advantages of using the Spring Framework's transaction management:

> It provides a lightweight and declarative syntax for transaction management

> It provides support for flexible transaction propagation management

> It provides a simple, consistent transaction management API for JTA, JDBC, and Hibernate

> It provides support for easy transaction management for both declarative as well as programmatic transaction management   

To apply transaction management in an application, we can think about the following points:

> Whether to apply the transaction to the DAO layer or the Service layer

> Decide whether to use declarative transaction or programmatic transaction management

> Define **PlatformtransactionManager** to use in beans configuration

> Decide the transaction attributes such as propagation behavior, isolation level, read only, timeout, and more, to be defined for the transaction

> According to programmatic or declarative transaction management, add the attributes to the transaction either in code or in the configuration of the XML file

Spring facilitates the use of transaction management in two ways, which are as follows:

> Programmatic transaction management

> Declarative transaction management

## Programmatic transaction management

Programmatic transaction management in Spring can be done using either **TransactionTemplate** or **PlatformTransactionManager**

### Using PlatformTransactionManager

**PlatformTransactionManager** is at the center of discussing Spring's transaction management API. It has the functionalities to commit and rollback

Note: 
- The transaction, when applied to the service layer, facilitates the DAOs to use a single transaction instead of multiple transactions

### TransactionTemplate

The use of thread-safe **TransactionTemplate** helps developers get rid of boilerplate code, as we already discussed with **JdbcTemplate**

## Declarative transaction management

The Spring Framework uses AOP to facilitate declarative transaction management. The best thing about declarative transaction is that it does not necessarily require to be managed by an application server, and it can be applied to any class. The framework also facilitates developers to customize the transactional behavior by using AOP. The declarative transaction can either be XML-based or annotation-based configuration.

