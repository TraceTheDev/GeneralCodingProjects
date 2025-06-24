import java.util.Scanner;

public class DrawHalfArrow {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int arrowBaseHeight;
        int arrowBaseWidth;
        int arrowHeadWidth;

        // ----- Gather input with clear prompts -----
        System.out.print("Enter arrow base height (number of rows in the shaft): ");
        arrowBaseHeight = scnr.nextInt();

        System.out.print("Enter arrow base width  (number of * per shaft row): ");
        arrowBaseWidth = scnr.nextInt();

        System.out.print("Enter arrow head width  (must be greater than the base width): ");
        arrowHeadWidth = scnr.nextInt();

        // Validate head width
        while (arrowHeadWidth <= arrowBaseWidth) {
            System.out.printf(
                "  ➔ %d is not greater than %d. Please enter a larger head width: ",
                arrowHeadWidth, arrowBaseWidth);
            arrowHeadWidth = scnr.nextInt();
        }

        // ----- Draw the shaft -----
        StringBuilder row = new StringBuilder();
        for (int x = 0; x < arrowBaseWidth; x++) {   // build one full shaft row
            row.append("*");
        }
        for (int i = 0; i < arrowBaseHeight; i++) {  // print it height times
            System.out.println(row);
        }

        // ----- Draw the head -----
        int temp = arrowHeadWidth;                   // current row width
        for (int y = 0; y < arrowHeadWidth; y++) {   // one row per line
            for (int z = temp; z > 0; z--) {
                System.out.print("*");
            }
            temp--;                                  // next row is one * shorter
            System.out.println();
        }
    }
}