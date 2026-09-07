# Facade — Shopping Order Example

## Purpose

This example demonstrates a high-level shopping-order workflow over several subsystem components.

## Main Classes

| Class | Responsibility |
|---|---|
| `ShoppingBasket` | Manages basket-related operations. |
| `BasketItem` | Represents an item in the basket. |
| `Inventory` | Handles inventory concerns. |
| `InventoryOrder` | Coordinates inventory order behavior. |
| `PaymentProcessor` | Handles payment processing. |
| `PurchaseOrder` | Represents purchase-order behavior. |
| `PurchaseInvoice` | Represents invoice behavior. |
| `SMSNotification` | Handles notification. |
| `Program` | Demonstrates the workflow. |

## How It Works

A shopping operation may require inventory, payment, order creation, invoicing, and notification. The Facade concept hides the coordination complexity from the high-level client.

## Why Facade Fits

The subsystem contains several cooperating classes, while the client typically wants one high-level operation.

## Key Takeaway

Facade simplifies usage without necessarily eliminating the underlying subsystem classes.
