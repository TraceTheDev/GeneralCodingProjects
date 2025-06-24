import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Characters
{
   public static void main(String[] args) throws FileNotFoundException
   {
      // Create a Scanner to read user input from the console
      Scanner console = new Scanner(System.in);
      System.out.println("Please input the name of a text file to evaluate:");
     
      // Read the file name entered by the user
      String inputFileName = console.next();
      File inputFile = new File(inputFileName);

      // Check if the file exists before proceeding
      if (!inputFile.exists()) {
         System.out.println("File not found. Please check the file name and try again.");
         return; // Exit the program if file is not found
      }

      // Create a Scanner to read the file character-by-character
      Scanner in = new Scanner(inputFile);
      in.useDelimiter(""); // Empty delimiter means read one character at a time

      // Counters for different types of characters
      int uppercase = 0;
      int lowercase = 0;
      int digits = 0;
      int whitespace = 0;
      int other = 0;

      System.out.println("\nReading file and counting characters...\n");

      // Loop through each character in the file and classify it
      while (in.hasNext())
      {
         char ch = in.next().charAt(0); // Read the next character
         
         // Use built-in Character methods to classify the character
         if (Character.isUpperCase(ch)) { uppercase++; }
         else if (Character.isLowerCase(ch)) { lowercase++; }
         else if (Character.isDigit(ch)) { digits++; }
         else if (Character.isWhitespace(ch)) { whitespace++; }
         else { other++; } // Everything else falls into 'other'
      }

      // Close the file scanner
      in.close();

      // Print the results to the console
      System.out.println("Character count summary:");
      System.out.println("------------------------");
      System.out.println("Uppercase:  " + uppercase);
      System.out.println("Lowercase:  " + lowercase);
      System.out.println("Digits:     " + digits);
      System.out.println("Whitespace: " + whitespace);
      System.out.println("Other:      " + other);
   }
}