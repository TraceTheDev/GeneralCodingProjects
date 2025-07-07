# ProductDemo

A concise Java console application demonstrating object encapsulation, state mutation, and step-by-step console narration through a `Product`’s lifecycle.

---

## Project Structure
```text
ProductDemo/
├── src/
│   ├── Product.java
│   └── ProductLifecycle.java
└──
```

---

## Core Java Classes

### `Product.java`
Defines a simple inventory item:
- **Fields**: `code` (String), `price` (double), `count` (int)  
- **Constructor**: initializes all three fields  
- **Getters/Setters**: basic access and mutation  
- **toString()**: formats output as `code | $price | qty: count`

### `ProductLifecycle.java`
Drives the demo with verbose console output:
1. **Create** a `Product` (`Apple`, $0.40, qty 3)  
2. **Add inventory** (+10) and show before/after  
3. **Sell inventory** (-5) and show before/after  
4. **Update fields** via setters (`Golden Delicious Apple`, $0.55, qty 4) with labeled banners  

---

## Running the Program

### From an IDE  
1. Import the project as a Java application.  
2. Run `ProductLifecycle.java` (right-click ▶ Run).  
3. Observe the console banners and before/after state changes.

### From the command line  
```bash
javac src/Product.java src/ProductLifecycle.java -d out
java -cp out ProductLifecycle
```

---

## Future Enhancements
- Replace hard-coded values with user input (e.g. via `Scanner`)  
- Add basic input validation in setters  
- Introduce JUnit 5 tests for `Product` behavior  
- Externalize console banners or switch to a logging framework  

---

## License
This project is licensed for personal, non-commercial use only. Redistribution, resale, or modification is prohibited without written permission from the author.  
See the [LICENSE] file for full details.

---

## Author

**Trace Davis**  
- GitHub: [TraceTheDev](https://github.com/TraceTheDev)  
- LinkedIn: [Trace Davis](https://www.linkedin.com/in/trace-d-926380138/)
