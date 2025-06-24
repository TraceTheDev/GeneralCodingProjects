import java.util.Scanner;

public class InstrumentInformation {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      Instrument myInstrument = new Instrument();
      StringInstrument myStringInstrument = new StringInstrument();

      String instrumentName, manufacturerName, stringInstrumentName, stringManufacturer;
      int yearBuilt, cost, stringYearBuilt, stringCost, numStrings, numFrets;

      // Input for general instrument
      System.out.println("Enter general instrument name:");
      instrumentName = scnr.nextLine();

      System.out.println("Enter general instrument manufacturer:");
      manufacturerName = scnr.nextLine();

      System.out.println("Enter year the general instrument was built:");
      yearBuilt = scnr.nextInt();
      scnr.nextLine(); // consume newline

      System.out.println("Enter cost of the general instrument:");
      cost = scnr.nextInt();
      scnr.nextLine(); // consume newline

      // Input for string instrument
      System.out.println("Enter string instrument name:");
      stringInstrumentName = scnr.nextLine();

      System.out.println("Enter string instrument manufacturer:");
      stringManufacturer = scnr.nextLine();

      System.out.println("Enter year the string instrument was built:");
      stringYearBuilt = scnr.nextInt();

      System.out.println("Enter cost of the string instrument:");
      stringCost = scnr.nextInt();

      System.out.println("Enter number of strings:");
      numStrings = scnr.nextInt();

      System.out.println("Enter number of frets:");
      numFrets = scnr.nextInt();

      // Set and print general instrument info
      myInstrument.setName(instrumentName);
      myInstrument.setManufacturer(manufacturerName);
      myInstrument.setYearBuilt(yearBuilt);
      myInstrument.setCost(cost);
      myInstrument.printInfo();

      // Set and print string instrument info
      myStringInstrument.setName(stringInstrumentName);
      myStringInstrument.setManufacturer(stringManufacturer);
      myStringInstrument.setYearBuilt(stringYearBuilt);
      myStringInstrument.setCost(stringCost);
      myStringInstrument.setNumOfStrings(numStrings);
      myStringInstrument.setNumOfFrets(numFrets);
      myStringInstrument.printInfo();

      System.out.println("   Number of strings: " + myStringInstrument.getNumOfStrings());
      System.out.println("   Number of frets: " + myStringInstrument.getNumOfFrets());
   }
}