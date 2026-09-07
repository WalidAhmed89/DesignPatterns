# Factory — Banking Example

## Purpose

This example demonstrates selecting a concrete bank through a factory.

## Main Classes

| Class | Responsibility |
|---|---|
| `IBank` | Common bank abstraction. |
| `Bank_AlAhly` | Al Ahly implementation. |
| `Bank_Misr` | Bank Misr implementation. |
| `IBankFactory` | Factory abstraction. |
| `BankFactory` | Creates the required bank implementation. |
| `Program` | Demonstrates object creation. |

## How It Works

The client requests a bank from `BankFactory` rather than directly instantiating `Bank_AlAhly` or `Bank_Misr`.

## Why Factory Fits

The creation decision is centralized and the client depends on the `IBank` abstraction.

## Key Takeaway

Factory is useful when the concrete class should be selected without exposing the creation logic to the client.
