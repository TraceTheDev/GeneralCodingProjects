import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for Java's built-in Stack pop() method.
 * Tests normal, empty, and edge cases with max/min size.
 */
public class StackPopTest {
    private final int MAXSTACKSIZE = 100;
    private final int MAXSTACKELEMENTVAL = 1000;

    // Test popping from an empty stack should throw exception
    @Test
    void testPopWithEmptyStack() {
        Stack<Integer> s = new Stack<>();
        assertThrows(EmptyStackException.class, s::pop);
    }

    // Test pop after pushing random number of elements
    @Test
    void testPopWithoutEmptyStack() {
        Stack<Integer> s = new Stack<>();
        Random rand = new Random();
        int stackSize = rand.nextInt(MAXSTACKSIZE);
        for (int i = 0; i < stackSize - 1; i++) {
            s.push(rand.nextInt(MAXSTACKELEMENTVAL));
        }
        int lastElement = rand.nextInt(MAXSTACKELEMENTVAL);
        s.push(lastElement);
        assertEquals(lastElement, s.pop());
    }

    // Test pop with a full stack (MAXSTACKSIZE)
    @Test
    void testPopWithMaxSizeStack() {
        Stack<Integer> s = new Stack<>();
        Random rand = new Random();
        for (int i = 0; i < MAXSTACKSIZE - 1; i++) {
            s.push(rand.nextInt(MAXSTACKELEMENTVAL));
        }
        int lastElement = rand.nextInt(MAXSTACKELEMENTVAL);
        s.push(lastElement);
        assertEquals(lastElement, s.pop());
    }

    // Test pop with MAXSTACKSIZE - 1
    @Test
    void testPopWithMaxSizeStackMinus1() {
        Stack<Integer> s = new Stack<>();
        Random rand = new Random();
        for (int i = 0; i < MAXSTACKSIZE - 2; i++) {
            s.push(rand.nextInt(MAXSTACKELEMENTVAL));
        }
        int lastElement = rand.nextInt(MAXSTACKELEMENTVAL);
        s.push(lastElement);
        assertEquals(lastElement, s.pop());
    }

    // Test pop with MAXSTACKSIZE + 1 elements (to show flexibility)
    @Test
    void testPopWithMaxSizeStackPlus1() {
        Stack<Integer> s = new Stack<>();
        Random rand = new Random();
        for (int i = 0; i < MAXSTACKSIZE; i++) {
            s.push(rand.nextInt(MAXSTACKELEMENTVAL));
        }
        int lastElement = rand.nextInt(MAXSTACKELEMENTVAL);
        s.push(lastElement);
        assertEquals(lastElement, s.pop());
    }
}