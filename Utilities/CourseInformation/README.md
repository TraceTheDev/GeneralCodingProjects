# CourseInformation

A concise Java console application illustrating core OOP principles—inheritance, encapsulation, and polymorphism—while managing basic course data and specific semester offerings.

---

## Project Structure

    CourseInformation/
    ├── src/
    │   ├── Course.java
    │   ├── OfferedCourse.java
    │   └── CourseInformation.java
    └──

---

## Core Java Classes

### `Course.java`
Represents a generic university course:
- `courseNumber`: Identifies the course (e.g., “CS101”)
- `courseTitle`: Descriptive title of the course
- Standard setters/getters for both fields
- `printInfo()`: Outputs a formatted “Course Information” block

### `OfferedCourse.java`
Extends `Course` to model a specific semester offering:
- Adds `instructorName`, `term`, and `classTime`
- Inherits `printInfo()` from `Course` to reuse base formatting
- Provides setters/getters for the new fields

### `CourseInformation.java`
Acts as the program driver:
- Prompts the user for base-course and offered-course details
- Instantiates `Course` and `OfferedCourse` objects with that input
- Prints the generic course block, then the semester-specific block with extra details

---

## Future Enhancements
- Implement the full JUnit 5 test suite
- Persist course offerings to a file or database
- Add a GUI (Swing or JavaFX) for interactive data entry

---

## License
This project is licensed for personal, non-commercial use only. Redistribution, resale, or modification is prohibited without written permission from the author.  
See the [LICENSE] file for full details.

---

## Author

**Trace Davis**  
- GitHub: [TraceTheDev](https://github.com/TraceTheDev)  
- LinkedIn: [Trace Davis](https://www.linkedin.com/in/trace-d-926380138/)
