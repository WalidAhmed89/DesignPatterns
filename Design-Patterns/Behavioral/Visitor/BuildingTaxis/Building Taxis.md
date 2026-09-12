# Visitor Pattern — Building Tax Calculation Example

## Overview

This example demonstrates the **Visitor Pattern** using a company that manages different types of buildings.

The buildings are:

```text
House
Factory
Hospital
```

The company wants to calculate the tax for each building.

Instead of putting tax calculation logic inside every building class, we create a separate:

```text
TaxVisitor
```

The buildings only know how to accept a Visitor.

---

## Class Structure

```text
                    Visitor
                       |
                 TaxVisitor
                /     |      \
               /      |       \
          visit()   visit()   visit()
             |         |         |
           House    Factory   Hospital
             \         |         /
              \        |        /
                   accept()
```

### Roles

| Class | Role |
|---|---|
| `Building` | Element |
| `House` | Concrete Element |
| `Factory` | Concrete Element |
| `Hospital` | Concrete Element |
| `Visitor` | Visitor |
| `TaxVisitor` | Concrete Visitor |
| `Program` | Client |

---

## 1. Visitor Interface

The Visitor defines an operation for each concrete element type.

```java
public interface Visitor {

    void visit(House house);

    void visit(Factory factory);

    void visit(Hospital hospital);
}
```

The Visitor knows about the different element types.

---

## 2. Element Interface

Every building must accept a Visitor.

```java
public interface Building {

    void accept(Visitor visitor);
}
```

---

## 3. House

```java
public class House implements Building {

    private final double value;

    public House(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
```

The important line is:

```java
visitor.visit(this);
```

Because `this` is a `House`, Java selects:

```java
visit(House house)
```

---

## 4. Factory

```java
public class Factory implements Building {

    private final double value;

    public Factory(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
```

Here, `this` is a `Factory`, so Java calls:

```java
visit(Factory factory)
```

---

## 5. Hospital

```java
public class Hospital implements Building {

    private final double value;

    public Hospital(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
```

---

## 6. TaxVisitor

The `TaxVisitor` contains the tax calculation logic.

```java
public class TaxVisitor implements Visitor {

    @Override
    public void visit(House house) {
        double tax = house.getValue() * 0.05;
        System.out.println("House tax: " + tax);
    }

    @Override
    public void visit(Factory factory) {
        double tax = factory.getValue() * 0.10;
        System.out.println("Factory tax: " + tax);
    }

    @Override
    public void visit(Hospital hospital) {
        double tax = hospital.getValue() * 0.03;
        System.out.println("Hospital tax: " + tax);
    }
}
```

The tax rules are completely outside:

```text
House
Factory
Hospital
```

The building classes contain their own data and the `accept()` method, while `TaxVisitor` contains the tax operation.

---

## 7. Client

```java
public class Program {

    public static void main(String[] args) {

        Building house = new House(100000);
        Building factory = new Factory(500000);
        Building hospital = new Hospital(300000);

        Visitor taxVisitor = new TaxVisitor();

        house.accept(taxVisitor);
        factory.accept(taxVisitor);
        hospital.accept(taxVisitor);
    }
}
```

---

## Expected Output

```text
House tax: 5000.0
Factory tax: 50000.0
Hospital tax: 9000.0
```

---

## How the Visitor Works

When we call:

```java
house.accept(taxVisitor);
```

the call enters:

```java
House.accept()
```

which contains:

```java
visitor.visit(this);
```

Since `this` is a `House`, Java selects:

```java
TaxVisitor.visit(House house)
```

### House Flow

```text
Program
   ↓
House.accept(taxVisitor)
   ↓
TaxVisitor.visit(House)
   ↓
Calculate House Tax
```

### Factory Flow

```text
Program
   ↓
Factory.accept(taxVisitor)
   ↓
TaxVisitor.visit(Factory)
   ↓
Calculate Factory Tax
```

### Hospital Flow

```text
Program
   ↓
Hospital.accept(taxVisitor)
   ↓
TaxVisitor.visit(Hospital)
   ↓
Calculate Hospital Tax
```

---

## Why Not Put Tax Inside the Buildings?

Without Visitor, we could put:

```java
class House {
    calculateTax();
}
```

and:

```java
class Factory {
    calculateTax();
}
```

But later we might need:

```text
calculateTax()
calculateInsurance()
generateReport()
calculateMaintenanceCost()
```

Every building class would keep growing.

With Visitor:

```text
Building classes
    ↓
Keep their own data
    ↓
accept(visitor)

TaxVisitor
    ↓
Tax logic

InsuranceVisitor
    ↓
Insurance logic

ReportVisitor
    ↓
Report logic
```

Operations stay separated from the elements.

---

## Adding a New Operation

Suppose we want an insurance calculation.

We can create:

```java
public class InsuranceVisitor implements Visitor {

    @Override
    public void visit(House house) {
        System.out.println("Calculating house insurance...");
    }

    @Override
    public void visit(Factory factory) {
        System.out.println("Calculating factory insurance...");
    }

    @Override
    public void visit(Hospital hospital) {
        System.out.println("Calculating hospital insurance...");
    }
}
```

The existing building classes do not need insurance calculation logic.

This is one of the main strengths of Visitor.

---

## The Trade-Off

Visitor makes adding **new operations** easy:

```text
+ TaxVisitor
+ InsuranceVisitor
+ ReportVisitor
```

But adding a **new element type** requires changes to the Visitor interface and Concrete Visitors.

For example, adding:

```text
School
```

requires:

```java
void visit(School school);
```

and implementations of that method in the Visitors.

So Visitor is a good fit when:

```text
Elements    → relatively stable
Operations  → frequently changing
```

---

## Key Takeaway

The core flow is:

```text
Elements
   ↓
accept(visitor)
   ↓
Visitor
   ↓
Perform operation for the concrete element
```

The element does not contain the operation logic.

The Visitor performs the operation for the specific element type.

### Memory Trick

**Visitor = ADD NEW OPERATIONS WITHOUT MODIFYING THE ELEMENTS.**

### Interview Definition

> **The Visitor Pattern is a behavioral design pattern that separates operations from the objects on which they operate, allowing new operations to be added without modifying the element classes.**

---

## Learning Goal

This example demonstrates:

- Visitor interface
- Concrete Visitor
- Element interface
- Concrete Elements
- `accept()` / `visit()`
- Double Dispatch
- Polymorphism
- Separation of operations from elements
- Adding operations without modifying element classes
