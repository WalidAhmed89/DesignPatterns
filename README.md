# Design Patterns in Java

A practical Java repository focused on **understanding, implementing, and documenting the Gang of Four (GoF) Design Patterns**.

This project is part of my journey to strengthen my understanding of **Object-Oriented Design, SOLID principles, software architecture, and reusable design solutions** through practical implementation.

The goal is not to simply memorize design patterns or collect implementations.

The goal is to understand:

> **What problem does a pattern solve, why does it exist, how does it work, and when should it actually be used?**

---

## 🎯 Purpose

Design Patterns can be difficult to understand when studied only from definitions and UML diagrams.

This repository was created as a hands-on learning environment where each pattern is studied and implemented through practical Java examples.

For each pattern, I focus on understanding:

- What problem does the pattern solve?
- Why does this problem exist?
- What is the main idea behind the pattern?
- What are the roles and responsibilities of each class?
- How do the objects communicate?
- How does the pattern reduce coupling or improve flexibility?
- When should the pattern be used?
- When should it **not** be used?
- What are its advantages and disadvantages?
- What are the important design trade-offs?

The implementations are intentionally kept understandable so that the focus remains on the **design idea**, rather than unnecessary application complexity.

---

## 📚 What This Repository Is

This repository is primarily a **learning and practice project**.

It contains:

- Java implementations of GoF Design Patterns
- Practical examples based on real-world scenarios
- Multiple examples for some patterns
- Pattern-specific documentation
- Small experiments to understand different implementations
- Notes about design decisions and trade-offs
- A progression from understanding the concept to implementing it

The project will continue to evolve as I study and implement more patterns.

---

## 🧠 Learning Approach

Instead of treating Design Patterns as something to memorize, I am approaching them as **solutions to recurring software design problems**.

My learning process for a pattern is generally:

```text
Understand the Problem
        ↓
Understand the Pattern Intent
        ↓
Identify the Pattern Roles
        ↓
Design the Class Relationships
        ↓
Implement in Java
        ↓
Test the Behavior
        ↓
Review the Design
        ↓
Document What I Learned
```

This helps me focus on recognizing **when a pattern is useful**, rather than only remembering its structure.

---

## 🔍 What You Will Find in Each Pattern

Whenever possible, each implemented pattern includes an example that demonstrates:

### 1. The Problem

What design problem are we trying to solve?

### 2. The Pattern

What is the core idea of the Design Pattern?

### 3. The Structure

What are the important classes, interfaces, and relationships?

### 4. The Implementation

A practical Java implementation of the pattern.

### 5. The Flow

How does the request or object move through the pattern?

### 6. When to Use It

Situations where the pattern can be useful.

### 7. Trade-offs

The advantages, disadvantages, and possible complexity introduced by the pattern.

---

## 🏗️ Design Pattern Categories

The Gang of Four patterns are divided into three major categories.

### 1. Creational Patterns

Creational patterns focus on **how objects are created**.

They help separate object creation from the code that uses those objects and can make object creation more flexible.

#### Implemented

- [x] Singleton
- [x] Prototype
- [x] Builder
- [x] Factory Method
- [x] Abstract Factory

#### Key Concepts

```text
Singleton
→ ONE

Prototype
→ COPY

Builder
→ STEP-BY-STEP CONSTRUCTION

Factory Method
→ LET SUBCLASSES DECIDE WHAT TO CREATE

Abstract Factory
→ CREATE RELATED PRODUCT FAMILIES
```

---

### 2. Structural Patterns

Structural patterns focus on **how classes and objects are composed**.

They help organize relationships between objects and make larger structures easier to work with.

#### Implemented

- [x] Adapter
- [x] Bridge
- [x] Composite
- [x] Decorator
- [x] Facade
- [x] Flyweight
- [x] Proxy

#### Key Concepts

```text
Adapter
→ TRANSLATE INCOMPATIBLE INTERFACES

Bridge
→ SEPARATE ABSTRACTION FROM IMPLEMENTATION

Composite
→ TREAT INDIVIDUAL OBJECTS AND COMPOSITIONS UNIFORMLY

Decorator
→ ADD BEHAVIOR DYNAMICALLY

Facade
→ PROVIDE A SIMPLE INTERFACE TO A COMPLEX SUBSYSTEM

Flyweight
→ SHARE COMMON OBJECT STATE

Proxy
→ CONTROL ACCESS TO ANOTHER OBJECT
```

---

### 3. Behavioral Patterns

Behavioral patterns focus on **communication, responsibilities, and interactions between objects**.

They help define how objects cooperate while keeping responsibilities organized.

#### Progress

- [x] Chain of Responsibility
- [x] Command
- [x] Interpreter
- [x] Iterator
- [x] Mediator
- [x] Memento
- [x] Observer
- [x] State
- [x] Strategy
- [x] Template Method
- [x] Visitor

#### Key Concepts

```text
Chain of Responsibility
→ PASS A REQUEST THROUGH A CHAIN OF HANDLERS

Command
→ ENCAPSULATE A REQUEST AS AN OBJECT

Interpreter
→ DEFINE AND EVALUATE A LANGUAGE OR GRAMMAR

Iterator
→ TRAVERSE A COLLECTION WITHOUT EXPOSING ITS INTERNAL STRUCTURE

Mediator
→ CENTRALIZE COMMUNICATION BETWEEN OBJECTS

Memento
→ CAPTURE AND RESTORE AN OBJECT'S STATE

Observer
→ ONE-TO-MANY NOTIFICATION

State
→ CHANGE BEHAVIOR WHEN INTERNAL STATE CHANGES

Strategy
→ ENCAPSULATE INTERCHANGEABLE ALGORITHMS

Template Method
→ DEFINE AN ALGORITHM SKELETON AND LET SUBCLASSES CUSTOMIZE STEPS

Visitor
→ ADD OPERATIONS TO OBJECT STRUCTURES WITHOUT CHANGING THEIR CLASSES
```

---

# 🧪 Practical Examples

The examples in this repository are intentionally based on scenarios that make the pattern easier to understand.

Some examples include:

### Singleton

A shared object that must have only one instance.

### Builder

Constructing complex objects step-by-step.

### Factory Method

Creating different implementations through specialized creators.

### Abstract Factory

Creating families of related objects.

### Adapter

Making an existing class work with a different interface.

### Composite

Representing hierarchical structures such as a file system.

```text
Root
├── resume.pdf
├── notes.txt
└── Projects
    ├── project1.java
    └── project2.java
```

### Decorator

Adding responsibilities to an object dynamically through wrapping.

### Proxy

Controlling access to a service through an intermediary object.

### Chain of Responsibility

Passing a request through multiple handlers.

### Observer

Notifying multiple objects when a subject changes.

Examples include:

```text
Product Inventory
        ↓
   notifyObservers()
        ↓
 ┌──────┼────────┐
 ↓      ↓        ↓
Cart  ProductList Checkout
```

and:

```text
Order
  ↓
notifyObservers()
  ↓
├── CustomerNotification
├── InventorySystem
└── DeliverySystem
```

These examples are designed to demonstrate the **reasoning behind the pattern**, not to simulate complete production systems.

---

# 📁 Project Structure

```text
Design-Patterns/
│
├── Creational/
│   ├── Singleton/
│   ├── Prototype/
│   ├── Builder/
│   ├── FactoryMethod/
│   └── AbstractFactory/
│
├── Structural/
│   ├── Adapter/
│   ├── Bridge/
│   ├── Composite/
│   ├── Decorator/
│   ├── Facade/
│   ├── Flyweight/
│   └── Proxy/
│
└── Behavioral/
    ├── ChainOfResponsibility/
    ├── Command/
    ├── Interpreter/
    ├── Iterator/
    ├── Mediator/
    ├── Memento/
    ├── Observer/
    ├── State/
    ├── Strategy/
    ├── TemplateMethod/
    └── Visitor/
```

Each pattern can contain its own examples and documentation.

---

# 📈 Progress

| Category | Completed | Total |
|---|---:|---:|
| Creational | 5 | 5 |
| Structural | 7 | 7 |
| Behavioral | 11 | 11 |
| **Overall** | **23** | **23** |

> Progress reflects the patterns currently implemented in the repository and will change as the project develops.

---

# 🛠️ Technologies

- **Java**
- **Object-Oriented Programming (OOP)**
- **SOLID Principles**
- **Gang of Four Design Patterns**
- **Git & GitHub**

---

# 🎓 Learning Goals

Through this project, I am working toward being able to:

- Recognize common software design problems
- Understand why a particular pattern exists
- Identify when a pattern is appropriate
- Design class relationships before writing code
- Apply OOP principles in practical scenarios
- Reduce unnecessary coupling
- Improve separation of responsibilities
- Understand composition vs inheritance
- Compare different design approaches
- Explain design decisions rather than simply implementing them

The long-term goal is to develop the ability to look at a software design problem and think:

> **"What is changing here, what should remain stable, and how can I structure the code to handle that change cleanly?"**

---

# ⚠️ About This Repository

This is a **learning and practice repository**.

The examples are intentionally small and focused on demonstrating specific design concepts.

They are **not intended to represent complete production-ready applications**.

Some implementations may intentionally favor simplicity and readability over production-level concerns such as:

- Dependency Injection frameworks
- Persistence
- Distributed systems
- Error handling at production scale
- Concurrency concerns
- Performance optimization
- Security
- Infrastructure

The purpose is to isolate and understand the **design problem and the pattern used to solve it**.

As my understanding improves, implementations and documentation may be refactored to reflect better design decisions.

---

# 🔄 Continuous Learning

This repository is a work in progress.

The plan is to continue implementing the remaining patterns while improving existing implementations and documentation.

The goal is not simply to reach:

```text
23 / 23
```

The more important goal is to be able to explain:

```text
Problem
   ↓
Why does it exist?
   ↓
Why this pattern?
   ↓
How does the pattern solve it?
   ↓
What are the trade-offs?
   ↓
Would I actually use it here?
```

---

# 💡 Important Principle

Design Patterns are **tools, not rules**.

A pattern should not be introduced simply because it exists.

The important question is:

> **"What problem am I solving, and does this pattern make the design better?"**

Using a Design Pattern where it is unnecessary can introduce additional abstraction and complexity.

This project therefore focuses not only on **how to implement patterns**, but also on understanding **when they are appropriate and when they are not**.

---

# 📖 For Anyone Studying Design Patterns

This repository can also be used as a small practical reference for anyone learning GoF Design Patterns in Java.

A suggested learning approach is:

```text
1. Read the problem
        ↓
2. Understand the pattern's intent
        ↓
3. Identify the roles
        ↓
4. Look at the class relationships
        ↓
5. Read the Java implementation
        ↓
6. Follow the execution flow
        ↓
7. Try implementing it yourself
        ↓
8. Compare your solution
```

The examples are kept relatively small so they can be studied without having to understand an entire large application first.

---

# 👤 Author

**Walid Ahmed**

Java Backend Developer in Progress

This repository represents part of my ongoing journey in learning **Java, Object-Oriented Design, SOLID principles, Design Patterns, and Backend Development**.
