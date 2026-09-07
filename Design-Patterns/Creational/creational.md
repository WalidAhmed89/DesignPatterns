# Creational Design Patterns

## Overview

**Creational Design Patterns** deal with the process of object creation.

Instead of allowing every part of an application to create concrete objects directly, creational patterns provide controlled and reusable approaches for creating objects.

This can reduce coupling between the client and concrete implementations and make the system easier to extend.

## Why Creational Patterns?

Direct object creation can become problematic when:

- Object creation is complex.
- A system needs different implementations of the same abstraction.
- The exact concrete class should not be hard-coded in client code.
- Objects require multiple configuration steps.
- An application needs controlled access to a shared instance.
- Existing objects can be copied more efficiently than recreated.

## Patterns Implemented in This Project

| Pattern | Main Purpose | Project Examples |
|---|---|---|
| Abstract Factory | Create families of related objects | Bank, Database System, UI Components |
| Builder | Construct complex objects step by step | Computer, Product Builder, Smart House |
| Factory | Delegate object creation to a factory | Banking, Delivery, Notification |
| Prototype | Create objects by copying existing prototypes | Employees |
| Singleton | Ensure controlled access to a single instance | Database Connection, Counter, Login Counter |

## Pattern Selection

A useful way to distinguish the patterns is:

- **Factory** — when object creation should be delegated to a factory.
- **Abstract Factory** — when related objects must be created as a consistent family.
- **Builder** — when an object has many construction steps or optional parts.
- **Prototype** — when copying an existing configured object is useful.
- **Singleton** — when a class must have one controlled instance.

## Project Goal

The examples in this project intentionally use different domains so that the underlying pattern structure becomes easier to recognize independently from the business domain.
