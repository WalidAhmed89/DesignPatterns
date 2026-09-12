# Strategy Pattern — Payment Processing Example

## Overview

This example demonstrates the **Strategy Design Pattern** using a payment processing system.

The system supports multiple payment algorithms:

- Credit Card
- PayPal
- Bank Transfer

The selected payment strategy can be changed at runtime without modifying the `PaymentProcessor`.

## Problem

A payment system may support multiple payment methods. Each method has its own implementation for processing a payment.

A poor design would put all payment algorithms inside `PaymentProcessor` using `if/else` or `switch`.

For example:

```text
if paymentType == "CREDIT_CARD"
    ...
else if paymentType == "PAYPAL"
    ...
else if paymentType == "BANK_TRANSFER"
    ...
```

This makes the Context tightly coupled to every payment method and makes adding new methods harder.

## Solution

The Strategy Pattern encapsulates each payment algorithm in a separate class.

```text
                     PaymentProcessor
                         Context
                            |
                            v
                    PaymentStrategy
                    /      |       \
                   /       |        \
                  v        v         v
          CreditCard    PayPal    BankTransfer
           Strategy     Strategy     Strategy
```

## Pattern Roles

| Role | Class | Responsibility |
|---|---|---|
| Strategy | `PaymentStrategy` | Defines the common payment operation |
| Concrete Strategy | `CreditCardPayment` | Implements credit card payment |
| Concrete Strategy | `PayPalStrategy` | Implements PayPal payment |
| Concrete Strategy | `BankTransferPayment` | Implements bank transfer payment |
| Context | `PaymentProcessor` | Stores and uses the selected strategy |
| Client | `Program` | Selects the payment strategy |

## Implementation

### Strategy Interface

```java
public interface PaymentStrategy {
    void pay(double amount);
}
```

The interface defines the common contract that every payment algorithm must follow.

### Credit Card Strategy

```java
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
    }
}
```

### PayPal Strategy

```java
public class PayPalStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
    }
}
```

### Bank Transfer Strategy

```java
public class BankTransferPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing bank transfer: $" + amount);
    }
}
```

### Context

```java
public class PaymentProcessor {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        strategy.pay(amount);
    }
}
```

The Context does not contain the implementation details of any payment method.

It only delegates the operation to the selected Strategy.

### Client

```java
PaymentProcessor paymentProcessor = new PaymentProcessor();

paymentProcessor.setStrategy(new CreditCardPayment());
paymentProcessor.processPayment(100);

paymentProcessor.setStrategy(new PayPalStrategy());
paymentProcessor.processPayment(250);

paymentProcessor.setStrategy(new BankTransferPayment());
paymentProcessor.processPayment(500);
```

## Runtime Switching

The same `PaymentProcessor` uses three different algorithms during runtime:

```text
CreditCardPayment
       ↓
processPayment(100)
       ↓
Credit Card Algorithm

PayPalStrategy
       ↓
processPayment(250)
       ↓
PayPal Algorithm

BankTransferPayment
       ↓
processPayment(500)
       ↓
Bank Transfer Algorithm
```

The Context does not change. Only the Strategy changes.

## Expected Output

```text
Processing credit card payment: $100.0
Processing PayPal payment: $250.0
Processing bank transfer payment: $500.0
```

## Why This Is Strategy

This implementation follows the Strategy Pattern because:

1. Multiple algorithms perform the same general operation.
2. Each algorithm is encapsulated in its own class.
3. All algorithms implement the same Strategy interface.
4. The Context depends on the abstraction rather than concrete implementations.
5. The Client can change the selected algorithm at runtime.
6. No `if/else`, `switch`, or `instanceof` is required.

## Adding a New Strategy

For example, a `CashPayment` strategy can be added:

```java
public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing cash payment: $" + amount);
    }
}
```

Then:

```java
paymentProcessor.setStrategy(new CashPayment());
paymentProcessor.processPayment(300);
```

`PaymentProcessor` does not need to be modified.

This demonstrates the **Open/Closed Principle**.

## Key Takeaways

- `PaymentStrategy` defines the common algorithm contract.
- Concrete Strategies encapsulate individual payment algorithms.
- `PaymentProcessor` is the Context.
- The Client selects the Strategy.
- Strategies are interchangeable at runtime.
- The Context does not contain payment-specific conditional logic.

### Memory Trick

**Strategy = WHICH ALGORITHM?**
