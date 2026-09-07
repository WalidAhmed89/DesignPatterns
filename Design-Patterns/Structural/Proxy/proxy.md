# Proxy Pattern

## Overview

Proxy is a **structural design pattern**. It provides a reusable way to solve a recurring software design problem while keeping the code easier to maintain, extend, and understand.

## Intent

Provide a substitute or representative for another object to control access to it.

## The Problem

A real service may be expensive, sensitive, remote, or otherwise require controlled access. Clients should not necessarily communicate with the real object directly.

## The Solution

The Proxy implements the same interface as the real subject and controls or augments access before delegating to the real object.

## Structure

The project contains three Proxy examples:

- **FileService** — `FileServiceProxy` controls access to `RealFileService`.
- **ProductAPI** — `ProductServiceProxy` stands between the client and `RealProductService`.
- **SMSService** — `SMSServiceProxy` controls access to the SMS service.

The common structure is a shared service interface implemented by both the real service and its proxy.

## Implementation in This Project

```text
Client
  |
  v
Subject Interface
  |
  +--> Proxy
  |      |
  |      v
  |   Real Subject
  |
  +--> Real Subject
```

The proxy can perform checks, logging, lazy initialization, caching, access control, or other cross-cutting behavior before delegating.

## Advantages

- Controls access to real services.
- Can add authorization, validation, logging, caching, or lazy loading.
- Keeps the client dependent on the same abstraction.

## Disadvantages / Trade-offs

- Adds an extra layer.
- Proxy logic can become complicated.
- Poorly designed proxies can hide expensive operations from callers.

## When to Use

Use it when access to an object needs control, monitoring, lazy creation, caching, security, or indirection.

## Related Patterns

Decorator, Adapter, Facade

## Key Takeaways

The important point is not to use a design pattern simply because it exists. The pattern should be introduced when its structure solves a real design problem and provides a meaningful improvement in flexibility, maintainability, or separation of responsibilities.
