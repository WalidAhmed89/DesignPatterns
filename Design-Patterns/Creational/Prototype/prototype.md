# Prototype Pattern

## Overview

Prototype is a **creational design pattern**. It provides a reusable way to solve a recurring software design problem while keeping the code easier to maintain, extend, and understand.

## Intent

Create new objects by copying an existing object, called a prototype.

## The Problem

Sometimes creating an object from scratch is expensive or requires repeating configuration. If an existing object already contains the desired state, copying it can be simpler.

## The Solution

The Prototype pattern defines a copy operation. A new object is produced from an existing prototype while remaining a separate object.

## Structure

The project demonstrates Prototype with employee objects:

- `EmployeePrototype` defines the prototype abstraction.
- `RegularEmployee` and `TempEmployee` represent employee variants.
- `Address` is part of the employee state.
- `Program` demonstrates the creation/copying process.

The example focuses on creating employee objects from existing prototype state rather than rebuilding every value from scratch.

## Implementation in This Project

```text
Existing Employee Prototype
          |
          | clone / copy
          v
     New Employee
          |
          +--> independent object
```

When an object contains mutable nested state, the implementation must consider whether the copy should be shallow or deep.

## Advantages

- Can simplify creation of complex configured objects.
- Can avoid repeated initialization.
- Can be useful when the concrete type should remain hidden from the client.

## Disadvantages / Trade-offs

- Copying mutable nested objects can introduce shallow-copy bugs.
- Prototype management can become difficult when object graphs are complex.
- Not every object benefits from cloning.

## When to Use

Use it when copying an existing configured object is easier or cheaper than constructing a new one.

## Related Patterns

Builder, Factory, Memento

## Key Takeaways

The important point is not to use a design pattern simply because it exists. The pattern should be introduced when its structure solves a real design problem and provides a meaningful improvement in flexibility, maintainability, or separation of responsibilities.
