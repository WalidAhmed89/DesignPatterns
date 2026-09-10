# Interpreter Pattern — Explanation

## Overview

The **Interpreter Design Pattern** is a Behavioral Design Pattern used when a system needs to **interpret expressions written in a language with a defined grammar**.

The pattern represents the rules of that language using objects and provides a way to interpret or evaluate those expressions.

### Simple Definition

> **Interpreter Pattern represents the grammar of a language using objects and interprets expressions according to that grammar.**

## Main Idea

Imagine a small language with expressions such as:

```text
10 + 5
10 - 3
```

The system needs to understand what these expressions mean and calculate their result.

Instead of putting all interpretation logic inside the Client, the language is represented using Expression objects.

```text
Expression
    ↓
Grammar Rules
    ↓
interpret()
    ↓
Result
```

## What Problem Does It Solve?

Without the Interpreter Pattern, the Client might need to understand the syntax and rules of the language itself.

As the language grows, this logic becomes harder to maintain. The Interpreter Pattern moves language rules into dedicated objects.

## Core Components

### Abstract Expression

Defines the common operation:

```java
public interface Expression {
    int interpret();
}
```

### Terminal Expression

Represents a basic value that does not need to be broken down further.

Example:

```text
10
5
3
```

### Non-Terminal Expression

Represents a grammar rule that combines other expressions.

Examples:

```text
10 + 5
10 - 3
```

## Expression Tree

Expressions can form a tree:

```text
          SubtractExpression
             /          \
   AddExpression           3
      /    \
     10     5
```

Each node knows how to interpret itself.

## When to Use

Use Interpreter when:

- You have a simple language or DSL.
- You have a well-defined grammar.
- Expressions need to be interpreted or evaluated.
- You want grammar rules represented as objects.

Examples include simple mathematical expressions, rule engines, configuration expressions, query-like mini languages, and simple scripting languages.

## SQL Example

SQL is a language with grammar:

```text
SQL Query
    ↓
Parsing
    ↓
Syntax / Expression Tree
    ↓
Evaluation / Execution
    ↓
Database
```

However, a complete SQL engine is much more complex than a typical GoF Interpreter example. The pattern is generally more suitable for **small languages or DSLs**.

## Interpreter vs Adapter

### Adapter

Translates an **incompatible interface**:

```text
Client
  ↓
Adapter
  ↓
Existing Class
```

**Adapter → Interface Translation**

### Interpreter

Understands and evaluates a **language/expression**:

```text
Expression
    ↓
Grammar
    ↓
interpret()
    ↓
Result
```

**Interpreter → Language / Grammar**

## Interpreter vs Command

```text
Command      → ACTION / REQUEST
Interpreter  → LANGUAGE / EXPRESSION
```

Command uses `execute()` to perform a request.

Interpreter uses `interpret()` to evaluate an expression according to grammar.

## Key Takeaway

The Interpreter Pattern is **not simply a mediator between the Client and another system**.

Its core purpose is:

> **To represent the grammar of a language using objects and interpret expressions according to that grammar.**

### Memory Trick

```text
Interpreter
     ↓
LANGUAGE
     ↓
GRAMMAR
     ↓
EXPRESSION
     ↓
interpret()
```

**Interpreter = Understand and evaluate a language according to its grammar.**
