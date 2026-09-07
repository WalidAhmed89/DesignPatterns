# Singleton — Counter Example

## Purpose

This example demonstrates shared state using a Singleton counter.

## Main Classes

| Class | Responsibility |
|---|---|
| `Counter` | Holds the shared counter state. |
| `Program` | Demonstrates access to the counter. |

## How It Works

Different callers access the same `Counter` instance, so changes to the counter are visible through the shared object.

## Why Singleton Fits

The example is designed to demonstrate the defining Singleton property: multiple accesses refer to one controlled instance.

## Key Takeaway

The example also illustrates why Singleton can introduce global/shared state. The pattern should be used only when that shared state is intentional.
