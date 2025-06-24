import java.util.Scanner;

public class BookInformation {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      Book myBook = new Book();
      Encyclopedia myEncyclopedia = new Encyclopedia();

      String title, author, publisher, publicationDate;
      String eTitle, eAuthor, ePublisher, ePublicationDate, edition;
      int numVolumes;

      /* ---------- inputs for Book ---------- */
      System.out.print("Enter BOOK title: ");
      title = scnr.nextLine();

      System.out.print("Enter BOOK author: ");
      author = scnr.nextLine();

      System.out.print("Enter BOOK publisher: ");
      publisher = scnr.nextLine();

      System.out.print("Enter BOOK publication date: ");
      publicationDate = scnr.nextLine();

      /* ---------- inputs for Encyclopedia ---------- */
      System.out.print("\nEnter ENCYCLOPEDIA title: ");
      eTitle = scnr.nextLine();

      System.out.print("Enter ENCYCLOPEDIA author: ");
      eAuthor = scnr.nextLine();

      System.out.print("Enter ENCYCLOPEDIA publisher: ");
      ePublisher = scnr.nextLine();

      System.out.print("Enter ENCYCLOPEDIA publication date: ");
      ePublicationDate = scnr.nextLine();

      System.out.print("Enter ENCYCLOPEDIA edition: ");
      edition = scnr.nextLine();

      System.out.print("Enter number of volumes: ");
      numVolumes = scnr.nextInt();

      /* ---------- build objects & print ---------- */
      myBook.setTitle(title);
      myBook.setAuthor(author);
      myBook.setPublisher(publisher);
      myBook.setPublicationDate(publicationDate);
      myBook.printInfo();

      myEncyclopedia.setTitle(eTitle);
      myEncyclopedia.setAuthor(eAuthor);
      myEncyclopedia.setPublisher(ePublisher);
      myEncyclopedia.setPublicationDate(ePublicationDate);
      myEncyclopedia.setEdition(edition);
      myEncyclopedia.setNumVolumes(numVolumes);
      myEncyclopedia.printInfo();

      scnr.close();
    }
}
