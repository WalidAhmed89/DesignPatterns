# Proxy — SMS Service Example

## Purpose

This example demonstrates a proxy around an SMS service.

## Main Classes

| Class | Responsibility |
|---|---|
| `SMSService` | Common SMS service abstraction. |
| `ConceerteSMSService` | Concrete/real SMS service implementation. |
| `SMSServiceProxy` | Proxy controlling access to the SMS service. |
| `Program` | Demonstrates the proxy. |

## How It Works

The client communicates with the SMS service abstraction. The proxy can intercept the request before delegating to the concrete SMS service.

## Why Proxy Fits

External messaging services may require validation, access control, logging, or other cross-cutting concerns before an actual request is sent.

## Key Takeaway

The proxy preserves the same interface while providing controlled access to the real service.
