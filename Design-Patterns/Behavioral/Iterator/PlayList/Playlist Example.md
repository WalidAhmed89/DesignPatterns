# Iterator Pattern — Playlist Example

## Overview

This example demonstrates the **Iterator Design Pattern** using a simple `Playlist`.

The Playlist stores songs internally using an array, while the Client accesses the songs through an Iterator.

The Client does not need to know that the Playlist uses an array or how the traversal is implemented.

## Project Structure

```text
Iterator/
├── Iterator.java
├── PlaylistIterator.java
├── Playlist.java
└── Program.java
```

## 1. Iterator Interface

```java
public interface Iterator {
    boolean hasNext();
    String next();
}
```

This interface defines the operations required to traverse the collection.

- `hasNext()` checks whether another element exists.
- `next()` returns the next element.

The Client only depends on this abstraction.

## 2. Playlist

```java
public class Playlist {

    private final String[] songs;

    public Playlist(String[] songs) {
        this.songs = songs;
    }

    public Iterator createIterator() {
        return new PlaylistIterator(songs);
    }
}
```

`Playlist` is the **Aggregate / Collection**.

It stores the songs and provides an Iterator to the Client.

## 3. PlaylistIterator

```java
public class PlaylistIterator implements Iterator {

    private final String[] songs;
    private int position = 0;

    public PlaylistIterator(String[] songs) {
        this.songs = songs;
    }

    @Override
    public boolean hasNext() {
        return position < songs.length;
    }

    @Override
    public String next() {
        return songs[position++];
    }
}
```

`PlaylistIterator` is the **Concrete Iterator**.

It contains the traversal logic.

### Position

```java
private int position = 0;
```

Keeps track of the current element.

### `hasNext()`

```java
return position < songs.length;
```

Checks whether more songs exist.

### `next()`

```java
return songs[position++];
```

Returns the current song and moves to the next position.

## 4. Program — The Client

```java
public class Program {

    public static void main(String[] args) {

        String[] songs = {
                "Song A",
                "Song B",
                "Song C"
        };

        Playlist playlist = new Playlist(songs);

        Iterator iterator = playlist.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

The Client asks the Playlist for an Iterator:

```java
Iterator iterator = playlist.createIterator();
```

Then it traverses the collection using:

```java
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

The Client does not access the array directly.

## 5. Execution Flow

```text
                    Program
                      |
                      ↓
                   Playlist
                      |
               createIterator()
                      |
                      ↓
              PlaylistIterator
                      |
                 hasNext()
                      |
                      ↓
                    next()
                      |
                      ↓
                  String[]
```

The Iterator controls how the elements are traversed.

## 6. Example Walkthrough

The Playlist contains:

```text
Song A
Song B
Song C
```

Initially:

```text
position = 0
```

First iteration:

```text
hasNext() → true
next() → Song A
position → 1
```

Second iteration:

```text
hasNext() → true
next() → Song B
position → 2
```

Third iteration:

```text
hasNext() → true
next() → Song C
position → 3
```

Final check:

```text
hasNext() → false
```

The loop stops.

## 7. Why Use the Iterator Pattern?

Without the Iterator, the Client could directly access the array:

```java
for (int i = 0; i < playlist.getSongs().length; i++) {
    System.out.println(playlist.getSongs()[i]);
}
```

Now the Client knows that the Playlist uses an Array.

With the Iterator:

```java
Iterator iterator = playlist.createIterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

The Client only knows how to traverse.

The internal representation remains hidden.

## 8. What If the Data Structure Changes?

Suppose the Playlist changes from:

```java
String[]
```

to:

```java
List<String>
```

The Client can still use:

```java
Iterator iterator = playlist.createIterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

The traversal implementation can change without changing the Client's traversal code.

## 9. Pattern Role Mapping

| Pattern Role | Example |
|---|---|
| Iterator | `Iterator` |
| Concrete Iterator | `PlaylistIterator` |
| Aggregate / Collection | `Playlist` |
| Client | `Program` |

## 10. Java's Built-in Iterator

Java already provides:

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

This follows the same core idea as the custom implementation.

## Key Takeaways

- `Playlist` stores the data.
- `PlaylistIterator` controls traversal.
- `Iterator` defines a common traversal interface.
- `Program` is the Client.
- The Client does not need to know the internal representation of the Playlist.
- `hasNext()` checks whether another element exists.
- `next()` returns the next element.
- The main purpose of Iterator is **traversal**, not object creation.

### Memory Rule

```text
Iterator → TRAVERSE
Collection → STORE DATA
Client → USE ITERATOR
```

This is a learning implementation of the Iterator Pattern.
