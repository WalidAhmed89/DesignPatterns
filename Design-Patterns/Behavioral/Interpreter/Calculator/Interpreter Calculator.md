# Interpreter Pattern — Simple Calculator Example

## Overview

This example demonstrates the **Interpreter Design Pattern** by creating a small mathematical language.

Supported expressions include:

```text
10 + 5
10 - 3
10 + 5 - 3
```

The expressions are represented using Java objects, and each expression provides an `interpret()` method to evaluate itself.

## Problem

If the Client handled parsing and calculation directly, it could become complicated as more operators and grammar rules were added.

The Interpreter Pattern moves these rules into Expression objects.

## Solution

We create an `Expression` abstraction:

```java
public interface Expression {
    int interpret();
}
```

Then create:

```text
Expression
   │
   ├── NumberExpression
   ├── AddExpression
   └── SubtractExpression
```

Each class knows how to interpret its own expression.

## Pattern Structure

```text
                    Expression
                         │
             ┌───────────┼────────────┐
             ↓           ↓            ↓
      NumberExpression AddExpression SubtractExpression
             │             │              │
             │          left/right      left/right
             └─────────────┴──────────────┘
                           ↓
                       interpret()
```

## 1. Abstract Expression

```java
public interface Expression {
    int interpret();
}
```

Every expression in the language implements `interpret()`.

## 2. NumberExpression — Terminal Expression

```java
public class NumberExpression implements Expression {

    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}
```

A `NumberExpression` represents a basic value such as `10`.

## 3. AddExpression — Non-Terminal Expression

```java
public class AddExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}
```

It represents:

```text
Expression + Expression
```

Notice that `left` and `right` are `Expression`, allowing expressions to contain other expressions.

## 4. SubtractExpression — Non-Terminal Expression

```java
public class SubtractExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}
```

It represents:

```text
Expression - Expression
```

## Simple Expression

To represent:

```text
10 + 5
```

we create:

```java
Expression ten = new NumberExpression(10);
Expression five = new NumberExpression(5);

Expression addition =
        new AddExpression(ten, five);

System.out.println(addition.interpret());
```

Output:

```text
15
```

## How It Works

The expression:

```text
10 + 5
```

is represented as:

```text
       AddExpression
          /     \
         10       5
```

Calling:

```java
addition.interpret();
```

causes:

```text
AddExpression.interpret()
          ↓
left.interpret() + right.interpret()
          ↓
10 + 5
          ↓
15
```

## Complex Expression

For:

```text
10 + 5 - 3
```

we build:

```java
Expression ten = new NumberExpression(10);
Expression five = new NumberExpression(5);
Expression three = new NumberExpression(3);

Expression addition =
        new AddExpression(ten, five);

Expression result =
        new SubtractExpression(addition, three);

System.out.println(result.interpret());
```

Output:

```text
12
```

## Expression Tree

The expression becomes:

```text
          SubtractExpression
             /          \
   AddExpression           3
      /    \
     10     5
```

Evaluation happens from the bottom upward:

```text
10 + 5
  ↓
15

15 - 3
  ↓
12
```

## Complete Execution Flow

```text
Program
   ↓
Create Expression Objects
   ↓
Build Expression Tree
   ↓
result.interpret()
   ↓
SubtractExpression
   ↓
AddExpression
   ↓
NumberExpression
   ↓
12
```

## Roles in This Example

| Interpreter Pattern Role | Class |
|---|---|
| Abstract Expression | `Expression` |
| Terminal Expression | `NumberExpression` |
| Non-Terminal Expression | `AddExpression` |
| Non-Terminal Expression | `SubtractExpression` |
| Client | `Program` |

## Grammar

The simple language can be described conceptually as:

```text
Expression = Number
           | Expression + Expression
           | Expression - Expression
```

The Java classes represent these grammar rules:

```text
Number
   ↓
NumberExpression

Expression + Expression
   ↓
AddExpression

Expression - Expression
   ↓
SubtractExpression
```

## Why This Is Interpreter Pattern

The important part is not simply that the program performs arithmetic.

The important points are:

1. The language has grammar rules.
2. Grammar rules are represented using objects.
3. Expressions share a common `Expression` abstraction.
4. Each expression implements `interpret()`.
5. Expressions can be combined into an expression tree.
6. The Client builds the expression and asks it to interpret itself.

## When to Use

This approach is useful for:

- Simple mathematical expression languages.
- Small DSLs.
- Rule engines.
- Query-like mini languages.
- Configuration expressions.
- Systems where expressions naturally form a tree.

For large languages such as full SQL, a dedicated parser and more advanced architecture are normally required.

## Project Structure

```text
Behavioral/
└── Interpreter/
    └── Calculator/
        ├── Expression.java
        ├── NumberExpression.java
        ├── AddExpression.java
        ├── SubtractExpression.java
        └── Program.java
```

## Key Takeaways

```text
Language
   ↓
Grammar
   ↓
Expression Objects
   ↓
interpret()
   ↓
Result
```

> **Interpreter = LANGUAGE + GRAMMAR + EXPRESSION + INTERPRET**
