import java.util.Scanner;

public class RollDice {
   public static int rollSpecificTimes(GVDie d, int rolls){  
      int result = 0;
      for (int i = 0; i < rolls; i++) {
         d.roll();
         result += d.getValue();
      }
      return result;
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      GVDie die = new GVDie();        // Create a GVDie object
      die.setSeed(15);                // Fix the RNG seed for repeatable results

      System.out.print("Enter the number of rolls: ");  // <-- user-friendly prompt
      int rolls = scnr.nextInt();

      int total = rollSpecificTimes(die, rolls);        // Sum of all rolls
      System.out.println(rolls + " rolls return a total of " + total + ".");
   }
}