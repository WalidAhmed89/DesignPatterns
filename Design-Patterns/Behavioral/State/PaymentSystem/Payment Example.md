# State Pattern — Payment Example

## Overview

This example demonstrates the **State Design Pattern** using a payment workflow.

The payment moves through:

```text
Pending → Paid → Shipped → Completed
```

The behavior of `pay()`, `ship()`, and `complete()` changes according to the current state.

## Problem

Without State, `Payment` could contain many conditional statements:

```java
if (state.equals("PENDING")) {
    // ...
} else if (state.equals("PAID")) {
    // ...
} else if (state.equals("SHIPPED")) {
    // ...
}
```

The State Pattern moves this state-specific behavior into separate classes.

## Pattern Roles

| Role | Class |
|---|---|
| Context | `Payment` |
| State | `PaymentState` |
| Concrete State | `PendingState` |
| Concrete State | `PaidState` |
| Concrete State | `ShippedState` |
| Concrete State | `CompletedState` |
| Client | `Program` |

## 1. State Interface

```java
public interface PaymentState {

    void pay(Payment payment);

    void ship(Payment payment);

    void complete(Payment payment);
}
```

## 2. PendingState

```java
public class PendingState implements PaymentState {

    @Override
    public void pay(Payment payment) {
        System.out.println("Payment completed successfully.");
        payment.setState(new PaidState());
    }

    @Override
    public void ship(Payment payment) {
        System.out.println("Cannot ship. Payment is still pending.");
    }

    @Override
    public void complete(Payment payment) {
        System.out.println("Cannot complete. Payment is still pending.");
    }
}
```

Transition:

```text
Pending → Paid
```

## 3. PaidState

```java
public class PaidState implements PaymentState {

    @Override
    public void pay(Payment payment) {
        System.out.println("Payment has already been paid.");
    }

    @Override
    public void ship(Payment payment) {
        System.out.println("Payment shipped.");
        payment.setState(new ShippedState());
    }

    @Override
    public void complete(Payment payment) {
        System.out.println("Cannot complete. Payment has not been shipped.");
    }
}
```

Transition:

```text
Paid → Shipped
```

## 4. ShippedState

```java
public class ShippedState implements PaymentState {

    @Override
    public void pay(Payment payment) {
        System.out.println("Payment has already been paid.");
    }

    @Override
    public void ship(Payment payment) {
        System.out.println("Payment has already been shipped.");
    }

    @Override
    public void complete(Payment payment) {
        System.out.println("Payment completed.");
        payment.setState(new CompletedState());
    }
}
```

Transition:

```text
Shipped → Completed
```

## 5. CompletedState

```java
public class CompletedState implements PaymentState {

    @Override
    public void pay(Payment payment) {
        System.out.println("Payment is already completed.");
    }

    @Override
    public void ship(Payment payment) {
        System.out.println("Payment is already completed.");
    }

    @Override
    public void complete(Payment payment) {
        System.out.println("Payment is already completed.");
    }
}
```

This is the final state, so further operations do not change the payment.

## 6. Payment — Context

```java
public class Payment {

    private PaymentState state;

    public Payment() {
        this.state = new PendingState();
    }

    public void pay() {
        state.pay(this);
    }

    public void ship() {
        state.ship(this);
    }

    public void complete() {
        state.complete(this);
    }

    public void setState(PaymentState state) {
        this.state = state;
    }
}
```

`Payment` is the **Context**. It does not need a large `if/else` chain. It delegates each operation to the current state.

## 7. Program

```java
public class Program {

    public static void main(String[] args) {

        Payment payment = new Payment();

        payment.ship();

        payment.pay();

        payment.pay();

        payment.ship();

        payment.complete();

        payment.complete();
    }
}
```

## Execution Flow

### 1. Initial State

```java
Payment payment = new Payment();
```

The initial state is:

```text
PendingState
```

### 2. Try to Ship

```java
payment.ship();
```

Output:

```text
Cannot ship. Payment is still pending.
```

### 3. Pay

```java
payment.pay();
```

Output:

```text
Payment completed successfully.
```

State transition:

```text
Pending → Paid
```

### 4. Pay Again

```java
payment.pay();
```

Output:

```text
Payment has already been paid.
```

### 5. Ship

```java
payment.ship();
```

Output:

```text
Payment shipped.
```

State transition:

```text
Paid → Shipped
```

### 6. Complete

```java
payment.complete();
```

Output:

```text
Payment completed.
```

State transition:

```text
Shipped → Completed
```

### 7. Complete Again

```java
payment.complete();
```

Output:

```text
Payment is already completed.
```

## Complete State Flow

```text
                 pay()
Pending --------------------→ Paid
   |                            |
   | ship()                     | ship()
   ↓                            ↓
Not Allowed                  Shipped
                                |
                                | complete()
                                ↓
                            Completed
```

## Why This Is State Pattern

This example is State Pattern because:

1. `Payment` has an internal state.
2. Its behavior depends on that state.
3. Each state has a separate class.
4. `Payment` delegates operations to its current state.
5. States can transition the Context to another state.

The core idea is:

```text
Same Object
    +
Different State
    ↓
Different Behavior
```

## Important Interview Point

The goal is **not simply to remove `if/else`**.

The deeper purpose is:

> Encapsulate state-specific behavior so that an object's behavior can change when its internal state changes.

Removing large conditional structures is a consequence of this design.

## State vs Strategy

```text
State
→ Behavior changes with the object's current state.

Strategy
→ Select an algorithm or interchangeable behavior.
```

## Key Takeaways

- `Payment` = Context
- `PaymentState` = State
- `PendingState`, `PaidState`, `ShippedState`, `CompletedState` = Concrete States
- Each state controls its own behavior.
- States can transition the Context.
- The Context avoids a large state-dependent conditional structure.

### Memory Trick

**STATE PATTERN = BEHAVIOR CHANGES WITH STATE**
