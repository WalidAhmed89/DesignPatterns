# Memento Pattern — Game Checkpoint Example

## Overview

This example demonstrates the **Memento Design Pattern** using a simple game checkpoint system.

The player has:
- Level
- Health
- Score

The player can save a checkpoint before continuing the game. If the state changes, the previous checkpoint can be restored.

## Problem

Suppose the player reaches:

```text
Level: 1
Health: 100
Score: 500
```

The player saves the game and continues.

After playing:

```text
Level: 2
Health: 80
Score: 600
```

We want to return to the saved state:

```text
Level: 1
Health: 100
Score: 500
```

Memento provides a snapshot of the player's state.

## Pattern Roles

| Class | Role | Responsibility |
|---|---|---|
| `Player` | Originator | Maintains state and creates/restores snapshots |
| `EditorMemento` | Memento | Stores a snapshot of the player's state |
| `Caretaker` | Caretaker | Stores and manages Mementos |
| `Program` | Client | Uses the pattern |

## 1. Player — Originator

```java
public class Player {

    private int level;
    private int health;
    private int score;

    public Player(int level, int health, int score) {
        this.level = level;
        this.health = health;
        this.score = score;
    }

    public void play() {
        level++;
        health -= 20;
        score += 100;

        System.out.println("Player played!");
    }

    public Memento save() {
        return new Memento(level, health, score);
    }

    public void restore(Memento memento) {
        this.level = memento.getLevel();
        this.health = memento.getHealth();
        this.score = memento.getScore();
    }

    public void showState() {
        System.out.println(
            "Level: " + level +
            ", Health: " + health +
            ", Score: " + score
        );
    }
}
```

`save()` creates a snapshot, while `restore()` applies a previously saved snapshot.

## 2. Memento

```java
public class Memento {

    private final int level;
    private final int health;
    private final int score;

    public Memento(int level, int health, int score) {
        this.level = level;
        this.health = health;
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }
}
```

If the player is:

```text
Level  = 1
Health = 100
Score  = 500
```

then:

```java
Memento checkpoint = player.save();
```

creates a snapshot containing those values.

## 3. Caretaker

The Caretaker manages the saved snapshots.

```java
import java.util.Stack;

public class Caretaker {

    private final Stack<Memento> history = new Stack<>();

    public void save(Memento memento) {
        history.push(memento);
    }

    public Memento undo() {
        if (history.isEmpty()) {
            return null;
        }

        return history.pop();
    }
}
```

The Caretaker does not need to understand:

```text
level
health
score
```

It only manages `EditorMemento` objects.

## 4. Program — Client

```java
public class Program {

    public static void main(String[] args) {

        Player player = new Player(1, 100, 500);

        Caretaker caretaker = new Caretaker();

        player.showState();

        // Save checkpoint
        caretaker.save(player.save());

        // Player changes state
        player.play();

        player.showState();

        // Restore checkpoint
        Memento savedState = caretaker.undo();

        player.restore(savedState);

        player.showState();
    }
}
```

## Execution Flow

### Step 1 — Create Player

```java
Player player = new Player(1, 100, 500);
```

Initial state:

```text
Level: 1
Health: 100
Score: 500
```

### Step 2 — Save Checkpoint

```java
caretaker.save(player.save());
```

Flow:

```text
Player
   |
   | save()
   v
Memento
   |
   | stored by
   v
Caretaker
```

### Step 3 — Player Plays

```java
player.play();
```

State changes:

```text
Before:
Level: 1
Health: 100
Score: 500

After:
Level: 2
Health: 80
Score: 600
```

### Step 4 — Restore

```java
Memento savedState = caretaker.undo();

player.restore(savedState);
```

The saved Memento is retrieved and passed back to the Player.

The Player restores:

```text
Level: 1
Health: 100
Score: 500
```

## Expected Output

```text
Level: 1, Health: 100, Score: 500
Player played!
Level: 2, Health: 80, Score: 600
Level: 1, Health: 100, Score: 500
```

## Complete Flow

```text
                    creates
Player ─────────────────────────> Memento
  ↑                                  |
  |                                  |
  | restore()                        | stored by
  |                                  |
  └──────────────────────────── Caretaker
                                      |
                                      v
                                Stack<Memento>
```

## Multiple Checkpoints

Because the Caretaker uses a stack, multiple checkpoints can be stored:

```java
caretaker.save(player.save());
player.play();

caretaker.save(player.save());
player.play();

caretaker.save(player.save());
```

The most recent checkpoint is restored first.

This provides a foundation for implementing multiple levels of Undo.

## Why Memento Is Useful Here

Without Memento, another class might need to know the internal details of `Player`.

With Memento:

```text
Player → creates snapshot
Memento → stores snapshot
Caretaker → manages snapshot
Player → restores snapshot
```

Each class has a clear responsibility.

## Key Takeaways

- `Player` is the **Originator**.
- `EditorMemento` is the **snapshot** of the player's state.
- `Caretaker` manages saved snapshots.
- The Caretaker does not need to know the internal details of the Player.
- `save()` creates a Memento.
- `restore()` restores a previous state.
- `Stack<Memento>` can manage multiple checkpoints.

### Memory Trick

```text
Originator → CREATE / RESTORE
Memento    → SNAPSHOT
Caretaker  → STORE / MANAGE

Memento Pattern = SAVE & RESTORE STATE
```
