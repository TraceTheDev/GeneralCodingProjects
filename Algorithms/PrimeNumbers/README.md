# PrimeNumbers

A concise Java console application that showcases algorithmic problem-solving, collection usage, and unit testing by generating eight random integers, identifying which of them are prime, and providing a reusable method to compute the first *n* primes.

---

## Project Structure
```text
PrimeNumbers/
├── src/
│   └── PrimeNumbers.java
├── test/
│   └── PrimeNumbersTest.java
└──
```

---

## Core Java Class

### `PrimeNumbers.java`
Central class containing all program logic:

- **Public API**  
  - `List<Integer> computePrimes(int n)` – returns the first *n* prime numbers.  
  - `static boolean isPrime(int n)` – helper that determines whether *n* is prime.  
- **Program flow (`main`)**  
  1. Generates eight random integers between 2 and 100.  
  2. Prints the generated list.  
  3. Filters out and prints only the prime numbers found in that list.  
- Written in a single file to keep the project lightweight and easy to understand.

---

## Running the Program

### From an IDE  
1. **Import** the project as a simple Java project (no external dependencies).  
2. **Open** `PrimeNumbers.java`.  
3. **Right-click** the file and choose **Run** (or use your IDE’s run button) to execute `main()`.  
4. View the console output for the random numbers and the primes among them.

### From the command line  
```bash
javac src/PrimeNumbers.java -d out
java  -cp out PrimeNumbers
```

---

## JUnit Testing

### `PrimeNumbersTest.java`
JUnit 5 test class validating core functionality:

| Test name                               | Purpose                                                      |
|-----------------------------------------|--------------------------------------------------------------|
| `testComputeFivePrimes()`               | Verifies the correct sequence of the first 5 primes.         |
| `testNegativeInputReturnsEmptyList()`   | Ensures negative requests return an empty list.              |
| `testZeroInputReturnsEmptyList()`       | Ensures zero requests return an empty list.                  |
| `testComputeEightPrimes()`              | Confirms the correct sequence of the first 8 primes.         |

> **Running the tests from the command line**  
> ```bash
> javac -cp .:junit-platform-console-standalone-1.10.2.jar \
>       src/PrimeNumbers.java test/PrimeNumbersTest.java -d out
> java  -jar junit-platform-console-standalone-1.10.2.jar \
>       --classpath out --scan-class-path
> ```
> Most modern IDEs (IntelliJ IDEA, Eclipse, VS Code) will detect the test class automatically; simply right-click it and choose **Run Tests**.

---

## Future Enhancements
- Accept upper-bound and list-size from the command line instead of hard-coding them.  
- Persist random numbers and their prime status to a CSV or JSON file.  
- Refactor primality testing to use the Sieve of Eratosthenes for large ranges.  
- Integrate a build tool (Maven or Gradle) for dependency management and standardized test execution.

---

## License
This project is licensed for personal, non-commercial use only. Redistribution, resale, or modification is prohibited without written permission from the author.  
See the [LICENSE] file for full details.

---

## Author
**Trace Davis**  
- GitHub: <https://github.com/Trace0727>  
- LinkedIn: <https://www.linkedin.com/in/trace-d-926380138/>
