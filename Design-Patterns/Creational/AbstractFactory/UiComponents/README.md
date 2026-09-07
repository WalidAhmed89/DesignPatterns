# Abstract Factory — UI Components Example

## Purpose

This example demonstrates platform-specific UI creation.

## Main Classes

| Class | Responsibility |
|---|---|
| `IGUIFactory` | Creates a family of UI components. |
| `IButton` | Button abstraction. |
| `ICheckBox` | Check-box abstraction. |
| `WindowsFactory` | Creates Windows components. |
| `MacFactory` | Creates macOS components. |
| `WindowsButton` | Windows button implementation. |
| `WindowsCheckBox` | Windows check-box implementation. |
| `MacButton` | macOS button implementation. |
| `MacCheckBox` | macOS check-box implementation. |

## How It Works

The client asks a GUI factory to create buttons and check boxes. The selected factory determines which platform-specific implementations are returned.

## Why Abstract Factory Fits

Button and check-box objects form a related family. The factory ensures that the components come from the same platform family.

## Key Takeaway

Abstract Factory is a natural fit for cross-platform UI systems where several related components must vary together.
