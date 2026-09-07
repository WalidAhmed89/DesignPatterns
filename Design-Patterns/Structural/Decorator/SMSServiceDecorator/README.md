# Decorator — SMS Service Example

## Purpose

This example demonstrates decorating an SMS-related service with additional notification behavior.

## Main Classes

| Class | Responsibility |
|---|---|
| `SMSDecorator` | Base decorator. |
| `NotificationEmailDecorator` | Adds email-notification behavior around the SMS operation. |
| `Program` | Demonstrates the example. |

## How It Works

The decorator wraps the underlying SMS service and can perform additional work around it.

## Why Decorator Fits

Additional behavior can be attached without modifying the original service class.

## Key Takeaway

The same service interface allows the original service and decorated service to remain interchangeable.
