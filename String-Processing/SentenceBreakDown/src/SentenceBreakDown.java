import java.util.Arrays;
import java.util.Scanner;

// Analyzes a sentence and provides various word statistics through a menu interface.
public class SentenceBreakDown {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a sentence of words separated by spaces: ");
        String sentence = in.nextLine();
        String[] words = sentence.split(" ");
        getAnswer(sentence, words);
    }

    // Displays a menu and handles user selection for different word list operations.
    public static void getAnswer(String sentence, String[] words) {
        Scanner scnr = new Scanner(System.in);
        boolean quit = false;
        int menuItem;

        do {
            System.out.println("\n1. Display Word List Ordered A-Z");
            System.out.println("2. Display Length of Each Word in the List");
            System.out.println("3. Display Word List Statistics");
            System.out.println("4. Count Number of Words with Even/Odd Length");
            System.out.println("5. Count Number of Words that Have a Prime Length");
            System.out.println("6. Enter New Word List");
            System.out.println("7. Quit\n");
            System.out.print("Choose a menu item or 7 to quit: ");

            menuItem = scnr.nextInt();
            scnr.nextLine(); // consume newline

            switch (menuItem) {
                case 1:
                    orderedWordList(words);
                    break;
                case 2:
                    wordLength(sentence);
                    break;
                case 3:
                    minMaxWordLength(sentence);
                    charCount(sentence);
                    avgWordLength(sentence);
                    nounCount(sentence);
                    mostFreqWord(sentence);
                    break;
                case 4:
                    evenOddLength(sentence);
                    break;
                case 5:
                    primeLength(sentence);
                    break;
                case 6:
                    sentence = newWordlist();
                    words = sentence.split(" ");
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (!quit);

        System.out.println("Thank you for using this program, goodbye!");
    }

    // Sorts and prints the word list alphabetically
    public static void orderedWordList(String[] orderedWords) {
        Arrays.sort(orderedWords);
        System.out.println("The sorted array is " + Arrays.toString(orderedWords));
    }

    // Prints the length of each word in the sentence
    public static void wordLength(String wordLengths) {
        for (String word : wordLengths.split(" ")) {
            System.out.println(word + " length is " + word.length());
        }
    }

    // Finds and prints the minimum and maximum word lengths in the sentence
    public static void minMaxWordLength(String evalWord) {
        String word = "", small = "", large = "";
        String[] words = new String[1000];
        int length = 0;

        evalWord = evalWord + " ";

        for (int i = 0; i < evalWord.length(); i++) {
            if (evalWord.charAt(i) != ' ') {
                word += evalWord.charAt(i);
            } else {
                words[length++] = word;
                word = "";
            }
        }

        small = large = words[0];

        for (int k = 0; k < length; k++) {
            if (small.length() > words[k].length()) small = words[k];
            if (large.length() < words[k].length()) large = words[k];
        }

        System.out.println("Min word length: " + small.length());
        System.out.println("Max word length: " + large.length());
    }

    // Counts and prints the number of characters excluding spaces
    public static void charCount(String charsInWords) {
        int charCount = 0;
        for (int i = 0; i < charsInWords.length(); i++) {
            if (charsInWords.charAt(i) != ' ') {
                charCount++;
            }
        }
        System.out.println("Number of characters: " + charCount);
    }

    // Calculates and prints the average word length
    public static void avgWordLength(String avgLength) {
        String[] words = avgLength.split(" ");
        int sum = 0;
        for (String word : words) {
            sum += word.length();
        }
        double average = (double) sum / words.length;
        System.out.println("Average word length: " + String.format("%.2f", average));
    }

    // Counts and prints the number of capitalized words (assumed to be nouns)
    public static void nounCount(String nounsWords) {
        int nounCount = 0;
        for (String word : nounsWords.split(" ")) {
            if (Character.isUpperCase(word.charAt(0))) {
                nounCount++;
            }
        }
        System.out.println("Number of nouns: " + nounCount);
    }

    // Finds and prints the most frequently occurring word in the sentence
    public static void mostFreqWord(String freqWord) {
        int max = 0, count = 0;
        String[] splited = freqWord.split(" ");
        Arrays.sort(splited);
        String curr = splited[0], word = splited[0];

        for (int i = 0; i < splited.length; i++) {
            if (splited[i].equalsIgnoreCase(curr)) {
                count++;
            } else {
                count = 1;
                curr = splited[i];
            }

            if (max < count) {
                max = count;
                word = splited[i];
            }
        }

        if (max == 1) {
            System.out.println("No Mode");
        } else {
            System.out.println("Most frequent word: " + word);
        }
    }

    // Counts and prints the number of even and odd-length words
    public static void evenOddLength(String evenOddWords) {
        int evenWordCount = 0;
        int oddWordCount = 0;

        for (String word : evenOddWords.split(" ")) {
            if (word.length() % 2 == 0) evenWordCount++;
            else oddWordCount++;
        }

        System.out.println("Number even: " + evenWordCount);
        System.out.println("Number odd: " + oddWordCount);
    }

    // Returns true if a number is prime
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Counts and prints the number of words with prime lengths
    public static void primeLength(String primeWord) {
        int primeCount = 0;
        for (String word : primeWord.split(" ")) {
            if (isPrime(word.length())) primeCount++;
        }
        System.out.println("Number of Prime in list: " + primeCount);
    }

    // Prompts the user to enter a new sentence and returns it
    public static String newWordlist() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter another sentence of words separated by spaces: ");
        return in.nextLine();
    }
}
