# DiceTotal

A simple Java-based dice-rolling application built with object-oriented design principles.  
This project demonstrates clean code structure and deterministic pseudo-randomness—ideal for educational or personal study tools.

---

## Project Structure

```
DiceTotal/
├── src/
│   ├── GVDie.java
│   └── RollDice.java
└──
```

---



## Core Java Classes

### `GVDie.java`
Represents a single six-sided die containing:
- `myValue`: The current face value (1-6)  
- `rand`: A `java.util.Random` instance for generating rolls  

### `RollDice.java`
Drives the application:
- Prompts the user for the number of rolls  
- Seeds a `GVDie` with **15** for repeatable output  
- Rolls the die the requested number of times  
- Prints the summed total of all rolls  

---



## Future Enhancements
- Persistent storage (file or database) to save roll histories  
- More interactive GUI using JavaFX or Swing  

---



## License
This project is licensed for personal, non-commercial use only. Redistribution, resale, or modification is prohibited without written permission from the author.  
See the [LICENSE] file for full details.


---



## Author
**Trace Davis**  
- GitHub: [Trace0727](https://github.com/Trace0727)  
- LinkedIn: [Trace Davis](https://www.linkedin.com/in/trace-d-926380138/)
