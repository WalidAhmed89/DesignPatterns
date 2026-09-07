# Adapter — Distance Calculator Example

## Purpose

This example adapts an old miles-based calculator to a kilometer-based interface.

## Main Classes

| Class | Responsibility |
|---|---|
| `DistanceCalculator` | Target interface expected by the client. |
| `OldDistanceCalculator` | Existing/adaptee implementation. |
| `DistanceAdapter` | Converts the expected API to the old API. |
| `Program` | Demonstrates the adapter. |

## How It Works

The client works with `DistanceCalculator`. `DistanceAdapter` internally uses `OldDistanceCalculator` and performs the required conversion between the two APIs.

## Why Adapter Fits

The existing class already provides useful functionality, but its interface does not match what the new client expects.

## Key Takeaway

Adapter allows reuse without modifying the existing class.
