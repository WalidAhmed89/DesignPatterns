# ApplicationConfiguration Builder Example

## Overview

This example demonstrates how the **Builder Pattern** can be used to construct a complex `ApplicationConfiguration` object.

The configuration contains many properties such as database settings, server configuration, JWT settings, logging level, caching, and Redis configuration.

Instead of creating the configuration directly through a large constructor, the **Builder Pattern** separates the construction process from the final `ApplicationConfiguration` object.

The example also uses different **Concrete Builders** to create different configuration profiles:

* Development
* Production
* Testing

A **Director** controls the construction steps and ensures that they are executed in the required order.

---

## Problem

`ApplicationConfiguration` contains many fields:

```text
Application Name
Database URL
Database Username
Database Password
Server Port
JWT Secret
Logging Level
Cache Enabled
Redis URL
```

Creating this object directly with a constructor would require passing many parameters:

```java
new ApplicationConfiguration(
    applicationName,
    databaseUrl,
    databaseUsername,
    databasePassword,
    serverPort,
    JWTSecret,
    loggingLevel,
    cacheEnabled,
    redisUrl
);
```

This makes object construction harder to read and maintain.

It also exposes construction details to the client.

---

## Solution

The **Builder Pattern** separates the construction process from the final object.

The construction is divided into multiple steps:

```text
setApplicationName()
setDatabase()
setServerPort()
setJWTSecret()
setLoggingLevel()
setCacheEnabled()
setRedisUrl()
build()
```

Different Concrete Builders provide different values for these steps.

---

# Pattern Structure

```text
                     Client
                       |
                       v
          ApplicationConfigurationDirector
                       |
                       v
        ApplicationConfigurationBuilder
                 /        |        \
                /         |         \
               v          v          v
       Development   Production   Testing
          Builder       Builder     Builder
               \         |         /
                \        |        /
                 \       |       /
                       v
             ApplicationConfiguration
                    (Product)
```

---

# Components

## 1. Product

### `ApplicationConfiguration`

The `ApplicationConfiguration` class is the **Product**.

It represents the final configuration object.

It contains:

```java
private final String applicationName;
private final String databaseUrl;
private final String databaseUsername;
private final String databasePassword;
private final int serverPort;
private final String JWTSecret;
private final String loggingLevel;
private final boolean cacheEnabled;
private final String redisUrl;
```

The fields are `final`, meaning the configuration is fully constructed when the object is created.

---

## 2. Builder

### `ApplicationConfigurationBuilder`

The `ApplicationConfigurationBuilder` interface defines the construction steps.

```java
public interface ApplicationConfigurationBuilder {

    void setApplicationName();

    void setDatabase();

    void setServerPort();

    void setJWTSecret();

    void setLoggingLevel();

    void setCacheEnabled();

    void setRedisUrl();

    ApplicationConfiguration build();
}
```

The Builder does not define the actual configuration values.

It only defines **what construction steps are required**.

---

## 3. Concrete Builders

The example contains three Concrete Builders:

```text
DevelopmentBuilder
ProductionBuilder
TestingBuilder
```

Each builder implements:

```java
ApplicationConfigurationBuilder
```

and provides its own configuration values.

### DevelopmentBuilder

For example:

```java
@Override
public void setApplicationName() {
    applicationName = "MyApp-Development";
}

@Override
public void setLoggingLevel() {
    loggingLevel = "DEBUG";
}

@Override
public void setCacheEnabled() {
    cacheEnabled = false;
}
```

The Development Builder creates a development-oriented configuration.

---

### ProductionBuilder

The Production Builder provides production-specific values such as:

```java
@Override
public void setApplicationName() {
    applicationName = "MyApp-Production";
}

@Override
public void setLoggingLevel() {
    loggingLevel = "INFO";
}

@Override
public void setCacheEnabled() {
    cacheEnabled = true;
}
```

---

### TestingBuilder

The Testing Builder provides values intended for the testing profile.

```java
@Override
public void setApplicationName() {
    applicationName = "MyApp-Testing";
}

@Override
public void setLoggingLevel() {
    loggingLevel = "TEST";
}

@Override
public void setCacheEnabled() {
    cacheEnabled = false;
}
```

---

# 4. Director

### `ApplicationConfigurationDirector`

The Director is responsible for controlling the construction process.

```java
public ApplicationConfiguration construct(
        ApplicationConfigurationBuilder builder) {

    builder.setApplicationName();
    builder.setDatabase();
    builder.setServerPort();
    builder.setJWTSecret();
    builder.setLoggingLevel();
    builder.setCacheEnabled();
    builder.setRedisUrl();

    return builder.build();
}
```

The Director knows:

> **What steps need to happen and in what order.**

However, it does not know the actual values or implementation details.

For example, it does not know whether the database is:

```text
Development Database
Production Database
Testing Database
```

The Concrete Builder handles those details.

---

# 5. Client

The Client chooses which Concrete Builder should be used.

For example:

```java
ApplicationConfigurationBuilder developmentBuilder =
        new DevelopmentBuilder();

ApplicationConfigurationDirector director =
        new ApplicationConfigurationDirector();

ApplicationConfiguration development =
        director.construct(developmentBuilder);

development.show();
```

The Client only needs to know that it wants a `DevelopmentBuilder`.

It does not need to manually execute:

```java
setApplicationName();
setDatabase();
setServerPort();
setJWTSecret();
setLoggingLevel();
setCacheEnabled();
setRedisUrl();
```

The Director handles these steps.

---

# Construction Flow

For a Development configuration:

```text
Client
  |
  | creates
  v
DevelopmentBuilder
  |
  | passed to
  v
Director
  |
  | executes construction steps
  |
  +--> setApplicationName()
  +--> setDatabase()
  +--> setServerPort()
  +--> setJWTSecret()
  +--> setLoggingLevel()
  +--> setCacheEnabled()
  +--> setRedisUrl()
  |
  +--> build()
          |
          v
ApplicationConfiguration
```

---

# Why Use Builder Here?

The Builder Pattern is useful because `ApplicationConfiguration` is a **complex object** with many properties and different possible configurations.

Without Builder:

```java
new ApplicationConfiguration(
    applicationName,
    databaseUrl,
    databaseUsername,
    databasePassword,
    serverPort,
    JWTSecret,
    loggingLevel,
    cacheEnabled,
    redisUrl
);
```

The constructor becomes difficult to read and maintain.

With Builder:

```text
DevelopmentBuilder
ProductionBuilder
TestingBuilder
```

each profile can define its own construction details.

The Client can therefore work with the common Builder interface instead of manually constructing every configuration.

---

# Key Idea

The main idea of this example is:

> **Separate the construction of a complex object from the object itself.**

The `ApplicationConfiguration` represents **what is being created**.

The Builders represent **how it is created**.

The Director represents **the order of the construction process**.

---

# Pattern Roles Summary

| Component                          | Role             |
| ---------------------------------- | ---------------- |
| `ApplicationConfiguration`         | Product          |
| `ApplicationConfigurationBuilder`  | Builder          |
| `DevelopmentBuilder`               | Concrete Builder |
| `ProductionBuilder`                | Concrete Builder |
| `TestingBuilder`                   | Concrete Builder |
| `ApplicationConfigurationDirector` | Director         |
| `Client`                           | Client           |

---

# When This Pattern Is Useful

Builder is useful when:

* An object has many fields.
* Object construction involves multiple steps.
* There are different variations of the same object.
* The constructor would contain many parameters.
* The Client should not handle construction details.
* Different representations of the same object need to be created.

---

# Key Takeaway

The **Builder Pattern** allows us to construct a complex object step-by-step while separating the construction process from the final product.

In this example:

```text
Different Builders
       ↓
Different Configurations
       ↓
Same Product
       ↓
ApplicationConfiguration
```

The Client chooses the desired configuration profile, while the Builder and Director handle the construction details.
