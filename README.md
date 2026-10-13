# CTCI Practice

My personal practice repo for working through *Cracking the Coding Interview* (6th Edition) in Java.

## Workflow

For each problem:

1. **Solve it by hand first.** Work it out on paper before touching the keyboard.
2. **Implement it here.** Type up my solution in the chapter's class, marked `// my solution`.
3. **Write my own tests.** Add JUnit tests covering normal cases and edge cases (empty strings, duplicates, etc.).
4. **Check the book's solution.** If my answer wasn't optimal (or wasn't right), implement the optimal version alongside mine, marked `// optimal solution` (method name prefixed with `optimal`), and test it too.

Keeping both versions lets me compare my approach to the optimal one later.

## Project Structure

```
src/
├── main/java/ctci/
│   ├── Chapter1.java      # Solutions for Chapter 1 (Arrays and Strings)
│   └── Main.java          # Scratch runner for quick manual checks
└── test/java/ctci/
    └── Chapter1Test.java  # My JUnit tests for Chapter 1
```

Each chapter gets its own `ChapterN.java` class with a matching `ChapterNTest.java`.

## Running

Requires Java 21 and Maven.

```bash
mvn test                          # run all tests
mvn test -Dtest=Chapter1Test      # run one chapter's tests
```

## Progress

### Chapter 1: Arrays and Strings

| #   | Problem       | My Solution | Optimal Solution |
|-----|---------------|:-----------:|:----------------:|
| 1.1 | Is Unique     | ✅          | ✅               |
| 1.2 | Check Permutation | ✅      | —                |
| 1.3 | URLify        |             |                  |
| 1.4 | Palindrome Permutation |    |                  |
| 1.5 | One Away      |             |                  |
| 1.6 | String Compression |        |                  |
| 1.7 | Rotate Matrix |             |                  |
| 1.8 | Zero Matrix   |             |                  |
| 1.9 | String Rotation |           |                  |

`—` = my solution was already optimal.
