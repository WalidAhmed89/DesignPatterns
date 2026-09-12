# Visitor Pattern

## Overview

The **Visitor Pattern** is a **Behavioral Design Pattern** that separates an operation from the objects on which that operation is performed.

### Key Idea

> **Add new operations without modifying the element classes.**

It is useful when we have a relatively stable set of object types, but expect to add different operations over those objects.

---

## The Problem

Imagine a system containing different types of buildings:

```text
House
Factory
Hospital
Shop
```

Now the system needs different operations:

```text
Calculate Tax
Calculate Insurance
Generate Report
Calculate Maintenance Cost
```

Putting every operation directly inside every building class can make those classes large and difficult to maintain.

The Visitor Pattern moves the operation logic into separate Visitor classes.

---

## The Solution

Each element provides an:

```java
accept(Visitor visitor)
```

method.

The Visitor provides a `visit()` method for each supported element type.

```text
Elements
 ├── House
 ├── Factory
 └── Hospital

Visitors
 ├── TaxVisitor
 ├── InsuranceVisitor
 └── ReportVisitor
```

The element accepts the Visitor, and the Visitor performs the appropriate operation.

---

## Main Roles

### 1. Visitor

Defines operations for each concrete element type.

```java
interface Visitor {
    void visit(House house);
    void visit(Factory factory);
}
```

### 2. Concrete Visitor

Implements a particular operation.

Examples:

```text
TaxVisitor
InsuranceVisitor
ReportVisitor
```

### 3. Element

Defines:

```java
accept(Visitor visitor)
```

### 4. Concrete Element

Represents the actual objects being visited:

```text
House
Factory
Hospital
```

### 5. Client

Creates the elements and Visitor and starts the operation.

---

## Double Dispatch

Visitor commonly uses **Double Dispatch**.

For example:

```java
house.accept(taxVisitor);
```

Inside `House`:

```java
visitor.visit(this);
```

Because `this` is a `House`, Java selects:

```java
visit(House house)
```

For a factory:

```java
factory.accept(taxVisitor);
```

results in:

```java
visit(Factory factory)
```

This allows the Visitor to perform type-specific behavior without using `instanceof`.

---

## Why Use Visitor?

Use Visitor when:

- The element types are relatively stable.
- Many different operations need to be performed on those elements.
- You want to keep operation logic separate from the element classes.
- Adding a new operation should not require changing every element class.

---

## Important Trade-Off

Visitor makes adding **new operations easy**, but adding **new element types harder**.

For example:

```text
Add TaxVisitor
→ Easy

Add InsuranceVisitor
→ Easy

Add School element
→ More work
```

Adding a new element such as `School` requires adding:

```java
void visit(School school);
```

to the Visitor interface and implementing it in Concrete Visitors.

Therefore, Visitor is most useful when:

```text
Elements    → relatively stable
Operations  → frequently changing
```

---

## Visitor vs Strategy

### Strategy

> **Which algorithm should I use?**

Strategy encapsulates interchangeable algorithms.

### Visitor

> **Which operation should I perform on these different element types?**

Visitor separates operations from the elements.

---

## Visitor vs Mediator

```text
Mediator
→ Centralizes communication between objects.

Visitor
→ Separates operations from object structures.
```

---

## Visitor and OCP

Visitor can make it easier to add a **new operation** without modifying the existing element classes.

However, Visitor is not automatically the best SOLID solution in every situation. It intentionally makes adding new element types more expensive.

---

## Memory Trick

> **Visitor = ADD NEW OPERATIONS WITHOUT MODIFYING THE ELEMENTS.**

Another useful phrase:

> **Visit different object types and perform type-specific operations.**

---

## Interview Definition

> **The Visitor Pattern is a behavioral design pattern that separates operations from the objects on which they operate, allowing new operations to be added without modifying the element classes.**
