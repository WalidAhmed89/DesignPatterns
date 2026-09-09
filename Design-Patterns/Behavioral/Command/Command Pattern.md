# Command Pattern

## Overview

The **Command Pattern** is a **Behavioral Design Pattern** that encapsulates a request or action as an object.

Instead of calling an operation directly, the request is represented by a Command object. This allows the object that requests an operation to remain decoupled from the object that performs the actual operation.

### Core Idea

> **Encapsulate a request as an object.**

A simple mental model is:

```text
Command → ACTION
```

The pattern is useful when an operation itself needs to be treated as an object.

---

## 🎯 What Problem Does It Solve?

Without the Command Pattern, a client may directly call methods on another object:

```java
account.sendMoney(5000);
```

This creates a direct dependency between the client and the object performing the operation.

As the number of operations grows, the client may become responsible for knowing many different operations:

```text
Client
  ├── sendMoney()
  ├── withdrawMoney()
  ├── depositMoney()
  └── refund()
```

The Command Pattern separates the requester from the receiver by representing each request as an object.

---

## 💡 The Main Idea

Instead of:

```text
Client → Receiver → Operation
```

we introduce a Command:

```text
Client → Command → Receiver
```

The Command encapsulates the request and knows which Receiver should perform it.

---

## 🏗️ Pattern Structure

```text
                Client
                  │
                  ↓
              Invoker
                  │
                  ↓
               Command
                  │
          ┌───────┴────────┐
          ↓                ↓
 ConcreteCommand A   ConcreteCommand B
          │                │
          └───────┬────────┘
                  ↓
               Receiver
```

### Main Roles

| Role | Responsibility |
|---|---|
| **Command** | Defines the common operation, usually `execute()` |
| **Concrete Command** | Encapsulates a specific request |
| **Receiver** | Performs the actual operation |
| **Invoker** | Executes the command |
| **Client** | Creates and configures the objects |

---

## 1. Command

The Command interface defines the operation that can be executed.

```java
public interface Command {
    void execute();
}
```

The Invoker only needs to know this interface.

It does not need to know what the command actually does.

---

## 2. Concrete Command

A Concrete Command represents a specific action.

For example:

```text
SendMoneyCommand
WithdrawCommand
DepositCommand
```

Each command implements:

```java
execute()
```

and delegates the actual work to its Receiver.

---

## 3. Receiver

The Receiver is the object that knows how to perform the real operation.

For example:

```java
BankAccount
```

may know how to:

```java
sendMoney()
withdrawMoney()
depositMoney()
```

The Command does not implement the business operation itself.

It tells the Receiver to perform it.

---

## 4. Invoker

The Invoker is responsible for executing the Command.

For example:

```text
TransactionButton
```

may contain:

```java
command.execute();
```

The Invoker does not need to know which Concrete Command it is executing.

---

## 5. Client

The Client creates the objects and connects them together.

For example:

```text
Client
 ↓
creates Receiver
 ↓
creates Command
 ↓
gives Command to Invoker
```

---

## 🔄 Execution Flow

Suppose the user wants to send money.

```text
User
 ↓
Invoker
 ↓
SendMoneyCommand
 ↓
BankAccount
 ↓
sendMoney()
```

The important part is that the Invoker does not directly call:

```java
account.sendMoney();
```

Instead, it calls:

```java
command.execute();
```

The Concrete Command then delegates to the Receiver.

---

## 🧠 Why Encapsulation Matters

The request:

```text
"Send $5000"
```

can now be represented by an object:

```text
SendMoneyCommand
```

That object can contain:

- The Receiver
- The required data
- The operation that should be executed

Therefore, the request becomes a first-class object that can potentially be:

- Stored
- Queued
- Logged
- Delayed
- Repeated
- Undone

---

## 🕐 When to Use Command

The Command Pattern is useful when:

- You want to encapsulate requests as objects.
- You want to decouple the requester from the receiver.
- Different actions should be interchangeable.
- Commands may need to be queued.
- Commands may need to be logged.
- Commands may need to be executed later.
- You need Undo/Redo functionality.
- UI actions need to be represented as objects.

Common examples:

- GUI buttons
- Banking operations
- Job queues
- Task scheduling
- Remote commands
- Undo/Redo systems
- Macro commands

---

## 🆚 Command vs Observer

Both are Behavioral Design Patterns, but they solve different problems.

### Command

The system wants to **perform an action**.

```text
"I want you to do something."
```

```text
Client
 ↓
Command
 ↓
Receiver
 ↓
Action
```

### Observer

The system wants to **notify interested objects about a change**.

```text
"Something happened. Let everyone interested know."
```

```text
Subject
 ↓
Notification
 ↓
Observers
```

### Simple Mental Model

```text
Command  → ACTION
Observer → NOTIFICATION
```

---

## ⚠️ Trade-offs

### Advantages

- Reduces coupling between requester and receiver.
- Encapsulates requests as objects.
- Commands can be stored, queued, logged, or executed later.
- Makes different actions interchangeable.
- Provides a foundation for Undo/Redo.

### Disadvantages

- Introduces additional classes.
- Simple operations may become unnecessarily complex.
- Each action may require its own Command class.

Therefore, the pattern should be used when the additional abstraction provides a real benefit.

---

## 🎯 Key Takeaway

The most important sentence to remember is:

> **The Command Pattern encapsulates a request as an object.**

The core relationship is:

```text
Client
  ↓
Command
  ↓
Receiver
```

With an Invoker:

```text
Client
  ↓
Invoker
  ↓
Command.execute()
  ↓
Receiver
```

The Command is not the object that performs the business operation.

The **Receiver** performs the operation.

The Command **encapsulates the request and delegates the work to the Receiver**.
