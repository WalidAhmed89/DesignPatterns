# Mediator Pattern — Air Traffic Control Example

## Overview

This example demonstrates the **Mediator Design Pattern** using an Air Traffic Control system.

Several planes need to communicate about landing. Instead of allowing every plane to communicate directly with every other plane, an `AirTrafficControl` object coordinates the communication.

## Problem

Without a mediator, the planes could become tightly coupled:

```text
Plane A → Plane B
Plane A → Plane C

Plane B → Plane A
Plane B → Plane C

Plane C → Plane A
Plane C → Plane B
```

If another plane is added, more direct dependencies would be required.

## Solution

Introduce an `AirTrafficControl` mediator:

```text
Plane A ──┐
Plane B ──┤
Plane C ──┼──→ AirTrafficControl
Plane D ──┘
```

Each plane communicates with the control system instead of communicating directly with other planes.

## Pattern Roles

| Pattern Role | Implementation |
|---|---|
| Mediator | `AirTrafficMediator` |
| Concrete Mediator | `AirTrafficControl` |
| Colleague | `Plane` |
| Client | `Program` |

## 1. AirTrafficMediator

The Mediator interface defines the communication contract:

```java
public interface AirTrafficMediator {

    void requestLanding(Plane plane);

    void notifyPlane(Plane plane, String message);
}
```

The `Plane` class does not need to know how communication is coordinated. It only needs to know the Mediator abstraction.

## 2. Plane

The `Plane` is a **Colleague**.

```java
public class Plane {

    private final String name;
    private final AirTrafficMediator mediator;

    public Plane(String name, AirTrafficMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void requestLanding() {
        System.out.println(name + ": Requesting landing...");
        mediator.requestLanding(this);
    }

    public void receiveMessage(String message) {
        System.out.println(name + ": " + message);
    }
}
```

Notice that the plane does not contain references to other planes. It knows only about `AirTrafficMediator`.

## 3. AirTrafficControl

`AirTrafficControl` is the **Concrete Mediator**.

```java
import java.util.ArrayList;
import java.util.List;

public class AirTrafficControl implements AirTrafficMediator {

    private final List<Plane> planes = new ArrayList<>();

    public void registerPlane(Plane plane) {
        planes.add(plane);
    }

    @Override
    public void requestLanding(Plane plane) {

        System.out.println(
                "Control Tower: " + plane.getName() +
                " is requesting landing."
        );

        for (Plane currentPlane : planes) {

            if (currentPlane != plane) {
                currentPlane.receiveMessage(
                        plane.getName() + " is landing now."
                );
            }
        }

        plane.receiveMessage("Landing approved.");
    }

    @Override
    public void notifyPlane(Plane plane, String message) {
        plane.receiveMessage(message);
    }
}
```

The mediator knows the participating planes and coordinates their communication.

## 4. Program — Client

The client creates the mediator and the planes:

```java
public class Program {

    public static void main(String[] args) {

        AirTrafficControl control = new AirTrafficControl();

        Plane planeA = new Plane("Plane A", control);
        Plane planeB = new Plane("Plane B", control);
        Plane planeC = new Plane("Plane C", control);

        control.registerPlane(planeA);
        control.registerPlane(planeB);
        control.registerPlane(planeC);

        planeA.requestLanding();
    }
}
```

## Execution Flow

When:

```java
planeA.requestLanding();
```

is called, the flow is:

```text
Program
   ↓
Plane A
   ↓
AirTrafficControl
   ↓
Plane B
Plane C
```

### Step 1

`Plane A` requests landing:

```java
mediator.requestLanding(this);
```

### Step 2

The request reaches `AirTrafficControl`.

### Step 3

The mediator informs the other registered planes.

```text
Plane B: Plane A is landing now.
Plane C: Plane A is landing now.
```

### Step 4

The mediator approves the landing for `Plane A`.

```text
Plane A: Landing approved.
```

## Example Output

```text
Plane A: Requesting landing...
Control Tower: Plane A is requesting landing.
Plane B: Plane A is landing now.
Plane C: Plane A is landing now.
Plane A: Landing approved.
```

## Why This Is Mediator

The important relationship is:

```text
Plane A ──┐
Plane B ──┤
Plane C ──┼──→ AirTrafficControl
          │
          └── central communication
```

`Plane A` does not directly call:

```java
planeB.receiveMessage(...);
planeC.receiveMessage(...);
```

Instead, it calls:

```java
mediator.requestLanding(this);
```

The Mediator decides which planes need to be notified.

## Adding a New Plane

Suppose we add:

```java
Plane planeD = new Plane("Plane D", control);
control.registerPlane(planeD);
```

We do not need to modify `Plane A`, `Plane B`, or `Plane C`.

This demonstrates the decoupling benefit of the pattern.

## Important Design Principle

> **Centralize communication instead of allowing direct communication between colleagues.**

Responsibilities are separated:

- `Plane` → represents a participating object.
- `AirTrafficMediator` → defines the communication contract.
- `AirTrafficControl` → coordinates communication.
- `Program` → creates and configures the objects.

## When This Approach Is Useful

This design is useful when many objects need to interact and their direct dependencies are becoming difficult to manage.

Typical examples include:

- Air traffic control.
- Chat rooms.
- UI component coordination.
- Multiplayer game communication.
- Workflow coordination.
- Complex business processes.

## Key Takeaways

- `AirTrafficMediator` is the Mediator abstraction.
- `AirTrafficControl` is the Concrete Mediator.
- `Plane` is a Colleague.
- Planes communicate through the Mediator.
- Planes do not need direct references to each other.
- The Mediator centralizes coordination.
- The main goal is **reducing coupling between collaborating objects**.

## Learning Goal

This example demonstrates how the Mediator Pattern can transform many direct object-to-object dependencies into a centralized communication model.

**Mediator = CENTRALIZE COMMUNICATION**
