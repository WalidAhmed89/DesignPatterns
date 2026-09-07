# Singleton — Login Counter Example

## Purpose

This example compares ordinary object creation with a Singleton-based login counter.

## Main Classes

| Class | Responsibility |
|---|---|
| `LoginCounter_FirstVersion` | Demonstrates the non-Singleton approach. |
| `LoginCounter_Singlton` | Demonstrates the Singleton approach. |
| `Program` | Runs the example. |

## Why Two Versions Exist

The first version helps show the problem: creating separate counter objects means each object can maintain separate state.

The Singleton version centralizes the state so different parts of the application access the same counter instance.

## Key Takeaway

Keeping both versions is useful pedagogically because it demonstrates the motivation behind Singleton instead of presenting the pattern without context.
