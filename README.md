# Code Interpreter

A **Java-based interpreter** for a minimal procedural **made-up** programming language that supports variables, arithmetic expressions, control flow, and structured parsing. Built entirely from scratch using **recursive descent parsing**, **tokenization**, and an **execution engine**, this project demonstrates the foundations of **language design**, **syntax trees**, **runtime evaluation**, and **pretty-printing of source code**.

---

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Language Syntax](#language-syntax)
    - [Program Structure](#program-structure)
    - [Expressions](#expressions)
- [Example Program](#example-program)
- [Example Input](#example-input)
- [Under The Hood](#under-the-hood)
    - [Tokenizer (Lexical Analysis)](#tokenizer-lexical-analysis)
    - [Parser (Syntax Analysis)](#parser-syntax-analysis)
    - [Executor (Runtime Evaluation)](#executor-runtime-evaluation)
    - [Pretty Printer (Formatter)](#pretty-printer-formatter)
- [How to Use](#how-to-use)

---

## Overview

The **Code Interpreter** takes source code written in the language, along with a file containing data for variables being read:

1. **Tokenizes** the source into meaningful symbols.
2. **Parses** the tokens into an Abstract Syntax Tree (AST).
3. **Executes** the AST while managing variables and evaluating expressions.
4. **Pretty-prints** the parsed code in a clean, easy-to-read format.

This was designed as a learning tool to explore how real interpreters and compilers work under the hood. **No external parsing libraries** were used.

---

## Features

- **Tokenizer** – Converts source code into a stream of tokens.
- **Recursive Descent Parser** – Builds an Abstract Syntax Tree (AST).
- **Interpreter Engine** – Executes the parsed AST.
- **Symbol Table Management** – Tracks identifiers and their values using a singleton pattern.
- **Expressions** – Supports `+`, `-`, `*`, `/`, `^`, and nested parentheses.
- **Assignments** – Evaluates expressions and stores results in variables.
- **Conditionals and Loops** – Implements `if`, `then`, `else`, `for`, `while`, and `end`.
- **Structured I/O** – Provides `read` and `write` statements.
- **Pretty Printing** – Outputs parsed programs in a clean, formatted layout.
- **Error Handling** – Displays clear, descriptive syntax and runtime errors.

---

## Language Syntax

The language is defined using a **BNF (Backus-Naur Form)** grammar, which specifies the structure of valid programs. BNF is a formal notation used to describe the syntax of programming languages, allowing us to clearly define how programs are written and parsed.  
These rules help the parser understand the structure of the code, detect syntax errors, and ensure that programs follow the correct form.

### Program Structure

````
<prog>       ::= program <decl seq> begin <stmt seq> end
<decl seq>   ::= <decl> | <decl> <decl seq>
<stmt seq>   ::= <stmt> | <stmt> <stmt seq>
<decl>       ::= int <id list>;
<id list>    ::= <id> | <id>, <id list>
<stmt>       ::= <assign> | <if> | <loop> | <for> | <in> | <out>
<assign>     ::= <id> = <exp>;
<if>         ::= if <cond> then <stmt seq> end
                 if <cond> then <stmt seq> else <stmt seq> end
<loop>       ::= while <cond> loop <stmt seq> end;
<for>        ::= for (<assign> <cond> ; <assign>) loop <stmt seq> end;
<in>         ::= read <id list>;
<out>        ::= write <id list>;
````

### Expressions

````
<cond>       ::= <comp> | !<cond> | [<cond> && <cond>] | [<cond> || <cond>]
<comp>       ::= (<op> <comp op> <op>)
<exp>        ::= <fac> | <fac> + <exp> | <fac> - <exp>
<fac>        ::= <op> | <op> * <fac> | <op> / <fac> | <op> ^ <fac>
<op>         ::= <int> | <id> | (<exp>)
<comp op>    ::= != | == | < | > | <= | >=
<id>         ::= ... as defined by regex ...
<int>        ::= ... as defined by regex (unsigned numbers only)
````

---

### Example Program

````
program
    int X, Y, A;
    int OPER, SUM, DIFF, PROD;
    int INDEX, POWER;
    int ERROR;
begin
    read OPER;
    read X, Y;
    write OPER, X, Y;

    if (OPER == 0) then
        SUM = X + Y;
        write SUM;
    else
        if (OPER == 1) then
            DIFF = X - Y;
            write DIFF;
        else
            if (OPER == 2) then
                PROD = X * Y;
                write PROD;
            else
                ERROR = 2147483647;
                write ERROR;
            end;
        end;
    end;

    for (A = 0; A < 2; A = A + 1) loop
        write A;
    end;

    INDEX = 1;
    POWER = X;
    write POWER;
    while (INDEX < Y) loop
        POWER = POWER * X;
        INDEX = INDEX + 1;
    end;

    POWER = POWER ^ 2;
    write POWER;
end
````

### Example Input

````
1
5
3
````

---

## Under The Hood

The interpreter operates as a step-by-step engine for the source code. Understanding its internals helps reveal how programs are parsed, executed, and pretty-printed.

### Tokenizer (Lexical Analysis)

- Converts raw source code into a stream of tokens.
- Tokens represent meaningful elements: keywords (`if`, `while`), operators (`+`, `-`, `*`), identifiers, and literals.
- Example token stream for the program above:

````
[program, int, X, ,, Y, ,, A, ;, int, OPER, ,, SUM, ,, DIFF, ,, PROD, ;, int, INDEX, ,, POWER, ;, int, ERROR, ;, begin, read, OPER, ;, read, X, ,, Y, ;, write, OPER, ,, X, ,, Y, ;, if, (, OPER, ==, 0, ), then, SUM, =, X, +, Y, ;, write, SUM, ;, else, if, (, OPER, ==, 1, ), then, DIFF, =, X, -, Y, ;, write, DIFF, ;, else, if, (, OPER, ==, 2, ), then, PROD, =, X, *, Y, ;, write, PROD, ;, else, ERROR, =, 2147483647, ;, write, ERROR, ;, end, ;, end, ;, end, ;, for, (, A, =, 0, ;, A, <, 2, ;, A, =, A, +, 1, ), loop, write, A, ;, end, ;, INDEX, =, 1, ;, POWER, =, X, ;, write, POWER, ;, while, (, INDEX, <, Y, ), loop, POWER, =, POWER, *, X, ;, INDEX, =, INDEX, +, 1, ;, end, ;, POWER, =, POWER, ^, 2, ;, write, POWER, ;, end]
````

- Corresponding numeric token values (as per `Types.java`):

````
13 13 12 13 13 13 12 13 12 12 12 13 12 13 13 12 20 26 21 14 22 12 12 20 26 21 14 23 12 12 20 26 21 14 24 12 12 14 12 12 12 12 12 20 14 12 27 12 14 22 21 12 12 14 12 14 12 12 20 27 21 14 24 12 14 22 12 12 14 36 12 12
````

### Parser (Syntax Analysis)

- Builds an **Abstract Syntax Tree (AST)** from the token stream using recursive descent.
- Validates program structure against the grammar.
- AST represents the hierarchical program structure for execution and formatting.

### Executor (Runtime Evaluation)

- Traverses the AST to execute statements sequentially:
    - **Assignments:** Evaluates expressions and updates the symbol table.
    - **Conditionals:** Evaluates `if` and `else` branches.
    - **Loops:** Executes `while` and `for` loops.
    - **I/O:** Executes `read` and `write` statements.
- **Symbol Table:** Singleton pattern ensures consistent variable management.

### Pretty Printer (Formatter)

- Traverses the AST to reconstruct the program in a clean format.
- Adds proper indentation, line breaks, and spacing.
- Outputs a standardized, readable version of the original program.

---

## How to Use

1. **Prepare your files:**
    - A **program file** (e.g., `mathOpYgtX.txt`) containing the source code.
    - A **data file** (e.g., `mathOp1P.txt`) containing input data.

2. **Run the program:**  
   When prompted, enter the file paths:

````
Enter path to code file: data/programs/input/mathOpYgtX.txt
Enter path to data file: data/programs/input/mathOp1P.txt
````

3. **Expected output (console):**

````
OPER = 1
X = 5
Y = 3
DIFF = 2
A = 0
A = 1
POWER = 5
POWER = 15625
````

- Includes a pretty-printed version of the original program.
- To see this program running in a custom IDE, refer to my [**SimpleIDE**](https://github.com/arunghim/simple-ide) repository.

---
