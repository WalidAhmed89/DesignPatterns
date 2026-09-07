# Abstract Factory — Database System Example

## Purpose

This example demonstrates creating a family of database-related objects for different database technologies.

## Main Classes

| Class | Responsibility |
|---|---|
| `IDatabase` | Database-family abstraction. |
| `IConnection` | Connection product abstraction. |
| `IQuery` | Query product abstraction. |
| `MySQLFactory` | Creates the MySQL product family. |
| `PostgresSQLFactory` | Creates the PostgreSQL product family. |
| `MySQLConnection` | MySQL connection implementation. |
| `MySQLQuery` | MySQL query implementation. |
| `PostgresSQLConnection` | PostgreSQL connection implementation. |
| `PostgresSQLQuery` | PostgreSQL query implementation. |

## How It Works

The application can select a database family through a concrete factory. Once selected, the factory creates compatible connection and query implementations.

## Why Abstract Factory Fits

A database system commonly requires several related components to work together. Treating them as a product family avoids hard-coding each concrete database implementation throughout the client.

## Key Takeaway

Changing the database family can be achieved by changing the factory rather than rewriting the client workflow.
