# Adapter Pattern

## Overview

Adapter is a **structural design pattern**. It provides a reusable way to solve a recurring software design problem while keeping the code easier to maintain, extend, and understand.

## Intent

Allow incompatible interfaces to work together by converting the interface of an existing class into the interface expected by the client.

## The Problem

The client expects one interface, while an existing or legacy class exposes a different interface. Changing the existing class may be impossible or undesirable.

## The Solution

The Adapter implements the interface expected by the client and internally delegates to the adaptee, translating calls or data when necessary.

## Structure

The project contains two Adapter examples:

- **DistanceCalculator** — adapts an old miles-based calculator to a kilometer-based interface.
- **Employees** — adapts an employee salary-related API to the interface expected by the application.

These examples show the Adapter as a compatibility layer between two interfaces.

## Implementation in This Project

```text
Client
  |
  v
Target Interface
  |
  v
Adapter
  |
  v
Adaptee / Legacy Class
```

The adapter translates the client's request into the form understood by the existing class.

## Advantages

- Reuses legacy or third-party code.
- Keeps incompatible classes unchanged.
- Isolates conversion logic in one place.

## Disadvantages / Trade-offs

- Adds an additional abstraction.
- Excessive adapters can make a system harder to follow.
- Data conversion can introduce runtime or precision concerns.

## When to Use

Use it when two components are useful together but their interfaces are incompatible.

## Related Patterns

Bridge, Decorator, Facade

## Key Takeaways

The important point is not to use a design pattern simply because it exists. The pattern should be introduced when its structure solves a real design problem and provides a meaningful improvement in flexibility, maintainability, or separation of responsibilities.
