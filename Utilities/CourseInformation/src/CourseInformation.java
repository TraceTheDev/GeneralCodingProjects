import java.util.Scanner;

public class CourseInformation {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      Course myCourse = new Course();
      OfferedCourse myOfferedCourse = new OfferedCourse();

      String courseNumber, courseTitle;
      String oCourseNumber, oCourseTitle, instructorName, term, classTime;

      /* ------- added user-friendly prompts ------- */
      System.out.print("Enter the base course number: ");
      courseNumber = scnr.nextLine();

      System.out.print("Enter the base course title: ");
      courseTitle = scnr.nextLine();

      System.out.print("Enter the offered course number: ");
      oCourseNumber = scnr.nextLine();

      System.out.print("Enter the offered course title: ");
      oCourseTitle = scnr.nextLine();

      System.out.print("Enter the instructor's name: ");
      instructorName = scnr.nextLine();

      System.out.print("Enter the academic term (e.g., Fall 2025): ");
      term = scnr.nextLine();

      System.out.print("Enter the class meeting time (e.g., MWF 10:00–10:50): ");
      classTime = scnr.nextLine();
      /* ------------------------------------------- */

      myCourse.setCourseNumber(courseNumber);
      myCourse.setCourseTitle(courseTitle);
      myCourse.printInfo();

      myOfferedCourse.setCourseNumber(oCourseNumber);
      myOfferedCourse.setCourseTitle(oCourseTitle);
      myOfferedCourse.setInstructorName(instructorName);
      myOfferedCourse.setTerm(term);
      myOfferedCourse.setClassTime(classTime);
      myOfferedCourse.printInfo();

      System.out.println("   Instructor Name: " + myOfferedCourse.getInstructorName());
      System.out.println("   Term: " + myOfferedCourse.getTerm());
      System.out.println("   Class Time: " + myOfferedCourse.getClassTime());
   }
}