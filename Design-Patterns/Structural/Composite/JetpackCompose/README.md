# Composite — Jetpack Compose Example

## Purpose

This example models UI elements and containers as a tree.

## Main Classes

| Class | Responsibility |
|---|---|
| `IComponent` | Common component abstraction. |
| `TextView` | Leaf component. |
| `ImageView` | Leaf component. |
| `WebView` | Leaf component. |
| `Container` | Composite containing child components. |
| `Program` | Demonstrates the component tree. |

## How It Works

Leaf components represent individual UI elements. `Container` can contain multiple `IComponent` objects, including other containers.

## Why Composite Fits

A UI hierarchy is naturally recursive: a container can contain individual components and other containers.

## Key Takeaway

Composite lets the client treat a single component and a group of components through the same interface.
