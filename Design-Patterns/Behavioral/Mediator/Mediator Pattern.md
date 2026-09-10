# Mediator Pattern

## Overview

The **Mediator Pattern** is a **Behavioral Design Pattern** that reduces coupling between a group of objects by centralizing their communication through a mediator object.

Instead of objects communicating directly with each other, they communicate through the Mediator.

## Problem

When many objects communicate directly, the system can become tightly coupled. Adding or changing one object may require changes in several other objects.

```text
A ↔ B
A ↔ C
A ↔ D
B ↔ C
B ↔ D
C ↔ D
```

## Solution

Introduce a Mediator between the objects:

```text
A ──┐
B ──┤
C ──┼──→ Mediator
D ──┘
```

The objects no longer need to communicate with each other directly. The Mediator receives requests and coordinates the interaction.

## Intent

> Define an object that encapsulates how a set of objects interact, promoting loose coupling by keeping objects from referring to each other explicitly.

## Pattern Structure

```text
                 Mediator
                    ↑
                    |
          ┌─────────┼─────────┐
          |         |         |
      Colleague A Colleague B Colleague C
```

| Role | Responsibility |
|---|---|
| Mediator | Defines communication between colleagues |
| Concrete Mediator | Implements coordination logic |
| Colleague | Participating object that communicates through the mediator |
| Client | Creates and configures the objects |

## How It Works

1. A Colleague needs to communicate or request an operation.
2. It sends the request to the Mediator.
3. The Mediator decides what should happen.
4. The Mediator communicates with the appropriate Colleagues.
5. The Colleagues react independently.

## Main Benefit

The main benefit is **decoupling**.

Without Mediator:

```text
Colleague → Colleague
```

With Mediator:

```text
Colleague → Mediator → Colleague
```

This reduces direct dependencies and makes the system easier to modify and extend.

## Real-World Examples

### Air Traffic Control

Aircraft can communicate with an air traffic control system instead of coordinating directly with every other aircraft.

```text
Plane A ──┐
Plane B ──┤
Plane C ──┼──→ Air Traffic Control
Plane D ──┘
```

### Chat Room

Users can communicate through a central chat room instead of maintaining direct communication with every other user.

```text
User A ──┐
User B ──┤
User C ──┼──→ Chat Room
User D ──┘
```

## Mediator vs Observer

**Mediator:** centralizes communication and coordination.

```text
Object → Mediator → Object
```

**Observer:** notifies registered subscribers when a subject changes.

```text
Subject → Observer 1
        → Observer 2
        → Observer 3
```

## Mediator vs Facade

**Facade** provides a simplified interface to a complex subsystem:

```text
Client → Facade → Complex Subsystem
```

**Mediator** coordinates communication between participating objects:

```text
Object A ──┐
Object B ──┼──→ Mediator
Object C ──┘
```

## When to Use

Use Mediator when:

- Many objects communicate directly with each other.
- Direct communication creates strong coupling.
- Adding a new object requires modifying many existing objects.
- Communication logic is becoming difficult to maintain.
- You want to centralize coordination between related objects.

## Advantages

- Reduces direct coupling.
- Centralizes communication logic.
- Makes colleagues simpler.
- Makes adding or modifying colleagues easier.
- Improves maintainability.

## Disadvantages

- The Mediator can become a **God Object** if it contains too much logic.
- Communication logic becomes concentrated in one place.
- A complex mediator can be difficult to maintain.

## Key Takeaway

**Mediator = CENTRALIZE COMMUNICATION**

The core idea is:

> Objects should communicate through a central mediator instead of communicating directly with each other.
