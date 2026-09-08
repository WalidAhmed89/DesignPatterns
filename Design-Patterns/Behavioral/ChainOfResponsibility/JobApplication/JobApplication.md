# Chain of Responsibility — Job Application Review

## Overview

This example demonstrates the **Chain of Responsibility Design Pattern** using a job application review system.

The project contains **two different scenarios**, implemented in separate packages:

```text
JobApplication/
├── FirstScenario/
└── SecondScenario/
```

Both scenarios use the same core idea: a request is passed through a chain of handlers. However, they demonstrate two different behaviors:

- **FirstScenario** → the request passes through **all handlers**.
- **SecondScenario** → the request stops when the **first responsible handler** processes it.

---

# What Problem Does Chain of Responsibility Solve?

Imagine a recruitment system where different departments may process a job application.

For example:

- **HR** handles `Product Management` and `Sales`.
- **Tech** handles `AI Engineer` and `Backend Engineer`.

Without this pattern, the client could become responsible for deciding which department should process the application using large `if/else` or `switch` statements.

Chain of Responsibility moves this responsibility into a chain of independent handlers.

```text
Client
  |
  v
First Handler
  |
  v
Next Handler
  |
  v
Next Handler
```

The client only needs to start the chain.

---

# Common Structure

Both scenarios share the same fundamental structure.

```text
                    BaseHandler
                         |
              +----------+----------+
              |                     |
              v                     v
          HRHandler             TechHandler
              |                     |
              +------ next ---------+

                       ^
                       |
                 JobApplication
                    Request

                       ^
                       |
                    Program
                    Client
```

| Component | Role |
|---|---|
| `JobApplication` | Request |
| `BaseHandler` | Handler |
| `HRHandler` | Concrete Handler |
| `TechHandler` | Concrete Handler |
| `Program` | Client |
| `nextHandler` | Link to the next handler |

---

# FirstScenario — All Handlers Process the Request

## Concept

In `FirstScenario`, the request passes through **all handlers in the chain**.

Each handler can inspect and modify the request. After processing, it passes the request to the next handler.

```text
Request
   |
   v
HRHandler
   |
   | Process / Modify
   v
TechHandler
   |
   | Process / Modify
   v
Next Handler
   |
   v
Final Response
```

The important rule is:

> **Processing the request does not stop the chain.**

## Example

For a job application, HR checks whether it is responsible for `Product Management` or `Sales`. Tech checks whether it is responsible for `AI Engineer` or `Backend Engineer`.

Even when a handler processes the request, it still forwards it to the next handler.

This makes the chain behave like a **processing pipeline**, where multiple stages can contribute to the final result.

### Flow

```text
JobApplication
      |
      v
  HRHandler
      |
      | Process / Check
      v
 TechHandler
      |
      | Process / Check
      v
 Next Handler
      |
      v
Final Response
```

---

# SecondScenario — First Responsible Handler Processes the Request

## Concept

In `SecondScenario`, the request passes through the chain until a handler is able to process it.

Once a handler successfully handles the request, the chain stops.

```text
Request
   |
   v
HRHandler
   |
   | Cannot handle
   v
TechHandler
   |
   | Can handle
   v
Handle Request
   |
  STOP
```

The important rule is:

> **A handler either handles the request or forwards it to the next handler.**

## Example

Suppose the job title is:

```text
Backend Engineer
```

### Step 1 — HR Handler

HR checks:

```text
Product Management
Sales
```

The job does not match, so HR forwards the request.

```text
HRHandler → TechHandler
```

### Step 2 — Tech Handler

Tech checks:

```text
AI Engineer
Backend Engineer
```

The job matches, so Tech handles the request and stops the chain.

```java
return;
```

### Flow

```text
JobApplication
      |
      v
  HRHandler
      |
      | Cannot handle
      v
 TechHandler
      |
      | Can handle
      v
 Managed by Tech
      |
     STOP
```

---

# The Key Difference

The main difference is what happens **after a handler processes the request**.

### FirstScenario

```text
Can process?
     |
    YES
     |
   Process
     |
     v
Next Handler
```

Processing does **not** stop the chain.

### SecondScenario

```text
Can process?
     |
    YES
     |
   Process
     |
    STOP
```

Processing **stops** the chain.

---

# Side-by-Side Comparison

| Feature | FirstScenario | SecondScenario |
|---|---|---|
| Request passes through all handlers | Yes | No |
| Handler can modify request | Yes | Yes |
| Handler forwards after processing | Yes | No |
| Chain stops after successful handling | No | Yes |
| Typical use | Processing pipeline | Responsibility / escalation |
| Core behavior | Process → Forward | Handle → Stop |

---

# Why Have Two Scenarios?

The two scenarios show that Chain of Responsibility can support different processing requirements.

### FirstScenario — Processing Pipeline

```text
Request
   ↓
Validation
   ↓
Authentication
   ↓
Logging
   ↓
Processing
   ↓
Response
```

Every stage can contribute to the request.

### SecondScenario — Responsibility Chain

```text
Request
   ↓
Handler A
   ↓
Handler B
   ↓
Handler C
   ↓
One handler handles it
   ↓
STOP
```

The first handler capable of handling the request takes responsibility for it.

---

# When to Use Chain of Responsibility

Use this pattern when:

- Multiple objects may be involved in processing a request.
- The sender should not be tightly coupled to the receiver.
- Processing logic can be divided into independent handlers.
- The order of handlers can be configured.
- You want to add or remove handlers without heavily modifying the client.

Common examples include:

- Approval workflows
- Authentication and authorization
- Validation pipelines
- HTTP middleware
- Logging pipelines
- Customer support escalation
- Event processing
- Request processing systems

---

# Advantages

- **Loose Coupling** — The client does not need to know which concrete handler processes the request.
- **Single Responsibility** — Each handler can focus on one responsibility.
- **Flexible Chain** — Handlers can be added, removed, or reordered.
- **Extensibility** — New handlers can be introduced without changing the client.
- **Reusable Processing** — The same handler can be used in different chains.

---

# Project Structure

```text
Behavioral/
└── ChainOfResponsibility/
    └── JobApplication/
        ├── BaseHandler.java
        ├── JobApplication.java
        │
        ├── FirstScenario/
        │   ├── HRHandler.java
        │   ├── TechHandler.java
        │   └── Program.java
        │
        └── SecondScenario/
            ├── HRHandler.java
            ├── TechHandler.java
            └── Program.java
```

The shared classes provide the common foundation, while the two packages demonstrate different chain behaviors.

---

# Key Takeaways

### FirstScenario

> **All handlers get the opportunity to process the request.**

```text
Handler → Process → Next
```

### SecondScenario

> **The first handler capable of processing the request handles it and stops the chain.**

```text
Handler → Handle → STOP
```

### General Idea

> **Pass a request along a chain of handlers, allowing each handler to decide how it should process or forward the request according to the application's requirements.**

---

# Learning Goal

This example was implemented to understand the **Chain of Responsibility Pattern through practice**, rather than memorizing its definition.

The two scenarios demonstrate that the same structural pattern can support different processing behaviors:

1. **FirstScenario** — all handlers participate in processing.
2. **SecondScenario** — processing stops at the first responsible handler.

Understanding this distinction makes it easier to recognize when Chain of Responsibility is appropriate in real-world software systems.
