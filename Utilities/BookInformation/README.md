# BookInfoCLI

A concise Java console app that asks the user for details about a standard book and an encyclopedia, then prints the formatted information back—perfect for practicing inheritance, encapsulation, and simple user-driven I/O.



## Project Structure

```
BookInformation/  
├── src/  
│   ├── Book.java  
│   ├── Encyclopedia.java  
│   └── BookInformation.java   ← main class (run this)  
└──
```


## Core Java Classes

### `Book.java`
Models a generic book with the fields **title**, **author**, **publisher**, **publicationDate**, plus a `printInfo()` method for nicely formatted output.

### `Encyclopedia.java`
Extends **Book** and adds **edition** and **numVolumes**, overriding `printInfo()` to include its extra details.

### `BookInformation.java`
The program’s entry point that  
1. Prompts the user (via clear `System.out.println` messages) for all required fields.  
2. Creates a `Book` object and an `Encyclopedia` object from that input.  
3. Calls each object’s `printInfo()` to echo the gathered information.



## How to Run

(Works out of the box in any Java-capable IDE, or use the command line.)

Compile  
`javac src/*.java`  

Run  
`java -cp src BookInformation`  

Enter the requested values at each prompt; after the final entry, the program displays the book and encyclopedia information.



## Future Enhancements
* Persist entered records to CSV or a lightweight database  
* Robust input validation (non-empty strings, numeric checks)  
* Additional subclasses (`Magazine`, `Journal`, etc.)  
* Interactive menu for multiple entries in a single session  



## License
This project is licensed for personal, non-commercial use only. Redistribution, resale, or modification is prohibited without written permission from the author.  
See the [LICENSE] file for full details.



## Author
**Trace Davis**  
• GitHub : [Trace0727](https://github.com/Trace0727)  
• LinkedIn: [Trace Davis](https://www.linkedin.com/in/trace-d-926380138/)
