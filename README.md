# 🚀 Spring Boot Backend Practice

A comprehensive hands-on learning repository exploring core Spring Boot concepts, dependency injection, bean lifecycle management, and REST API development.

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.5-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-red)

## 📚 What's Inside

This repository contains progressive examples demonstrating fundamental Spring Boot concepts through practical, runnable code. Each module builds upon previous knowledge, creating a complete learning path for backend development.

### 🎯 Core Concepts Covered

- **Dependency Injection** - Understanding IoC and autowiring
- **Bean Lifecycle Management** - From creation to destruction
- **REST API Development** - Building RESTful endpoints
- **Service Layer Architecture** - Interface-based design
- **Bean Selection Strategies** - @Qualifier, @Primary, and resolution priority
- **Circular Dependency Handling** - Using @Lazy annotation
- **Annotations Deep Dive** - @Component, @Service, @Controller, @RestController

---

## 🗂️ Project Structure

```
com.isha.spring_boot_learning/
│
├── 📁 basics/                          # REST API & Service Injection
│   ├── controller/
│   │   └── MyController.java          # REST endpoint example
│   └── service/
│       ├── Greetings.java             # Service interface
│       └── MyGreetings.java           # Time-based greeting implementation
│
├── 📁 basics1/                         # Bean Lifecycle
│   ├── controller/
│   │   └── MyAlienController.java
│   └── service/
│       └── Alien.java                 # @PostConstruct & @PreDestroy demo
│
├── 📁 basics2/                         # Dependency Injection Priority
│   ├── controller/
│   │   └── AnimalController.java     # @Qualifier usage
│   └── service/
│       ├── Animal.java                # Parent class
│       ├── Cat.java                   # Child with @Component
│       └── Dog.java                   # Child with @Primary
│
└── 📁 basics3/                         # Circular Dependency Resolution
    └── service/
        ├── A.java                     # Bean A with @Lazy
        └── B.java                     # Bean B
```

---

## 📖 Learning Modules

### Module 1: REST API & Dependency Injection (`basics/`)

**Concepts:**
- `@RestController` vs `@Controller`
- `@Autowired` for dependency injection
- `@Service` annotation for service layer
- `@GetMapping` for HTTP GET endpoints
- Interface-based programming

**Example Endpoint:**
```java
GET http://localhost:8080/greet
Response: "Good Morning Isha" (time-dependent greeting)
```

**Key Learning:**
```java
@RestController
public class MyController {
    @Autowired
    private Greetings greeting;  // Interface injection
    
    @GetMapping("greet")
    public String message() {
        return greeting.message("Isha");
    }
}
```

---

### Module 2: Bean Lifecycle Management (`basics1/`)

**Concepts:**
- Bean creation sequence: Static block → Instance block → Constructor
- `@PostConstruct` - runs after dependency injection
- `@PreDestroy` - runs before bean destruction
- `@Component` annotation

**Execution Order:**
```
1. Static block of Alien!
2. Instance block of Alien!
3. Constructor of Alien
4. PostConstruct call
5. (Application runs...)
6. PreDestroy call (on shutdown)
```

**Key Learning:**
```java
@Component
public class Alien {
    @PostConstruct
    public void init() {
        // Initialization logic after bean creation
    }
    
    @PreDestroy
    public void destroy() {
        // Cleanup before bean destruction
    }
}
```

---

### Module 3: Bean Selection Priority (`basics2/`)

**Concepts:**
- Dependency injection resolution order
- `@Qualifier` for explicit bean selection
- `@Primary` for default bean preference
- Polymorphism with Spring beans

**DI Priority Order:**
1. **Type match** - Spring looks for matching type
2. **@Qualifier** - Explicit bean name specification
3. **@Primary** - Default preference when multiple beans exist
4. **Name match** - Field name matching bean name
5. **ERROR** - If still ambiguous

**Key Learning:**
```java
@Autowired
@Qualifier("cat")  // Explicitly selects Cat bean over Dog
private Animal animal;
```

```java
@Primary  // Dog is selected by default if no @Qualifier specified
@Component("dog")
public class Dog extends Animal { }
```

---

### Module 4: Circular Dependency Resolution (`basics3/`)

**Concepts:**
- Understanding circular dependencies
- `@Lazy` annotation to break dependency cycles
- Field injection vs Constructor injection

**Important Note:**
> Spring supports circular dependency **only for field and setter injection** using early references, but **does NOT support constructor injection** because dependencies must be fully initialized at creation time.

**Key Learning:**
```java
@Component
public class A {
    @Autowired
    @Lazy  // Delays B's creation until actually used
    private B b;
}

@Component
public class B {
    @Autowired
    private A a;  // No @Lazy needed on one side
}
```

---

## 🛠️ Technologies Used

| Technology | Version | Purpose |
|------------|---------|---------|
| Spring Boot | 4.0.5 | Framework foundation |
| Java | 17 | Programming language |
| Maven | - | Build & dependency management |
| Spring Web MVC | 4.0.5 | REST API development |

---

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- IDE (IntelliJ IDEA / Eclipse / VS Code)

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone https://github.com/IshaParihariya/spring-boot-backend-practice.git
   cd spring-boot-backend-practice
   ```

2. **Build the project**
   ```bash
   ./mvnw clean install
   ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Test the endpoint**
   ```bash
   curl http://localhost:8080/greet
   ```

---

## 📝 Key Annotations Reference

| Annotation | Purpose | Example |
|------------|---------|---------|
| `@SpringBootApplication` | Main application entry point | Combines @Configuration + @EnableAutoConfiguration + @ComponentScan |
| `@RestController` | REST API controller | Returns JSON/String data directly |
| `@Controller` | MVC controller | Returns view names (HTML) |
| `@Service` | Service layer component | Business logic layer |
| `@Component` | Generic Spring bean | Any Spring-managed component |
| `@Autowired` | Dependency injection | Injects beans automatically |
| `@Qualifier` | Bean selection | Specifies which bean to inject |
| `@Primary` | Default bean | Marks preferred bean when multiple exist |
| `@Lazy` | Lazy initialization | Delays bean creation until needed |
| `@PostConstruct` | Post-initialization | Runs after bean creation |
| `@PreDestroy` | Pre-destruction | Runs before bean destruction |
| `@GetMapping` | HTTP GET endpoint | Maps GET requests to methods |

---

## 💡 Best Practices Demonstrated

✅ **Separation of Concerns** - Controllers, Services, and Models in separate packages  
✅ **Interface-Based Design** - Programming to interfaces, not implementations  
✅ **Dependency Injection** - Loose coupling through Spring's IoC container  
✅ **RESTful API Design** - Clean endpoint structure  
✅ **Bean Lifecycle Management** - Proper initialization and cleanup  
✅ **Code Documentation** - Inline comments explaining concepts  

---

## 🎓 Learning Outcomes

After exploring this repository, you'll understand:

- How Spring Boot's auto-configuration works
- The complete bean lifecycle in Spring
- Different ways to inject dependencies
- How to resolve bean selection conflicts
- Best practices for REST API development
- How to handle circular dependencies properly
- The difference between various Spring annotations

---

## 📚 Additional Resources

- [Spring Boot Official Documentation](https://docs.spring.io/spring-boot/4.0.5/reference/)
- [Spring Framework Documentation](https://docs.spring.io/spring-framework/reference/)
- [Building REST Services with Spring](https://spring.io/guides/tutorials/rest/)
- [Maven Official Guide](https://maven.apache.org/guides/index.html)

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/IshaParihariya/spring-boot-backend-practice/issues).

---

## 👩‍💻 Author

**Isha Parihariya**
- GitHub: [@IshaParihariya](https://github.com/IshaParihariya)

---

## 🌟 Acknowledgments

- Spring Boot Team for excellent framework and documentation
- The Java community for continuous support and resources

---

<div align="center">

### ⭐ Star this repository if you found it helpful!

**Happy Learning! 🚀**

</div>
