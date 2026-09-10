# Implement Iterator Pattern — University Students

## Summary

Implemented the **Iterator Design Pattern** in Java using a University Students collection example.

The implementation separates student storage from the mechanism used to traverse the collection.

## What Was Implemented

- Created `Student` as the collection element.
- Created `StudentIterator` as the Iterator abstraction.
- Created `StudentCollectionIterator` as the Concrete Iterator.
- Created `StudentCollection` as the Aggregate / Collection.
- Added student management operations.
- Added `createIterator()` to provide controlled traversal.
- Demonstrated sequential traversal from the client.
- Kept the internal `List<Student>` hidden from `Program`.

## Pattern Flow

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

The client interacts with `StudentIterator` instead of directly accessing the internal collection.

## Example

The collection contains:

```text
Walid
Ahmed
Mohamed
Ali
```

The client traverses the students using:

```java
StudentIterator iterator = collection.createIterator();

while (iterator.hasNext()) {
    Student student = iterator.next();
    System.out.println(student.getName());
}
```

## Key Learning

The implementation demonstrates the main purpose of the Iterator Pattern:

> Provide a way to access elements of a collection sequentially without exposing its underlying representation.

The collection is responsible for storing students, while the iterator is responsible for traversal.

## Related Issue

Closes #<ISSUE_NUMBER>
