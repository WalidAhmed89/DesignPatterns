# Iterator Pattern

## What Is the Iterator Pattern?

The **Iterator Pattern** is a **Behavioral Design Pattern** that provides a standard way to access elements of a collection sequentially without exposing its internal representation.

In simple words:

> The Iterator allows the Client to traverse a collection without knowing how the data is stored internally.

A collection may internally use an Array, List, Linked List, Stack, Set, or another data structure.

The Client works with a common Iterator interface such as:

```java
hasNext()
next()
```

## Main Idea

```text
Client
   ↓
Iterator
   ↓
Collection
```

- **Collection** stores the data.
- **Iterator** controls the traversal.
- **Client** uses the Iterator without knowing the internal structure.

## Problem

Different data structures can require different traversal techniques.

For example, an Array can be traversed using indexes:

```java
for (int i = 0; i < array.length; i++) {
    // access element
}
```

A linked structure may require moving through nodes.

If the Client handles these details itself, it becomes coupled to the collection's implementation.

## Solution

The Iterator Pattern moves traversal logic into a separate Iterator object.

The Client only needs to know:

```java
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

The Client does not need to know whether the collection uses an Array, List, Linked List, or another structure.

## Pattern Roles

| Role | Responsibility |
|---|---|
| Iterator | Defines operations for traversing elements |
| Concrete Iterator | Implements the traversal algorithm |
| Aggregate / Collection | Stores elements and provides an Iterator |
| Client | Uses the Iterator |

## Important Distinction

The Iterator is **not primarily responsible for creating objects**.

Its main responsibility is:

```text
TRAVERSE A COLLECTION
```

Memory rule:

```text
Iterator    → TRAVERSE
Collection  → STORE DATA
Client      → USE ITERATOR
```

## Advantages

- Hides the internal representation of a collection.
- Provides a standard traversal interface.
- Reduces coupling between Client and Collection.
- Keeps traversal logic separate from the collection.
- Allows different collections to implement different traversal strategies.

## When to Use

Use Iterator when:

- You need to traverse a collection.
- The internal structure should remain hidden.
- Different collections may require different traversal implementations.
- The Client should use a common traversal interface.

## Java's Built-in Iterator

Java already provides this pattern through:

```java
java.util.Iterator
```

Example:

```java
List<String> songs = List.of(
        "Song A",
        "Song B",
        "Song C"
);

Iterator<String> iterator = songs.iterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

## Iterator vs Other Patterns

| Pattern | Main Idea |
|---|---|
| Iterator | Traverse a collection |
| Adapter | Translate incompatible interfaces |
| Command | Encapsulate a request/action |
| Observer | Notify registered observers |
| Interpreter | Evaluate a language/expression |

## Key Takeaway

> **The Iterator Pattern provides a way to access elements of a collection sequentially without exposing its underlying representation.**
