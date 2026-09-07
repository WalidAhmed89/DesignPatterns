# Decorator Pattern

## Overview

Decorator is a **structural design pattern**. It provides a reusable way to solve a recurring software design problem while keeping the code easier to maintain, extend, and understand.

## Intent

Attach additional responsibilities to an object dynamically without changing the object's original class.

## The Problem

Subclassing can produce many classes when different combinations of optional behaviors are required.

## The Solution

The decorator implements the same interface as the wrapped object and contains a reference to it. It can add behavior before or after delegating to the wrapped object.

## Structure

The project contains two Decorator examples:

- **FileServiceDecorator** — includes a base decorator and decorators such as logging and deletion-dialog behavior.
- **SMSServiceDecorator** — adds notification-related behavior around an SMS service.

The examples demonstrate stacking behavior around an existing service without modifying the service's original implementation.

## Implementation in This Project

```text
Client
  |
  v
Decorator Interface
  |
  +--> Concrete Decorator
          |
          v
      Wrapped Service
```

Multiple decorators can be composed when the interface remains compatible.

## Advantages

- Adds behavior dynamically.
- Avoids subclass explosion.
- Follows composition over inheritance.
- Behaviors can be combined in different orders.

## Disadvantages / Trade-offs

- Many small decorator objects can make debugging harder.
- The order of decorators can affect behavior.
- Clients must understand the wrapping structure when it becomes complex.

## When to Use

Use it when optional responsibilities should be added without modifying the original class and different combinations are useful.

## Related Patterns

Proxy, Adapter, Composite

## Key Takeaways

The important point is not to use a design pattern simply because it exists. The pattern should be introduced when its structure solves a real design problem and provides a meaningful improvement in flexibility, maintainability, or separation of responsibilities.
