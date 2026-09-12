# Template Method Pattern

## Overview

The **Template Method Pattern** is a **Behavioral Design Pattern** that defines the skeleton of an algorithm in a base class while allowing subclasses to customize specific steps.

**Key idea:** Fix the algorithm structure, but let subclasses customize some steps.

## The Problem

Suppose several classes perform the same overall process, but some steps differ.

For example, every pizza must be:

1. Prepare the dough
2. Add sauce
3. Add toppings
4. Bake

The order should stay fixed, but different pizzas can implement the individual steps differently.

Without Template Method, each class may duplicate the whole algorithm.

## The Solution

An abstract base class contains the common algorithm. The algorithm is the **Template Method**, while variable steps are methods that subclasses implement or override.

```java
abstract class PizzaMaker {

    public final void makePizza() {
        prepareDough();
        addSauce();
        addToppings();
        bake();
    }

    protected abstract void prepareDough();
    protected abstract void addSauce();
    protected abstract void addToppings();

    protected void bake() {
        System.out.println("Bake pizza for 15 minutes");
    }
}
```

`makePizza()` is the Template Method because it defines the fixed sequence.

```text
makePizza()
    ↓
prepareDough()
    ↓
addSauce()
    ↓
addToppings()
    ↓
bake()
```

## Main Components

### Abstract Class
Contains the template method and common behavior.

### Template Method
Defines the fixed sequence of the algorithm. It is commonly `final` so subclasses cannot change the algorithm structure.

### Variable Steps
Methods that subclasses customize. They can be abstract methods or optional hook methods.

### Concrete Classes
Provide the implementation for the variable steps.

## When to Use It

Use Template Method when:

- Multiple classes follow the same algorithm structure.
- The order of operations must remain fixed.
- Some steps need different implementations.
- You want to avoid duplicated algorithms.
- You want subclasses to customize specific steps.

## Template Method vs Strategy

**Template Method:**

```text
Base Class
    ↓
Fixed Algorithm
    ↓
Subclass Customizes Steps
```

**Strategy:**

```text
Context
   ↓
Strategy
 ├── Strategy A
 ├── Strategy B
 └── Strategy C
```

Memory trick:

> **Template Method → Same algorithm, different steps**

> **Strategy → Choose between different algorithms**

## Key Takeaway

The Template Method Pattern defines the skeleton of an algorithm in a base class and lets subclasses redefine specific steps without changing the algorithm's overall structure.
