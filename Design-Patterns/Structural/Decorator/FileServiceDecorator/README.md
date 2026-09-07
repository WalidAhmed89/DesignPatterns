# Decorator — File Service Example

## Purpose

This example demonstrates adding responsibilities around a file service without modifying its original implementation.

## Main Classes

| Class | Responsibility |
|---|---|
| `FileServiceDecorator` | Base decorator abstraction. |
| `FileLoggingDecorator` | Adds logging behavior. |
| `FileDeletionDialogDecorator` | Adds deletion-dialog behavior. |

## How It Works

A decorator wraps a file service and implements the same service contract. Additional decorators can be layered around the service.

## Why Decorator Fits

Logging and user-confirmation behavior are optional responsibilities that should not be permanently embedded inside the base file service.

## Key Takeaway

Decorator is ideal when behaviors should be composable and dynamically attachable.
