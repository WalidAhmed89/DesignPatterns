# Proxy — Product API Example

## Purpose

This example demonstrates a proxy in front of a product service/API.

## Main Classes

| Class | Responsibility |
|---|---|
| `IProductService` | Common product-service interface. |
| `RealProductService` | Real product service. |
| `ProductServiceProxy` | Proxy controlling access to the real service. |

## How It Works

The client calls the common interface. The proxy can perform checks or additional processing before delegating to the real product service.

## Why Proxy Fits

The proxy creates an indirection layer while preserving the same service contract.

## Key Takeaway

Proxy is useful when the client should interact with a controlled representative rather than the real service directly.
