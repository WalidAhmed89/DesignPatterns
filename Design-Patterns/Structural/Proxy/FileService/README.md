# Proxy — File Service Example

## Purpose

This example demonstrates placing a proxy between the client and a real file service.

## Main Classes

| Class | Responsibility |
|---|---|
| `IFileService` | Common service interface. |
| `RealFileService` | Real service implementation. |
| `FileServiceProxy` | Controls access to the real service. |

## How It Works

The client communicates through `IFileService`. The proxy can intercept the request and then delegate to `RealFileService`.

## Why Proxy Fits

The proxy provides an access-control layer without changing the real service implementation.

## Key Takeaway

Both the proxy and real service share the same abstraction, allowing the proxy to stand in for the real object.
