# Builder Pattern

## Overview

Builder is a **creational design pattern**. It provides a reusable way to solve a recurring software design problem while keeping the code easier to maintain, extend, and understand.

## Intent

Separate the construction of a complex object from its representation so the same construction process can create different representations.

## The Problem

Constructors can become difficult to manage when an object has many fields, optional components, or a multi-step construction process. The client can also become responsible for too much construction logic.

## The Solution

The Builder pattern moves construction steps into builder classes. A director can optionally control the construction sequence, while the final product remains independent of the construction process.

## Structure

The project contains three Builder examples:

- **Computer** — builds different computer configurations such as gaming and office computers.
- **ProductBuilder** — demonstrates building different product types such as a car and motorcycle.
- **SmartHouse** — constructs different house configurations through house builders.

The examples demonstrate both the Builder and optional Director roles.

## Implementation in This Project

```text
Client
  |
  v
Director
  |
  v
Builder Interface
  |
  +--> Concrete Builder A
  +--> Concrete Builder B
  |
  v
Product
```

The Director is useful when the construction sequence should be centralized. The client can also interact with the builder directly when appropriate.

## Advantages

- Handles complex construction cleanly.
- Supports different representations of the same construction process.
- Avoids large telescoping constructors.
- Keeps construction logic separate from the product.

## Disadvantages / Trade-offs

- Introduces additional classes.
- Can be unnecessary for simple objects.
- A poorly designed builder can expose too much construction detail.

## When to Use

Use it when object construction has multiple meaningful steps, optional components, or several possible configurations.

## Related Patterns

Abstract Factory, Prototype

## Key Takeaways

The important point is not to use a design pattern simply because it exists. The pattern should be introduced when its structure solves a real design problem and provides a meaningful improvement in flexibility, maintainability, or separation of responsibilities.
