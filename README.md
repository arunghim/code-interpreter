# Code Interpreter

A **Java-based interpreter** for a minimal procedural **made-up** programming language that supports variables, arithmetic expressions, control flow, and structured parsing.  
Built entirely from scratch using **recursive descent parsing**, **tokenization**, and an **execution engine**, this project demonstrates the foundations of **language design**, **syntax trees**, **runtime evaluation**, and **pretty-printing of source code**.

---

## Overview

The Code Interpreter takes source code written in the language, along with a file containing data for variables being read:

1. **Tokenizes** the source into meaningful symbols.
2. **Parses** the tokens into an Abstract Syntax Tree (AST).
3. **Executes** the AST while managing variables and evaluating expressions.
4. **Pretty-prints** the parsed code in a clean, easy-to-read format.

This was designed as a learning tool to explore how real interpreters and compilers work under the hood. No external parsing libraries were used.

---

## Features

- **Tokenizer** : Converts source code into a stream of tokens.
- **Recursive Descent Parser** : Builds an abstract syntax tree (AST).
- **Interpreter Engine** : Executes the parsed AST.
- **Symbol Table Management** : Tracks declared identifiers and their values.
- **Expressions** : Supports `+`, `-`, `*`, `/`, and nested parentheses.
- **Assignments** : Evaluates and stores results in variables.
- **Conditionals and Loops** : Implements `if`, `then`, `else`, `while`, and `end`.
- **Structured I/O** : Provides `read` and `write` statements.
- **Pretty Printing** : Outputs parsed programs in a clean, formatted layout for readability.
- **Error Handling** : Displays clear, descriptive syntax and runtime errors.

---

## How to Use

1. **Prepare your files:**
    - A **program file** (e.g., `mathUgly.txt`) containing the source code you want to interpret.
    - A **data file** (e.g., `mathOpYgtX.txt`) containing the input data for that program to be read.

2. **Run the program:**  
   When prompted, enter the file paths to your code and data files.
   ```
   Enter path to code file: data/programs/legal/mathUgly.txt
   Enter path to data file: data/programs/input/mathOpYgtX.txt
   ```
   
---