# Chain of Responsibility — Job Application Review

## Overview

This example demonstrates the **Chain of Responsibility Design Pattern** using a job application review workflow.

A `JobApplication` is passed through a chain of handlers. Each handler checks whether it is responsible for the application's job title:

- If the handler can process the request, it handles it and stops the chain.
- If it cannot process the request, it forwards the request to the next handler.

---

## Problem

Imagine a recruitment system where different departments are responsible for different job applications.

- **HR** handles `Product Management` and `Sales`.
- **Tech** handles `Backend Engineer`, `Software Engineer`, and `AI Engineer`.

Without Chain of Responsibility, the client might contain a large `if/else` or `switch` statement to decide which department should process the application.

This creates unnecessary coupling between the client and the concrete handlers.

---

## Solution

Chain of Responsibility creates a chain of handlers.

Each handler:

1. Checks whether it can handle the request.
2. Handles the request and stops the chain if it can.
3. Otherwise, forwards the request to the next handler.

```text
Client
  |
  v
HRHandler
  |
  | cannot handle
  v
TechHandler
  |
  | can handle
  v
Handle Request
  |
 STOP
```

---

## Pattern Structure

### Request

`JobApplication`

Contains the data that travels through the chain.

### Handler

`BaseHandler`

Defines the common structure for all handlers and stores a reference to the next handler.

### Concrete Handlers

- `HRHandler`
- `TechHandler`

Each handler contains its own responsibility and decides whether it can handle the request.

### Client

`Program`

Builds the chain and sends the request to the first handler.

---

## Class Structure

```text
                 BaseHandler
                     |
          +----------+----------+
          |                     |
          v                     v
      HRHandler            TechHandler
          |                     |
          +------ next ---------+

JobApplication
      ^
      |
   Request

Program
  |
  +--> HRHandler
```

---

## Example

The application contains:

```java
JobApplication jobApplication =
    new JobApplication(
        "Walid Ahmed",
        "Backend Engineer",
        "9543532",
        new StringBuilder()
    );
```

The chain is created as:

```java
HRHandler hrHandler = new HRHandler();
TechHandler techHandler = new TechHandler();

hrHandler.setNext(techHandler);
```

The client starts the chain:

```java
hrHandler.handelRequest(jobApplication);
```

---

## How It Works

The job title is:

```text
Backend Engineer
```

### Step 1 — HR Handler

`HRHandler` checks whether the job title is:

```text
Product Management
Sales
```

The answer is **No**, so HR forwards the request to the next handler.

```text
HRHandler → TechHandler
```

### Step 2 — Tech Handler

`TechHandler` checks whether the job title is:

```text
Backend Engineer
Software Engineer
AI Engineer
```

The answer is **Yes**, so Tech handles the request.

```text
Managed by Tech
```

Then it executes `return`, which stops the chain.

---

## Request Flow

For a `Backend Engineer` application:

```text
JobApplication
      |
      v
  HRHandler
      |
      | Not responsible
      v
 TechHandler
      |
      | Responsible
      v
 Managed by Tech
      |
     STOP
```

---

## Why `return` Is Important

When a handler successfully processes the request, the chain should stop.

```java
if (request.getJobTitle().equals("Backend Engineer")) {
    request.getComments().append("Managed by Tech\n");
    return;
}
```

The `return` prevents the request from continuing to another handler after it has already been handled.

The core rule is:

> **Handle the request OR pass it to the next handler.**

---

## Advantages

- Reduces coupling between the client and concrete handlers.
- Each handler contains its own responsibility.
- New handlers can be added without changing the client.
- The order of handlers can be changed easily.
- A request can stop as soon as an appropriate handler processes it.

---

## When to Use

Use Chain of Responsibility when:

- Multiple objects may be able to handle a request.
- The appropriate handler is not known by the client.
- You want to avoid large `if/else` or `switch` blocks.
- You want handlers to be independently configurable.
- The request should move through a sequence of possible handlers.

Common examples include:

- Approval workflows
- Authentication and authorization pipelines
- Validation pipelines
- Customer support escalation
- HTTP middleware
- Request processing pipelines

---

## Key Takeaways

| Concept | Implementation |
|---|---|
| Request | `JobApplication` |
| Handler | `BaseHandler` |
| Concrete Handlers | `HRHandler`, `TechHandler` |
| Next Handler | `nextHandler` |
| Client | `Program` |
| Handle | Process the request |
| Forward | Call `nextHandler.handelRequest()` |
| Stop | `return` |

The main idea:

```text
Can I handle this request?
        |
   +----+----+
   |         |
  YES        NO
   |         |
 Handle      Next Handler
   |
 STOP
```

---

## Learning Goal

This example is designed to build a practical understanding of the **Chain of Responsibility** pattern rather than memorizing its definition.

The important concept is recognizing the design problem:

> **Several handlers may be responsible for a request, and the request should be passed through the chain until an appropriate handler handles it.**
