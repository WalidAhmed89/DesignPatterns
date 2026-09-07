# Singleton Pattern

## Overview

Singleton is a **creational design pattern**. It provides a reusable way to solve a recurring software design problem while keeping the code easier to maintain, extend, and understand.

## Intent

Ensure that a class has one controlled instance and provide a common access point to that instance.

## The Problem

Some resources or coordinators should not have multiple independent instances. Creating several instances can cause inconsistent state or duplicated resources.

## The Solution

The class controls its own instantiation and exposes a shared access point. The constructor is restricted so external code cannot freely create new instances.

## Structure

The project contains three Singleton examples:

- **Connection** — demonstrates a shared database connection object.
- **Counter** — demonstrates shared counter state.
- **Login** — contrasts a first version with a Singleton-based login counter implementation.

The Login example is particularly useful because it demonstrates the motivation for Singleton by comparing ordinary object creation with shared state.

## Implementation in This Project

```text
Client 1 ----Client 2 -----+----> Singleton Instance
Client 3 ----/
```

All clients access the same controlled instance rather than constructing independent instances.

## Advantages

- Guarantees controlled instance creation.
- Provides a single shared access point.
- Can be useful for truly application-wide resources.

## Disadvantages / Trade-offs

- Introduces global/shared state.
- Can make testing harder.
- Can hide dependencies.
- Often becomes overused when dependency injection would be clearer.

## When to Use

Use it only when a single shared instance is genuinely required by the design, not simply because sharing an object is convenient.

## Related Patterns

Factory, Dependency Injection, Monostate

## Key Takeaways

The important point is not to use a design pattern simply because it exists. The pattern should be introduced when its structure solves a real design problem and provides a meaningful improvement in flexibility, maintainability, or separation of responsibilities.
