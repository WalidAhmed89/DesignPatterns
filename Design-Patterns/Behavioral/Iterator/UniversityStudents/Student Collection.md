# Iterator Pattern — University Students Example

## Overview

This example demonstrates the **Iterator Design Pattern** using a university student collection.

The goal is to allow the client to traverse students sequentially without exposing the internal data structure used by `StudentCollection`.

## Problem

The client needs to access every student, but should not depend on how the students are stored internally.

The collection could use an `ArrayList`, an array, or another data structure. The client should only interact with an iterator.

## Solution

The Iterator Pattern separates **collection storage** from **collection traversal**.

The collection creates an iterator, while the iterator maintains the current position and provides:

```java
boolean hasNext();
Student next();
```

The client therefore does not access the internal `List<Student>` directly.

## Pattern Structure

```text
StudentCollection
       |
       | createIterator()
       v
StudentCollectionIterator
       |
       | implements
       v
StudentIterator
       ^
       |
     Program
```

| Pattern Role | Implementation |
|---|---|
| Iterator | `StudentIterator` |
| Concrete Iterator | `StudentCollectionIterator` |
| Aggregate / Collection | `StudentCollection` |
| Element | `Student` |
| Client | `Program` |

## StudentIterator

The `StudentIterator` interface defines the traversal operations:

```java
public interface StudentIterator {
    boolean hasNext();
    Student next();
}
```

`hasNext()` checks whether another student exists, while `next()` returns the next student and advances the position.

## StudentCollectionIterator

`StudentCollectionIterator` is the **Concrete Iterator**.

It stores a reference to the collection data and maintains an internal position:

```java
private final List<Student> students;
private int position = 0;
```

Its traversal logic is:

```java
@Override
public boolean hasNext() {
    return position < students.size();
}

@Override
public Student next() {
    return students.get(position++);
}
```

For four students, the position moves from `0` to `4`.

## StudentCollection

`StudentCollection` is the **Aggregate / Collection**.

It stores students internally and exposes collection operations such as:

```java
addStudent(Student student)
removeStudent(Student student)
createIterator()
```

The iterator is created with:

```java
public StudentIterator createIterator() {
    return new StudentCollectionIterator(students);
}
```

The important point is that `Program` does not need to know that the collection currently uses an `ArrayList`.

## Program

The client creates the collection and students:

```java
StudentCollection collection = new StudentCollection();

collection.addStudent(new Student(1, "Walid"));
collection.addStudent(new Student(2, "Ahmed"));
collection.addStudent(new Student(3, "Mohamed"));
collection.addStudent(new Student(4, "Ali"));
```

Then it requests an iterator:

```java
StudentIterator iterator = collection.createIterator();
```

Finally, it traverses the collection:

```java
while (iterator.hasNext()) {
    Student student = iterator.next();
    System.out.println(student.getName());
}
```

Expected output:

```text
Walid
Ahmed
Mohamed
Ali
```

## Execution Flow

```text
Program
   |
   | createIterator()
   v
StudentCollection
   |
   | creates
   v
StudentCollectionIterator
   |
   | hasNext() / next()
   v
Student objects
```

## Why Iterator Is Useful

The pattern separates two responsibilities:

- `StudentCollection` → stores students.
- `StudentCollectionIterator` → traverses students.
- `Program` → uses the traversal abstraction.

This hides the internal representation from the client and makes the traversal mechanism easier to change.

## When to Use

Use Iterator when:

- You need sequential access to collection elements.
- You want to hide the collection's internal representation.
- Different collections may need different traversal mechanisms.
- The client should use a common traversal interface.

## Key Takeaways

- **Iterator = TRAVERSE A COLLECTION**
- The collection stores the data.
- The iterator controls traversal.
- `hasNext()` checks for another element.
- `next()` returns the next element.
- The client does not need to know whether the collection uses an array, list, or another structure.

## Learning Goal

This is a practical learning implementation of the Iterator Pattern in Java. The main goal is to understand how a collection can provide controlled traversal without exposing its underlying representation.
