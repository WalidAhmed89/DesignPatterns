# Observer Pattern

## Overview

The **Observer Pattern** is a behavioral design pattern that defines a one-to-many relationship between objects.

When the **Subject** changes its state, all registered **Observers** are automatically notified and can react to the change.

The main idea is to keep the Subject independent from the concrete objects that are interested in its state.

---

## Intent

> Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified automatically.

---

## What Problem Does It Solve?

Imagine a system where multiple components need to know whenever something changes.

For example, an application may have:

- A notification service
- An email service
- An SMS service
- A logging service

Without the Observer Pattern, the main object may need to directly call every service:

```java
emailService.send();
smsService.send();
notificationService.send();
logger.log();
```

This creates **tight coupling** between the main object and all dependent objects.

With the Observer Pattern:

```text
                  ┌──────────────┐
                  │   Subject    │
                  └──────┬───────┘
                         │
                    State Changed
                         │
             ┌───────────┼───────────┐
             │           │           │
             ▼           ▼           ▼
        ┌────────┐  ┌────────┐  ┌────────┐
        │Observer│  │Observer│  │Observer│
        │   A    │  │   B    │  │   C    │
        └────────┘  └────────┘  └────────┘
```

The Subject only knows about the **Observer abstraction**, not the concrete implementations.

---

## Main Components

| Component | Responsibility |
|---|---|
| `Subject` | Maintains a list of observers and notifies them when its state changes |
| `Observer` | Defines the notification method |
| `ConcreteSubject` | Stores the actual state and notifies observers when it changes |
| `ConcreteObserver` | Reacts to notifications from the subject |

---

## Structure

```text
                    ┌────────────────────┐
                    │      Subject       │
                    ├────────────────────┤
                    │ + attach()         │
                    │ + detach()         │
                    │ + notify()         │
                    └─────────┬──────────┘
                              │
                              │ notifies
                              │
             ┌────────────────┼────────────────┐
             │                │                │
             ▼                ▼                ▼
      ┌─────────────┐  ┌─────────────┐  ┌─────────────┐
      │  Observer A │  │  Observer B │  │  Observer C │
      ├─────────────┤  ├─────────────┤  ├─────────────┤
      │ + update()  │  │ + update()  │  │ + update()  │
      └─────────────┘  └─────────────┘  └─────────────┘
```

---

## How It Works

The typical flow is:

```text
1. Observer registers with Subject
            ↓
2. Subject state changes
            ↓
3. Subject calls notify()
            ↓
4. Subject calls update() on every Observer
            ↓
5. Each Observer reacts to the change
```

---

## Java Example

### Observer Interface

```java
public interface Observer {

    void update(String message);
}
```

The interface defines how observers receive notifications.

### Subject

```java
import java.util.ArrayList;
import java.util.List;

public class Subject {

    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void changeState(String message) {
        System.out.println("Subject state changed.");
        notifyObservers(message);
    }
}
```

### Concrete Observer

```java
public class EmailObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Email notification: " + message);
    }
}
```

Another observer:

```java
public class SMSObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("SMS notification: " + message);
    }
}
```

### Client

```java
public class Main {

    public static void main(String[] args) {

        Subject subject = new Subject();

        Observer emailObserver = new EmailObserver();
        Observer smsObserver = new SMSObserver();

        subject.attach(emailObserver);
        subject.attach(smsObserver);

        subject.changeState("New order has been created.");
    }
}
```

### Output

```text
Subject state changed.
Email notification: New order has been created.
SMS notification: New order has been created.
```

---

## Real-World Example

A common real-world example is a **YouTube Channel subscription system**.

When a channel publishes a new video, all subscribers are notified.

```text
                  YouTube Channel
                         │
                    New Video
                         │
                    notify()
                         │
          ┌──────────────┼──────────────┐
          │              │              │
          ▼              ▼              ▼
      Subscriber A   Subscriber B   Subscriber C
          │              │              │
          ▼              ▼              ▼
       Notify          Notify          Notify
```

The YouTube channel does not need to know how each subscriber handles the notification.

It only needs to notify the registered observers.

---

## When Should We Use It?

Use the Observer Pattern when:

- Multiple objects depend on the state of another object.
- Changes in one object should automatically trigger actions in other objects.
- You need a publish/subscribe style relationship.
- You want to avoid tightly coupling the Subject to its dependents.
- Observers can be dynamically added or removed.
- The number of observers can change during runtime.

---

## Advantages

### 1. Loose Coupling

The Subject only depends on the Observer abstraction.

### 2. Dynamic Relationships

Observers can be added or removed at runtime.

### 3. Open/Closed Principle

New observers can be introduced without modifying the Subject.

### 4. Automatic Notification

Observers automatically receive updates when the Subject changes.

### 5. Separation of Responsibilities

The Subject manages state and notifications, while observers handle their own reactions.

---

## Disadvantages

### 1. Unexpected Updates

An Observer may receive notifications at times when it does not expect them.

### 2. Notification Order

The order in which observers receive notifications may matter in some systems.

### 3. Performance

A large number of observers can make notification operations expensive.

### 4. Memory Management

Observers that are not properly detached can remain referenced by the Subject.

---

## Observer vs. Direct Communication

### Without Observer Pattern

```text
Subject
  │
  ├──► EmailService
  ├──► SMSService
  ├──► NotificationService
  └──► LoggingService
```

The Subject is tightly coupled to every service.

### With Observer Pattern

```text
                    Subject
                       │
                       ▼
                  Observer
                  Interface
                       │
          ┌────────────┼────────────┐
          ▼            ▼            ▼
       Email          SMS      Notification
      Observer      Observer      Observer
```

The Subject communicates through the Observer abstraction.

---

## Key Idea

The most important concept behind the Observer Pattern is:

> **When the Subject's state changes, all registered Observers are automatically notified.**

The relationship can be represented as:

```text
Subject
   │
   │ State Changes
   ▼
notify()
   │
   ├──────────► Observer A → update()
   │
   ├──────────► Observer B → update()
   │
   └──────────► Observer C → update()
```

---

## Common Use Cases

The Observer Pattern is commonly used in:

- Event handling systems
- Notification systems
- GUI event listeners
- Publish/Subscribe systems
- Stock price monitoring
- Chat applications
- News feeds
- Social media notifications
- Real-time dashboards
- MVC architectures

---

## Related Design Patterns

- **Mediator** — centralizes communication between objects.
- **Chain of Responsibility** — passes requests through a chain of handlers.
- **Command** — encapsulates a request as an object.
- **Singleton** — can sometimes be used for a centralized event manager, although it should not replace proper Observer design.

---

## Summary

The **Observer Pattern** establishes a one-to-many relationship between a Subject and multiple Observers.

When the Subject's state changes:

```text
Subject State Changes
        ↓
     notify()
        ↓
 ┌──────┼──────┐
 ▼      ▼      ▼
Obs A  Obs B  Obs C
 │      │      │
 ▼      ▼      ▼
React  React  React
```

This allows objects to react to state changes without the Subject being tightly coupled to their concrete implementations.

### In One Sentence

> **Observer lets multiple objects automatically react when the state of another object changes.**
