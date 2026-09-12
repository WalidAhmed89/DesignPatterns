# Visitor Pattern — Building Maintenance Example

## Overview

This example demonstrates the **Visitor Pattern** using a Building Inspection System.

The system contains three building types:

- `House`
- `Factory`
- `Hospital`

A maintenance team needs to calculate maintenance costs for each building type.

Instead of placing the maintenance calculation inside every building class, the operation is moved into a separate `MaintenanceVisitor`.

## Class Structure

```text
Building
 ├── House
 ├── Factory
 └── Hospital
       ↓
    accept()
       ↓
    Visitor
       ↓
MaintenanceVisitor
```

### Roles

| Class | Role |
|---|---|
| `Building` | Element |
| `House` | Concrete Element |
| `Factory` | Concrete Element |
| `Hospital` | Concrete Element |
| `Visitor` | Visitor |
| `MaintenanceVisitor` | Concrete Visitor |
| `Program` | Client |

## Visitor Interface

```java
public interface Visitor {
    void visit(House house);
    void visit(Factory factory);
    void visit(Hospital hospital);
}
```

The Visitor defines an operation for each concrete element type.

## Building Interface

```java
public interface Building {
    void accept(Visitor visitor);
}
```

Each building accepts a Visitor.

## Concrete Elements

Each building stores its own data and delegates the operation to the Visitor.

```java
@Override
public void accept(Visitor visitor) {
    visitor.visit(this);
}
```

For `House`, `this` is a `House`, so the Visitor executes `visit(House house)`.

The same idea applies to `Factory` and `Hospital`.

## MaintenanceVisitor

The maintenance rules are:

```text
House     → area × 5
Factory   → area × 12
Hospital  → area × 8
```

Example implementation:

```java
public class MaintenanceVisitor implements Visitor {

    @Override
    public void visit(House house) {
        double maintenanceCost = house.getArea() * 5;
        System.out.println("House: " + house.getHouseName()
                + "\nMaintenance Cost: " + maintenanceCost);
    }

    @Override
    public void visit(Factory factory) {
        double maintenanceCost = factory.getArea() * 12;
        System.out.println("Factory: " + factory.getFactoryName()
                + "\nMaintenance Cost: " + maintenanceCost);
    }

    @Override
    public void visit(Hospital hospital) {
        double maintenanceCost = hospital.getArea() * 8;
        System.out.println("Hospital: " + hospital.getHospitalName()
                + "\nMaintenance Cost: " + maintenanceCost);
    }
}
```

## Client

```java
Building house = new House("Walid House", 200);
Building factory = new Factory("Tech Factory", 1000);
Building hospital = new Hospital("City Hospital", 500);

Visitor visitor = new MaintenanceVisitor();

house.accept(visitor);
factory.accept(visitor);
hospital.accept(visitor);
```

## Expected Output

```text
House: Walid House
Maintenance Cost: 1000.0

Factory: Tech Factory
Maintenance Cost: 12000.0

Hospital: City Hospital
Maintenance Cost: 4000.0
```

## Double Dispatch

The important flow is:

```text
Program
   ↓
house.accept(visitor)
   ↓
House.accept()
   ↓
visitor.visit(this)
   ↓
MaintenanceVisitor.visit(House)
   ↓
Calculate maintenance cost
```

This allows type-specific behavior without `instanceof` or `if/switch`.

## Why Visitor?

Suppose the system later needs:

```text
Tax
Insurance
Maintenance
Reports
Safety Inspection
```

Instead of adding all these operations to every building class, each operation can be represented by a separate Visitor:

```text
TaxVisitor
InsuranceVisitor
MaintenanceVisitor
ReportVisitor
SafetyInspectionVisitor
```

The existing building classes can remain unchanged.

## Trade-Off

Visitor makes adding **new operations** easy, but adding a **new element type** requires updating the Visitor interface and Concrete Visitors.

Therefore Visitor is a good fit when:

```text
Elements    → relatively stable
Operations  → frequently changing
```

## Key Takeaway

> **Visitor separates operations from the objects on which they operate, allowing new operations to be added without modifying the element classes.**

### Memory Trick

**Visitor = ADD NEW OPERATIONS WITHOUT MODIFYING THE ELEMENTS.**
