# Factory — Delivery Example

## Purpose

This example demonstrates factory-based creation of different delivery services.

## Main Classes

| Class | Responsibility |
|---|---|
| `IDeliver` | Common delivery product abstraction. |
| `BikeDelivery` | Bike delivery implementation. |
| `CarDelivery` | Car delivery implementation. |
| `DroneDelivery` | Drone delivery implementation. |
| `IDeliveryFactory` | Factory abstraction. |
| `BikeDeliveryFactory` | Creates bike delivery. |
| `CarDeliveryFactory` | Creates car delivery. |
| `DroneDeliveryFactory` | Creates drone delivery. |
| `Program` | Demonstrates the example. |

## How It Works

Each concrete factory is responsible for creating a particular delivery implementation.

## Why Factory Fits

The client can work with `IDeliver` while the concrete delivery mechanism is selected through the factory.

## Key Takeaway

Adding another delivery type can be isolated to a new implementation and factory without changing the common client abstraction.
