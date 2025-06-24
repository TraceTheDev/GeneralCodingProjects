import java.util.Scanner;

public class MatrixMultiplication {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int n;

      // Prompt for matrix size
      System.out.print("Enter the size of the matrix/vector (n): ");
      n = scnr.nextInt();

      int[] vectorA = new int[n];        // 1 x n vector
      int[][] matrixB = new int[n][n];   // n x n matrix
      int[] resultC = new int[n];        // Result vector (1 x n)

      // Input vector A
      System.out.println("Enter " + n + " integers (space-separated) for vector A:");
      for (int i = 0; i < n; i++) {
         vectorA[i] = scnr.nextInt();
      }

      // Input matrix B
      System.out.println("Enter the " + n + " rows of matrix B (each with " + n + " space-seperated integers):");
      for (int i = 0; i < n; i++) {
         System.out.print("Row " + i + ": ");
         for (int j = 0; j < n; j++) {
            matrixB[i][j] = scnr.nextInt();
         }
      }

      // Perform vector × matrix multiplication
      for (int i = 0; i < n; i++) {
         resultC[i] = 0;
         for (int k = 0; k < n; k++) {
            resultC[i] += vectorA[k] * matrixB[k][i];
         }
      }

      // Output result
      System.out.print("Resulting vector C (A × B): ");
      for (int i = 0; i < n; i++) {
         System.out.print(resultC[i] + " ");
      }
      System.out.println();
   }
}