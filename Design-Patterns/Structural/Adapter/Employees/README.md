# Adapter — Employees Example

## Purpose

This example demonstrates adapting an employee-related operation to a different interface expected by the application.

## Main Classes

| Class | Responsibility |
|---|---|
| `Employee` | Employee domain object. |
| `MachineOperation` | Existing operation/interface. |
| `SalaryCalculator` | Target salary-calculation abstraction. |
| `SalaryAdapter` | Adapter between the interfaces. |
| `Program` | Demonstrates the example. |

## How It Works

The adapter translates the interface expected by the client into operations supported by the existing salary-related component.

## Why Adapter Fits

The existing implementation can be reused without forcing the client or the existing class to change its contract.

## Key Takeaway

The adapter acts as a compatibility boundary between two APIs.
