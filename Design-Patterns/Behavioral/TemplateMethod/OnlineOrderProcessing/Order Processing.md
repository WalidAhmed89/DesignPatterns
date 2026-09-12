# Template Method — Online Order Processing Example

## Overview

This example demonstrates the **Template Method Pattern** using an online order processing system.

Different order types follow the same overall algorithm:

1. Validate the order
2. Process payment
3. Prepare shipment
4. Send notification

The sequence is fixed in the abstract base class, while subclasses customize the steps that differ.

## Class Structure

```text
                    OrderProcessor
                          |
              -------------------------
              |                       |
      CreditCardOrder       CashOnDeliveryOrder
```

### Roles

| Class / Method | Role |
|---|---|
| `OrderProcessor` | Abstract Class |
| `orderProcessor()` | Template Method |
| `validateOrder()` | Variable Step |
| `processPayment()` | Variable Step |
| `prepareShipment()` | Variable Step |
| `sendNotification()` | Common Step |
| `CreditCardOrder` | Concrete Class |
| `CashOnDeliveryOrder` | Concrete Class |

## 1. Abstract Class — OrderProcessor

```java
abstract class OrderProcessor {

    public final void orderProcessor(){
        validateOrder();
        processPayment();
        prepareShipment();
        sendNotification();
    }

    protected abstract void validateOrder();
    protected abstract void processPayment();
    protected abstract void prepareShipment();

    protected void sendNotification(){
        System.out.println("Order notification sent.");
    }
}
```

The `orderProcessor()` method is the **Template Method**.

It controls the fixed algorithm:

```text
orderProcessor()
      ↓
validateOrder()
      ↓
processPayment()
      ↓
prepareShipment()
      ↓
sendNotification()
```

The method is `final`, so subclasses cannot change the algorithm's structure.

## 2. CreditCardOrder

```java
public class CreditCardOrder extends OrderProcessor {

    @Override
    protected void validateOrder() {
        System.out.println("Validating credit card order...");
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing credit card payment...");
    }

    @Override
    protected void prepareShipment() {
        System.out.println("Preparing standard shipment...");
    }
}
```

This class customizes the variable steps for credit-card orders.

## 3. CashOnDeliveryOrder

```java
public class CashOnDeliveryOrder extends OrderProcessor {

    @Override
    protected void validateOrder() {
        System.out.println("Validating cash on delivery order...");
    }

    @Override
    protected void processPayment() {
        System.out.println("Payment will be collected on delivery.");
    }

    @Override
    protected void prepareShipment() {
        System.out.println("Preparing cash on delivery shipment...");
    }
}
```

This class uses the same algorithm but provides different implementations for the variable steps.

## 4. Client

```java
public class Program {

    public static void main(String[] args) {

        OrderProcessor creditOrder = new CreditCardOrder();
        creditOrder.orderProcessor();

        System.out.println("\n--------------\n");

        OrderProcessor cashOrder = new CashOnDeliveryOrder();
        cashOrder.orderProcessor();
    }
}
```

## Expected Output

```text
Validating credit card order...
Processing credit card payment...
Preparing standard shipment...
Order notification sent.

--------------

Validating cash on delivery order...
Payment will be collected on delivery.
Preparing cash on delivery shipment...
Order notification sent.
```

## How the Pattern Works

The client only calls:

```java
creditOrder.orderProcessor();
```

The base class controls the sequence.

Because of polymorphism, the overridden methods in `CreditCardOrder` are executed:

```text
OrderProcessor.orderProcessor()
        |
        +--> CreditCardOrder.validateOrder()
        |
        +--> CreditCardOrder.processPayment()
        |
        +--> CreditCardOrder.prepareShipment()
        |
        +--> OrderProcessor.sendNotification()
```

For `CashOnDeliveryOrder`, the same sequence executes with its own implementations.

## Why This Is Template Method

The **algorithm is fixed**:

```text
Validate
   ↓
Payment
   ↓
Shipment
   ↓
Notification
```

The **implementation of some steps varies**:

```text
Credit Card:
    Credit-card validation
    Credit-card payment
    Standard shipment

Cash on Delivery:
    COD validation
    Payment on delivery
    COD shipment
```

The subclasses do not duplicate the complete algorithm.

## Why `final`?

```java
public final void orderProcessor()
```

prevents subclasses from overriding the template method and changing the required order of operations.

## Interview Explanation

> **Template Method is a behavioral design pattern that defines the skeleton of an algorithm in a base class and lets subclasses customize specific steps without changing the overall algorithm structure.**

### Memory Trick

**Template Method = FIX THE ALGORITHM, CUSTOMIZE THE STEPS.**

## Learning Goal

This example demonstrates:

- Abstract classes
- Method overriding
- Polymorphism
- `final` template methods
- Abstract operations
- Common algorithm structure
- Code reuse
- Behavioral customization
