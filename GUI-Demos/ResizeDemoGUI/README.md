# ResizeDemoGUI

A simple Java Swing application that allows users to dynamically resize the width and height of a window, with automatic re-centering after each adjustment for a smooth and user-friendly experience.

---

## Project Structure

```
ResizeDemoGUI/
├── src/
│   └── ResizeGUI.java
└──
```

---

## Core Java Class

### `ResizeGUI.java`
Implements a graphical user interface using Swing:
- Initializes a default window (400x300) with two input panels—one for width and one for height.
- Each panel includes a text field and a submit button that updates the window size in real time.
- After resizing, the window is automatically re-centered on the screen using `frame.setLocationRelativeTo(null)`.
- Uses `GridLayout` for clean and structured component layout.

---

## How to Run

### From an IDE
1. Open the project folder.
2. Navigate to `ResizeGUI.java`.
3. Click **Run** on the main method to launch the GUI.

### From the command line
```bash
javac src/ResizeGUI.java -d out
java -cp out ResizeGUI
```

---

## Future Enhancements
- Combine width and height inputs into a single submission for convenience.
- Add input validation to prevent non-numeric entries or extreme values.
- Provide visual feedback or status messages upon resizing.
- Enable preset resolution buttons (e.g., 800x600, 1024x768).
- Implement a reset button to return to default dimensions.

---

## License
This project is licensed for personal, educational, and non-commercial use only. Redistribution or modification without permission is not allowed.  
See the [LICENSE] file for full details.

---

## Author
**Trace Davis**  
- GitHub: https://github.com/Trace0727  
- LinkedIn: https://www.linkedin.com/in/trace-d-926380138/
