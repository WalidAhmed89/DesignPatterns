# Bridge Pattern

## Overview

Bridge is a **structural design pattern**. It provides a reusable way to solve a recurring software design problem while keeping the code easier to maintain, extend, and understand.

## Intent

Decouple an abstraction from its implementation so the two can vary independently.

## The Problem

A single inheritance hierarchy can become difficult to maintain when two independent dimensions vary. For example, UI components may vary by component type and operating system.

## The Solution

The abstraction holds a reference to an implementation interface. Concrete implementations can change independently from concrete abstractions.

## Structure

The project demonstrates Bridge through the **MultiPlatform** example.

The main abstraction/implementation relationship uses:

- `Button` as the abstraction.
- `ICommonUI` as the implementation interface.
- `Android`, `IOS`, and `Windows` as concrete implementations.
- `Program` as the client.

This allows the UI abstraction to work with different platform implementations.

## Implementation in This Project

```text
             Button (Abstraction)
                    |
                    v
              ICommonUI
             /    |     \
        Android  IOS   Windows
```

The abstraction does not inherit from each platform. Instead, it composes an implementation reference.

## Advantages

- Prevents class-explosion caused by combining multiple dimensions.
- Allows abstraction and implementation to evolve independently.
- Favors composition over inheritance.

## Disadvantages / Trade-offs

- Adds indirection.
- May feel more complex than inheritance for a simple two-dimensional design.

## When to Use

Use it when a system has two independent dimensions that should vary separately.

## Related Patterns

Adapter, Strategy, Abstract Factory

## Key Takeaways

The important point is not to use a design pattern simply because it exists. The pattern should be introduced when its structure solves a real design problem and provides a meaningful improvement in flexibility, maintainability, or separation of responsibilities.
