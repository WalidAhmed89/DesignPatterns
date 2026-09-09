# Command Pattern — Game Character Example

## Overview
This example demonstrates the **Command Design Pattern** using a simple game character. Actions such as **Attack**, **Jump**, and **Move** are encapsulated as command objects, allowing the `GameController` to execute different actions without knowing their implementation details.

## Problem
A controller that directly calls `GameCharacter` methods becomes tightly coupled to the receiver. As the number of actions grows, the controller becomes harder to extend and maintain.

## Solution
The Command Pattern encapsulates each request as an object.

- `AttackCommand` represents an attack request.
- `JumpCommand` represents a jump request.
- `MoveCommand` represents a move request.
- `GameCharacter` performs the actual operations.
- `GameController` executes commands through the common `Command` interface.

## Pattern Structure

```text
Client
  ↓
GameController (Invoker)
  ↓
Command
  ├── AttackCommand
  ├── JumpCommand
  └── MoveCommand
          ↓
GameCharacter (Receiver)
```

## Roles

### Receiver — `GameCharacter`
Contains the actual action logic:

```java
public class GameCharacter {
    public void attack() {
        System.out.println("Character attacks!");
    }

    public void jump() {
        System.out.println("Character jumps!");
    }

    public void move(String direction) {
        System.out.println("Character move! " + direction);
    }
}
```

### Command — `Command`
Defines the common execution operation:

```java
public interface Command {
    void execute();
}
```

### Concrete Commands
Each command encapsulates one request and delegates execution to `GameCharacter`.

```java
public class AttackCommand implements Command {
    private final GameCharacter gameCharacter;

    public AttackCommand(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    @Override
    public void execute() {
        gameCharacter.attack();
    }
}
```

```java
public class JumpCommand implements Command {
    private final GameCharacter gameCharacter;

    public JumpCommand(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    @Override
    public void execute() {
        gameCharacter.jump();
    }
}
```

```java
public class MoveCommand implements Command {
    private final GameCharacter gameCharacter;
    private final String direction;

    public MoveCommand(GameCharacter gameCharacter, String direction) {
        this.gameCharacter = gameCharacter;
        this.direction = direction;
    }

    @Override
    public void execute() {
        gameCharacter.move(direction);
    }
}
```

### Invoker — `GameController`
The Invoker stores a command and executes it without knowing the concrete command:

```java
public class GameController {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```

### Client — `Program`
The Client creates and configures the Receiver, Commands, and Invoker.

```java
GameCharacter character = new GameCharacter();

MoveCommand moveCommand = new MoveCommand(character, "straight");
JumpCommand jumpCommand = new JumpCommand(character);
AttackCommand attackCommand = new AttackCommand(character);

GameController controller = new GameController();

controller.setCommand(moveCommand);
controller.pressButton();

controller.setCommand(jumpCommand);
controller.pressButton();

controller.setCommand(attackCommand);
controller.pressButton();
```

## Execution Flow

```text
Program
  ↓
GameController
  ↓
MoveCommand.execute()
  ↓
GameCharacter.move("straight")
```

The same structure applies to `JumpCommand` and `AttackCommand`.

## Example Output

```text
Character move! straight
Character jumps!
Character attacks!
```

## Why Command Pattern Is Useful Here

The `GameController` only depends on the `Command` abstraction:

```java
command.execute();
```

It does not need to know whether the command performs an attack, jump, or movement.

New commands such as `DefendCommand`, `ShootCommand`, or `ReloadCommand` can be added without changing the basic `GameController`.

## Key Concept

> **Encapsulate a request as an object.**

In this example:

```text
AttackCommand → Attack request
JumpCommand   → Jump request
MoveCommand   → Move request
```

The Command stores the information required for the request and delegates the actual operation to the Receiver.

## Command vs Observer

| Command | Observer |
|---|---|
| Represents an action/request | Represents a notification |
| Uses `execute()` | Uses `update()` |
| Encapsulates a request | Notifies registered observers |
| Example: Attack, Jump, Move | Example: Order status changed |

Simple rule:

```text
Command  → ACTION / REQUEST
Observer → NOTIFICATION
```

## When to Use Command

Use Command when you need:

- Encapsulated requests as objects.
- Interchangeable operations.
- Decoupling between sender and receiver.
- Undo/redo functionality.
- Command queues or scheduling.
- Logging or retrying operations.

## Advantages

- Reduces coupling between Invoker and Receiver.
- Commands become interchangeable.
- New commands can be added easily.
- Supports undo/redo, logging, queues, and scheduling.
- Separates request creation from execution.

## Trade-offs

- Introduces additional classes.
- Can be unnecessary for very simple operations.
- Each new action may require a new Command class.

## Project Structure

```text
Behavioral/
└── Command/
    └── GameCharacter/
        ├── Command.java
        ├── GameCharacter.java
        ├── AttackCommand.java
        ├── JumpCommand.java
        ├── MoveCommand.java
        ├── GameController.java
        └── Program.java
```

## Pattern Mapping

| Role | Class |
|---|---|
| Receiver | `GameCharacter` |
| Command | `Command` |
| Concrete Command | `AttackCommand` |
| Concrete Command | `JumpCommand` |
| Concrete Command | `MoveCommand` |
| Invoker | `GameController` |
| Client | `Program` |

## Learning Goal

The main idea is:

```text
Client
  ↓
Invoker
  ↓
Command
  ↓
Receiver
```

The Invoker only knows the Command abstraction, while the Receiver contains the actual operation logic.

**Command = Encapsulate a request as an object.**
