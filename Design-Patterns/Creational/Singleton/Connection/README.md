# Singleton — Database Connection Example

## Purpose

This example demonstrates controlling access to a shared database connection instance.

## Main Classes

| Class | Responsibility |
|---|---|
| `DatabaseConnection` | Singleton connection object. |
| `Program` | Demonstrates accessing the shared instance. |

## How It Works

The Singleton class controls construction and exposes a shared instance. Multiple callers obtain the same controlled object.

## Why Singleton Fits

A database connection resource may need centralized lifecycle and access control. The example demonstrates the basic Singleton structure.

## Important Design Note

In production Java applications, a connection pool and dependency injection framework are often preferable to manually implementing a Singleton database connection.

## Key Takeaway

Singleton guarantees controlled instance creation, but shared resources should be managed carefully to avoid hidden global state.
