# Facade Pattern

## Overview

Facade is a **structural design pattern**. It provides a reusable way to solve a recurring software design problem while keeping the code easier to maintain, extend, and understand.

## Intent

Provide a simplified, high-level interface to a complex subsystem.

## The Problem

A client may need to coordinate many subsystem classes to complete one business operation. This exposes unnecessary implementation details to the client.

## The Solution

The Facade provides a small interface that coordinates the underlying subsystem classes and hides their complexity.

## Structure

The project demonstrates Facade through **ShoppingOrder**.

The subsystem includes classes such as:

- `ShoppingBasket`
- `Inventory`
- `InventoryOrder`
- `PaymentProcessor`
- `PurchaseOrder`
- `PurchaseInvoice`
- `BasketItem`
- `SMSNotification`

The example models an order workflow where multiple subsystem components participate in completing a purchase.

## Implementation in This Project

```text
Client
  |
  v
Facade / High-Level Entry Point
  |
  +--> Shopping Basket
  +--> Inventory
  +--> Payment
  +--> Order
  +--> Invoice
  +--> Notification
```

The client does not need to know every subsystem interaction.

## Advantages

- Simplifies client usage.
- Reduces coupling to subsystem details.
- Centralizes a high-level workflow.

## Disadvantages / Trade-offs

- The facade can become a large coordinator if too much logic is placed inside it.
- Advanced clients may still need direct access to subsystem classes.

## When to Use

Use it when a subsystem is complex and most clients need only a small set of high-level operations.

## Related Patterns

Adapter, Mediator, Abstract Factory

## Key Takeaways

The important point is not to use a design pattern simply because it exists. The pattern should be introduced when its structure solves a real design problem and provides a meaningful improvement in flexibility, maintainability, or separation of responsibilities.
