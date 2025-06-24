import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PrimeNumbers {

    public List<Integer> computePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        if (n <= 0) {
            return primes;                 // nothing requested → return empty list
        }

        int count  = 0;                    // how many primes have been collected
        int number = 2;                    // smallest candidate prime

        while (count < n) {
            if (isPrime(number)) {         // accept the number if it is prime
                primes.add(number);
                count++;
            }
            number++;                      // test the next integer
        }
        return primes;
    }
    
    public static boolean isPrime(int n) {
        if (n < 2)  return false;          // numbers < 2 are not prime
        if (n == 2) return true;           // 2 is the only even prime
        if (n % 2 == 0) return false;      // eliminate other even numbers quickly

        /* Check odd divisors up to √n */
        for (int d = 3; d * d <= n; d += 2) {
            if (n % d == 0) {
                return false;              // divisible → composite
            }
        }
        return true;                       // no divisors found → prime
    }

    public static void main(String[] args) {
        final int LIST_SIZE   = 8;         // number of random integers to generate
        final int UPPER_BOUND = 100;       // upper bound of the random range (inclusive)

        Random rng = new Random();
        int[] randomNumbers = new int[LIST_SIZE];

        /* Generate the random list */
        for (int i = 0; i < LIST_SIZE; i++) {
            randomNumbers[i] = 2 + rng.nextInt(UPPER_BOUND - 1);
        }
        System.out.println("Random numbers: " + Arrays.toString(randomNumbers));

        /* Extract primes from the list */
        List<Integer> primesInList = new ArrayList<>();
        for (int num : randomNumbers) {
            if (isPrime(num)) {
                primesInList.add(num);
            }
        }

        /* Report results */
        if (primesInList.isEmpty()) {
            System.out.println("No primes found in the list.");
        } else {
            System.out.println("Prime numbers in the list: " + primesInList);
        }
    }
}
