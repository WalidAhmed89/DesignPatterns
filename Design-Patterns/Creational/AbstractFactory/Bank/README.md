# Abstract Factory — Bank Example

## Purpose

This example demonstrates how Abstract Factory can create a consistent family of banking-related objects.

## Main Classes

| Class | Responsibility |
|---|---|
| `IFactory` | Defines the abstract factory contract. |
| `IBank` | Defines the bank product abstraction. |
| `IPaymentCard` | Defines the payment-card product abstraction. |
| `AlAhly_Factory` | Creates the Al Ahly product family. |
| `Bank_Misr_Factory` | Creates the Bank Misr product family. |
| `AlAhly_Bank` | Concrete Al Ahly bank product. |
| `Bank_Misr` | Concrete Bank Misr bank product. |
| `VisaCard` | Concrete Visa card product. |
| `MasterCard` | Concrete MasterCard product. |

## How It Works

The client depends on `IFactory` rather than constructing concrete bank and card classes directly.

A concrete factory represents a product family and creates the required related products.

## Why Abstract Factory Fits

The example involves multiple related products. The factory abstraction allows the client to work with a complete family without depending directly on its concrete classes.

## Key Takeaway

Abstract Factory is especially useful when the application must keep related products consistent while allowing the entire product family to be replaced.
