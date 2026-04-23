# Spring Dependency Demo

This project is a beginner-friendly Spring Boot example created to understand **Spring beans, Dependency Injection (DI), bean scopes, bean lifecycle, and multiple bean implementations**.

It is useful for learning how Spring manages objects and injects dependencies automatically instead of creating them manually with `new`.

## What This Project Covers

- Spring Boot project setup using Maven
- Creating beans using `@Component`
- Creating beans using `@Bean` inside a `@Configuration` class
- Bean lifecycle using `@PostConstruct` and `@PreDestroy`
- Bean scope using `@Scope("request")`
- Multiple implementations of an interface
- Injecting all implementations using `Map<String, NotificationService>`

## Tech Stack

- Java 17
- Spring Boot 3.5.13
- Maven
- Spring Boot Starter Web
- Spring Boot Starter Test

## Project Structure

```text
springdependency
├── pom.xml
├── src
│   ├── main
│   │   ├── java/com/hitakshi/springdependency
│   │   │   ├── AppConfig.java
│   │   │   ├── Module1IntroductionApplication.java
│   │   │   ├── NotificationService.java
│   │   │   ├── PaymentService.java
│   │   │   ├── SpringdependencyApplication.java
│   │   │   └── impl
│   │   │       ├── EmailNotificationService.java
│   │   │       └── SmsNotificationService.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java/com/hitakshi/springdependency
│           └── SpringdependencyApplicationTests.java
```

## Important Files Explained

### `NotificationService.java`

This is an interface with one method:

```java
void send(String message);
```

It acts like a contract. Any class implementing this interface must provide logic for sending a message.

### `EmailNotificationService.java`

This class implements `NotificationService` and sends messages through email-style output.

It is marked with:

- `@Component`
- `@Qualifier("emailNotif")`

This tells Spring to register it as a bean.

### `SmsNotificationService.java`

This is another implementation of `NotificationService` for SMS-style output.

It is also marked with:

- `@Component`
- `@Qualifier("smsNotif")`

This allows Spring to manage it as a separate bean.

### `Module1IntroductionApplication.java`

This class demonstrates dependency injection in a practical way.

It uses:

```java
@Autowired
Map<String, NotificationService> notificationServiceMap = new LinkedHashMap<>();
```

Spring injects all beans implementing `NotificationService` into the map.  
Then the `run()` method loops through them and calls `send("Hello")`.

This is a good example of how Spring can inject **multiple implementations** of the same interface.

### `PaymentService.java`

This class demonstrates:

- bean creation using `@Component`
- lifecycle hooks using `@PostConstruct`
- cleanup hooks using `@PreDestroy`

Methods used:

- `afterInitaaaaa()` runs after bean creation
- `beforeDestroyaaa()` runs before bean destruction

### `AppConfig.java`

This class is marked with `@Configuration` and creates a bean manually using `@Bean`.

```java
@Bean
@Scope("request")
public PaymentService paymentService() {
    return new PaymentService();
}
```

This shows Java-based configuration and bean scope configuration.

## Concepts Demonstrated

### 1. Dependency Injection

Dependency Injection means objects get their dependencies from Spring instead of creating them inside the class.

Without Spring:

```java
NotificationService service = new EmailNotificationService();
```

With Spring:

Spring creates the object and injects it automatically.

### 2. Inversion of Control

In a normal Java application, developers control object creation.

In Spring, the container controls object creation and lifecycle.

That is why it is called **Inversion of Control (IoC)**.

### 3. Bean Lifecycle

This project also shows the Spring bean lifecycle:

1. Bean is created
2. Dependencies are injected
3. `@PostConstruct` method runs
4. Bean is used
5. `@PreDestroy` method runs before shutdown

### 4. Bean Scope

`@Scope("request")` means a new bean instance is created for each HTTP request.

This scope is mainly useful in web applications.

## How To Run The Project

Open the project in terminal and use Maven:

```bash
./mvnw spring-boot:run
```

If Maven is installed globally, you can also use:

```bash
mvn spring-boot:run
```

## Common Maven Commands

```bash
./mvnw clean
./mvnw compile
./mvnw test
./mvnw package
./mvnw spring-boot:run
```

## What all concept cover in this Project

this project contains below concepts

- how Spring finds beans
- how interfaces and implementations work with DI
- how multiple beans of the same interface are handled
- how bean lifecycle hooks work
- how configuration classes create beans manually
- how Maven is used in a Spring Boot project

## Summary

This project is a simple practice project for understanding **Spring Dependency Injection**.

The main idea is:

- define an interface
- create multiple implementations
- let Spring create and manage those objects
- inject them where needed

This makes the code:

- easier to change
- easier to test
- easier to maintain



