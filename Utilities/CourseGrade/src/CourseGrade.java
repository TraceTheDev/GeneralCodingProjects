import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class CourseGrade {
   public static void main(String[] args) throws IOException {
	   Scanner scnr = new Scanner(System.in);
       String inputfile = "";
       String outputfile = "report.txt";
       String lName, fName;
       int a, b, c, count = 0;
       char grade;
       double totalMid1 = 0, totalMid2 = 0, totalFinal = 0;

       System.out.print("Enter tsv filename: ");
       inputfile = scnr.nextLine();

       Scanner reader = new Scanner(new File(inputfile));
       PrintWriter writer = new PrintWriter(new File(outputfile));
       while (reader.hasNext()) {
           lName = reader.next();
           fName = reader.next();
           a = reader.nextInt();
           b = reader.nextInt();
           c = reader.nextInt();
           double avg = (a + b + c) / 3.0;
           if (avg >= 90) grade= 'A';
           else if (avg >= 80) grade= 'B';
           else if (avg >= 70) grade= 'C';
           else if (avg >= 60) grade= 'D';
           else grade= 'F';
           
           
           writer.printf("%-12s %-12s %4d %4d %4d %c%n",
                   lName, fName, a, b, c, grade);

           totalMid1 += a;
           totalMid2 += b;
           totalFinal += c;
           count += 1;
       }
       writer.write(String.format("\r\nAverages: Midterm1 %.2f, Midterm2 %.2f, Final %.2f",
               totalMid1 / count, totalMid2 / count, totalFinal / count) + "\n");
       writer.flush();
       reader.close();
       writer.close();

       System.out.println(outputfile+" generated successfully..");

   }
  
}