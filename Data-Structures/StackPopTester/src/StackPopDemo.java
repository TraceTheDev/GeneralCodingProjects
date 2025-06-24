import java.util.EmptyStackException;
import java.util.Stack;

/**
 * StackPopDemo
 * ------------
 * A simple manual test driver for Java's Stack class.
 * Demonstrates basic stack operations like push, pop, and peek,
 * and shows how to safely handle popping from an empty stack.
 */
public class StackPopDemo {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        System.out.println("== StackPopTester: Manual Stack Demo ==");

        // Push values to the stack
        System.out.println("Pushing values: 10, 20, 30...");
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Show the current top element
        System.out.println("Current top (should be 30): " + stack.peek());

        // Pop the top value
        System.out.println("Popping top value: " + stack.pop());

        // Show new top after pop
        System.out.println("Top after pop (should be 20): " + stack.peek());

        // Clear the stack
        System.out.println("Clearing stack...");
        stack.clear();

        // Attempt to pop from an empty stack
        System.out.println("Attempting to pop from empty stack...");
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Caught expected EmptyStackException: " + e);
        }

        System.out.println("== Demo Complete ==");
    }
}