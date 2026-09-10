# Memento Pattern

## Overview

The **Memento Pattern** is a **Behavioral Design Pattern** used to save and restore the previous state of an object without exposing its internal implementation details.

Common uses:
- Undo / Redo
- Rollback
- Game checkpoints
- Saving drafts
- Restoring previous states

## Problem

An object may change its state, but we may need to return it to an earlier state.

If another class directly stores the object's internal fields, this creates strong coupling because that class must know the object's implementation details.

## Solution

The object that owns the state creates a **Memento** containing a snapshot of its current state.

A **Caretaker** stores the Memento without needing to understand the details of the saved state.

When restoration is needed, the **Originator** uses the Memento to restore its previous state.

## Pattern Structure

```text
Originator
    |
    | createMemento()
    v
 Memento
    |
    | stored by
    v
Caretaker
    |
    | restore
    v
Originator
```

## Main Roles

### Originator

The object whose state needs to be saved and restored.

Responsibilities:
- Maintain the actual state.
- Create a Memento containing its current state.
- Restore its state from a Memento.

### Memento

Stores a snapshot of the Originator's state.

### Caretaker

Manages saved Mementos. It may use a `Stack<Memento>` to keep multiple snapshots.

The Caretaker should not understand or modify the internal state stored inside the Memento.

## Execution Flow

```text
1. Originator has its current state.
2. Originator creates a Memento.
3. Caretaker stores the Memento.
4. Originator changes its state.
5. Caretaker retrieves the saved Memento.
6. Originator restores its previous state.
```

## Real-World Examples

### Game Checkpoints

Save the player's level, health, score, position, or inventory and restore them later.

### Text Editor

Save document snapshots before changes and restore an earlier version for Undo.

### Transaction Rollback

Preserve a previous state before an operation and restore it if the operation fails.

## Memento vs Command

| Pattern | Main Purpose |
|---|---|
| Command | Encapsulate an action/request |
| Memento | Save and restore state |

They can work together in an Undo system:

```text
Command → performs the action
Memento → saves the previous state
```

## When to Use Memento

Use it when:
- You need Undo/Redo.
- You need rollback functionality.
- You need checkpoints.
- An object's state changes frequently.
- You want to preserve encapsulation while saving state.

## Advantages

- Preserves encapsulation.
- Supports Undo and Rollback.
- Separates state storage from state management.
- Makes checkpoints easy to implement.
- Keeps the Caretaker independent of the Originator's internal state.

## Key Takeaway

> **Memento Pattern allows an object to save and restore its previous state without exposing its internal details.**

### Memory Trick

```text
Memento → SAVE & RESTORE STATE

Originator → Creates and restores state
Memento    → Stores a snapshot
Caretaker  → Manages snapshots
```
