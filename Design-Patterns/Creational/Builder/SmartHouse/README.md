# Builder — Smart House Example

## Purpose

This example demonstrates building different house configurations.

## Main Classes

| Class | Responsibility |
|---|---|
| `House` | Final product. |
| `IHouseBuilder` | Defines house construction operations. |
| `ModernHouseBuilder` | Builds a modern house. |
| `SimpleHouseBuilder` | Builds a simple house. |
| `HouseDirector` | Coordinates construction. |
| `Program` | Demonstrates the process. |

## How It Works

The director uses an `IHouseBuilder` to execute the required construction steps. The selected builder determines the final house configuration.

## Why Builder Fits

A house is naturally constructed through multiple steps and can have different representations. Builder keeps those steps out of the product class.

## Key Takeaway

Builder is effective for multi-step construction with different possible configurations.
