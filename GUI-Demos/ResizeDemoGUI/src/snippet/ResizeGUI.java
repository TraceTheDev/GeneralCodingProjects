package snippet;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ResizeGUI {
    // Default window dimensions
    static final int DEFAULT_WIDTH = 400;
    static final int DEFAULT_HEIGHT = 300;
    
    // Current window dimensions
    static int currentWidth = DEFAULT_WIDTH;
    static int currentHeight = DEFAULT_HEIGHT;

    // Main components
    static JFrame frame;
    static JTextField widthTextField;
    static JTextField heightTextField;

    public static void main(String[] args) {
        // Initialize the frame
        frame = new JFrame();
        frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Example GUI Window");
        frame.setLocationRelativeTo(null); // Center window initially

        // Main panel with grid layout (2 rows, 2 columns)
        JPanel main = new JPanel();
        main.setLayout(new GridLayout(2, 2));

        // Panel for width input
        JPanel widthPanel = new JPanel();
        JLabel widthLabel = new JLabel("Enter New Width: ");
        widthTextField = new JTextField("", 20);
        JButton widthButton = new JButton("Submit Width");
        widthButton.addActionListener(e -> widthButtonPress());
        widthPanel.add(widthLabel);
        widthPanel.add(widthTextField);
        widthPanel.add(widthButton);

        // Panel for height input
        JPanel heightPanel = new JPanel();
        JLabel heightLabel = new JLabel("Enter New Height: ");
        heightTextField = new JTextField("", 20);
        JButton heightButton = new JButton("Submit Height");
        heightButton.addActionListener(e -> heightButtonPress());
        heightPanel.add(heightLabel);
        heightPanel.add(heightTextField);
        heightPanel.add(heightButton);

        // Add input panels to main panel and main panel to frame
        main.add(widthPanel);
        main.add(heightPanel);
        frame.add(main);

        // Display the GUI
        frame.setVisible(true);
    }

    // Handles width change input
    static void widthButtonPress() {
        if (!widthTextField.getText().isBlank()) {
            int newWidth = Integer.parseInt(widthTextField.getText());
            frame.setSize(newWidth, currentHeight);
            currentWidth = newWidth;
            frame.setLocationRelativeTo(null); // Recenter the window
        }
    }

    // Handles height change input
    static void heightButtonPress() {
        if (!heightTextField.getText().isBlank()) {
            int newHeight = Integer.parseInt(heightTextField.getText());
            frame.setSize(currentWidth, newHeight);
            currentHeight = newHeight;
            frame.setLocationRelativeTo(null); // Recenter the window
        }
    }
}
