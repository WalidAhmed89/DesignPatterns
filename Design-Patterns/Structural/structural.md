# Structural Design Patterns

## Overview

**Structural Design Patterns** describe how classes and objects can be combined to form larger, flexible structures.

Their main concern is not object creation, but the relationships between components.

## Patterns Implemented in This Project

| Pattern | Main Purpose | Project Examples |
|---|---|---|
| Adapter | Make incompatible interfaces work together | Distance Calculator, Employees |
| Bridge | Separate abstraction from implementation | Multi-Platform UI |
| Composite | Treat individual and grouped objects uniformly | Jetpack Compose UI |
| Decorator | Add behavior without changing the original class | File Service, SMS Service |
| Facade | Provide a simplified interface to a subsystem | Shopping Order |
| Flyweight | Share reusable intrinsic state | Discount Calculator |
| Proxy | Control access to another object | File Service, Product API, SMS Service |

## Why Structural Patterns Matter

Without structural patterns, systems can develop rigid dependencies between classes. Structural patterns help introduce:

- Loose coupling
- Composition
- Reusability
- Replaceable implementations
- Clear boundaries between responsibilities

## Pattern Selection

- **Adapter** — existing interfaces do not match.
- **Bridge** — abstraction and implementation need to evolve independently.
- **Composite** — individual objects and object groups should be treated uniformly.
- **Decorator** — behavior must be added dynamically without modifying the original class.
- **Facade** — clients need a simple entry point to a complex subsystem.
- **Flyweight** — many objects share the same intrinsic state and memory optimization matters.
- **Proxy** — access to another object needs control, indirection, or additional behavior.
