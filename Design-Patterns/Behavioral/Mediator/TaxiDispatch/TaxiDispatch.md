# Mediator Pattern — Taxi Dispatch System

## Overview

This example demonstrates the **Mediator Design Pattern** in Java using a Taxi Dispatch System.

The system contains multiple taxi drivers that need to communicate through a central dispatch center.

Instead of allowing drivers to communicate directly with each other, the `TaxiDispatchCenter` acts as the mediator and coordinates the communication.

---

## Problem

Imagine several taxi drivers in the same system:

```text
Driver A ↔ Driver B
Driver A ↔ Driver C
Driver B ↔ Driver C
```

If every driver communicates directly with the others, the system becomes tightly coupled.

Adding a new driver can also increase the number of relationships between objects.

---

## Solution

Introduce a central Mediator:

```text
Driver A ──┐
Driver B ──┤
Driver C ──┼──→ TaxiDispatchCenter
Driver D ──┘
```

Each driver communicates with the dispatch center instead of directly communicating with other drivers.

This reduces direct coupling between the drivers.

---

# Pattern Structure

```text
                 TaxiMediator
                      ↑
                      |
             TaxiDispatchCenter
                /      |                     /       |               TaxiDriver TaxiDriver TaxiDriver
```

## Pattern Roles

| Pattern Role | Implementation |
|---|---|
| Mediator | `TaxiMediator` |
| Concrete Mediator | `TaxiDispatchCenter` |
| Colleague | `TaxiDriver` |
| Client | `Program` |

---

# 1. TaxiMediator

`TaxiMediator` defines the communication contract between the drivers and the dispatch center.

```java
public interface TaxiMediator {

    void requestRide(TaxiDriver driver, String location);

    void sendMessage(TaxiDriver driver, String message);
}
```

The important point is that `TaxiDriver` depends on the **Mediator abstraction**, not on other drivers.

---

# 2. TaxiDriver

`TaxiDriver` is the **Colleague** in this example.

```java
public class TaxiDriver {

    private final String driverName;
    private final TaxiMediator mediator;

    public TaxiDriver(String driverName, TaxiMediator mediator) {
        this.driverName = driverName;
        this.mediator = mediator;
    }

    public String getDriverName() {
        return driverName;
    }

    public void requestRide(String location) {
        System.out.println(driverName + " Requesting for Ride");
        mediator.requestRide(this, location);
    }

    public void receiveMessage(String message) {
        System.out.println(driverName + " " + message);
    }
}
```

The driver knows only about:

```java
TaxiMediator mediator;
```

It does **not** contain references to other drivers.

For example, it does not do:

```java
driver2.receiveMessage(...);
driver3.receiveMessage(...);
```

This is the main decoupling provided by the Mediator Pattern.

---

# 3. TaxiDispatchCenter

`TaxiDispatchCenter` is the **Concrete Mediator**.

It maintains the registered drivers:

```java
private final List<TaxiDriver> drivers = new ArrayList<>();
```

Drivers can be registered using:

```java
public void registerDriver(TaxiDriver driver) {
    drivers.add(driver);
}
```

The dispatch center receives ride requests and coordinates communication:

```java
@Override
public void requestRide(TaxiDriver driver, String location) {

    System.out.println(
        "Driver " + driver.getDriverName()
        + " is request for a ride in : " + location
    );

    for (TaxiDriver currentDriver : drivers) {

        if (currentDriver != driver) {

            currentDriver.receiveMessage(
                driver.getDriverName()
                + " is Getting a ride in " + location
            );
        }
    }

    driver.receiveMessage(
        driver.getDriverName() + " The Ride is on you now"
    );
}
```

The important responsibility here is **coordination**.

The driver sends the request to the mediator, and the mediator decides how to communicate with the registered drivers.

---

# 4. Program

`Program` is the Client.

It creates the mediator:

```java
TaxiDispatchCenter dispatchCenter =
        new TaxiDispatchCenter();
```

Then it creates the drivers:

```java
TaxiDriver driver1 =
        new TaxiDriver("Ahmed", dispatchCenter);

TaxiDriver driver2 =
        new TaxiDriver("Walid", dispatchCenter);

TaxiDriver driver3 =
        new TaxiDriver("Mohamed", dispatchCenter);
```

The drivers are then registered:

```java
dispatchCenter.registerDriver(driver1);
dispatchCenter.registerDriver(driver2);
dispatchCenter.registerDriver(driver3);
```

Finally, Ahmed requests a ride:

```java
driver1.requestRide("Nasr City");
```

---

# Execution Flow

When:

```java
driver1.requestRide("Nasr City");
```

is called, the flow is:

```text
Ahmed / TaxiDriver
        ↓
   TaxiMediator
        ↓
TaxiDispatchCenter
        ↓
Walid / TaxiDriver
Mohamed / TaxiDriver
```

### Step 1 — Driver Request

Ahmed calls:

```java
mediator.requestRide(this, location);
```

Ahmed does not contact Walid or Mohamed directly.

### Step 2 — Mediator Receives Request

`TaxiDispatchCenter` receives the request.

### Step 3 — Mediator Coordinates Communication

The dispatch center sends a message to the registered drivers.

### Step 4 — Drivers Receive Messages

The other drivers receive the notification through:

```java
receiveMessage(...)
```

---

# Example Output

The output will be similar to:

```text
Ahmed Requesting for Ride
Driver Ahmed is request for a ride in : Nasr City
Walid Ahmed is Getting a ride in Nasr City
Mohamed Ahmed is Getting a ride in Nasr City
Ahmed Ahmed The Ride is on you now
```

The exact wording depends on the messages implemented in the classes.

---

# Why This Is Mediator

The key relationship is:

```text
TaxiDriver
    ↓
TaxiMediator
    ↓
TaxiDispatchCenter
    ↓
Other TaxiDrivers
```

The drivers do not communicate directly.

Instead of:

```java
walid.receiveMessage(...);
mohamed.receiveMessage(...);
```

the driver communicates with:

```java
mediator.requestRide(this, location);
```

The mediator handles the coordination.

---

# Adding a New Driver

Suppose we want to add another driver:

```java
TaxiDriver driver4 =
        new TaxiDriver("Ali", dispatchCenter);

dispatchCenter.registerDriver(driver4);
```

We do not need to modify the existing `TaxiDriver` objects.

This demonstrates one of the main benefits of the pattern: **reducing direct dependencies between collaborating objects**.

---

# Responsibilities

### TaxiDriver

Responsible for:

- Representing a taxi driver.
- Sending ride requests.
- Receiving messages.

### TaxiMediator

Responsible for:

- Defining the communication contract.

### TaxiDispatchCenter

Responsible for:

- Registering drivers.
- Receiving requests.
- Coordinating communication between drivers.

### Program

Responsible for:

- Creating objects.
- Connecting them together.
- Starting the example.

---

# Design Principle

The main principle demonstrated by this example is:

> **Centralize communication between related objects to reduce direct coupling.**

Instead of every driver knowing about every other driver, the communication is centralized in the dispatch center.

---

# When to Use Mediator

Mediator is useful when:

- Many objects communicate directly with each other.
- Objects have too many dependencies.
- Communication logic is becoming difficult to maintain.
- Adding one object requires changing many other objects.
- You want to centralize coordination between collaborating objects.

Common examples include:

- Taxi dispatch systems.
- Air traffic control.
- Chat rooms.
- UI component communication.
- Multiplayer game systems.
- Workflow systems.

---

# Key Takeaways

- `TaxiMediator` is the Mediator abstraction.
- `TaxiDispatchCenter` is the Concrete Mediator.
- `TaxiDriver` is a Colleague.
- Drivers do not need direct references to each other.
- The dispatch center coordinates communication.
- The main goal is **reducing coupling**.

## Mnemonic

**Mediator = CENTRALIZE COMMUNICATION**
