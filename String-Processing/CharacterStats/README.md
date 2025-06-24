# CharacterStats

A simple Java console application that analyzes the contents of a text file and counts the number of uppercase letters, lowercase letters, digits, whitespace characters, and other symbols.

---

## Project Structure

```
CharacterStats/
├── src/
│   └── Characters.java
├── test1.txt
├── test2.txt
└── test3.txt
```

---

## Core Java Class

### `Characters.java`
This is the main program that:
- Prompts the user to enter the name of a `.txt` file located in the project directory (e.g., `test1.txt`)
- Opens and reads the file character-by-character using a `Scanner` and `in.useDelimiter("")`
- Uses `Character` class methods to classify each character as:
  - Uppercase
  - Lowercase
  - Digit
  - Whitespace
  - Other (symbols, punctuation, etc.)
- Outputs a formatted count summary of each character type

---

## Sample Input Files

- `test1.txt`: Includes a basic sentence with punctuation  
- `test2.txt`: Uses tabs, newlines, and special characters  
- `test3.txt`: A longer file with paragraphs and a variety of characters  

These should be placed in the **root level** of the project, alongside the `src/` folder.

---

## How to Run

### From the command line
```bash
javac src/Characters.java -d out
java -cp out Characters
```
- When prompted, enter the name of one of the `.txt` files (e.g., `test1.txt`).

### From an IDE
1. Open the project folder.
2. Navigate to `Characters.java`.
3. Click **Run** on the main method.
4. Type the input file name in the console when prompted.

---

## Future Enhancements
- Implement the full JUnit 5 test suite  
- Persist character summaries to a file or database  
- Add a GUI (Swing or JavaFX) for interactive file selection and output

---

## License
This project is licensed for personal, non-commercial use only. Redistribution, resale, or modification is prohibited without written permission from the author.  
See the [LICENSE] file for full details.

---

## Author
**Trace Davis**  
- GitHub: https://github.com/Trace0727  
- LinkedIn: https://www.linkedin.com/in/trace-d-926380138/
