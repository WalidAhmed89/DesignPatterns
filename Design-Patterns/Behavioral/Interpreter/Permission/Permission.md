# Interpreter Pattern — Permission Expression Example

## Overview

This example demonstrates the **Interpreter Design Pattern** using a simple permission expression language.

The system evaluates expressions such as:

- `ADMIN AND USER`
- `ADMIN AND MANAGER`
- `ADMIN OR MANAGER`
- `NOT GUEST`
- `ADMIN AND (USER OR MANAGER)`

The example uses an **Expression Tree** where each expression knows how to interpret itself.

## Problem

We need to evaluate permission expressions for a user without putting all interpretation logic inside the client.

For example:

```text
ADMIN AND (USER OR MANAGER)
```

## Solution

The Interpreter Pattern represents a language's grammar using objects.

```java
public interface Expression {
    boolean interpreter();
}
```

Expressions can be combined into an **Expression Tree** and evaluated recursively.

## Pattern Structure

```text
Expression
├── PermissionExpression
├── AndExpression
├── OrExpression
└── NotExpression
```

| Role | Class | Responsibility |
|---|---|---|
| Abstract Expression | `Expression` | Defines the interpretation operation |
| Terminal Expression | `PermissionExpression` | Checks whether a permission exists |
| Non-Terminal Expression | `AndExpression` | Evaluates AND logic |
| Non-Terminal Expression | `OrExpression` | Evaluates OR logic |
| Non-Terminal Expression | `NotExpression` | Negates another expression |
| Client | `Program` | Builds and evaluates the expression tree |

## PermissionExpression

`PermissionExpression` represents a single permission.

The current user has:

```java
Set.of("ADMIN", "USER")
```

It checks whether the requested permission exists:

```java
return userPermissions.contains(context);
```

Therefore:

```text
ADMIN   → true
USER    → true
MANAGER → false
GUEST   → false
```

This is the **Terminal Expression** because it does not contain another expression.

## AndExpression

`AndExpression` contains two `Expression` objects and recursively evaluates both:

```java
return firstExpression.interpreter()
        && secondExpression.interpreter();
```

Both expressions must be `true`.

## OrExpression

`OrExpression` contains two expressions:

```java
return firstExpression.interpreter()
        || secondExpression.interpreter();
```

At least one expression must be `true`.

## NotExpression

`NotExpression` contains one expression and reverses its result:

```java
return !expression.interpreter();
```

For example:

```text
NOT GUEST
false → true
```

## Expression Tree

The example evaluates:

```text
ADMIN AND (USER OR MANAGER)
```

The tree is:

```text
              AND
             /   \
          ADMIN   OR
                 /  \
              USER  MANAGER
```

Each node implements the same `Expression` interface, allowing recursive evaluation.

## Execution Flow

The client creates the permission expressions:

```java
PermissionExpression firstPermission =
        new PermissionExpression("ADMIN");

PermissionExpression secondPermission =
        new PermissionExpression("USER");

PermissionExpression thirdPermission =
        new PermissionExpression("MANAGER");
```

Then it builds the expression tree:

```java
Expression expression =
        new AndExpression(
                firstPermission,
                new OrExpression(secondPermission, thirdPermission)
        );
```

Finally:

```java
System.out.println(expression.interpreter());
```

### Evaluation

```text
ADMIN → true

USER → true
MANAGER → false

USER OR MANAGER
true OR false
     ↓
   true

ADMIN AND true
true AND true
     ↓
   true
```

Final result:

```text
true
```

## Why This Is Interpreter

The program represents a small language:

```text
Expression =
    Permission
    OR Expression AND Expression
    OR Expression OR Expression
    OR NOT Expression
```

The objects represent parts of this grammar, and `interpreter()` evaluates the resulting expression tree.

The client builds the expression rather than manually evaluating every logical operation.

## Interpreter vs Other Behavioral Patterns

| Pattern | Main Idea |
|---|---|
| Command | Encapsulate an **action/request** |
| Observer | Send **notifications** to subscribers |
| Chain of Responsibility | Pass a request through a **chain of handlers** |
| Interpreter | Evaluate a **language/expression** |

Memory rule:

```text
Command      → ACTION
Observer     → NOTIFICATION
Chain        → CHAIN
Interpreter  → LANGUAGE / EXPRESSION
```

## When to Use

Interpreter is useful when:

- You have a small language or grammar.
- Expressions need to be evaluated repeatedly.
- The grammar is relatively simple.
- The grammar can naturally be represented as an object tree.
- You want to add new expression types without changing existing ones.

Examples include:

- Permission expressions
- Boolean rules
- Simple mathematical expressions
- Search/filter expressions
- Configuration rules
- Query languages
- Small domain-specific languages (DSLs)

## Advantages

- Represents grammar using objects.
- Easy to add new expression types.
- Naturally supports recursive expressions.
- Keeps interpretation logic inside the expressions.
- Makes expressions composable.

## Disadvantages

- Large grammars can create many classes.
- Expression trees can become difficult to maintain.
- Complex languages usually require more specialized parsing solutions.

## Project Structure

```text
Behavioral/
└── Interpreter/
    └── Permission/
        ├── Expression.java
        ├── PermissionExpression.java
        ├── AndExpression.java
        ├── OrExpression.java
        ├── NotExpression.java
        └── Program.java
```

## Key Takeaways

1. **Interpreter evaluates expressions according to a grammar.**
2. `Expression` defines the common interpretation operation.
3. `PermissionExpression` is the Terminal Expression.
4. `AndExpression`, `OrExpression`, and `NotExpression` are Non-Terminal Expressions.
5. Expressions can be combined into an **Expression Tree**.
6. Interpretation happens recursively.
7. The Client builds the tree instead of implementing the interpretation logic itself.

## Learning Goal

This example is designed to understand the **structure and mechanics of the Interpreter Pattern**, especially:

- Terminal Expressions
- Non-Terminal Expressions
- Expression Trees
- Recursive interpretation
- Grammar-based object composition

It is a learning example and is not intended to represent a complete production authorization system.
