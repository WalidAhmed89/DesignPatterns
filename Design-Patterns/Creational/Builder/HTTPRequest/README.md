# HTTPRequest Builder Example

## Overview

This example demonstrates how the **Builder Pattern** can be used to construct a complex `HttpRequest` object.

An HTTP request can contain multiple properties such as:

* HTTP Method
* URL
* Headers
* Query Parameters
* Body
* Timeout

Some of these properties are required, while others are optional.

Instead of using a large constructor with many parameters, the **Builder Pattern** provides a clean and readable way to construct the request step-by-step.

This example uses a **Fluent Builder** that allows method chaining.

---

## Problem

The `HttpRequest` object contains multiple properties:

```text
HTTP Method
URL
Headers
Query Parameters
Body
Timeout
```

Creating the object directly using a constructor would require passing all parameters:

```java
new HttpRequest(
    method,
    url,
    headers,
    query,
    body,
    timeout
);
```

As the number of properties increases, this approach becomes harder to read and maintain.

It also makes it difficult to distinguish between required and optional values.

---

## Solution

The **Builder Pattern** separates the construction of the `HttpRequest` from the final `HttpRequest` object.

Instead of using a large constructor, the Client can construct the request using chained methods:

```java
HttpRequest request = new HttpRequestBuilder()
        .method("POST")
        .url("/users")
        .headers("Authorization", "Bearer xxx")
        .headers("Content-Type", "application/json")
        .queryParameters("active", "true")
        .body("{\"name\":\"Walid\"}")
        .timeout(5000)
        .build();
```

This makes the construction process more readable and easier to maintain.

---

# Pattern Structure

Unlike the traditional Builder example, this implementation does **not** use a Director.

The structure is:

```text
                     Client
                       |
                       v
              HttpRequestBuilder
                       |
                 build()
                       |
                       v
                  HttpRequest
                    Product
```

The Builder itself handles the construction process because there is no fixed construction sequence that needs to be managed by a separate Director.

---

# Components

## 1. Product

### `HttpRequest`

The `HttpRequest` class is the **Product**.

It represents the final HTTP request object.

It contains:

```java
private final String URL;
private final String httpMethod;
private final Map<String, String> headers;
private final Map<String, String> query;
private final String body;
private final int timeout;
```

The properties are `final`, meaning their values are provided when the `HttpRequest` is created.

---

## 2. Builder

### `HttpRequestBuilder`

`HttpRequestBuilder` is responsible for collecting the values required to create the final `HttpRequest`.

It contains:

```java
private String method;
private String url;

private final Map<String, String> headers = new HashMap<>();
private final Map<String, String> queryParameters = new HashMap<>();

private String body;
private int timeout = 3000;
```

The Builder provides methods for configuring the request:

```text
method()
url()
headers()
queryParameters()
body()
timeout()
build()
```

---

# Fluent Interface

The Builder uses **method chaining**.

For example:

```java
.method("POST")
.url("/users")
.body("{\"name\":\"Walid\"}")
.timeout(5000)
```

Each method returns:

```java
return this;
```

This allows another method to be called immediately.

For example:

```java
HttpRequestBuilder builder = new HttpRequestBuilder();

builder
    .method("POST")
    .url("/users")
    .body("...")
    .timeout(5000);
```

This style is commonly known as a **Fluent Builder**.

---

# Required Fields

The example treats:

```text
HTTP Method
URL
```

as required properties.

The validation is performed inside `build()`.

For example:

```java
if (method == null || method.isBlank()) {
    throw new IllegalStateException(
        "HTTP Request is required"
    );
}
```

And:

```java
if (url == null || url.isBlank()) {
    throw new IllegalStateException(
        "URL is required"
    );
}
```

This prevents an invalid `HttpRequest` from being created.

---

# Optional Fields

Some properties are optional.

For example:

```java
private String body;
```

The Client does not have to provide a body.

The timeout also has a default value:

```java
private int timeout = 3000;
```

Therefore, if the Client does not specify a timeout, the request uses:

```text
3000 ms
```

The Client can override it:

```java
.timeout(5000)
```

---

# Headers and Query Parameters

The Builder allows multiple headers to be added:

```java
.headers("Authorization", "Bearer xxx")
.headers("Content-Type", "application/json")
```

Internally, the values are stored in a `Map`:

```java
private final Map<String, String> headers = new HashMap<>();
```

The same approach is used for query parameters:

```java
.queryParameters("active", "true")
```

which are stored in:

```java
private final Map<String, String> queryParameters =
        new HashMap<>();
```

---

# Build Process

The `build()` method creates the final Product.

```java
return new HttpRequest(
        method,
        url,
        new HashMap<>(headers),
        new HashMap<>(queryParameters),
        body,
        timeout
);
```

The Builder collects all the configuration values and then creates the final `HttpRequest`.

The general flow is:

```text
Client
  |
  | configure
  v
HttpRequestBuilder
  |
  +--> method()
  +--> url()
  +--> headers()
  +--> queryParameters()
  +--> body()
  +--> timeout()
  |
  +--> build()
          |
          v
      HttpRequest
```

---

# Defensive Copying

The Builder creates new `HashMap` instances when constructing the `HttpRequest`:

```java
new HashMap<>(headers)
```

and:

```java
new HashMap<>(queryParameters)
```

This means the Product receives copies of the maps rather than directly receiving the Builder's internal maps.

This helps separate the constructed `HttpRequest` from the Builder's mutable collections.

---

# Client

The Client is responsible for selecting the values it wants for the request.

Example:

```java
public class Client {

    public static void main(String[] args) {

        HttpRequest request = new HttpRequestBuilder()
                .method("POST")
                .url("/users")
                .headers("Authorization", "Bearer xxx")
                .headers("Content-Type", "application/json")
                .queryParameters("active", "true")
                .body("{\"name\":\"Walid\"}")
                .timeout(5000)
                .build();

        request.show();
    }
}
```

The Client does not use the large `HttpRequest` constructor directly.

Instead, it uses the Builder.

---

# Why Is Builder Useful Here?

The Builder Pattern is useful because `HttpRequest` is a **complex object with multiple properties**.

Some properties are:

* Required
* Optional
* Configurable
* Collection-based

Using a constructor would result in:

```java
new HttpRequest(
    method,
    url,
    headers,
    query,
    body,
    timeout
);
```

The Builder provides a more readable alternative:

```java
new HttpRequestBuilder()
        .method("POST")
        .url("/users")
        .headers(...)
        .queryParameters(...)
        .body(...)
        .timeout(...)
        .build();
```

The construction process becomes easier to understand from the code itself.

---

# Why No Director?

The traditional Builder Pattern can contain a `Director` that controls the construction sequence.

However, this example does not require one.

There is no fixed construction algorithm such as:

```text
Step 1
  ↓
Step 2
  ↓
Step 3
  ↓
Step 4
```

Instead, the Client can configure the request according to its needs.

For example, a simple GET request can be:

```java
HttpRequest request = new HttpRequestBuilder()
        .method("GET")
        .url("/users")
        .build();
```

While a POST request can contain additional configuration:

```java
HttpRequest request = new HttpRequestBuilder()
        .method("POST")
        .url("/users")
        .body("{\"name\":\"Walid\"}")
        .timeout(5000)
        .build();
```

Therefore, the Builder itself is sufficient.

---

# Pattern Roles Summary

| Component            | Role                       |
| -------------------- | -------------------------- |
| `HttpRequest`        | Product                    |
| `HttpRequestBuilder` | Builder / Concrete Builder |
| `Client`             | Client                     |
| `Director`           | Not used                   |

---

# Builder vs Constructor

### Constructor

```java
HttpRequest request = new HttpRequest(
    method,
    url,
    headers,
    query,
    body,
    timeout
);
```

### Builder

```java
HttpRequest request = new HttpRequestBuilder()
        .method("POST")
        .url("/users")
        .headers("Authorization", "Bearer xxx")
        .body("{\"name\":\"Walid\"}")
        .timeout(5000)
        .build();
```

The Builder version makes it easier to understand what each value represents.

---

# When This Pattern Is Useful

Builder is useful when:

* An object has many parameters.
* The object contains optional properties.
* The constructor would become large or difficult to read.
* The object can have different configurations.
* Validation is required before object creation.
* A fluent API improves readability.
* The construction process does not necessarily require a separate Director.

---

# Real-World Backend Relevance

This example is especially relevant to backend development because request objects often contain many configurable properties.

Similar Builder-style APIs can be found in Java libraries and frameworks for constructing objects such as:

```text
HTTP Requests
Database Queries
Configuration Objects
DTOs
Client Requests
Cloud Configurations
Security Configurations
```

The main benefit is keeping object creation readable while keeping the final object separate fr
