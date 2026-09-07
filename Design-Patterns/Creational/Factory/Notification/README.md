# Factory — Notification Example

## Purpose

This example demonstrates creating different notification services.

## Main Classes

| Class | Responsibility |
|---|---|
| `Notification` | Common notification abstraction. |
| `EmailNotification` | Email notification implementation. |
| `SMSNotification` | SMS notification implementation. |
| `PushNotification` | Push notification implementation. |
| `INotificationFactory` | Factory abstraction. |
| `EmailNotificationService` | Email creation/service implementation. |
| `SMSNotificationService` | SMS creation/service implementation. |
| `PushNotficationService` | Push-notification creation/service implementation. |

## How It Works

The client can request a notification implementation through the factory abstraction instead of directly constructing each concrete notification type.

## Why Factory Fits

The available notification mechanism can vary while the client continues to depend on the common abstraction.

## Key Takeaway

Factory keeps notification creation logic separate from the business code that uses notifications.
