# Builder — Computer Example

## Purpose

This example demonstrates building different computer configurations using the Builder pattern.

## Main Classes

| Class | Responsibility |
|---|---|
| `Computer` | Product being constructed. |
| `IComputerBuilder` | Defines construction operations. |
| `GamingComputerBuilder` | Builds a gaming configuration. |
| `OfficeComputerBuilder` | Builds an office configuration. |
| `ComputerDirector` | Coordinates construction steps. |
| `Program` | Demonstrates the example. |

## How It Works

The director coordinates the construction process through `IComputerBuilder`. Different concrete builders can produce different computer configurations while using the same construction concept.

## Why Builder Fits

A computer can contain multiple configurable components. Builder keeps the construction process separate from the final `Computer` object.

## Key Takeaway

The same construction workflow can produce different product configurations by changing the concrete builder.
