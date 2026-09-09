# Command Pattern — Bank Transaction Example

## Overview

This example demonstrates the **Command Design Pattern** using a simple banking transaction system.

The system supports two operations:

- Send money
- Withdraw money

Each operation is represented by its own Command object.

The example demonstrates how a common `Command` interface allows the same Invoker to execute different actions without knowing how those actions are implemented.

---

## 🧩 Classes

```text
Behavioral/
└── Command/
    ├── BankAccount.java
    ├── Command.java
    ├── SendMoneyCommand.java
    ├── WithdrawCommand.java
    ├── TransactionButton.java
    └── Program.java
```

---

## 🏗️ Pattern Roles

### `BankAccount` — Receiver

`BankAccount` contains the actual operations:

```java
public void sendMoney(double amount)
public void withdrawMoney(double amount)
```

It is responsible for performing the real banking actions.

---

### `Command` — Command

The common interface for all commands:

```java
public interface Command {
    void execute();
}
```

The Invoker only depends on this abstraction.

---

### `SendMoneyCommand` — Concrete Command

Encapsulates the request to send money.

```java
public class SendMoneyCommand implements Command {

    private final BankAccount account;
    private final double amount;

    public SendMoneyCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.sendMoney(amount);
    }
}
```

The command stores:

- The Receiver (`BankAccount`)
- The required data (`amount`)

When `execute()` is called, it delegates the operation to the Receiver.

---

### `WithdrawCommand` — Concrete Command

Encapsulates the request to withdraw money.

```java
public class WithdrawCommand implements Command {

    private final BankAccount account;
    private final double amount;

    public WithdrawCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.withdrawMoney(amount);
    }
}
```

---

### `TransactionButton` — Invoker

The `TransactionButton` stores a Command and executes it when clicked.

```java
public class TransactionButton {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void click() {
        command.execute();
    }
}
```

Notice that the button does not know:

- Whether it is sending money
- Whether it is withdrawing money
- How the operation works
- Which methods exist inside `BankAccount`

It only knows:

```java
command.execute();
```

---

### `Program` — Client

The Client creates and connects the objects.

```java
public class Program {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        SendMoneyCommand sendMoneyCommand =
                new SendMoneyCommand(account, 5000);

        WithdrawCommand withdrawCommand =
                new WithdrawCommand(account, 4000);

        TransactionButton transactionButton =
                new TransactionButton();

        transactionButton.setCommand(sendMoneyCommand);
        transactionButton.click();

        transactionButton.setCommand(withdrawCommand);
        transactionButton.click();
    }
}
```

---

## 🔄 Execution Flow

### Sending Money

First, the client creates the command:

```java
SendMoneyCommand sendMoneyCommand =
        new SendMoneyCommand(account, 5000);
```

Then assigns it to the Invoker:

```java
transactionButton.setCommand(sendMoneyCommand);
```

When the button is clicked:

```java
transactionButton.click();
```

The execution flow becomes:

```text
Program
   ↓
TransactionButton
   ↓
command.execute()
   ↓
SendMoneyCommand
   ↓
BankAccount.sendMoney()
```

Output:

```text
Sending $5000.0
```

---

## 💸 Withdrawing Money

The same Invoker can execute another Command.

```java
transactionButton.setCommand(withdrawCommand);
transactionButton.click();
```

Execution flow:

```text
Program
   ↓
TransactionButton
   ↓
command.execute()
   ↓
WithdrawCommand
   ↓
BankAccount.withdrawMoney()
```

Output:

```text
Withdraw $4000.0
```

---

## 🔍 Why Use Command Here?

Without Command, the client could directly call:

```java
account.sendMoney(5000);
account.withdrawMoney(4000);
```

With Command:

```text
Program
   ↓
TransactionButton
   ↓
Command
   ↓
BankAccount
```

The `TransactionButton` does not need to know which operation it is executing.

It only works with the `Command` abstraction:

```java
command.execute();
```

This makes different operations interchangeable.

---

## 🔀 Interchangeable Commands

The same `TransactionButton` can execute different commands.

```java
transactionButton.setCommand(sendMoneyCommand);
transactionButton.click();
```

Then:

```java
transactionButton.setCommand(withdrawCommand);
transactionButton.click();
```

The Invoker does not change.

Only the Command changes.

This demonstrates one of the important benefits of the Command Pattern:

> **The requester can work with different actions through the same abstraction.**

---

## 📊 Pattern Mapping

| Pattern Role | Implementation |
|---|---|
| Command | `Command` |
| Concrete Command | `SendMoneyCommand` |
| Concrete Command | `WithdrawCommand` |
| Receiver | `BankAccount` |
| Invoker | `TransactionButton` |
| Client | `Program` |

---

## 🆚 Command vs Observer in This Project

It is useful to compare this example with the Observer examples in this repository.

### Command

The user requests an operation:

```text
"Send $5000"
```

```text
TransactionButton
       ↓
SendMoneyCommand
       ↓
BankAccount
       ↓
sendMoney()
```

### Observer

An object changes and notifies interested objects:

```text
ProductInventory
       ↓
Stock Changed
       ↓
notifyObservers()
       ↓
Cart
ProductList
Checkout
```

The fundamental difference is:

```text
Command  → represents an ACTION
Observer → represents a NOTIFICATION
```

---

## 🎯 Learning Goals

This example was created to understand the practical structure of the Command Pattern.

The main concepts demonstrated are:

- Encapsulating a request as an object
- Separating the requester from the receiver
- Understanding the Command interface
- Understanding Concrete Commands
- Understanding the Receiver
- Understanding the Invoker
- Using polymorphism to execute different actions
- Understanding why `execute()` is useful

The main idea to remember is:

> **The Command object represents what should be done, while the Receiver knows how to do it.**

---

## ⚠️ Note

This is a **learning example**, not a complete banking application.

The goal is to isolate the Command Pattern and make its responsibilities and object relationships easy to understand.
