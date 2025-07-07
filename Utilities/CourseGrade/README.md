# CourseGrade

A compact Java console utility that reads a **tab-separated** roster of student exam scores, assigns letter grades, computes overall exam averages, and writes the results to **report.txt** — perfect for practicing file I/O, basic data processing, and formatted output in Java.

---

## Project Structure

    CourseGrade/
    ├── src/
    │   └── CourseGrade.java
    ├── course_grades.txt      # sample TSV input
    └──

---

## Core Java Class

### `CourseGrade.java`
* Prompts the user for a **TSV** filename at runtime.  
* Reads each line in the format  
  `LastName<TAB>FirstName<TAB>Midterm1<TAB>Midterm2<TAB>FinalExam`.  
* Calculates every student’s numeric average, maps it to an **A–F** grade, and outputs the enriched data.  
* Maintains running totals to compute class-wide averages for all three exams.  
* Saves everything to `report.txt` and prints a success confirmation.

---

## Future Enhancements
* Accept **CSV** or **XLSX** inputs automatically.  
* Export results as nicely formatted **PDF/HTML** reports.  
* Add command-line flags for custom grade cut-offs and output filenames.  
* Refactor logic into testable helpers and provide full JUnit coverage.

---

## License
This project is licensed for personal, non-commercial use only. Redistribution, resale, or modification requires written permission from the author.  
See the **LICENSE** file for details.

---

## Author

**Trace Davis**  
- GitHub: [TraceTheDev](https://github.com/TraceTheDev)  
- LinkedIn: [Trace Davis](https://www.linkedin.com/in/trace-d-926380138/)
