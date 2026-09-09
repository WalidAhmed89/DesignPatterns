# Observer Pattern — Order Notification System

## Overview

This example demonstrates the **Observer Design Pattern** in Java using an E-commerce Order Notification System.

An `Order` acts as the **Observable (Subject)**. Whenever the order status changes, it notifies all registered **Observers**.

The observers represent different parts of the system:

- `CustomerNotification`
- `InventorySystem`
- `DeliverySystem`

Each observer reacts to the same order update according to its own responsibility.

---

## Problem

In an E-commerce application, an order can change its status during its lifecycle:

```text
PLACED
   ↓
SHIPPED
   ↓
DELIVERED
```

When the status changes, several systems may need to react.

Without Observer, `Order` could become tightly coupled to all of these systems.

---

## Solution

The Observer Pattern introduces an `Observer` abstraction.

```text
                         Order
                    (Observable/Subject)
                           |
                     status changes
                           |
                    notifyObserver()
                           |
             +-------------+-------------+
             |             |             |
             v             v             v
      Customer          Inventory      Delivery
     Notification         System        System
       Observer          Observer       Observer
```

The `Order` knows only about the `Observer` interface, not the concrete observer implementations.

This reduces coupling.

---

## Pattern Structure

| Component | Responsibility |
|---|---|
| `Observable` | Defines registration, removal, and notification operations |
| `Order` | Concrete Observable that owns the order state |
| `Observer` | Defines the update contract |
| `CustomerNotification` | Notifies the customer about order changes |
| `InventorySystem` | Reacts to order changes |
| `DeliverySystem` | Reacts to shipping-related changes |
| `Program` | Creates and connects the objects |

---

## Observer Interface

```java
public interface Observer {
    void update(String orderId, String status, String customerName);
}
```

Every observer implements the same `update()` contract.

This allows `Order` to notify different concrete observers polymorphically.

---

## Observable Interface

```java
public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
```

> In conventional Java naming, `notifyObservers()` would be more natural than `notifyObserver()` because multiple observers can be notified. The current name matches the implementation.

---

## Order — Concrete Observable

`Order` stores the order information and a list of registered observers.

```java
private final List<Observer> observers = new ArrayList<>();
String orderID;
String customerName;
private String status;
```

The important relationship is:

```text
Order
  |
  +---- List<Observer>
```

The order does not need to know whether an observer is a customer notification service, inventory system, delivery system, or another implementation.

---

## Registering Observers

```java
order.addObserver(customerNotification);
order.addObserver(inventorySystem);
order.addObserver(deliverySystem);
```

After registration:

```text
Order
 ├── CustomerNotification
 ├── InventorySystem
 └── DeliverySystem
```

All three observers will receive future notifications.

---

## Changing the Order State

```java
public void setStatus(String status){
    this.status = status;
    notifyObserver();
}
```

The sequence is:

```text
setStatus("SHIPPED")
        ↓
Order state changes
        ↓
notifyObserver()
        ↓
Every registered Observer receives update()
```

---

## Notification

The `Order` loops through all registered observers:

```java
for(Observer observer : observers){
    observer.update(this.orderID, this.status, this.customerName);
}
```

The important point is that the `Order` does not directly depend on concrete observer classes. It calls the common `Observer.update()` contract.

---

## CustomerNotification

`CustomerNotification` reacts to an order update and notifies the customer.

```java
public class CustomerNotification implements Observer {
    @Override
    public void update(String orderId, String status, String customerName) {
        System.out.println(
            "Customer " + customerName +
            " notified: Order #" + orderId +
            " is now " + status
        );
    }
}
```

---

## InventorySystem

`InventorySystem` also receives the notification.

```java
public class InventorySystem implements Observer {
    @Override
    public void update(String orderId, String status, String customerName) {
        System.out.println(
            "Inventory System: Updating inventory for Order #" + orderId
        );
    }
}
```

A real system could use this update to synchronize inventory-related information.

---

## DeliverySystem

`DeliverySystem` reacts specifically when the order becomes `SHIPPED`.

```java
public class DeliverySystem implements Observer {
    @Override
    public void update(String orderId, String status, String customerName) {
        if(status.equals("SHIPPED")) {
            System.out.println(
                "Delivery System: Preparing delivery for Order #" + orderId
            );
        }
    }
}
```

This demonstrates that different observers can receive the same notification but react differently.

---

## Client

The `Program` creates the Observable and the Observers:

```java
Order order = new Order("1001", "Walid", "PLACED");

CustomerNotification customerNotification = new CustomerNotification();
InventorySystem inventorySystem = new InventorySystem();
DeliverySystem deliverySystem = new DeliverySystem();
```

Then it registers them:

```java
order.addObserver(customerNotification);
order.addObserver(inventorySystem);
order.addObserver(deliverySystem);
```

Finally:

```java
order.setStatus("SHIPPED");
```

---

## Example Output

```text
Customer Walid notified:
Order #1001 is now SHIPPED

Inventory System:
Updating inventory for Order #1001

Delivery System:
Preparing delivery for Order #1001
```

---

## Complete Flow

```text
                         Client
                           |
                           v
                         Order
                      (Observable)
                           |
                    setStatus("SHIPPED")
                           |
                           v
                    notifyObserver()
                           |
          +----------------+----------------+
          |                |                |
          v                v                v
 CustomerNotification  InventorySystem  DeliverySystem
          |                |                |
       update()          update()          update()
          |                |                |
       Notify          Update data       Prepare
       customer        inventory         delivery
```

---

## Removing an Observer

Observers can unsubscribe:

```java
order.removeObserver(inventorySystem);
```

After removal, the inventory system will not receive future notifications.

This makes subscriptions dynamic.

---

## Important Concept

Observer does **not** mean:

> "When the Subject changes, every Observer automatically changes its own state."

The accurate idea is:

> **When the Subject's state changes, it notifies all registered Observers so they can react to the change.**

For example:

```text
Order status = SHIPPED
        |
        +----> Customer → send notification
        |
        +----> Inventory → update information
        |
        +----> Delivery → prepare shipment
```

The same event can produce different reactions.

---

## Adding a New Observer

A new observer can be added without modifying `Order`:

```java
public class EmailNotification implements Observer {
    @Override
    public void update(String orderId, String status, String customerName) {
        System.out.println("Email sent to " + customerName);
    }
}
```

Then:

```java
order.addObserver(new EmailNotification());
```

This demonstrates the loose coupling provided by the pattern.

---

## When to Use Observer

Use Observer when:

- One object changes state and multiple objects need to know.
- You need a one-to-many relationship.
- Observers should be registered or removed dynamically.
- Different observers need different reactions to the same event.
- You want to reduce direct coupling between the subject and its dependents.

### Real-World Examples

- E-commerce order notifications
- Stock price updates
- GUI event systems
- News subscriptions
- Push notification systems
- Chat applications
- Event-driven applications

---

## Advantages

- Reduces coupling between the subject and observers.
- Supports one-to-many relationships.
- Observers can be added or removed dynamically.
- New observer types can be introduced without modifying the subject.
- Each observer controls its own reaction.
- Encourages separation of responsibilities.

## Disadvantages

- A large number of observers can make notification expensive.
- Notification order may matter in some systems.
- Debugging event chains can become harder.
- Poorly managed subscriptions can cause unexpected updates.

---

## Project Structure

```text
Behavioral/
└── Observer/
    └── OrderNotficationSystem/
        ├── Observer.java
        ├── Observable.java
        ├── Order.java
        ├── CustomerNotification.java
        ├── InventorySystem.java
        ├── DeliverySystem.java
        └── Program.java
```

> `OrderNotficationSystem` matches the current package name. A conventional spelling would be `OrderNotificationSystem`.

---

## Key Takeaways

### Observer Pattern

> **Define a one-to-many dependency so that when one object changes state, all registered dependents are notified automatically.**

Remember:

```text
SUBJECT
   |
   | state changes
   v
NOTIFY
   |
   +----> Observer 1
   +----> Observer 2
   +----> Observer 3
```

### Core Idea

**Observer = ONE-TO-MANY NOTIFICATION**

The Subject manages the observers.

The Observers decide how to react.

The Subject does not need to know the concrete implementation of each observer.

---

## Learning Goal

This example demonstrates:

- Observable / Subject
- Observer
- Registration and subscription
- Notification
- One-to-many relationships
- Loose coupling
- Polymorphism
- Dynamic observer removal
- Different reactions to the same state change

The goal is to understand **why** the Observer Pattern is useful and how it allows multiple components to react to state changes without tightly coupling them to the object that owns the state.
