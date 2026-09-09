# Observer Pattern — Product Inventory

## Overview

This example demonstrates the **Observer Design Pattern** in Java using a Product Inventory system.

`ProductInventory` acts as the **Observable (Subject)**. When the product stock changes, it notifies all registered **Observers**.

The observers can react independently without the inventory needing to know their concrete implementations.

The core idea is a **one-to-many notification relationship**.

## Problem

Several parts of an e-commerce system may depend on product stock:

- Shopping Cart
- Product List
- Checkout

When stock changes, all interested components need to know about the update.

Without Observer, `ProductInventory` could become directly coupled to every dependent component:

```text
ProductInventory
   ├── Cart
   ├── ProductList
   └── Checkout
```

Adding another dependent would require modifying the inventory.

## Solution

The Observer Pattern introduces an `Observer` abstraction.

```text
                 ProductInventory
                    Observable
                        |
                  notifyObserver()
                        |
            +-----------+-----------+
            |           |           |
            v           v           v
          Cart      ProductList   Checkout
        Observer     Observer     Observer
```

The subject stores a collection of observers and notifies them whenever its state changes.

## Pattern Structure

| Component | Responsibility |
|---|---|
| `Observable` | Defines observer registration, removal, and notification |
| `ProductInventory` | Concrete subject containing the product state |
| `Observer` | Defines the update contract |
| `Cart` | Reacts to stock updates |
| `productList` | Reacts to stock updates |
| `Checkout` | Reacts to stock updates |
| `Program` | Creates and connects the objects |

## Observer Interface

```java
public interface Observer {
    void update(String productName, int stock);
}
```

Any class that wants to receive updates implements this interface.

## Observable Interface

```java
public interface Observable {
    void addProduct(Observer observer);
    void removeProduct(Observer observer);
    void notifyObserver();
}
```

The implementation uses these methods to manage subscriptions.

> In production code, names such as `addObserver`, `removeObserver`, and `notifyObservers` would be more conventional. The current names match this learning example.

## ProductInventory

`ProductInventory` is the Concrete Observable.

It stores:

```java
private final List<Observer> observers = new ArrayList<>();
private String productName;
private int stock;
```

The important relationship is:

```text
ProductInventory
       |
       +---- List<Observer>
```

It only depends on the `Observer` abstraction.

### Registering Observers

```java
productInventory.addProduct(cart);
productInventory.addProduct(productList);
productInventory.addProduct(checkout);
```

Now all three objects are subscribed.

### Changing State

```java
public void setStock(int stock){
    this.stock = stock;
    notifyObserver();
}
```

When the state changes, the observers are notified.

### Notification

```java
for(Observer observer : observers){
    observer.update(productName, stock);
}
```

Each registered observer receives the new state.

## Complete Flow

```text
setStock(9)
    |
    v
State Changes
    |
    v
notifyObserver()
    |
    +----> Cart.update()
    |
    +----> ProductList.update()
    |
    +----> Checkout.update()
```

## Example

The client creates the subject:

```java
ProductInventory productInventory =
        new ProductInventory("Laptop", 10);
```

Then creates the observers:

```java
Cart cart = new Cart();
productList productList = new productList();
Checkout checkout = new Checkout();
```

Then registers them:

```java
productInventory.addProduct(cart);
productInventory.addProduct(productList);
productInventory.addProduct(checkout);
```

Finally, the stock changes:

```java
productInventory.setStock(9);
```

Output:

```text
Cart update: Laptop stock is now: 9
Product List update: Laptop -> 9
Checkout updated: Laptop -> 9
```

## What Problem Does Observer Solve?

The main problem is:

> **One object changes state while multiple other objects depend on that change.**

Instead of tightly coupling the subject to concrete classes, the subject depends on the `Observer` abstraction.

```text
ProductInventory
       |
       v
    Observer
    /  |     Cart List Checkout
```

This creates **loose coupling**.

## Adding a New Observer

A new observer can be added without modifying `ProductInventory`.

```java
public class EmailNotification implements Observer {

    @Override
    public void update(String productName, int stock) {
        System.out.println(
            "Email: " + productName +
            " stock changed to " + stock
        );
    }
}
```

Then:

```java
productInventory.addProduct(new EmailNotification());
```

The subject does not need to know the concrete class.

## Removing an Observer

An observer can unsubscribe:

```java
productInventory.removeProduct(cart);
```

After removal, `Cart` will not receive future notifications.

## Important Concept

Observer does **not** mean:

> "When the subject changes, all observers automatically change their own state."

The accurate idea is:

> **When the Subject's state changes, it notifies all registered Observers so they can react to the change.**

Each observer decides what to do with the update.

## Observer vs Tight Coupling

### Without Observer

```text
ProductInventory
   |
   +----> Cart
   +----> ProductList
   +----> Checkout
   +----> EmailNotification
   +----> AdminDashboard
```

### With Observer

```text
ProductInventory
       |
       v
    Observer
    /  |   \    \         Cart List Checkout Email Dashboard
```

The subject depends on an abstraction rather than concrete observers.

## When to Use Observer

Use Observer when:

- One object's state changes and multiple objects need to know.
- You need a one-to-many relationship.
- Observers should be able to subscribe or unsubscribe dynamically.
- You want to reduce coupling between the subject and its dependents.
- Different observers need different reactions to the same update.

### Real-World Examples

- E-commerce inventory updates
- Stock price notifications
- GUI event systems
- News subscriptions
- Notification systems
- Chat applications
- Event-driven systems

## Advantages

- Reduces coupling between subject and observers.
- Supports one-to-many relationships.
- Observers can be added or removed dynamically.
- New observer types can be introduced without modifying the subject.
- Each observer controls its own reaction.
- Encourages the Open/Closed Principle.

## Disadvantages

- A large number of observers can make notification expensive.
- Notification order may matter in some systems.
- Debugging event chains can become difficult.
- Poorly managed subscriptions can cause unexpected updates.

## Project Structure

```text
Behavioral/
└── Observer/
    └── Poduct/
        ├── Observer.java
        ├── Observable.java
        ├── ProductInventory.java
        ├── Cart.java
        ├── productList.java
        ├── Checkout.java
        └── Program.java
```

> `Poduct` matches the current package name. A conventional spelling would be `Product`.

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

The Subject knows the `Observer` abstraction.

The Observers know how to react to updates.

This allows the system to remain loosely coupled.

## Learning Goal

This example demonstrates:

- Subject / Observable
- Observer
- Registration and subscription
- Notification
- One-to-many relationships
- Loose coupling
- Polymorphism
- Dynamic subscription and removal
- Event-driven communication

The goal is to understand **why** the Observer Pattern is useful, not just memorize its class structure.
