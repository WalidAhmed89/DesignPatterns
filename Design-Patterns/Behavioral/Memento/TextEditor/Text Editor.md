# Memento Pattern – TextEditor Example

## Idea
An implementation of the **Memento Design Pattern** using a text editor example (`TextEditor`), so we can save the editor's state (content + font size) at a given point, and restore it later if we need to undo.

## Components

### 1. `TextEditor` (Originator)
The core class that holds the actual state:
- `content`: the current text.
- `fontSize`: the font size.

It provides:
- `write(text)`: appends new text to the content.
- `changeFontSize(fontSize)`: changes the font size (with a basic check that the value is greater than zero).
- `showState()`: prints the current state.
- `createMemento()`: creates a snapshot of the current state and returns it as an `EditorMemento`.
- `restore(memento)`: restores the editor's state from a given `Memento`.

### 2. `EditorMemento` (Memento)
A simple, immutable class (all fields are `final`) that stores a copy of:
- `content`
- `fontSize`

Its only job is to carry the state without exposing it or letting anyone modify it from outside.

### 3. `Caretaker`
Responsible for managing the history of states without knowing the details of the state itself:
- Uses a `Stack<EditorMemento>` to keep states in order.
- `save(memento)`: pushes a new state onto the stack.
- `undo()`: pops and returns the last saved state (or `null` if the stack is empty).

### 4. `Program` (Client)
This is where the actual sequence happens:
1. Create a `TextEditor` with empty content and font size 14.
2. Write "Hello" → save the state (Checkpoint 1).
3. Change font size to 20 + write " Walid" → save the state (Checkpoint 2).
4. Write " Ahmed" (without saving).
5. Call `undo()` → returns the last saved state (Checkpoint 2), so the content goes back to "Hello Walid" with font size 20, and the " Ahmed" addition is discarded.

## Why use Memento here?
- To separate the "save/restore logic" from the class itself (`TextEditor` doesn't need to know the history details).
- To preserve **encapsulation**: nothing outside `TextEditor` or `EditorMemento` can directly modify the saved state.
- It makes implementing an Undo/Redo feature clean, without cluttering the rest of the code.

## Note on the code
In `changeFontSize`, if the value is ≤ 0, an error message is printed but **the code still continues and changes the value** (there's no `return` after the `if`). If the goal is to actually reject the change, a `return;` needs to be added inside the `if`.
