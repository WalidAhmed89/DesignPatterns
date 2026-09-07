# Flyweight — Discount Example

## Purpose

This example demonstrates sharing discount-calculation objects.

## Main Classes

| Class | Responsibility |
|---|---|
| `IDiscountCalculator` | Flyweight abstraction. |
| `DayDiscountCalculator` | Concrete shared calculator. |
| `DiscountCalculatorFactory` | Creates or reuses flyweights. |
| `ItemPriceCalculator` | Client using the calculator. |
| `Program` | Demonstrates the example. |

## How It Works

The factory is responsible for reusing discount calculator instances. Multiple operations can therefore share the same intrinsic calculation object.

## Why Flyweight Fits

If many requests require equivalent discount-calculation behavior, repeatedly creating identical objects is unnecessary.

## Key Takeaway

The core Flyweight idea is **sharing reusable state/behavior rather than duplicating objects**.
