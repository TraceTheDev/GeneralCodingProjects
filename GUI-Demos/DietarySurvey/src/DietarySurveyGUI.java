import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class DietarySurveyGUI extends JFrame {
	JLabel headingLabel;
	JLabel firstNameLabel;
	JLabel lastNameLabel;
	JLabel phoneNumberLabel;
	JLabel emailLabel;
	JLabel dietaryLabel;
	JLabel genderLabel;
	JLabel waterLabel;
	JLabel mealsLabel;
	JLabel checkBoxLabel;
	JLabel walkLabel;
	JLabel weightLabel;
	JTextField firstNameTextField;
	JTextField lastNameTextField;
	JTextField phoneNumberTextField;
	JTextField emailTextField;
	JRadioButton maleRadioButton;
	JRadioButton femaleRadioButton;
	JRadioButton preferRadioButton;
	ButtonGroup radioButtonGroup;
	JSpinner waterIntakeSpinner;
	JSlider mealSlider;
	JCheckBox wheatCheckBox;
	JCheckBox sugarCheckBox;
	JCheckBox dairyCheckBox;
	JComboBox<?> walkComboBox;
	String[] walkOptions = {"Less than 1 mile", "More than 1 mile but less than 2 miles", "More than 2 miles but less than 3 miles", "More than 3 miles"};
	JFormattedTextField weightFormattedTextField;
	JButton clearButton;
	JButton submitButton;
	FileHandler fileHandler = new FileHandler();


	/**
	 * Creates a custom JFrame with all proper labels, textFields, buttons, sliders, etc.,
	 * that creates a dietary survery GUI. 
	 */
	public DietarySurveyGUI() {
		final int DEFAULT_WIDTH = 380;
		final int DEFAULT_HEIGHT = 800;
		JFrame jFrameMain = new JFrame("Dietary Survey");

		jFrameMain.setLayout(null);

		headingLabel = new JLabel("Personal Information");
		headingLabel.setBounds(10,10,150,25);

		firstNameLabel = new JLabel("First Name: ", SwingConstants.CENTER);
		firstNameLabel.setBounds(10,45,120,25);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(140,45,200,25);

		lastNameLabel = new JLabel("Last Name: ", SwingConstants.CENTER);
		lastNameLabel.setBounds(10,90,120,25);

		lastNameTextField = new JTextField("", 20);
		lastNameTextField.setBounds(140,90,200,25);

		phoneNumberLabel = new JLabel("Phone Number: ", SwingConstants.CENTER);
		phoneNumberLabel.setBounds(10,140,120,25);

		phoneNumberTextField = new JTextField("", 20);
		phoneNumberTextField.setBounds(140,140,200,25);

		emailLabel = new JLabel("Email: ", SwingConstants.CENTER);
		emailLabel.setBounds(10,190,120,25);

		emailTextField = new JTextField("", 20);
		emailTextField.setBounds(140,190,200,25);

		genderLabel = new JLabel("Sex: ", SwingConstants.CENTER);
		genderLabel.setBounds(10,230,120,25);
		maleRadioButton = new JRadioButton();
		femaleRadioButton = new JRadioButton();
		preferRadioButton = new JRadioButton();
		maleRadioButton.setBounds(140,230,200,20);
		femaleRadioButton.setBounds(140,255,200,20);
		preferRadioButton.setBounds(140,280,200,20);
		maleRadioButton.setText("Male");
		femaleRadioButton.setText("Female");
		preferRadioButton.setText("Prefer not to say");
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(maleRadioButton);
		radioButtonGroup.add(femaleRadioButton);
		radioButtonGroup.add(preferRadioButton);

		dietaryLabel = new JLabel("Dietary Questions");
		dietaryLabel.setBounds(20,310,200,25);

		waterLabel = new JLabel("How many cups of water on average do you drink a day?");
		waterLabel.setBounds(20,340,400,25);
		SpinnerModel spinnerModel = new SpinnerNumberModel(15, 0, 50, 1);
		waterIntakeSpinner = new JSpinner(spinnerModel);
		waterIntakeSpinner.setBounds(140,375,50,25);

		mealsLabel = new JLabel("How many meals on average do you eat a day?");
		mealsLabel.setBounds(45,410,400,25);
		mealSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 3);
		mealSlider.setMajorTickSpacing(1);
		mealSlider.setPaintTicks(true);
		mealSlider.setPaintLabels(true);
		mealSlider.setBounds(60,447,240,40);

		checkBoxLabel = new JLabel("Do any of these meals regularly contain:");

		JPanel checkBoxPanel = new JPanel();
		dairyCheckBox = new JCheckBox("Dairy");
		wheatCheckBox = new JCheckBox("Wheat");
		sugarCheckBox = new JCheckBox("Sugar");
		checkBoxPanel.add(dairyCheckBox);
		checkBoxPanel.add(wheatCheckBox);
		checkBoxPanel.add(sugarCheckBox);
		checkBoxLabel.setBounds(65,510,280,25);
		checkBoxPanel.setBounds(55,535,250,25);

		walkLabel = new JLabel("On average how many miles do you walk in a day?");
		walkLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		walkLabel.setBounds(40,585,315,25);

		walkComboBox = new JComboBox<Object>(walkOptions);
		walkComboBox.setBounds(50,620,250,30);

		weightLabel = new JLabel("How much do you weigh?");
		weightLabel.setBounds(110,660,300,25);
		MaskFormatter maskWeightField;

		// makes weight label only be able to take numbers as input
		try {
			maskWeightField = new MaskFormatter("####");
			weightFormattedTextField = new JFormattedTextField(maskWeightField);
			weightFormattedTextField.setColumns(12);
			weightFormattedTextField.setBounds(60,690,250,25);
		} catch(Exception e) {
			e.printStackTrace();
		} // end try/catch

		clearButton = new JButton("Clear");
		clearButton.addActionListener(null);
		clearButton.setBounds(10,730,80,25);
		clearButton.setBackground(Color.YELLOW);
		clearButton.setOpaque(true);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});

		submitButton = new JButton("Submit");
		submitButton.addActionListener(null);
		submitButton.setBounds(275,730,80,25);
		submitButton.setBackground(Color.GREEN);
		submitButton.setOpaque(true);
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Gets all the form data and then writes it to a String surveyData to return to 
				// the fileHandler class to write the csv file
				String firstName = firstNameTextField.getText();
				String lastName = lastNameTextField.getText();
				String phoneNumber = phoneNumberTextField.getText();
				String email = emailTextField.getText();
				String gender = "";
				if (maleRadioButton.isSelected()) {
					gender = "Male";
				} else if (femaleRadioButton.isSelected()) {
					gender = "Female";
				} else if (preferRadioButton.isSelected()) {
					gender = "Prefer not to say";
				}
				int waterIntake = (int) waterIntakeSpinner.getValue();
				int mealIntake = mealSlider.getValue();
				boolean wheat = wheatCheckBox.isSelected();
				boolean sugar = sugarCheckBox.isSelected();
				boolean dairy = dairyCheckBox.isSelected();
				int walkIndex = walkComboBox.getSelectedIndex();
				String walk = walkOptions[walkIndex];
				String weight = weightFormattedTextField.getText();

				// format the data as a string
				String surveyData = String.format("%s,%s,%s,%s,%s,%s,%d,%d,%b,%b,%b,%s,%s", 
						   LocalDateTime.now(), firstName, lastName, phoneNumber, email, gender,
						   waterIntake, mealIntake, wheat, sugar, dairy, walk, weight);
				// write the data to survey_results.csv using the FileHandler class
				fileHandler.writeResults(surveyData);
				clearForm();
			}
		});

		jFrameMain.add(headingLabel);
		jFrameMain.add(firstNameLabel);
		jFrameMain.add(firstNameTextField);
		jFrameMain.add(lastNameLabel);
		jFrameMain.add(lastNameTextField);
		jFrameMain.add(phoneNumberLabel);
		jFrameMain.add(phoneNumberTextField);
		jFrameMain.add(emailLabel);
		jFrameMain.add(emailTextField);
		jFrameMain.add(genderLabel);
		jFrameMain.add(maleRadioButton);
		jFrameMain.add(femaleRadioButton);
		jFrameMain.add(preferRadioButton);
		jFrameMain.add(dietaryLabel);
		jFrameMain.add(waterLabel);
		jFrameMain.add(waterIntakeSpinner);
		jFrameMain.add(mealsLabel);
		jFrameMain.add(mealSlider);
		jFrameMain.add(checkBoxLabel);
		jFrameMain.add(checkBoxPanel);
		jFrameMain.add(walkLabel);
		jFrameMain.add(walkComboBox);
		jFrameMain.add(weightLabel);
		jFrameMain.add(weightFormattedTextField);
		jFrameMain.add(clearButton);
		jFrameMain.add(submitButton);

		jFrameMain.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		jFrameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrameMain.setVisible(true);
	} // end CustomJFrame


	/**
	 * Clears all the form data
	 */
	public void clearForm() { 
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		phoneNumberTextField.setText("");
		emailTextField.setText("");
		radioButtonGroup.clearSelection();
		waterIntakeSpinner.setValue(15);
		mealSlider.setValue(3);
		wheatCheckBox.setSelected(false);
		sugarCheckBox.setSelected(false);
		dairyCheckBox.setSelected(false);
		walkComboBox.setSelectedIndex(0);
		weightFormattedTextField.setValue(null);
	} // end clearForm


	class InnerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// actionPerformed() needs to clear the data of the form and if the submit button was pressed the
			// data needs to be captured and written to the csv file
			// 	1. The submitted data needs to be written to the survey_results.csv file using the
			// 	   FileHandler writeResults() method
			// 	2. The submit and clear buttons both need to register this action listener
		} // end actionPerformed	
	} // end InnerActionListener
} // end class
