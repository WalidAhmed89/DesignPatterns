# Flyweight Pattern

## Overview

Flyweight is a **structural design pattern**. It provides a reusable way to solve a recurring software design problem while keeping the code easier to maintain, extend, and understand.

## Intent

Share common intrinsic state between many objects to reduce memory usage and object duplication.

## The Problem

Creating a large number of similar objects can consume unnecessary memory when much of their state is identical and reusable.

## The Solution

The Flyweight separates shared intrinsic state from unique extrinsic state. A factory or cache reuses flyweight objects instead of creating duplicates.

## Structure

The project demonstrates Flyweight through the **Discount** example.

The example includes:

- `IDiscountCalculator` as the flyweight abstraction.
- `DayDiscountCalculator` as a concrete shared calculator.
- `DiscountCalculatorFactory` as the object-sharing factory.
- `ItemPriceCalculator` as a client using the calculators.
- `Program` as the demonstration entry point.

The factory is responsible for reusing discount-calculator objects instead of unnecessarily creating equivalent instances.

## Implementation in This Project

```text
Client
  |
  v
DiscountCalculatorFactory
  |
  +--> Shared Flyweight
  |       ^
  |       |
  +-------+  reused by multiple clients
```

Shared intrinsic state belongs to the flyweight; changing request-specific data should remain outside the shared object when possible.

## Advantages

- Reduces duplicate objects.
- Can significantly reduce memory consumption when many similar objects exist.
- Centralizes shared-object management.

## Disadvantages / Trade-offs

- Adds complexity.
- Requires careful separation of intrinsic and extrinsic state.
- Not useful when the number of objects is small.

## When to Use

Use it when many objects share substantial common state and object count or memory consumption is significant.

## Related Patterns

Singleton, Factory, Composite

## Key Takeaways

The important point is not to use a design pattern simply because it exists. The pattern should be introduced when its structure solves a real design problem and provides a meaningful improvement in flexibility, maintainability, or separation of responsibilities.
