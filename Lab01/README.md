# Lab 01 - Environment Setup and Java Basics

This directory contains the completed Java work for exercises 2.2.1-2.2.6 and
6.1-6.6 from the Lab 01 handout.

## Compile and run

From this directory, using Java 8 or later:

```text
javac -d out src\*.java
java -cp out BasicOperations
```

Use the class name for the exercise you want to run. The console programs read
their input from standard input. `FirstDialog`, `HelloNameDialog`,
`ShowTwoNumbers`, and `ChoosingOption` use Swing dialogs.

## Exercises

| Exercise | Class |
| --- | --- |
| 2.2.1 | `HelloWorld` |
| 2.2.2 | `FirstDialog` |
| 2.2.3 | `HelloNameDialog` |
| 2.2.4 | `ShowTwoNumbers` |
| 2.2.5 | `BasicOperations` |
| 2.2.6 | `EquationSolver` |
| 6.1 | `ChoosingOption` |
| 6.2 | `InputFromKeyboard` |
| 6.3 | `Triangle` |
| 6.4 | `DaysOfMonth` |
| 6.5 | `ArrayStatistics` |
| 6.6 | `MatrixAddition` |

The `out` directory is generated build output and is intentionally ignored by
Git. See `answers.txt` for the exercise questions.
