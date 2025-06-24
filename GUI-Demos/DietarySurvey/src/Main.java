public class Main {
	
	
	/**
	 * Initialize customJFrame and display
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new DietarySurveyGUI();
	} // end main
} // end class

/*
Additional Notes:
• The format of your output file must match the format of the survey_results_EXAMPLE.csv file
• The FileHandler constructor should overwrite any existing file
• The writeResults method should append to the output file. It should not overwrite the existing data
• All input and output streams must be closed properly
• All input and output streams must be surrounded by a try catch
*/