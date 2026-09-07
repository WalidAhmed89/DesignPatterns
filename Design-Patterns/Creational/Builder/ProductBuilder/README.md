# Builder — Product Builder Example

## Purpose

This example demonstrates constructing different product types through a common builder abstraction.

## Main Classes

| Class | Responsibility |
|---|---|
| `IBuilder` | Builder abstraction. |
| `Product` | Product representation. |
| `Director` | Coordinates the construction sequence. |
| `Car` | Concrete product representation. |
| `MotorCycle` | Concrete product representation. |
| `Program` | Demonstrates construction. |

## How It Works

The director controls the construction process while concrete builders/products determine the resulting representation.

## Why Builder Fits

The construction process can be separated from the final representation. This makes it possible to construct different products using the same general sequence.

## Key Takeaway

Builder is useful when construction has multiple steps and different implementations may represent the resulting product differently.
