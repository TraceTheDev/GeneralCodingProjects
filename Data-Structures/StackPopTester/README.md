# StackPopTester

A focused Java project designed to test the behavior of the `Stack.pop()` method using both automated JUnit tests and a manual console-based demo, providing clear insight into stack operations and exception handling in Java.

---

## Project Structure

```
StackPopTester/
├── src/
│   └── StackPopDemo.java
├── test/
│   └── StackPopTest.java
```

---

## Core Java Classes

### `StackPopDemo.java`
A manual console-based driver:
- Demonstrates core `Stack` operations like `push()`, `pop()`, and `peek()`.
- Prints stack changes in sequence to show LIFO behavior.
- Intentionally triggers and catches `EmptyStackException` when attempting to pop from an empty stack.
- Ideal for visually verifying stack behavior during execution.

### `StackPopTest.java`
A JUnit 5 test class for verifying the correctness of the `pop()` method:
- Tests popping from an empty stack (expects an exception).
- Pushes elements into the stack and ensures the top value is returned by `pop()`.
- Covers boundary cases: max size, one less, and one more than the defined limit.
- Uses assertions (`assertEquals()`, `assertThrows()`) to ensure proper behavior.

---

## How to Run

### From an IDE
1. Open the project folder.
2. Navigate to `StackPopDemo.java`.
3. Click **Run** on the main method to see stack behavior in the console.
4. To run JUnit tests, make sure the JUnit 5 library is added to the classpath.
   - In Eclipse: Right-click project → Build Path → Add Libraries → JUnit → JUnit 5.
   - In IntelliJ: File → Project Structure → Libraries → Add JARs → Select `junit-platform-console-standalone` or equivalent.
5. Run `StackPopTest.java` as a JUnit Test.

### From the command line
To run the demo class:
```bash
javac src/StackPopDemo.java -d out
java -cp out StackPopDemo
```

To run the JUnit tests:
1. Download the JUnit 5 JARs (or the standalone console JAR).
2. Compile and run using:
```bash
javac -cp "lib/junit-platform-console-standalone-1.10.0.jar" test/StackPopTest.java -d out
java -jar lib/junit-platform-console-standalone-1.10.0.jar --class-path out --scan-class-path
```

> 🔹 Replace `lib/` with the path to your JAR file location if different.

---

## Future Enhancements
- Add parameterized test cases to reduce redundancy and increase test coverage.
- Expand test suite to include `peek()`, `search()`, and `empty()` methods.
- Create a GUI interface to visualize the stack operations in real time.
- Package project using Maven or Gradle for dependency and test management.

---

## License
This project is licensed for educational and personal use only. Redistribution or modification without permission is prohibited.  
See the [LICENSE] file for full details.

---

## Author
**Trace Davis**  
- GitHub: https://github.com/Trace0727  
- LinkedIn: https://www.linkedin.com/in/trace-d-926380138/
