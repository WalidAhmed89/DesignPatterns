# Strategy Pattern

## Overview

The **Strategy Design Pattern** is a **Behavioral Design Pattern** that defines a family of algorithms, encapsulates each algorithm in a separate class, and makes them interchangeable.

The client can change the selected algorithm at runtime without changing the Context.

## Problem

Sometimes an application needs to perform the same operation in several different ways.

For example, a delivery system may calculate shipping cost using Standard, Express, or Same-Day delivery.

Putting all algorithms inside one class using large `if/else` or `switch` blocks makes the code harder to maintain and extend.

## Solution

Extract each algorithm into its own class.

The **Context** stores a reference to the current Strategy and delegates the operation to it.

```text
                    Context
                       |
                       v
                 DeliveryStrategy
                  /      |       \
                 /       |        \
                v        v         v
          Standard    Express    SameDay
          Strategy    Strategy   Strategy
```

## Main Roles

| Role | Responsibility |
|---|---|
| Strategy | Defines the common interface for all algorithms |
| Concrete Strategy | Implements one specific algorithm |
| Context | Uses the selected Strategy |
| Client | Chooses/configures the Strategy |

## Important Idea

The Strategy represents an **algorithm or behavior**, not a type of object.

For example:

```text
PaymentStrategy
├── CashPayment
├── CreditCardPayment
└── PayPalPayment
```

## Runtime Switching

The selected algorithm can change at runtime:

```java
context.setStrategy(new ExpressDeliveryStrategy());
context.calculate();

context.setStrategy(new StandardDeliveryStrategy());
context.calculate();
```

The Context does not need to know the implementation details of either algorithm.

## Strategy vs State

### Strategy

The **client chooses the algorithm**.

```text
Which algorithm should I use?
```

### State

The object's **current state determines its behavior**.

```text
How should I behave in my current state?
```

## When to Use Strategy

Use Strategy when:

- You have multiple algorithms for the same task.
- You want to switch algorithms at runtime.
- You want to avoid large conditional blocks.
- You want to isolate algorithms from the Context.
- You expect new algorithms to be added later.

## Advantages

- Reduces conditional logic.
- Encapsulates algorithms.
- Makes algorithms independently testable.
- Allows runtime algorithm selection.
- Reduces coupling between the Context and concrete algorithms.
- Supports the Open/Closed Principle.

## Key Takeaway

> **Strategy Pattern = interchangeable algorithms.**

### Memory Trick

**Strategy → WHICH ALGORITHM?**
