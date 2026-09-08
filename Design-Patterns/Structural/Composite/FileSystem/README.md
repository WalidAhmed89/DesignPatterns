# Composite Pattern — File System Example

This example demonstrates the **Composite Design Pattern** using a simple File System structure in Java.

The goal is to understand how the Composite Pattern allows individual objects and groups of objects to be treated uniformly through a common interface.

---

## 🎯 What Problem Does Composite Solve?

Imagine a file system where we have:

- Files
- Folders

A `File` is an individual object, while a `Folder` can contain multiple Files and other Folders.

For example:

```text
Root
├── resume.pdf
├── notes.txt
└── Projects
    ├── project1.java
    └── project2.java