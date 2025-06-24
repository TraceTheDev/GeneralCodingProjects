# InstrumentInformation

A simple Java console program that asks the user to enter details about two musical instruments—one general and one string-based—and then displays their information.

---

## Project Structure

```
InstrumentInformation/
├── src/
│   ├── Instrument.java
│   ├── StringInstrument.java
│   └── InstrumentInformation.java
└──
```

---

## Core Java Classes

### `Instrument.java`
Represents a generic musical instrument:
- `instrumentName`: Name of the instrument (e.g., “Piano”)
- `instrumentManufacturer`: Manufacturer or brand
- `yearBuilt`: The year the instrument was made
- `cost`: Price of the instrument
- Standard setters/getters for all fields
- `printInfo()`: Outputs a formatted “Instrument Information” block

### `StringInstrument.java`
Extends `Instrument` to model string-based instruments:
- Adds `numStrings` and `numFrets` as private fields
- Provides setters/getters for the new fields

### `InstrumentInformation.java`
Acts as the program driver:
- Prompts the user for general and string instrument details
- Instantiates `Instrument` and `StringInstrument` objects with the input
- Prints the general instrument block, then the string instrument block with extra details

---

## How to Run

### From an IDE
1. Open the project folder.
2. Navigate to `InstrumentInformation.java`.
3. Click **Run** on the main method and follow the prompts in the console.

### From the command line
```bash
javac src/InstrumentInformation.java src/Instrument.java src/StringInstrument.java -d out
java -cp out InstrumentInformation
```

---

## Future Enhancements
- Add support for other instrument categories (e.g., wind, percussion)
- Persist instrument data to a file or database
- Include a GUI (Swing or JavaFX) for a more interactive experience

---

## License
This project is licensed for personal, non-commercial use only. Redistribution, resale, or modification is prohibited without written permission from the author.  
See the [LICENSE] file for full details.

---

## Author
**Trace Davis**  
- GitHub: https://github.com/Trace0727  
- LinkedIn: https://www.linkedin.com/in/trace-d-926380138/
