# Chain of Responsibility — Customer Support System

## Overview

This example demonstrates the **Chain of Responsibility** behavioral design pattern using a Customer Support System.

A support request is passed through a chain of handlers. Each handler checks whether it is responsible for the request.

If it can handle the request, it processes it and **stops the chain**. Otherwise, it forwards the request to the next handler.

This example represents the **First Responsible Handler** scenario.

## Problem

Different customer issues need different support levels:

- **Basic Support** → basic account-related problems
- **Technical Support** → technical problems
- **Manager** → critical or high-priority problems

Without Chain of Responsibility, the client could become tightly coupled to the concrete handlers by deciding who should process each request.

## Solution

Create a chain of handlers:

```text
Client
  ↓
Basic Support
  ↓
Technical Support
  ↓
Manager
```

The client sends the request to the first handler and does not need to know which handler will eventually process it.

## Pattern Structure

```text
                 BaseHandler
                      |
          +-----------+-----------+
          |           |           |
       Basic       Technical    Manager
       Handler      Handler      Handler
          |           |           |
          +----------->-----------+
                nextHandler
```

| Component | Responsibility |
|---|---|
| `SupportRequest` | Contains request data such as customer, issue, and priority |
| `BaseHandler` | Defines the common handler structure and next handler |
| `BasicSupportHandler` | Handles priority `1` |
| `TechnicalSupportHandler` | Handles priority `2` |
| `ManagerHandler` | Handles priority `3` |
| `Program` | Builds and starts the chain |

## SupportRequest

`SupportRequest` represents the request traveling through the chain.

It contains:

- `customerName`
- `issue`
- `priority`

Example:

```java
SupportRequest request =
        new SupportRequest("Frosted", "server issues", 2);
```

The priority is supplied when the request is created. The request does not decide which handler should process it.

## BaseHandler

```java
public abstract class BaseHandler {
    protected BaseHandler nextHandler;

    public void setNext(BaseHandler handler) {
        nextHandler = handler;
    }

    public abstract void handleRequest(SupportRequest request);
}
```

`BaseHandler` stores the next handler and defines the contract that every concrete handler must implement.

## Handlers

### BasicSupportHandler

Handles requests where:

```text
priority == 1
```

If responsible, it handles the request and returns. Otherwise, it forwards the request.

### TechnicalSupportHandler

Handles:

```text
priority == 2
```

If the priority is not `2`, the request continues to the next handler.

### ManagerHandler

Handles:

```text
priority == 3
```

It is the final handler in the chain.

## Building the Chain

The chain is created in `Program`:

```java
basicHandler.setNext(technicalSupportHandler);
technicalSupportHandler.setNext(managerHandler);
```

This creates:

```text
Basic → Technical → Manager
```

The client starts the chain from the first handler:

```java
basicHandler.handleRequest(request);
```

## Example Flows

### Priority 1 — Basic Support

```text
Request
  ↓
Basic Support
  ↓
HANDLE
  ↓
STOP
```

### Priority 2 — Technical Support

```text
Request
  ↓
Basic Support
  ↓
Not responsible
  ↓
Technical Support
  ↓
HANDLE
  ↓
STOP
```

### Priority 3 — Manager

```text
Request
  ↓
Basic Support
  ↓
Not responsible
  ↓
Technical Support
  ↓
Not responsible
  ↓
Manager
  ↓
HANDLE
  ↓
STOP
```

## Why `return` Matters

In the **First Responsible Handler** version, once a handler processes the request, it must stop the chain.

```java
if (request.getPriority() == 1) {
    System.out.println("Handled by Basic Support");
    return;
}
```

The `return` means:

> The request has been handled, so there is no reason to pass it further.

## First Responsible Handler vs Pipeline

Chain of Responsibility can be used with different processing behaviors.

### First Responsible Handler

The first handler that can handle the request processes it and stops:

```text
Request
   ↓
Handler A ❌
   ↓
Handler B ✅
   ↓
STOP
```

### Pipeline / All Handlers

Every handler can process or modify the request before forwarding it:

```text
Request
   ↓
Handler A → modifies
   ↓
Handler B → modifies
   ↓
Handler C → modifies
   ↓
Final Result
```

The current Customer Support System uses the **First Responsible Handler** approach.

## When to Use Chain of Responsibility

Use this pattern when:

- Multiple objects may be able to handle a request.
- The sender should not be tightly coupled to a specific receiver.
- A request should move through a sequence of possible handlers.
- Handlers may need to be added, removed, or reordered.
- Each handler should decide whether to process or forward the request.

### Real-World Examples

- Customer support escalation
- Authentication and authorization pipelines
- HTTP middleware
- Approval workflows
- Request validation
- Logging systems
- Event processing

## Advantages

- Reduces coupling between sender and receiver.
- Keeps responsibilities separated between handlers.
- Makes the processing flow flexible.
- Handlers can be added or reordered easily.
- The client does not need to know the concrete handler responsible for the request.

## Disadvantages

- A request may reach the end without being handled.
- Long chains can be harder to debug.
- Handler order can affect behavior.
- Poorly designed chains can cause unnecessary processing.

## Project Structure

```text
Behavioral/
└── ChainOfResponsibility/
    └── CustomerSupportSystem/
        ├── BaseHandler.java
        ├── SupportRequest.java
        ├── BasicSupportHandler.java
        ├── TechnicalSupportHandler.java
        ├── ManagerHandler.java
        └── Program.java
```

## Key Takeaways

### Chain of Responsibility

> Pass a request through a chain of handlers until one of them handles it.

The core decision made by every handler is:

```text
Can I handle it?
   |
   +-- YES → Handle → STOP
   |
   +-- NO  → Pass to next handler
```

### Remember

**Chain of Responsibility = PASS THE REQUEST**

The client sends the request to the chain without knowing which concrete handler will process it.

## Learning Goal

This example is designed to build a practical understanding of:

- Handler chains
- Delegation
- Polymorphism
- Loose coupling
- Responsibility separation
- First-responsible request handling
- Stopping versus forwarding in a chain

The goal is to understand **why** Chain of Responsibility is useful, not just memorize its class structure.
