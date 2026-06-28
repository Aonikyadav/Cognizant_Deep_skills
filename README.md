# DN 5.0 – Java FSE Hands-on Assignments

This repository contains my hands-on practice work for the **Cognizant Digital Nurture 5.0** Java Full Stack Engineer (FSE) program.

---

## 📁 Repository Structure

```
DN5.0-JAVA-FSE-Handson/
├── WEEK1/
│   └── DesignPattern/
│       ├── SingletonPatternExample/
│       ├── FactoryMethodPatternExample/
│       ├── BuilderPatternExample/
│       ├── AdapterPatternExample/
│       ├── ProxyPatternExample/
│       ├── DecoratorPatternExample/
│       ├── ObserverPatternExample/
│       ├── StrategyPatternExample/
│       ├── CommandPatternExample/
│       └── MVCPatternExample/
└── WEEK2/
    └── Junit5/
```

---

## 📌 Week 1 – Design Patterns

### Creational Design Patterns

#### Exercise 1 – Singleton Pattern ✅
Implemented the **Singleton** design pattern using the `Logger` class. Only one instance of the Logger is created throughout the program. Both references `l1` and `l2` point to the same object, which confirms the Singleton behavior.

#### Exercise 2 – Factory Method Pattern ✅
Used the **Factory Method** pattern to create different types of documents (`Word`, `PDF`, `Excel`) without specifying exact classes. A factory class creates the object and the client uses it via the `Document` interface.

#### Exercise 3 – Builder Pattern ✅
Used the **Builder** pattern to construct `Computer` objects step by step. This avoids long constructors and makes it easy to create different configurations like gaming PC, office PC, etc.

---

### Structural Design Patterns

#### Exercise 4 – Adapter Pattern ✅
Implemented the **Adapter** pattern for a payment processing system. Different payment gateways (PayPal, Stripe, Razorpay) have different method names, and adapters are used to make them work through a common `PaymentProcessor` interface.

#### Exercise 5 – Proxy Pattern ✅
Used the **Proxy** pattern for lazy loading of images. The `ProxyImage` class loads the actual `RealImage` only when the `display()` method is called for the first time. On second call, it uses a cached version.

#### Exercise 6 – Decorator Pattern ✅
Applied the **Decorator** pattern to add extra notification channels (SMS, Slack) on top of a base `EmailNotifier`. Multiple decorators can be stacked together for combined functionality.

---

### Behavioural Design Patterns

#### Exercise 7 – Observer Pattern ✅
Implemented the **Observer** pattern for a stock market application. When the stock price is updated, all registered observers (MobileApp, WebApp) get notified automatically.

#### Exercise 8 – Strategy Pattern ✅
Used the **Strategy** pattern to switch between different payment methods (Credit Card, PayPal) at runtime. The `PaymentContext` class delegates payment to whichever strategy is set.

#### Exercise 9 – Command Pattern ✅
Implemented the **Command** pattern using a smart home scenario. A `RemoteControl` (invoker) executes commands (`LightOnCommand`, `LightOffCommand`) on a `Light` (receiver) without knowing the details.

#### Exercise 10 – MVC Pattern ✅
Demonstrated the **MVC** pattern with a Student management example. The `Student` class is the Model, `StudentView` is the View, and `StudentController` handles the logic and updates.

---

## 📌 Week 2 – JUnit 5 Testing

All test files are located in `WEEK2/Junit5/`. A simple `calculator` class with `add()` and `substract()` methods is tested using various JUnit 5 features.

| File | Description |
|---|---|
| `CalculatorTest.java` | Basic unit tests for add and subtract methods |
| `CalculatorFixtureTest.java` | Tests using `@BeforeEach` and `@AfterEach` with AAA pattern |
| `AssertionsTest.java` | Demonstrates different JUnit 5 assertion types |

---

## 🛠 Technologies Used

- Java (JDK 17+)
- JUnit 5
- IntelliJ IDEA

---

## 📝 Notes

- All design pattern exercises are in `WEEK1/DesignPattern/`
- Each pattern has its own folder with source files and a screenshot of the output
- Week 2 covers unit testing basics with JUnit 5