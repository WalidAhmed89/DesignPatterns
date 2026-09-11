# State Design Pattern

## Overview
The **State Pattern** is a behavioral design pattern that allows an object to change its behavior when its internal state changes.

Instead of placing many `if`, `else if`, or `switch` statements in one class, each state is represented by a separate class containing the behavior associated with that state.

## Problem
Suppose an object can be in several states such as `Pending`, `Paid`, `Shipped`, and `Completed`, and supports operations such as `pay()`, `ship()`, and `complete()`.

Without State, the code can become a large conditional structure:

```java
if (state == PENDING) {
    // ...
} else if (state == PAID) {
    // ...
} else if (state == SHIPPED) {
    // ...
}
```

As states and operations grow, the class becomes harder to maintain.

## Solution
Move state-specific behavior into separate classes. The main object, called the **Context**, stores its current state and delegates operations to it.

```text
Payment
   |
currentState
   |
   +-- PendingState
   +-- PaidState
   +-- ShippedState
   +-- CompletedState
```

## Pattern Structure

### Context
The object whose behavior changes.

Example: `Payment`

### State
An interface defining operations supported by all states.

Example: `PaymentState`

### Concrete States
Classes implementing behavior for individual states.

Examples:
- `PendingState`
- `PaidState`
- `ShippedState`
- `CompletedState`

## How It Works

The Context delegates an operation to its current state:

```java
state.pay(this);
```

The current state decides:
1. What should happen.
2. Whether the operation is allowed.
3. Whether the Context should transition to another state.

Example:

```text
Pending
   |
  pay()
   ↓
Paid
```

## When to Use It
Use State when:
- An object has multiple states.
- Its behavior changes depending on its current state.
- State-dependent conditional logic is becoming large.
- State transitions are important business logic.

## State vs Iterator

```text
State
→ How should the object BEHAVE in its current state?

Iterator
→ How do I TRAVERSE elements in a collection?
```

A `getNext()` operation over books is usually an Iterator problem if the goal is simply to traverse a collection.

## State vs Strategy

```text
State
→ Behavior changes because the object's state changes.

Strategy
→ Select an algorithm or interchangeable behavior.
```

## Real-World Examples
- Order processing
- Payment workflows
- Media players
- ATM systems
- Traffic lights
- Vending machines
- Game characters
- Authentication/session states

## Key Takeaway

> **State Pattern = Behavior changes when the object's internal state changes.**

### Memory Trick

**STATE → BEHAVIOR**
