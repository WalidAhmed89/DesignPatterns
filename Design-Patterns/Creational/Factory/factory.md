# Factory Pattern Pattern

## Overview

Factory Pattern is a **creational design pattern**. It provides a reusable way to solve a recurring software design problem while keeping the code easier to maintain, extend, and understand.

## Intent

Centralize or delegate object creation so client code does not need to instantiate concrete product classes directly.

## The Problem

Client code becomes tightly coupled when it contains many `new` operations for concrete implementations. Adding another implementation can require modifying the client.

## The Solution

The client asks a factory for an object through an abstraction. The factory decides which concrete implementation should be created.

## Structure

The project contains three Factory examples:

- **Banking** — selects the appropriate bank implementation.
- **Delivery** — creates delivery services such as bike, car, or drone delivery.
- **Notification** — creates notification implementations such as email, SMS, or push notification services.

The examples show how creation logic can be moved away from the client.

## Implementation in This Project

```text
Client
  |
  v
Factory
  |
  +--> Concrete Product A
  +--> Concrete Product B
  +--> Concrete Product C
```

The returned object is consumed through an abstraction such as an interface.

## Advantages

- Reduces coupling to concrete classes.
- Centralizes creation logic.
- Makes adding implementations easier.
- Keeps client code focused on behavior rather than construction.

## Disadvantages / Trade-offs

- Factories can become large if many creation rules are added.
- The abstraction can be unnecessary for very simple object creation.

## When to Use

Use it when the concrete type is selected dynamically or when object-creation logic should be centralized.

## Related Patterns

Abstract Factory, Builder, Prototype

## Key Takeaways

The important point is not to use a design pattern simply because it exists. The pattern should be introduced when its structure solves a real design problem and provides a meaningful improvement in flexibility, maintainability, or separation of responsibilities.
