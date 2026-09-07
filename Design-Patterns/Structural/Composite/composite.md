# Composite Pattern

## Overview

Composite is a **structural design pattern**. It provides a reusable way to solve a recurring software design problem while keeping the code easier to maintain, extend, and understand.

## Intent

Compose objects into tree structures and allow clients to treat individual objects and compositions uniformly.

## The Problem

Client code becomes complicated when it must distinguish between a single UI element and a container holding many UI elements.

## The Solution

The Composite pattern defines a common component interface. Leaf objects implement individual behavior, while composite objects contain child components and delegate operations to them.

## Structure

The project demonstrates Composite through the **JetpackCompose** example:

- `IComponent` defines the common component abstraction.
- `TextView`, `ImageView`, and `WebView` act as leaf components.
- `Container` acts as the composite and can contain components.
- `Program` demonstrates the hierarchy.

This models a UI structure where a container and individual UI elements can be handled through the same abstraction.

## Implementation in This Project

```text
IComponent
   |
   +--> TextView
   +--> ImageView
   +--> WebView
   |
   +--> Container
          |
          +--> IComponent
          +--> IComponent
```

The structure forms a tree of components.

## Advantages

- Simplifies client code.
- Naturally represents hierarchical structures.
- Makes recursive structures easier to process.

## Disadvantages / Trade-offs

- The common interface may become too broad.
- Some operations may not make sense for every component type.

## When to Use

Use it when the domain naturally forms a tree and clients should treat leaves and groups consistently.

## Related Patterns

Decorator, Iterator, Visitor

## Key Takeaways

The important point is not to use a design pattern simply because it exists. The pattern should be introduced when its structure solves a real design problem and provides a meaningful improvement in flexibility, maintainability, or separation of responsibilities.
