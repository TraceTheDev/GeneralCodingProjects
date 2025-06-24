# MatrixMultiplication

A straightforward Java console application that demonstrates the multiplication of a 1D row vector by a square matrix, reinforcing basic array handling and loop logic in procedural programming.

---

## Project Structure

```
MatrixMultiplication/
├── src/
│   └── MatrixMultiplication.java
└──
```

---

## Core Java Class

### `MatrixMultiplication.java`
Executes vector-matrix multiplication:
- Prompts the user for the size `n`, a 1D vector of length `n`, and an `n × n` matrix
- Computes the resulting 1D vector using dot-product logic
- Prints the resulting vector as the output of multiplying `A × B`

**Key Concepts:**
- Uses nested loops for input and calculation
- Demonstrates use of 1D and 2D arrays
- Handles clean console interaction with guided prompts

---

## How to Run

### From an IDE
1. Open the project folder.
2. Navigate to `MatrixMultiplication.java`.
3. Click **Run** on the main method.

### From the command line
```bash
javac src/MatrixMultiplication.java -d out
java -cp out MatrixMultiplication
```

---

## Future Enhancements
- Add matrix-to-matrix multiplication capability
- Include formatted matrix display for input and result
- Implement input validation and exception handling
- Support reading matrix data from a file

---

## License
This project is licensed for personal, non-commercial use only. Redistribution, resale, or modification is prohibited without written permission from the author.  
See the [LICENSE] file for full details.

---

## Author
**Trace Davis**  
- GitHub: https://github.com/Trace0727  
- LinkedIn: https://www.linkedin.com/in/trace-d-926380138/
