import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for PrimeNumbers.
 */
class PrimeNumbersTest {

    @Test
    void testComputeFivePrimes() {
        PrimeNumbers pn = new PrimeNumbers();
        List<Integer> result = pn.computePrimes(5);
        assertEquals(List.of(2, 3, 5, 7, 11), result);
    }

    @Test
    void testNegativeInputReturnsEmptyList() {
        PrimeNumbers pn = new PrimeNumbers();
        List<Integer> result = pn.computePrimes(-5);
        assertTrue(result.isEmpty());
    }

    @Test
    void testZeroInputReturnsEmptyList() {
        PrimeNumbers pn = new PrimeNumbers();
        List<Integer> result = pn.computePrimes(0);
        assertTrue(result.isEmpty());
    }

    @Test
    void testComputeEightPrimes() {
        PrimeNumbers pn = new PrimeNumbers();
        List<Integer> result = pn.computePrimes(8);
        assertEquals(List.of(2, 3, 5, 7, 11, 13, 17, 19), result);
    }
}
