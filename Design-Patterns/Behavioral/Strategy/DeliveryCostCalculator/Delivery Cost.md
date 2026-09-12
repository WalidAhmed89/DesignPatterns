# Strategy Pattern — Delivery Cost Calculator

## Problem

A delivery application needs to calculate delivery cost using different pricing algorithms:

- Standard Delivery
- Express Delivery
- Same-Day Delivery

The algorithm should be changeable at runtime.

A bad design would put all pricing rules inside `DeliveryCalculator` using `if/else` or `switch`.

## Solution

Use the **Strategy Pattern**.

Each delivery pricing algorithm becomes a separate Strategy.

```text
                         DeliveryCalculator
                              Context
                                 |
                                 v
                         DeliveryStrategy
                           /     |      \
                          /      |       \
                         v       v        v
                    Standard  Express  SameDay
                    Strategy  Strategy  Strategy
```

## Requirements

Create:

```text
DeliveryStrategy
StandardDeliveryStrategy
ExpressDeliveryStrategy
SameDayDeliveryStrategy
DeliveryCalculator
Program
```

### 1. Strategy Interface

```java
public interface DeliveryStrategy {
    double calculateCost(double distance);
}
```

### 2. Concrete Strategies

#### StandardDeliveryStrategy

```text
distance × 5
```

For 10 km:

```text
50
```

#### ExpressDeliveryStrategy

```text
distance × 8 + 30
```

For 10 km:

```text
110
```

#### SameDayDeliveryStrategy

```text
distance × 12 + 50
```

For 10 km:

```text
170
```

Each class must implement `DeliveryStrategy`.

### 3. Context

Create:

```java
public class DeliveryCalculator
```

It should:

- Store the current `DeliveryStrategy`.
- Allow changing the Strategy.
- Calculate delivery cost using the selected Strategy.

Required methods:

```java
setStrategy(DeliveryStrategy strategy)
calculateCost(double distance)
```

The Context must **not** contain the pricing algorithms.

### 4. Program

Test:

```java
DeliveryCalculator calculator = new DeliveryCalculator();

calculator.setStrategy(new StandardDeliveryStrategy());
System.out.println(calculator.calculateCost(10));

calculator.setStrategy(new ExpressDeliveryStrategy());
System.out.println(calculator.calculateCost(10));

calculator.setStrategy(new SameDayDeliveryStrategy());
System.out.println(calculator.calculateCost(10));
```

Expected output:

```text
50.0
110.0
170.0
```

## Constraints

Do not use:

- `if/else` to select the delivery algorithm.
- `switch` to select the delivery algorithm.
- `instanceof`.
- A String such as `"STANDARD"` or `"EXPRESS"` inside the Context to determine the algorithm.

The Context should work only with:

```java
DeliveryStrategy
```

## Pattern Roles

| Role | Class |
|---|---|
| Strategy | `DeliveryStrategy` |
| Concrete Strategy | `StandardDeliveryStrategy` |
| Concrete Strategy | `ExpressDeliveryStrategy` |
| Concrete Strategy | `SameDayDeliveryStrategy` |
| Context | `DeliveryCalculator` |
| Client | `Program` |

## Main Concept

The Context does not know how each algorithm calculates the cost.

It only delegates:

```java
strategy.calculateCost(distance);
```

The selected Strategy decides how the calculation is performed.

## Bonus

Add:

```text
FreeDeliveryStrategy
```

with:

```text
distance × 0
```

Then use it without modifying `DeliveryCalculator`.

This demonstrates the **Open/Closed Principle**.
