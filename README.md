# Spring - Spring Boot

## Spring
Spring is a powerful Java framework that simplifies enterprise-level application development by providing infrastructure support. It encourages best practices such as dependency injection (DI) and inversion of control (IoC).

## Spring-Boot
Spring Boot is a Java-based framework used to create stand-alone, production-grade Spring-based applications. It is built on top of the Spring Framework and simplifies the development of new applications by providing ready-to-use configurations and a wide array of features.

## Spring vs. Spring Boot

| Feature               | Spring                               | Spring Boot                          |
|-----------------------|--------------------------------------|--------------------------------------|
| **Configuration**      | Requires manual configuration (XML or Java). | Offers auto-configuration.          |
| **Startup**            | Slower due to extensive setup.       | Faster due to embedded servers.     |
| **Dependency Management** | Requires explicit dependency declarations. | Provides pre-configured dependencies via spring-boot-starter. |
| **Deployment**         | Requires external server deployment. | Can embed servers like Tomcat, enabling standalone execution. |
| **Ease of Use**        | More complex for beginners.         | Simpler with built-in defaults.     |

---

## Spring vs. Spring Boot in Use Cases

| Feature              | Spring                                      | Spring Boot                                |
|----------------------|---------------------------------------------|-------------------------------------------|
| **Complex Applications** | Large, highly customized enterprise apps. | Simple or moderately complex applications. |
| **Microservices**     | Possible, but involves more configuration.  | Designed for microservices.               |
| **Rapid Development** | Requires manual configurations.            | Faster due to auto-configuration.         |
| **API Development**   | Suitable but verbose.                      | Simplifies API creation with REST support. |
| **Legacy Systems**    | Integrates well with existing setups.       | Better for greenfield projects.           |

 ## Why Use Spring Framework?

Spring is a framework that helps you build Java applications, especially for big, complex systems. Here’s why beginners might use it:

- **Easy to Organize Code**: Spring helps you organize your code into separate, manageable parts. This makes your code easier to read and maintain.
- **Automatic Management of Dependencies**: Spring automatically handles the relationships between different parts of your code, saving you time.
- **Works with Databases**: Spring helps you easily connect to and manage databases, making it great for apps that need to store data.
- **Security Features**: It has built-in tools to handle user logins, passwords, and permissions (making your app more secure).
- **Easy Testing**: Spring makes it easy to test different parts of your application to make sure everything works.

## Why Use Spring Boot?

Spring Boot is a tool that makes using Spring even easier. It takes care of many things automatically, so you don’t have to worry about a lot of complicated setup. Here’s why beginners should consider Spring Boot:

- **Minimal Setup**: Spring Boot sets up the basics for you. You don’t need to write complex configurations to get started.
- **No Need for an External Server**: Spring Boot comes with its own built-in server, so you don’t have to install or configure one separately.
- **Ready-to-Use Features**: It provides ready-made features like health checks, logging, and more, so you can focus on building your app.
- **Quick Start**: With tools like Spring Initializr, you can generate a project in seconds with the libraries and settings you need.
- **Production-Ready**: Spring Boot makes it easy to deploy your app and monitor it once it's live.

  ## Simple Comparison:

- **Spring**: Great for complex applications and if you want full control over your project’s setup.
- **Spring Boot**: Perfect if you want to get started quickly with minimal configuration and focus on building your app.


## Application Architecture

Spring applications are typically divided into three layers:

- **Controller**: Handles HTTP requests and responses.
- **Service**: Contains business logic.
- **Repository**: Manages database operations.

## Core Concepts

### Inversion of Control (IoC)

IoC is a principle that allows an external container to manage object lifecycles and dependencies.

### Dependency Injection (DI)

DI is the implementation of IoC, where the framework injects required objects (dependencies) into classes, eliminating the need for manual object creation.

#### Types of Dependency Injection:

- **Field Injection**:

    ```java
    @Autowired  
    private Laptop laptop;
    ```

- **Constructor Injection**:

    ```java
    public Dev(@Autowired Laptop laptop) {  
        this.laptop = laptop;  
    }
    ```

- **Setter Injection**:

    ```java
    @Autowired  
    public void setLaptop(Laptop laptop) {  
        this.laptop = laptop;  
    }
    ```

## Spring Annotations

| Annotation          | Purpose                                                                 |
|---------------------|-------------------------------------------------------------------------|
| **@Component**       | Marks a class as a Spring-managed component.                            |
| **@Autowired**       | Injects dependencies automatically.                                    |
| **@Primary**         | Specifies the preferred bean when multiple candidates are available.    |
| **@Qualifier**       | Used to select a specific bean when multiple beans qualify.            |
| **@RestController**  | Combines @Controller and @ResponseBody for REST APIs.                   |
| **@RequestMapping**  | Maps HTTP requests to controller methods.                               |

# Running a Spring Application

## With Spring Boot

```java
ApplicationContext context = SpringApplication.run(MyAppApplication.class, args);  
Dev dev = context.getBean(Dev.class);  
dev.build();
```

## Without Spring Boot (XML Configuration)

### Define a bean in `spring.xml`:

```xml
<beans>  
    <bean id="dev" class="com.spring.Dev"/>  
</beans>
```

### Load the context and use the bean:

```java
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");  
Dev dev = (Dev) context.getBean("dev");  
dev.build();
```

# Spring Web

## Overview of Spring Web

In a web application, communication between the client and server is done using the HTTP protocol. Spring Web allows us to create REST APIs and interact with client-side requests.

## MVC Architecture

Model-View-Controller (MVC) separates concerns:

- **Model**: Represents data and business logic.
- **View**: Displays data to the user.
- **Controller**: Handles user input and updates the model/view.

## HTTP Methods

- **GET**: Retrieve data.
- **POST**: Create data.
- **PUT**: Update data.
- **DELETE**: Remove data.

### Example
### ProductController Example

```java
@RestController
@RequestMapping("/products")
public class ProductController {

    // GET: Fetch product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    // POST: Add a new product
    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    // PUT: Update an existing product
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    // DELETE: Remove a product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
```

## Key Annotations in Spring Web

### 1. `@RestController`

**Purpose**: This annotation is used to define a class as a REST controller that will handle HTTP requests.

**Example**:

```java
@RestController
public class ProductController {
    // Methods to handle requests
}
```

### 2. `@RequestMapping`

**Purpose**: Used to assign HTTP request paths (URLs) to methods in a controller.

**Example**:

```java
@RequestMapping("/products")
public List<Product> getAllProducts() {
    return productService.getAllProducts();
}
```

### 3. `@PathVariable`

**Purpose**: Extracts values from the URL and passes them as method parameters.

**Example**:

```java
@RequestMapping("/products/{prodId}")
public Product getProductById(@PathVariable int prodId) {
    return productService.getProductById(prodId);
}
```

### 4. `@RequestBody`

**Purpose**: Used to bind the incoming HTTP request body to a method parameter.

**Example**:

```java
@PostMapping("/products")
public void addProduct(@RequestBody Product product) {
    productService.addProduct(product);
}
```

### 5. `@CrossOrigin`

**Purpose**: Allows cross-origin requests, enabling a client from a different domain to interact with your API.

**Example**:

```java
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    // Methods to handle requests
}
```

# Understanding Multipart (Handling Multimedia)

In web applications, multimedia files like images or documents are typically uploaded or downloaded using multipart requests. Spring provides built-in support for handling multipart data.

## Uploading Files with Multipart

- `@RequestParam` is used to handle file uploads.
- The uploaded file is usually handled as a `MultipartFile`.

### Example:

```java
@PostMapping("/upload")
public String uploadFile(@RequestParam("file") MultipartFile file) {
    // Handle file upload logic here
    return "File uploaded successfully: " + file.getOriginalFilename();
}
```

# JPA and Hibernate

## What is JPA?

JPA (Java Persistence API) is a standard for ORM (Object-Relational Mapping) in Java. Hibernate is one of its implementations.

## Hibernate

Hibernate is a Java framework used for Object-Relational Mapping (ORM). It helps developers interact with a database using Java objects rather than writing SQL queries. Hibernate handles the conversion between Java objects (like classes) and database tables, making it easier to work with databases.

## Core Concepts

- **@Entity**: Maps a Java class to a database table.
- **JpaRepository**: Provides built-in methods for CRUD operations.


## Advantages of JPA

- Reduces boilerplate SQL code.
- Simplifies database interactions.

## Advantages of Spring Framework

- **Lightweight**: Modular architecture ensures efficient resource usage.
- **Flexible**: Supports various configuration styles (XML, annotations, Java-based).
- **IoC Container**: Simplifies dependency management.
- **AOP Support**: Aspect-Oriented Programming enables clean separation of concerns.
- **Integration**: Works seamlessly with other frameworks like Hibernate, JPA, etc.

## Disadvantages of Spring Framework

- **Learning Curve**: Complex for beginners.
- **Verbose Configuration**: Without Spring Boot, setup can be tedious.
- **Performance**: Initial startup time may be high due to configuration loading.

 
