# DietarySurveyGUI

A simple Java GUI application that collects personal and dietary information through a survey form and stores the results in a CSV file. This project demonstrates GUI design with Swing, structured form input, and file handling with persistent CSV output. Ideal for learning form-based input, data collection, and file I/O in Java.

---

## Project Structure

```
DietarySurveyApp/
├── src/
│   ├── Main.java                  # Entry point; launches the survey window
│   ├── DietarySurveyGUI.java      # Full Swing GUI with form fields, sliders, buttons, and input handling
│   └── FileHandler.java           # Handles creation and appending to the CSV file
└──
```

---

## Core Java Classes

### `Main.java`
- Contains the `main()` method that launches the dietary survey interface.

### `DietarySurveyGUI.java`
Creates and manages the Swing GUI:
- Fields for name, phone number, email, and gender
- Dietary input via spinners, sliders, checkboxes, and combo boxes
- Submit and clear buttons for processing or resetting the form
- Sends data to `FileHandler` for CSV output

### `FileHandler.java`
Manages CSV output:
- Creates `survey_results.csv` if it does not already exist
- Adds a header line only once when the file is first created
- Appends each new form submission as a new row
- Ensures all I/O streams are safely handled with proper error checking

---


## How to Run

1. Compile all Java files:
```bash
javac src/*.java
```

2. Run the application:
```bash
java -cp src Main
```

3. Fill out the form and click **Submit** to append the data to `survey_results.csv` in the project directory.

> **Note:** The CSV file preserves previous results. To clear the file, manually delete its contents.

---

## Future Enhancements
- Add validation for required fields (e.g., name, email)
- Improve layout using layout managers for better responsiveness
- Include analytics or visual summaries of survey results

---

## License
This project is licensed for personal, non-commercial use only. Redistribution, resale, or modification is prohibited without written permission from the author.  
See the [LICENSE] file for full details.

---

## Author  
**Trace Davis**  
- GitHub: [Trace0727](https://github.com/Trace0727)  
- LinkedIn: [Trace Davis](https://www.linkedin.com/in/trace-d-926380138/)
