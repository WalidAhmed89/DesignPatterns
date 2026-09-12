# Template Method — Pizza Making Example

## Overview

This example demonstrates the **Template Method Pattern** using a pizza-making process.

Different pizzas follow the same process:

1. Prepare the dough
2. Add sauce
3. Add toppings
4. Bake

The sequence is fixed, while some individual steps differ.

## Class Structure

```text
                    PizzaMaker
                        |
              ---------------------
              |                   |
        ChickenPizza         CheesePizza
```

| Class | Role |
|---|---|
| `PizzaMaker` | Abstract Class |
| `makePizza()` | Template Method |
| `prepareDough()` | Variable Step |
| `addSauce()` | Variable Step |
| `addToppings()` | Variable Step |
| `bake()` | Common Step |
| `ChickenPizza` | Concrete Class |
| `CheesePizza` | Concrete Class |

## 1. Abstract Class

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

`makePizza()` controls the entire algorithm and its order.

The method is `final`, so subclasses cannot change that order.

## 2. ChickenPizza

```java
class ChickenPizza extends PizzaMaker {

    @Override
    protected void prepareDough() {
        System.out.println("Prepare normal dough");
    }

    @Override
    protected void addSauce() {
        System.out.println("Add tomato sauce");
    }

    @Override
    protected void addToppings() {
        System.out.println("Add chicken and mushrooms");
    }
}
```

## 3. CheesePizza

```java
class CheesePizza extends PizzaMaker {

    @Override
    protected void prepareDough() {
        System.out.println("Prepare thin dough");
    }

    @Override
    protected void addSauce() {
        System.out.println("Add cheese sauce");
    }

    @Override
    protected void addToppings() {
        System.out.println("Add mozzarella");
    }
}
```

## 4. Client

```java
public class Program {

    public static void main(String[] args) {

        PizzaMaker chickenPizza = new ChickenPizza();
        chickenPizza.makePizza();

        System.out.println("----------------");

        PizzaMaker cheesePizza = new CheesePizza();
        cheesePizza.makePizza();
    }
}
```

## Expected Output

```text
Prepare normal dough
Add tomato sauce
Add chicken and mushrooms
Bake pizza for 15 minutes
----------------
Prepare thin dough
Add cheese sauce
Add mozzarella
Bake pizza for 15 minutes
```

## How It Works

When the client calls:

```java
chickenPizza.makePizza();
```

the parent class controls the algorithm:

```text
1. prepareDough()
2. addSauce()
3. addToppings()
4. bake()
```

Because the actual object is `ChickenPizza`, Java polymorphism calls the overridden methods from `ChickenPizza`.

```text
PizzaMaker.makePizza()
        |
        +--> ChickenPizza.prepareDough()
        |
        +--> ChickenPizza.addSauce()
        |
        +--> ChickenPizza.addToppings()
        |
        +--> PizzaMaker.bake()
```

For `CheesePizza`, the same algorithm executes, but the customized steps come from `CheesePizza`.

## Why This Is Template Method

The **algorithm is fixed**:

```text
Prepare → Sauce → Toppings → Bake
```

But **some steps are customizable**:

```text
ChickenPizza:
    Chicken + Mushrooms

CheesePizza:
    Mozzarella
```

This avoids duplicating the complete `makePizza()` algorithm in every class.

## Why `final`?

```java
public final void makePizza()
```

prevents subclasses from overriding the template method and changing the algorithm structure.

The base class remains responsible for controlling the sequence.

## Interview Explanation

> **Template Method is a behavioral design pattern that defines the skeleton of an algorithm in a base class and lets subclasses customize specific steps without changing the overall algorithm structure.**

### Memory Trick

**Template Method = FIX THE ALGORITHM, CUSTOMIZE THE STEPS.**

## Learning Goal

This example demonstrates:

- Abstract classes
- Method overriding
- Polymorphism
- `final` template methods
- Abstract operations
- Common algorithm structure
- Code reuse
- Behavioral customization
