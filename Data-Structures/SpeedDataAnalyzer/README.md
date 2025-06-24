# SpeedDataAnalyzer

A Java-based data processing application that reads traffic sensor data, reformats dates, calculates speed differences and averages, and outputs the results to a new CSV file. Ideal for learning file I/O, array lists, data cleaning, and basic analytics in Java.

---

## Project Structure

```
SpeedDataAnalyzer/
├── src/
│   └── SpeedDataAnalyzer.java
├── Speed_Data.csv
└── 
```

---

## Core Java Class

### `SpeedDataAnalyzer.java`
Performs the following functions:
- Prompts the user to input a CSV file
- Parses and stores sensor data into ArrayLists
- Reformats all date values to `yyyy/MM/dd`
- Calculates section speed differences and total average speed
- Identifies the most frequent date in the dataset
- Outputs cleaned and processed results to `Speed_Data_Difference.csv`

---

## How to Run

### 1. Open the project in your preferred Java IDE (e.g., IntelliJ, Eclipse, VS Code)
Ensure `Speed_Data.csv` is located in the project root.

### 2. Compile and Run

```bash
javac src/SpeedDataAnalyzer.java
java src.SpeedDataAnalyzer
```

When prompted, input:
```
Speed_Data.csv
```

The output file will be:
```
Speed_Data_Difference.csv
```

---

## Future Enhancements
- Add a GUI for data file selection and display
- Support multiple input file formats (e.g., Excel)
- Export graphical trends of speed variations over time

---

## License
This project is licensed for personal, educational use only. Redistribution or commercial use requires permission from the author.  
See the [LICENSE] file for full details.

---

## Author  
**Trace Davis**  
- GitHub: [Trace0727](https://github.com/Trace0727)  
- LinkedIn: [Trace Davis](https://www.linkedin.com/in/trace-d-926380138/)
