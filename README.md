# Extensible Calculator Application

This project is an implementation of a simple and extensible calculator in Java using the Spring Framework. The calculator supports multiple operations and adheres to object-oriented principles, particularly the Open-Closed Principle. The application is designed to be maintainable, extensible, and compatible with an Inversion of Control (IoC) environment.

## Features

- Supports basic operations: Addition, Subtraction, Multiplication, and Division.
- Allows chaining multiple operations on a single value.
- Easily extensible to add new operations without modifying the existing calculator code.
- Handles errors gracefully for unsupported operations and division by zero.
- Uses Spring's Dependency Injection to manage components and promote loose coupling.

## Assumptions

1. **Basic Operations Only:**
   - The calculator currently supports four basic operations: Addition (`ADD`), Subtraction (`SUBTRACT`), Multiplication (`MULTIPLY`), and Division (`DIVIDE`).
   - The `Operation` enum is used to define these operations. New operations can be added by extending the `CalculatorOperation` interface and adding new components.

2. **Number Handling:**
   - All operations are designed to work with the `Number` type. Internally, the operations are cast to `double` for arithmetic purposes. This allows for flexibility in supporting different numeric types (e.g., `Integer`, `Double`).

3. **Error Handling:**
   - The application throws custom exceptions (`UnsupportedOperationException` and `DivisionByZeroException`) for unsupported operations and division by zero, respectively.
   - Graceful error messages are provided for better user experience and debugging.

4. **Spring Framework Usage:**
   - The project uses core Spring Framework modules for dependency injection and bean management.
   - Manual context initialization is done using `AnnotationConfigApplicationContext`.

5. **Chained Operations:**
   - The chaining functionality allows users to start with an initial value and apply multiple operations sequentially. This mimics the behavior of a basic calculator.

## Design Decisions

1. **Use of Interfaces for Extensibility:**
   - The `CalculatorOperation` interface is created to define the contract for different operations. This allows for easy addition of new operations without modifying the core `Calculator` class, adhering to the Open-Closed Principle.

2. **Spring's `@Component` and `@Autowired` Annotations:**
   - Operations (`AddOperation`, `SubtractOperation`, `MultiplyOperation`, `DivideOperation`) are annotated with `@Component` to make them Spring-managed beans.
   - The `Calculator` class uses `@Autowired` for constructor-based dependency injection, making it easier to manage and test dependencies.

3. **Java-based Configuration:**
   - The application uses Java-based configuration (`CalculatorConfig`) with `@Configuration` and `@ComponentScan` to set up the Spring context. This approach offers flexibility and avoids XML-based configuration.

4. **Exception Handling:**
   - Specific exceptions (`UnsupportedOperationException`, `DivisionByZeroException`) are used to handle errors clearly and concisely. This improves readability and makes it easier to manage different error scenarios.

5. **Manual Context Initialization:**
   - The `AnnotationConfigApplicationContext` is used to initialize the Spring context manually. This provides more control over the application's lifecycle.

## Setup and Usage

### Prerequisites

- Java 8 or higher
- Spring Framework (Core Modules)
- JUnit 5 (for running unit tests)

## Extending the Application

1. **Adding New Operations:**
   - To add a new operation, create a new class that implements the `CalculatorOperation` interface.
   - Annotate the new operation class with `@Component`.
   - The Spring context will automatically detect the new operation and inject it into the `Calculator`.

2. **Modifying Error Handling:**
   - To customize error handling, modify the `Calculator` class or create a new exception type as needed.

## Known Limitations

- The calculator currently does not support advanced mathematical functions (e.g., trigonometry, exponentiation).
- Operations are limited to arithmetic on `Number` types, and may need further extension to support complex numbers or custom numeric types.
