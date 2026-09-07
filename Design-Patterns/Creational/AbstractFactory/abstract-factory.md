# Abstract Factory Pattern

## Overview

Abstract Factory is a **creational design pattern**. It provides a reusable way to solve a recurring software design problem while keeping the code easier to maintain, extend, and understand.

## Intent

Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

## The Problem

The client may need several related products. Creating each concrete product directly can couple the client to a specific product family and can make it easy to accidentally mix incompatible products.

## The Solution

The client works with abstract product interfaces and an abstract factory. A concrete factory creates a consistent family of concrete products. Switching the concrete factory changes the product family without changing the client logic.

## Structure

The project demonstrates Abstract Factory through three independent examples:

- **Bank** — creates related bank/card objects through bank-specific factories.
- **DatabaseSystem** — creates a related database connection/query family for MySQL or PostgreSQL.
- **UiComponents** — creates platform-specific UI components such as buttons and check boxes.

The common idea is that a factory creates multiple related products rather than one unrelated object.

## Implementation in This Project

```text
Client
  |
  v
IFactory / IGUIFactory / Database Factory
  |
  +--> Abstract Product Interfaces
  |       |
  |       +--> Concrete Products
  |
  +--> Concrete Factory
          |
          +--> Product A
          +--> Product B
```

The exact interface names differ by example, but the role relationship remains the same.

## Advantages

- Keeps client code dependent on abstractions.
- Makes switching product families easier.
- Helps prevent incompatible product combinations.
- Encapsulates concrete object creation.

## Disadvantages / Trade-offs

- Adds more interfaces and classes.
- Adding a completely new product type may require changes across all concrete factories.
- Can be excessive for a very small system.

## When to Use

Use it when the application has multiple **families of related objects** and the client should remain independent from the concrete family.

## Related Patterns

Factory Method, Builder, Dependency Injection

## Key Takeaways

The important point is not to use a design pattern simply because it exists. The pattern should be introduced when its structure solves a real design problem and provides a meaningful improvement in flexibility, maintainability, or separation of responsibilities.
