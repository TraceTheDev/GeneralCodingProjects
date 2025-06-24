# DrawHalfArrow

A compact Java console application that reinforces foundational control-flow concepts—input validation, nested loops, and `StringBuilder` usage—by rendering a half-arrow made of asterisks based on user-supplied dimensions.

---

## Project Structure
```
DrawHalfArrow/
├── src/
│   └── DrawHalfArrow.java
└──
```

---

## Core Java Class

### `DrawHalfArrow.java`
Handles every aspect of the program:

- **User-prompted fields**  
  - `arrowBaseHeight` – number of rows in the rectangular shaft  
  - `arrowBaseWidth`  – number of `*` per shaft row  
  - `arrowHeadWidth`  – widest row of the triangular head (must exceed the base width)

- **Key responsibilities**  
  1. Guides the user with clear console prompts and enforces that the head width is larger than the base width.  
  2. Builds one shaft row via a `StringBuilder`, then prints it `arrowBaseHeight` times.  
  3. Prints the arrow head by decrementing the row length from `arrowHeadWidth` down to one.  

The result is a half-arrow shape directly in the terminal.

---

## Future Enhancements
- Allow users to pick the arrow character (e.g., `#`, `$`, or Unicode arrows)  
- Support right-aligned or full (two-sided) arrows  
- Wrap drawing logic in separate methods for easier unit testing  
- Add JUnit 5 tests that verify output for sample inputs

---

## License
This project is licensed for personal, non-commercial use only. Redistribution, resale, or modification is prohibited without written permission from the author.  
See the [LICENSE] file for full details.

---

## Author
**Trace Davis**  
- GitHub: <https://github.com/Trace0727>  
- LinkedIn: <https://www.linkedin.com/in/trace-d-926380138/>
