# Bridge — Multi-Platform UI Example

## Purpose

This example demonstrates separating a UI abstraction from platform-specific implementation.

## Main Classes

| Class | Responsibility |
|---|---|
| `Button` | UI abstraction. |
| `ICommonUI` | Platform implementation abstraction. |
| `Android` | Android implementation. |
| `IOS` | iOS implementation. |
| `Windows` | Windows implementation. |
| `Program` | Demonstrates the bridge. |

## How It Works

`Button` uses an `ICommonUI` implementation instead of being hard-coded to one operating system.

The platform can therefore change independently from the UI abstraction.

## Why Bridge Fits

There are two dimensions of variation:

1. UI abstraction/component.
2. Operating-system implementation.

Bridge prevents these dimensions from being combined into a large inheritance hierarchy.

## Key Takeaway

Bridge is fundamentally about **separating two dimensions that need to vary independently**.
