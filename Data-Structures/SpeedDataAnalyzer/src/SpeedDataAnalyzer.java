import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SpeedDataAnalyzer {
	public static ArrayList<String> dates = new ArrayList<String>();
	public static ArrayList<String> times = new ArrayList<String>();
	public static ArrayList<Double> sensor2278 = new ArrayList<Double>();
	public static ArrayList<Double> sensor3276 = new ArrayList<Double>();
	public static ArrayList<Double> sensor4689 = new ArrayList<Double>();
	public static ArrayList<Double> sensor5032 = new ArrayList<Double>();
	public static ArrayList<Double> section1Diff = new ArrayList<Double>();
	public static ArrayList<Double> section2Diff = new ArrayList<Double>();
	public static ArrayList<Double> totalAvg = new ArrayList<Double>();  
	
	public static void main(String[] args) {
		System.out.println("Project 2 Data Preprocessing\n");

		// Prompt user for file input and read data
		String fileName = readData();
		System.out.println("\nReading in Data from the file '" + fileName + "'\n");

		// Convert all date strings to standard format
		System.out.println("Converting Dates from MM/DD/YYY to YYYY/MM/DD..");
		dataWork(fileName);

		// Perform calculations on sensor values
		System.out.println("Calculating Speed Difference..");
		System.out.println("Calculating Speed Average..");
		sensorWork();

		// Identify the most frequent date in the dataset
	    String mostFreqDate = mostFreqDate();
	    System.out.println("\nThe most frequent date is: " + mostFreqDate);

		// Output processed data to a CSV file
		System.out.println("\nWriting Data to the file 'Speed_Data_Difference.csv'");
		writeData();

		System.out.println("\nDone! Exiting program.");
	} // end main

	public static String readData()
	{
		String fileName;
		Scanner scnr = new Scanner(System.in);

		while (true) {
			try {
				// Prompt user for file name
				System.out.println("Please enter the file name: ");
				fileName = scnr.nextLine();

				// Attempt to read the file
				FileInputStream fileStream = new FileInputStream(fileName);
				Scanner fileScanner = new Scanner(fileStream);

				// Skip the header line
				fileScanner.nextLine();

				// Read all data lines and store values into respective ArrayLists
				while (fileScanner.hasNextLine()) {
					String[] lineData = fileScanner.nextLine().split(",");
					dates.add(lineData[0]);
					times.add(lineData[1]);
					sensor2278.add(Double.parseDouble(lineData[2]));
					sensor3276.add(Double.parseDouble(lineData[3]));
					sensor4689.add(Double.parseDouble(lineData[4]));
					sensor5032.add(Double.parseDouble(lineData[5]));
				}

				fileScanner.close();
				break; // Exit loop on success
			} 
			catch (FileNotFoundException e) {
				// Inform user if file is not found
				System.out.println("\nFile was not found.");
				System.out.println("Please enter another file name: \n");
			}
			catch (NumberFormatException e) {
				// Inform user if bad numeric data is encountered
				System.out.println("\nThe file contains bad number data.");
				System.out.println("Please enter another file name: \n");
			}
		}

		scnr.close();
		return fileName;
	} // end readData

	public static void dataWork(String fileName)
	{
		// Define old and new date formats
		SimpleDateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy/MM/dd");

		// Loop through all dates to convert them
		for (String date : dates) {
			try {
				Date originalDate = originalFormat.parse(date);
				String newDate = newFormat.format(originalDate);

				// Replace old format with new format in list
				int index = dates.indexOf(date);
				dates.set(index, newDate);
			} catch (ParseException e) {
				// Re-read data if parse fails due to bad format
				System.out.println("\nThe file contains bad date data.");
				readData();
				return;
			}
		}
	} // end dataWork

	public static void sensorWork()
	{
		// Loop through all sensor values to compute differences and averages
		for(int i = 0; i < sensor2278.size(); i++)
		{
			// Difference for first pair of sensors
			double diff = sensor2278.get(i) - sensor3276.get(i);
			section1Diff.add(diff);

			// Difference for second pair of sensors
			diff = sensor4689.get(i) - sensor5032.get(i);
			section2Diff.add(diff);

			// Compute average of all four sensors
			double avg = (sensor3276.get(i) + sensor5032.get(i) + sensor2278.get(i) + sensor4689.get(i)) / 4;
			totalAvg.add(avg);
		}
	} // end sensorWork

	public static String mostFreqDate()
	{
		// Create a frequency map to count occurrences of each date
		Map<String, Integer> freqMap = new HashMap<>();
	    for (String date : dates) {
	        freqMap.put(date, freqMap.getOrDefault(date, 0) + 1);
	    }

	    // Find the date with the maximum frequency
	    String mostFreqDate = "";
	    int maxFreq = 0;
	    for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
	        if (entry.getValue() > maxFreq) {
	            mostFreqDate = entry.getKey();
	            maxFreq = entry.getValue();
	        }
	    }

	    return mostFreqDate;
	} // end mostFreqDate 

	public static void writeData()
	{
		// Ensure calculated values are up to date
		sensorWork();

		try
		{
			// Set up number formatting
			DecimalFormat df = new DecimalFormat("0.00000000");
			PrintStream ps = new PrintStream("Speed_Data_Difference.csv");

			// Write CSV header
			ps.println("Date,Time,Sensor_2278,Sensor_3276,Sensor_4689,Sensor_5032,Section1_Diff,Section2_Diff,Total_Avg");

			// Write all data rows with calculated values
			for(int i = 0; i < dates.size(); i++)
			{
				ps.println(dates.get(i) + "," + times.get(i) + "," + df.format(sensor2278.get(i)) + "," + df.format(sensor3276.get(i)) 
				+ "," + df.format(sensor4689.get(i)) + "," + df.format(sensor5032.get(i)) + "," + df.format(section1Diff.get(i)) 
				+ "," + df.format(section2Diff.get(i)) + "," + df.format(totalAvg.get(i)));
			}

			ps.close();
		}
		catch(Exception e)
		{
			// Print any errors that occur during writing
			System.out.println(e.getMessage());
		}
	} // end writeData
} // end class
