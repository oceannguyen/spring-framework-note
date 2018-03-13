## Core and cross-cutting concerns

Logging, transaction management, and security mechanism are some of the cross-cutting concerns that developers use in the application

## Aspect-oriented programming

Similar to object-oriented programming, aspect-oriented programming (AOP) is also a style of programming, which allows developers to write cohesive code by separating the cross-cutting concerns from the business logic code.

The AOP to handle cross-cutting concerns is written in one place, which helps in achieving
the following benefits:

- Reduction in the duplication of the code to achieve writing of clean code
- Helps in writing loosely coupled modules
- Helps in achieving highly cohesive modules
- The developer can concentrate on writing the business logic
- Easy to change or modify the code for new functionalities without touching the existing code

### Joint point

The join points are **the points in the application where an aspect can be plugged in for some miscellaneous functionality** without being a part of the actual business logic. Spring supports only methods as join points.

### Pointcut

A pointcut is where the developers decide to apply the aspect to perform a specific action for the cross-cutting concern

### Advice

**The action taken by the aspect at pointcut is called advice**. Advice has the code that gets executed for the respective cross-cutting concern. If we consider the method as the join point, the aspect can be applied before or after the method gets executed

- **Before** Applied before the business logic method
- **After** Applied after the business logic method, irrespective of whether the method is executed successfully, or an exception is thrown
- **After returning** Applied after the successful execution of the business logic method takes place
- **After throwing** Applied after the execution of the business logic method that has thrown an exception4
- **Around** Applied on a method both before and after the execution of the business logic method

### Aspect

Aspect defines the opportunities by the pointcut expressions and the advices to specify when and where the action will be taken

#### Introduction

Introduction helps in the declaration of additional methods and fields in the existing class without changing the existing code. Spring AOP allows developers to introduce a new interface to any class that has been advised by the aspect.

#### Target object

Target objects are the objects of classes on which the aspects are applied.

#### AOP proxy

By default, the Spring AOP uses JDK's dynamic proxy to get the proxy of the target classes.

#### Weaving

We, as developers, write business logic and the aspect code in two separate modules. Then, these two have to be combined as a proxied target class. The process of plugging the aspect in the business logic code is known as weaving.

### Spring AOP

Spring AOP is a Java-compatible and easy-to-use framework, which is used to integrate AOP in the Spring Framework.

Spring supports AspectJ and Spring AOP integration to use cross-cutting concerns with less coding. Both Spring AOP and AspectJ are used for implementation of cross-cutting technology

#### XML-based aspect configuration

The following are the steps that need to be followed to develop an XML-based aspect:

> Select the cross-cutting concern to be implemented.
> Write the aspect to fulfill the requirement of the cross-cutting concern.
> Register the aspect as a bean in the Spring context.
> Write the aspect configuration as follows:

    > Add an AOP namespace in XML
    > Add aspect configuration that has pointcut expressions and advices
    > Register the bean on which the aspect can be applied

From the available join points, the developers need to decide which to track, and then need to write pointcuts using expressions to target them. To write such pointcuts, the Spring framework uses AspectJ's pointcut expression language. We can write pointcuts with the help of the following designators in the expression:


