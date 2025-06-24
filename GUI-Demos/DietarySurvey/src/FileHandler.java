import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler {
	String surveyFile;
	FileWriter fileOutput;
	PrintWriter printWriter;
	
	/**
	 * Creates surveyFile with custom header
	 */
	public FileHandler() {
	    surveyFile = "survey_results.csv";
	    File file = new File(surveyFile);
	    if (!file.exists()) {
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(surveyFile))) {
	            bw.write("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight\n");
	        } catch (IOException e) {
	            System.out.println("Cannot Write to File");
	        }
	    }
	}
 // end FileHandler
	
	
	/**
	 * Appends surveyData to the surveyFile
	 * 
	 * @param surveyData
	 */
	public void writeResults(String surveyData) {
		// (b)writeResults(String surveyData) needs to append the surveyData string to the survey_results.csv file
		 try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(surveyFile, true)))) {
			 out.println(surveyData);
		  } catch (IOException e) {
		     System.err.println("Error writing to file: " + e);
		  }
	} // end writeResults
} // end class


